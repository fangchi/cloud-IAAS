package com.hicomb.cloud.hmc.tools;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import com.hicomb.cloud.hmc.exception.HMCException;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.configuration.ConfigurationException;
import com.sshtools.j2ssh.configuration.ConfigurationLoader;
import com.sshtools.j2ssh.connection.ChannelState;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;
import com.sshtools.j2ssh.util.InvalidStateException;

/**
 * HMC命令行工具类
 * 注：同一台机器一个用户在一段时间内仅保持一个回话并且执行命令
 */
public class CommondLineTools {

	private static final Log logger = LogFactory.getLog(CommondLineTools.class);

	static {
		Properties properties = new Properties();//强制指定不输出语句
		properties.put("log4j.rootLogger","error");
		PropertyConfigurator.configure(properties);
	}

	/**
	 * 执行命令
	 * @param host HMC主机IP
	 * @param port  端口（默认22）
	 * @param username  HMC用户名
	 * @param password   HMC密码
	 * @param commondName 命令名称
	 * @return
	 * @throws HMCException
	 */
	public static synchronized String getCommondResponse(String host, int port,
			String username, String password, String commondName)
			throws HMCException {
		SessionChannelClient session = null;
		try {
			String responseStr = null;
			ConfigurationLoader.initialize(false);//初始化
			SshClient ssh = new SshClient(); //构建Client
			ssh.setSocketTimeout(30000);//设置Timeout
			ssh.connect(host, port, new IgnoreHostKeyVerification());//不进行主机校验
			ssh.setKexTransferLimit(1000000000);//设置最大吞吐
			PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();//设置用户名/密码
			// Read the password
			pwd.setUsername(username);
			// Get the password
			pwd.setPassword(password);
			// Try the authentication
			int result = ssh.authenticate(pwd);
			// Evaluate the result
			// switch result;
			switch (result) {//判断执行结果
				case AuthenticationProtocolState.COMPLETE://如果完成
					session = ssh.openSessionChannel();//打开回话通道
					ChannelClientInputStream inputStream = new ChannelClientInputStream(
							session, 2000);//获取输入流
					if (session.executeCommand(commondName)) {//执行命令
						session.getState().waitForState(
								ChannelState.CHANNEL_CLOSED, 2000);
						responseStr = new String(
								inputStream.getAllDataFromBuffers());//获取返回字符串
					}
					break;
				case AuthenticationProtocolState.FAILED://如果执行失败
					throw new HMCException(new RuntimeException(), "命令执行错误");
				case AuthenticationProtocolState.PARTIAL://如果执行没有权限的命令
					throw new HMCException(new RuntimeException(),
							"The authentication succeeded but another authentication is required");
				case AuthenticationProtocolState.CANCELLED://如果被取消
					throw new HMCException(new RuntimeException(), "命令被取消");
				case AuthenticationProtocolState.READY:
					logger.info("Protocol READY");
				default:
					break;
			}
			return responseStr;
		} catch (ConfigurationException e) {
			logger.error(e);
			throw new HMCException(e, "配置错误");
		} catch (IOException e) {
			logger.error(e);
			throw new HMCException(e, "IO错误");
		} catch (InvalidStateException e) {
			logger.error(e);
			throw new HMCException(e, "状态错误");
		} catch (InterruptedException e) {
			logger.error(e);
			throw new HMCException(e, "状态错误");
		} finally {
			if (session != null) {//关闭会话
				try {
					session.close();
				} catch (IOException e) {
					throw new HMCException(e, "关闭ssh时，失败！");
				}
			}
		}
	}
}
