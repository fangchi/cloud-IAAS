package com.hicomb.vm.vmware.trustmanager;

/**
 * 授信管理类，不做任何授信校验
 */
public class TrustAllTrustManager implements javax.net.ssl.TrustManager,
		javax.net.ssl.X509TrustManager {

    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
       return null;
    }

    public void checkServerTrusted(
          java.security.cert.X509Certificate[] certs, String authType)
          throws java.security.cert.CertificateException {
       return;
    }

    public void checkClientTrusted(
          java.security.cert.X509Certificate[] certs, String authType)
          throws java.security.cert.CertificateException {
       return;
    }

}
