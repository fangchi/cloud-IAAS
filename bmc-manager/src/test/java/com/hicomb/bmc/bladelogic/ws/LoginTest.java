package com.hicomb.bmc.bladelogic.ws;


import java.rmi.RemoteException;

import com.bladelogic._2009._11._30.AssumeRoleService;
import com.bladelogic._2009._11._30.AssumeRoleServiceStub;
import com.bladelogic._2009._11._30.BlRemoteException;
import com.bladelogic._2009._11._30.CLITunnelService;
import com.bladelogic._2009._11._30.CLITunnelServiceStub;
import com.bladelogic._2009._11._30.CommandLoadException;
import com.bladelogic._2009._11._30.CommandNotFoundException;
import com.bladelogic._2009._11._30.LoginService;
import com.bladelogic._2009._11._30.LoginServiceStub;
import com.bladelogic._2009._11._30.SessionCredentialExpiredException;
import com.bladelogic._2009._11._30.SessionRejectedException;
import com.bladelogic.webservices.framework.xsd.SessionId;
import com.bladelogic.webservices.framework.xsd.TransactionId;
import com.bladelogic.webservices.skeleton.assumerole.AssumeRole;
import com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString;
import com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse;
import com.bladelogic.webservices.skeleton.login.LoginUsingUserCredential;
import com.bladelogic.webservices.skeleton.login.LoginUsingUserCredentialResponse;

public class LoginTest {

	private static final String TRUST_STORE ="javax.net.ssl.trustStore";

	private static final String KEY_STORE_PASSWORD ="javax.net.ssl.keyStorePassword";
	
	/**
	 * @param args
	 * @throws SessionRejectedException 
	 * @throws RemoteException 
	 * @throws SessionCredentialExpiredException 
	 * @throws CommandLoadException 
	 * @throws CommandNotFoundException 
	 * @throws BlRemoteException 
	 */
	public static void main(String[] args) throws RemoteException, SessionRejectedException, SessionCredentialExpiredException, BlRemoteException, CommandNotFoundException, CommandLoadException {
		System.setProperty(TRUST_STORE, "D:\\Program Files (x86)\\Java\\jdk1.6.0_24\\bin\\test_store");// 注意是绝对路径
		System.setProperty(KEY_STORE_PASSWORD, "123456");
		
		LoginService loginServiceStub = new LoginServiceStub("https://192.168.14.160:9843/services/LoginService");
		LoginUsingUserCredential loginUsingSessionCredential = new LoginUsingUserCredential();
		loginUsingSessionCredential.setUserName("BLAdmin");
		loginUsingSessionCredential.setPassword("sa");
		loginUsingSessionCredential.setAuthenticationType("SRP");
		TransactionId transactionId = new TransactionId();
		transactionId.setTransactionId("");
		LoginUsingUserCredentialResponse response = loginServiceStub.loginUsingUserCredential(loginUsingSessionCredential, transactionId);
		
		System.out.println(response.getReturnSessionId());
		AssumeRoleService assumeRoleService = new AssumeRoleServiceStub("https://192.168.14.160:9843/services/AssumeRoleService");
		AssumeRole assumeRole = new AssumeRole();
		assumeRole.setRoleName("BLAdmins");
		SessionId sessionId  = new SessionId();
		sessionId.setSessionId(response.getReturnSessionId());
		assumeRoleService.assumeRole(assumeRole, sessionId, transactionId);
		System.out.println("AssumeRoleServiceStub");
		CLITunnelService cliTunnelService = new CLITunnelServiceStub("https://192.168.14.160:9843/services/CLITunnelService");
		ExecuteCommandByParamString executeCommandByParamString =new ExecuteCommandByParamString() ;
		executeCommandByParamString.setNameSpace("Server");
		executeCommandByParamString.setCommandName("listAllServers");
		ExecuteCommandByParamStringResponse respones = cliTunnelService.executeCommandByParamString(executeCommandByParamString, sessionId, transactionId);
		System.out.println(respones.get_return().getReturnValue());
		
	}
	
}
