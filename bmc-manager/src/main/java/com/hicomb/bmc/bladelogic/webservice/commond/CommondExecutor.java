package com.hicomb.bmc.bladelogic.webservice.commond;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bladelogic._2009._11._30.AssumeRoleService;
import com.bladelogic._2009._11._30.AssumeRoleServiceStub;
import com.bladelogic._2009._11._30.BlRemoteException;
import com.bladelogic._2009._11._30.CLITunnelService;
import com.bladelogic._2009._11._30.CLITunnelServiceStub;
import com.bladelogic._2009._11._30.CommandLoadException;
import com.bladelogic._2009._11._30.CommandNotFoundException;
import com.bladelogic._2009._11._30.LoginService;
import com.bladelogic._2009._11._30.LoginServiceStub;
import com.bladelogic.webservices.framework.xsd.SessionId;
import com.bladelogic.webservices.framework.xsd.TransactionId;
import com.bladelogic.webservices.skeleton.assumerole.AssumeRole;
import com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList;
import com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse;
import com.bladelogic.webservices.skeleton.login.LoginUsingUserCredential;
import com.bladelogic.webservices.skeleton.login.LoginUsingUserCredentialResponse;
import com.hicomb.bmc.bladelogic.webservice.exception.BladeLogicCommondException;

/**
 * BladeLogic 命令执行器
 * 
 * @author Administrator
 */
public class CommondExecutor {

	private static final Log logger = LogFactory.getLog(CommondExecutor.class);

	// trust store
	private static final String TRUST_STORE = "javax.net.ssl.trustStore";

	// password
	private static final String KEY_STORE_PASSWORD = "javax.net.ssl.keyStorePassword";

	/**
	 * 执行CLINSH作业
	 * @param trustStore 证书
	 * @param keyStorePassword 密码
	 * @param endPointAddress 终端IP
	 * @param port  端口
	 * @param userName bladelogic用户名称
	 * @param password 密码
	 * @param authenticationType  登录验证方式
	 * @param groupName 作业组名称
	 * @param jobName 作业名称
	 * @param servers 服务器列表(,分隔)
	 * @param params 参数列表
	 * @param needResult 需要执行结果
	 * @param timeOut 超时次数
	 * @throws BladeLogicCommondException
	 */
	public static void executeCLINSHCommond(String trustStore,
			String keyStorePassword, String endPointAddress, int port,
			String userName, String password, String authenticationType,
			String groupName, String jobName, String servers, String[] params,boolean needResult,int timeOut)
			throws BladeLogicCommondException {
		System.setProperty(TRUST_STORE, trustStore);// 注意是绝对路径
		System.setProperty(KEY_STORE_PASSWORD, keyStorePassword);
		// 登录
		SessionId sessionID = loginService(endPointAddress, port, userName,
				password, authenticationType);

		logger.info("BladeLogic登录成功");
		TransactionId transactionId = new TransactionId();
		transactionId.setTransactionId("");
		// 赋角色
		assumeRoleService(endPointAddress, port, sessionID, transactionId,
				"BLAdmins");
		logger.info("BladeLogic赋角色成功");
		// 执行命令
		String scheduleId = callCliCommond(endPointAddress, port, sessionID, transactionId,
				groupName, jobName, servers, params,needResult,timeOut);
		logger.info("执行命令完成:"+scheduleId);
	}

