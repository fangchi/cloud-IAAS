package com.hicomb.bmc.bladelogic.ws;

import java.rmi.RemoteException;

import junit.framework.TestCase;

import com.bladelogic._2009._11._30.BlRemoteException;
import com.bladelogic._2009._11._30.CommandLoadException;
import com.bladelogic._2009._11._30.CommandNotFoundException;
import com.bladelogic._2009._11._30.SessionCredentialExpiredException;
import com.bladelogic._2009._11._30.SessionRejectedException;
import com.hicomb.bmc.bladelogic.webservice.commond.CommondExecutor;
import com.hicomb.bmc.bladelogic.webservice.exception.BladeLogicCommondException;

public class CommondTest extends TestCase {

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
	/**public static void testMainBody() throws RemoteException, SessionRejectedException, SessionCredentialExpiredException, BlRemoteException, CommandNotFoundException, CommandLoadException {
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
		ExecuteCommandByParamList executeCommandByParamList =new ExecuteCommandByParamList() ;
		executeCommandByParamList.setNameSpace("NSHScriptJob");
		executeCommandByParamList.setCommandName("clearNSHScriptParameterValuesByGroupAndName");
		String[]  commondArgs = new String[2];
		commondArgs[0] = "/test";
		commondArgs[1] = "ggg";
		executeCommandByParamList.setCommandArguments(commondArgs);
		cliTunnelService.executeCommandByParamList(executeCommandByParamList, sessionId, transactionId);
		System.out.println("clearNSHScriptParameterValuesByGroupAndName");
		
		ExecuteCommandByParamList executeCommandByParamList1 =new ExecuteCommandByParamList() ;
		executeCommandByParamList1.setNameSpace("NSHScriptJob");
		executeCommandByParamList1.setCommandName("addNSHScriptParameterValueByGroupAndName");
		String[]  commondArgs1 = new String[4];
		commondArgs1[0] = "/test";
		commondArgs1[1] = "ggg";
		commondArgs1[2] = "0";
		commondArgs1[3] = "192.168.0.165";
		executeCommandByParamList1.setCommandArguments(commondArgs1);
		cliTunnelService.executeCommandByParamList(executeCommandByParamList1, sessionId, transactionId);
		System.out.println("addNSHScriptParameterValuesByGroupAndName");
		
		ExecuteCommandByParamList executeCommandByParamList2 =new ExecuteCommandByParamList() ;
		executeCommandByParamList2.setNameSpace("NSHScriptJob");
		executeCommandByParamList2.setCommandName("getDBKeyByGroupAndName");
		String[]  commondArgs2 = new String[2];
		commondArgs2[0] = "/test";
		commondArgs2[1] = "ggg";
		executeCommandByParamList2.setCommandArguments(commondArgs2);
		ExecuteCommandByParamListResponse exeResponse =   cliTunnelService.executeCommandByParamList(executeCommandByParamList2, sessionId, transactionId);
		String jobKey = exeResponse.get_return().getReturnValue().toString();
		System.out.println("getDBKeyByGroupAndName:"+jobKey);
		
		ExecuteCommandByParamList executeCommandByParamList3 =new ExecuteCommandByParamList() ;
		executeCommandByParamList3.setNameSpace("Job");
		executeCommandByParamList3.setCommandName("executeAgainstServers");
		String[]  commondArgs3 = new String[2];
		commondArgs3[0] = jobKey;
		commondArgs3[1] = "192.168.14.160";
		executeCommandByParamList3.setCommandArguments(commondArgs3);
		ExecuteCommandByParamListResponse exeResponse2 =   cliTunnelService.executeCommandByParamList(executeCommandByParamList3, sessionId, transactionId);
		System.out.println(exeResponse2.get_return().getReturnValue().toString());
		
		/**ExecuteCommandByParamList executeCommandByParamList3 =new ExecuteCommandByParamList() ;
		executeCommandByParamList3.setNameSpace("Job");
		executeCommandByParamList3.setCommandName("clearTargetServers");
		String[]  commondArgs3 = new String[1];
		commondArgs3[0] = string;
		executeCommandByParamList3.setCommandArguments(commondArgs3);
		ExecuteCommandByParamListResponse exeResponse2 =   cliTunnelService.executeCommandByParamList(executeCommandByParamList3, sessionId, transactionId);
		System.out.println("clearTargetServers");
		
		/**ExecuteCommandByParamList executeCommandByParamList4 =new ExecuteCommandByParamList() ;
		executeCommandByParamList4.setNameSpace("Job");
		executeCommandByParamList4.setCommandName("addTargetServer");
		String[]  commondArgs4 = new String[2];
		commondArgs4[0] = jobId;
		commondArgs4[1] = "192.168.14.160";
		executeCommandByParamList4.setCommandArguments(commondArgs4);
		cliTunnelService.executeCommandByParamList(executeCommandByParamList4, sessionId, transactionId);
		System.out.println("addTargetServer");
		
		ExecuteCommandByParamList executeCommandByParamList5 =new ExecuteCommandByParamList() ;
		executeCommandByParamList5.setNameSpace("Job");
		executeCommandByParamList5.setCommandName("execute");
		String[]  commondArgs5 = new String[1];
		commondArgs5[0] = jobId;
		executeCommandByParamList5.setCommandArguments(commondArgs5);
		ExecuteCommandByParamListResponse exeResponse3 =   cliTunnelService.executeCommandByParamList(executeCommandByParamList5, sessionId, transactionId);
		System.out.println(exeResponse3.get_return().getReturnValue().toString());
	}**/
	
	/**
	 * @param args
	 * @throws BladeLogicCommondException 
	 * @throws SessionRejectedException 
	 * @throws RemoteException 
	 * @throws SessionCredentialExpiredException 
	 * @throws CommandLoadException 
	 * @throws CommandNotFoundException 
	 * @throws BlRemoteException 
	 */
	public static void testExecutor() throws BladeLogicCommondException{
		CommondExecutor.executeCLINSHCommond("D:\\Program Files (x86)\\Java\\jdk1.6.0_24\\bin\\test_store",
				"123456", "192.168.14.160", 9843, "BLAdmin", "sa", "SRP", "DBKey:SJobModelKeyImpl:2000021-3-2004702",  
				"192.168.14.160", new String[]{"192.168.14.160"},true,4);
		
	}
	
	
	/**
	 * @param args
	 * @throws BladeLogicCommondException 
	 * @throws SessionRejectedException 
	 * @throws RemoteException 
	 * @throws SessionCredentialExpiredException 
	 * @throws CommandLoadException 
	 * @throws CommandNotFoundException 
	 * @throws BlRemoteException 
	 */
	public static void testExecutor2() throws BladeLogicCommondException{
		//CommondExecutor.executeCLINSHCommond("D:\\Program Files (x86)\\Java\\jdk1.6.0_24\\bin\\test_store", "123456", "192.168.14.160", 9843, "BLAdmin", "sa", "SRP", "/test","ggg", "192.168.14.160", new String[]{"192.168.14.160"},true,2);
	}
}
