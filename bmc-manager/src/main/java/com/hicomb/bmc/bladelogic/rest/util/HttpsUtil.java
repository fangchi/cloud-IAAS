package com.hicomb.bmc.bladelogic.rest.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import com.hicomb.rest.exception.RestException;

/**
 * Https工具类
 */
public class HttpsUtil {

	private static Map<String, SSLSocketFactory> cachedSocketFactory = new HashMap<String, SSLSocketFactory>();
	
	private static HostnameVerifier hostNameVerifier = new HostnameVerifier() {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};
	
	public static HostnameVerifier getHostNameVerifier() {
		return hostNameVerifier;
	}

	public static SSLSocketFactory getSSLSocketFactory(String serverName,int port,String certificateStorePassword ) throws RestException{
		try {
			if(cachedSocketFactory.get(serverName) == null){
				// create a temporary KeyStore file that will be removed when the JVM exits (normally)
		        File keyStoreFile = File.createTempFile("tmpkeystore", ".jks");
		   	    keyStoreFile.deleteOnExit();
		   	    KeyStore ts = createKeyStore(serverName, port, keyStoreFile, certificateStorePassword.toCharArray());
		   	    
		   	    // set up the TrustManager and sslSocketFactory
		        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SUNX509");
		        tmf.init(ts);
		        TrustManager[] tm = tmf.getTrustManagers();
		
		        SSLContext sslContext = SSLContext.getInstance("SSL");
		        sslContext.init(null, tm, null);
		        SSLSocketFactory sslsocketFactory =  sslContext.getSocketFactory();
		        cachedSocketFactory.put(serverName, sslsocketFactory);
			}
			return cachedSocketFactory.get(serverName);
		} catch (IOException e) {
			throw new RestException(e.getLocalizedMessage());
		} catch (KeyManagementException e) {
			throw new RestException(e.getLocalizedMessage());
		} catch (KeyStoreException e) {
			throw new RestException(e.getLocalizedMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new RestException(e.getLocalizedMessage());
		} catch (CertificateException e) {
			throw new RestException(e.getLocalizedMessage());
		}
		
	}
	
	/**
	 * Creates a (JKS) key store using the <code>keystoreFile</code> specified to contain the Director
	 * self-signed certificate.
	 * 
	 * @param host Host name or IP address for the Director Server
	 * @param port The port for the Director Server
	 * @param keystoreFile File representing the key store to be created (overwritten if it exists)
	 * @param password The password to use for the key store file
	 * 
	 * @return A new Keystore
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws Exception if the server certificate cannot be downloaded or the key store created.
	 */
	private static KeyStore createKeyStore(String host, int port, File keystoreFile, char [] password) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException  {
		// load an empty keystore
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(null, password);

		// put the director certificate into the empty key store and save the keystore using specified password
		Certificate firstCert = getBladeLogicCertificate(host, port);
		keyStore.setCertificateEntry(host, firstCert);
		keyStore.store(new BufferedOutputStream(new FileOutputStream(keystoreFile)), password);
		
		return keyStore;
	}
	
	 /**
	 * Gets the self-signed certificate used by the Director Server.  This method creates a SSLContext
	 * that trusts all certificates and uses it with a HttpsUrlConnection to get the server's
	 * certificate.
	 * 
	 * @param host Host name or IP address for the Director Server
	 * @param port Port for the Director Server
     *
	 * @return The Director server certificate
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws IOException 
	 * @throws Exception if an exception occurred connecting to the server or getting the certificate
	 */
	private static Certificate getBladeLogicCertificate(String host, int port) throws NoSuchAlgorithmException, KeyManagementException, IOException  {
		URL url = new URL("https://" + host + ":" + Integer.toString(port) + "/type/PropertySetClasses");
		// create a trust manager that does not validate certificate chains
		X509TrustManager[] trustAllCerts = new X509TrustManager[]{
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					public void checkClientTrusted(
							java.security.cert.X509Certificate[] certs, String authType) {
					}
					public void checkServerTrusted(
							java.security.cert.X509Certificate[] certs, String authType) {
					}
				}
		};

		// install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());

		// Now use this connection to get the Director server's certificates
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setHostnameVerifier(hostNameVerifier);
		connection.setSSLSocketFactory(sc.getSocketFactory());
		connection.connect();
		Certificate certs[] = connection.getServerCertificates();
		connection.disconnect();
		return certs[0];
	}
}