	/**
	 * 执行CLINSH作业
	 * @param trustStore 证书
	 * @param keyStorePassword 密码
	 * @param endPointAddress 终端IP
	 * @param port  端口
	 * @param userName bladelogic用户名称
	 * @param password  密码
	 * @param authenticationType 登录验证方式
	 * @param jobKey  作业key
	 * @param servers 服务器列表(,分隔)
	 * @param params 参数列表
	 * @param needResult 需要执行结果
	 * @param timeOut 超时次数
	 * @throws BladeLogicCommondException
	 */
	public static void executeCLINSHCommond(String trustStore,
			String keyStorePassword, String endPointAddress, int port,
			String userName, String password, String authenticationType,
			String jobKey, String servers, String[] params,boolean needResult,int timeOut)
			throws BladeLogicCommondException {
		System.setProperty(TRUST_STORE, trustStore);// 注意是绝对路径
		System.setProperty(KEY_STORE_PASSWORD, keyStorePassword);
		// 登录
		SessionId sessionID = loginService(endPointAddress, port, userName,
				password, authenticationType);

		logger.info("BladeLogic登录成功");
		TransactionId transactionId = new TransactionId();
		transactionId.setTransactionId("");
		// 赋角色
		assumeRoleService(endPointAddress, port, sessionID, transactionId,
				"BLAdmins");
		logger.info("BladeLogic赋角色成功");
		// 执行命令
		String result = callCliCommond(endPointAddress, port, sessionID, transactionId, jobKey,
				servers, params,needResult,timeOut);
		System.out.println("执行命令完成:"+result);
	}

	
	private static String handleJobResult(CLITunnelService cliTunnelService, SessionId sessionId,
			TransactionId transactionId, String scheduleId,int timeOut)throws BladeLogicCommondException{
		try {
			String response = "";
			int index  = 0;
			while (!"Completed".equals(response)) {
				if(index >= timeOut){
					break;
				}
				Thread.sleep(5000);
				// 设置命名空间和执行命令
				ExecuteCommandByParamList executeCommandByParamList = new ExecuteCommandByParamList();
				executeCommandByParamList.setNameSpace("JobRun");
				executeCommandByParamList.setCommandName("getJobRunStatusByScheduleId");
				executeCommandByParamList.setCommandArguments(new String[] {
						scheduleId });
				ExecuteCommandByParamListResponse exeResponse = cliTunnelService
						.executeCommandByParamList(executeCommandByParamList,
								sessionId, transactionId);
				index++;
				response = (String)exeResponse.get_return().getReturnValue();
			}
			return response;
		} catch (Exception e) {
			throw new BladeLogicCommondException(e);
		}
	}
	
	/**
	 * 执行登录服务
	 * @param endPointAddress 服务器IP
	 * @param port 服务器端口
	 * @param userName 用户名
	 * @param password 密码
	 * @param authenticationType 认证模式
	 * @return 会话ID
	 * @throws BladeLogicCommondException
	 */
	private static SessionId loginService(String endPointAddress, int port,
			String userName, String password, String authenticationType)
			throws BladeLogicCommondException {
		try {
			LoginService loginServiceStub = new LoginServiceStub(
					buildServiceURL(endPointAddress, port, "LoginService"));
			LoginUsingUserCredential loginUsingSessionCredential = new LoginUsingUserCredential();
			// 设置登录信息
			loginUsingSessionCredential.setUserName(userName);
			loginUsingSessionCredential.setPassword(password);
			loginUsingSessionCredential
					.setAuthenticationType(authenticationType);
			TransactionId transactionId = new TransactionId();
			transactionId.setTransactionId("");
			logger.info("正在登录BladeLigic");
			// 获取返回
			LoginUsingUserCredentialResponse response = loginServiceStub
					.loginUsingUserCredential(loginUsingSessionCredential,
							transactionId);
			SessionId sessionId = new SessionId();
			sessionId.setSessionId(response.getReturnSessionId());
			logger.info("登录成功返回会话编号：" + sessionId.getSessionId());
			return sessionId;
		} catch (Exception e) {
			throw new BladeLogicCommondException(e);
		}

	}

	/**
	 * 赋予角色
	 * @param endPointAddress 地址
	 * @param port 端口
	 * @param sessionId 会话ID
	 */
	private static void assumeRoleService(String endPointAddress, int port,
			SessionId sessionId, TransactionId transactionId, String roleName)
			throws BladeLogicCommondException {
		try {
			// 赋角色
			AssumeRoleService assumeRoleService = new AssumeRoleServiceStub(
					buildServiceURL(endPointAddress, port, "AssumeRoleService"));
			AssumeRole assumeRole = new AssumeRole();
			logger.info("正在登录为用户赋权");
			assumeRole.setRoleName("BLAdmins");
			assumeRoleService.assumeRole(assumeRole, sessionId, transactionId);
			logger.info("用户赋权成功");
		} catch (Exception e) {
			throw new BladeLogicCommondException(e);
		}
	}

	/**
	 * 清理和添加参数
	 * @param sessionId
	 * @param transactionId
	 * @param groupName
	 * @param jobName
	 * @param params
	 * @throws CommandLoadException
	 * @throws CommandNotFoundException
	 * @throws BlRemoteException
	 * @throws RemoteException
	 */
	private static void clearAndAddJobParam(CLITunnelService cliTunnelService,
			SessionId sessionId, TransactionId transactionId, String groupName,
			String jobName, String[] params) throws RemoteException,
			BlRemoteException, CommandNotFoundException, CommandLoadException {
		logger.info("开始执行命令：" + groupName + "/" + jobName);
		ExecuteCommandByParamList executeCommandByParamList = new ExecuteCommandByParamList();
		executeCommandByParamList.setNameSpace("NSHScriptJob");
		executeCommandByParamList
				.setCommandName("clearNSHScriptParameterValuesByGroupAndName");
		executeCommandByParamList.setCommandArguments(new String[] { groupName,
				jobName });
		cliTunnelService.executeCommandByParamList(executeCommandByParamList,
				sessionId, transactionId);
		logger.info("命令清理参数过程完成...");
		int paramIndex = 0;
		if(params!=null){
			for (String paramString : params) {// 遍历添加参数
				addNSHScriptParameterValueByGroupAndName(cliTunnelService,
						sessionId, transactionId, groupName, jobName, paramIndex,
						paramString);
			}
		}
		logger.info("添加命令清理参数完成...");

	}

