package swingBms.com;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;



public class MySwingBMS {

	public JFrame frame;
	public JTextField txtSterowanie;

	FTPconnection myFTP;
	FTPconnection myFTP2;//do wywlania
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwingBMS window = new MySwingBMS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MySwingBMS() {
		initialize();
		showUI();
		//showStatus();
		
		
		//FTP connection to server
		myFTP = new FTPconnection();
		myFTP2 = new FTPconnection(2);//do wywalenia!!!!!!!!!!
		myFTP.connect(myFTP.getHost(), myFTP.getPort());
		myFTP.logIn(myFTP.getUser(), myFTP.getPass());
		//myFTP.download(myFTP.getFileName());
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				myFTP.download(myFTP.getFileName());
				
				System.out.println("ftp obiekt: "+myFTP.getStatusVals().size());
				System.out.println("ftp obiekt2: "+myFTP2.getStatusVals().size());
			}
			
		},1000,10000);
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));								
	}
	private void showUI(){
		Controlls control = new Controlls(frame);
		control.showMPanel();
		StatusDisp status = new StatusDisp(frame);
	}
	private void showStatus(){
		
		//status.displayStatusPanel();
	}

}