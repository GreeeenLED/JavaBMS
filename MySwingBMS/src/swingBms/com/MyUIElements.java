package swingBms.com;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class MyUIElements{
	JFrame frame;
	
	ArrayList<String> fromFTP;
	
	FTPconnection myFTP;
	
	MyUIElements(JFrame frame){
		this.frame=frame;
		System.out.println("kontruktor MyUIElements");
		/*
		fromFTP = new ArrayList<String>();
		
		//FTP connection to server
		myFTP = new FTPconnection();
		myFTP.connect(myFTP.getHost(), myFTP.getPort());
		myFTP.logIn(myFTP.getUser(), myFTP.getPass());
		//myFTP.download(myFTP.getFileName());
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask(){
			@Override
				public void run() {
					// TODO Auto-generated method stub
					myFTP.download(myFTP.getFileName());
					fromFTP=myFTP.getStatusVals();
				}				
			},1000,10000);		
		*/
	}

	public ArrayList<String> getFromFTP() {
		return fromFTP;
	}

	public void setFromFTP(ArrayList<String> fromFTP) {
		this.fromFTP = fromFTP;
	}
	
}