	/**
	 * 执行CLI命令
	 * @param endPointAddress 地址
	 * @param port 端口
	 * @param sessionId 会话
	 * @param transactionId transaction
	 * @param groupName 组名称
	 * @param jobName 作业名称
	 * @param jobKey 作业Key
	 * @param servers 服务器名称
	 * @param params 参数列表
	 * @return response
	 */
	private static String callCliCommond(
			String endPointAddress, int port, SessionId sessionId,
			TransactionId transactionId, String groupName, String jobName,
			String servers, String[] params,boolean needResult,int timeout)
			throws BladeLogicCommondException {
		try {
			CLITunnelService cliTunnelService = new CLITunnelServiceStub(
					buildServiceURL(endPointAddress, port, "CLITunnelService"));
			//清理和添加参数
			clearAndAddJobParam(cliTunnelService, sessionId,
					transactionId, groupName, jobName,params);
			logger.info("开始获取jobKey：" + groupName + "/" + jobName);
			
			// 设置命名空间和执行命令
			ExecuteCommandByParamList executeCommandByParamList1 = new ExecuteCommandByParamList();
			executeCommandByParamList1.setNameSpace("NSHScriptJob");
			executeCommandByParamList1.setCommandName("getDBKeyByGroupAndName");
			executeCommandByParamList1.setCommandArguments(new String[] {
					groupName, jobName });
			ExecuteCommandByParamListResponse exeResponse = cliTunnelService
					.executeCommandByParamList(executeCommandByParamList1,
							sessionId, transactionId);
			String jobkey = exeResponse.get_return().getReturnValue()
					.toString();
			logger.info("jobKey：" + jobkey);
			ExecuteCommandByParamListResponse executeCommandByParamListResponse =
				executeNshJobAgainstServers(cliTunnelService, sessionId,
					transactionId, jobkey, servers);
			String scheduleId =  (String)executeCommandByParamListResponse.get_return().getReturnValue();
			//如果需要结果
			if(needResult){
				return handleJobResult( cliTunnelService,  sessionId,
					 transactionId,  scheduleId, timeout);
			}else {
				return scheduleId;
			}
		} catch (Exception e) {
			throw new BladeLogicCommondException(e);
		}
	}

	/**
	 * 执行CLI命令
	 * @param endPointAddress 地址
	 * @param port  端口
	 * @param sessionId 会话
	 * @param transactionId transaction
	 * @param jobkey 作业key
	 * @param servers  服务器名称
	 * @param params 参数列表
	 * @return response
	 */
	private static String callCliCommond(
			String endPointAddress, int port, SessionId sessionId,
			TransactionId transactionId, String jobkey, String servers,
			String[] params,boolean needResult,int timeout) throws BladeLogicCommondException {
		try {
			CLITunnelService cliTunnelService = new CLITunnelServiceStub(
					buildServiceURL(endPointAddress, port, "CLITunnelService"));
			logger.info("获取Job名称..");
			ExecuteCommandByParamList executeCommandByParamList = new ExecuteCommandByParamList();
			executeCommandByParamList.setNameSpace("Job");
			executeCommandByParamList.setCommandName("getJobNameByDBKey");
			executeCommandByParamList
					.setCommandArguments(new String[] { jobkey });
			ExecuteCommandByParamListResponse response = cliTunnelService
					.executeCommandByParamList(executeCommandByParamList,
							sessionId, transactionId);
			String jobName = response.get_return().getReturnValue().toString();
			logger.info("获取组名称名称..");
			ExecuteCommandByParamList executeCommandByParamList1 = new ExecuteCommandByParamList();
			executeCommandByParamList1.setNameSpace("Job");
			executeCommandByParamList1.setCommandName("getGroupId");
			executeCommandByParamList1
					.setCommandArguments(new String[] { jobkey });
			ExecuteCommandByParamListResponse response2 = cliTunnelService
					.executeCommandByParamList(executeCommandByParamList1,
							sessionId, transactionId);
			ExecuteCommandByParamList executeCommandByParamList2 = new ExecuteCommandByParamList();
			executeCommandByParamList2.setNameSpace("Group");
			executeCommandByParamList2.setCommandName("getAQualifiedGroupName");
			executeCommandByParamList2
					.setCommandArguments(new String[] { "5005",
							response2.get_return().getReturnValue().toString() });
			ExecuteCommandByParamListResponse response3 = cliTunnelService
					.executeCommandByParamList(executeCommandByParamList2,
							sessionId, transactionId);
			String groupName = response3.get_return().getReturnValue()
					.toString();
			//清理和添加参数
			clearAndAddJobParam(cliTunnelService, sessionId,
					transactionId, groupName, jobName,params);
			logger.info("作业名称:"+jobkey);
			ExecuteCommandByParamListResponse executeCommandByParamListResponse =
				executeNshJobAgainstServers(cliTunnelService, sessionId,
						transactionId, jobkey, servers);
			String scheduleId= (String)executeCommandByParamListResponse.get_return().getReturnValue();
			//如果需要结果
			if(needResult){
				return handleJobResult( cliTunnelService,  sessionId,
					 transactionId,  scheduleId, timeout);
			}else {
				return scheduleId;
			}
		} catch (Exception e) {
			throw new BladeLogicCommondException(e);
		}
	}

