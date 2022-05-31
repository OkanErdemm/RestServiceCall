package com.global.bilgi.restservice.call;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class LinuxConnection {
	
	String sonuc;
	
	public String sshConnection(String command) {

		try {

			JSch jsch = new JSch();
			Session session = jsch.getSession(LinuxProperty.getUsername(), LinuxProperty.getHost(),
					LinuxProperty.getPort());
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			;
			session.setPassword(LinuxProperty.getPassword());
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			
			channel.setInputStream(null);
			// ((ChannelExec)channel).setErrStream(System.err);

			InputStream input = channel.getInputStream();
			channel.connect();

			System.out.println("Channel Connected to machine " + command);
			
			if(command.equals("pwd")) {
				sonuc="!!!Hatali bilgi girdiniz !!!";
				return sonuc;
			}

			try {
				InputStreamReader inputReader = new InputStreamReader(input);
				BufferedReader bufferedReader = new BufferedReader(inputReader);
				String line=null;

				while ((line = bufferedReader.readLine()) != null) {
				sonuc=line;
					System.out.println(line);
				}
				bufferedReader.close();
				inputReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			channel.disconnect();
			session.disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sonuc;

	}

}
