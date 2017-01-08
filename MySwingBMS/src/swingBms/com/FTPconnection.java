package swingBms.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.TimerTask;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import org.apache.commons.net.ftp.FTPReply;

public class FTPconnection {
	String host;
	int port;
	String user;
	String pass;
	String fileName;
	FTPClient ftpClient;
	//
	FTPconnection(){
		 //defaults
		ftpClient = new FTPClient();
		setHost("127.0.0.1");
		setPort(505);
		setUser("user1");
		setPass("user1");
		setFileName("zmienne.txt");
	}
	
	protected void connect(String host,int port){
		try {
			ftpClient.connect(host,port);
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void logIn(String user, String pass){		
		try {
			boolean success = ftpClient.login(user, pass);
			showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
	protected void download(String file){
		BufferedReader br =null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			String readFile = file;
			InputStream inputStream = ftpClient.retrieveFileStream(readFile);
			//isToString(inputStream);
			br = new BufferedReader(new InputStreamReader(inputStream));
			while((line=br.readLine())!=null){
				sb.append(line);
				//here put adding elements to array!!
				sb.append('\n');	
			}
			System.out.println("convert: "+sb.toString());
			
			boolean success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File #2 has been downloaded successfully.");
	            }
	            inputStream.close();
		} catch (IOException e) {
			 System.out.println("Error: " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void isToString(InputStream is){
		
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	

}