	/**
	 * 在指定上执行NSH作业
	 * @param cliTunnelService命令服务
	 * @param groupName 作业组名称
	 * @param jobName 作业名称
	 * @param jobkey jobkey
	 * @param sessionid 回话Id
	 * @param transactionId transactionId
	 * @param serversName 服务器名称
	 * @throws CommandLoadException
	 * @throws CommandNotFoundException
	 * @throws BlRemoteException
	 * @throws RemoteException
	 * @return ExecuteCommandByParamListResponse 返回消息
	 */
	private static ExecuteCommandByParamListResponse executeNshJobAgainstServers(
			CLITunnelService cliTunnelService, SessionId sessionId,
			TransactionId transactionId, String jobkey, String serversName)
			throws RemoteException, BlRemoteException,
			CommandNotFoundException, CommandLoadException {
		// 在指定的Server上执行
		ExecuteCommandByParamList executeCommandByParamList1 = new ExecuteCommandByParamList();
		executeCommandByParamList1.setNameSpace("Job");
		executeCommandByParamList1.setCommandName("executeAgainstServers");
		executeCommandByParamList1.setCommandArguments(new String[] { jobkey,
				serversName });
		return cliTunnelService.executeCommandByParamList(
				executeCommandByParamList1, sessionId, transactionId);
	}

	/**
	 * 添加参数至作业中
	 * @param cliTunnelService 执行Service
	 * @param sessionId会话ID
	 * @param transactionIdtransactionId
	 * @param groupName 组名称
	 * @param jobNameJob名称
	 * @param index参数Index
	 * @param paramValue参数值
	 * @throws CommandLoadException
	 * @throws CommandNotFoundException
	 * @throws BlRemoteException
	 * @throws RemoteException
	 */
	private static void addNSHScriptParameterValueByGroupAndName(
			CLITunnelService cliTunnelService, SessionId sessionId,
			TransactionId transactionId, String groupName, String jobName,
			int index, String paramValue) throws RemoteException,
			BlRemoteException, CommandNotFoundException, CommandLoadException {
		ExecuteCommandByParamList executeCommandByParamList = new ExecuteCommandByParamList();
		executeCommandByParamList.setNameSpace("NSHScriptJob");
		executeCommandByParamList
				.setCommandName("addNSHScriptParameterValueByGroupAndName");
		String[] commondArgs = new String[4];
		commondArgs[0] = groupName;
		commondArgs[1] = jobName;
		commondArgs[2] = String.valueOf(index);
		commondArgs[3] = paramValue;
		executeCommandByParamList.setCommandArguments(commondArgs);
		cliTunnelService.executeCommandByParamList(executeCommandByParamList,
				sessionId, transactionId);
	}

	/**
	 * 构建服务请求头
	 * 
	 * @param ipAddr IP地址
	 * @param port 端口
	 * @param serviceName 服务名称
	 * @return 构建好的URL
	 */
	private static String buildServiceURL(String ipAddr, int port,
			String serviceName) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("https://");
		stringBuffer.append(ipAddr);
		stringBuffer.append(":");
		stringBuffer.append(port);
		stringBuffer.append("/services/");
		stringBuffer.append(serviceName);
		return stringBuffer.toString();
	}

}
