package swingBms.com;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;



public class MySwingBMS {

	public JFrame frame;
	public JTextField txtSterowanie;
	ArrayList<String> fromFTP;
	boolean flag;//flag for first run and reading FTP content
	
	Controlls control;
	StatusDisp status;
	MyImage images;

	FTPconnection myFTP;
	//FTPconnection myFTP2;//do wywlania
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
		fromFTP = new ArrayList<String>(); 
		flag = true;
		//for(int i =0;i<100;i++){
	//		fromFTP.add("def");//set 100 def values
	//	}
		initialize();
		initUI();
		//showStatus();		
		//FTP connection to server
		myFTP = new FTPconnection();
		//myFTP2 = new FTPconnection(2);//do wywalenia!!!!!!!!!!
		myFTP.connect(myFTP.getHost(), myFTP.getPort());
		myFTP.logIn(myFTP.getUser(), myFTP.getPass());
		//myFTP.download(myFTP.getFileName());
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				myFTP.download(myFTP.getFileName());
				for(int i =0;i<myFTP.getStatusVals().size();i++){
					if(flag)fromFTP.add(i, myFTP.getStatusVals().get(i));
					if(!flag)fromFTP.set(i, myFTP.getStatusVals().get(i));	
				}
				flag =false;
				status.update(fromFTP);
				System.out.println("ftp obiekt: "+fromFTP.size());
			//	System.out.println("ftp obiekt2: "+myFTP2.getStatusVals().size());
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
	private void initUI(){
		status = new StatusDisp(frame);
		images = new MyImage(frame);
		control = new Controlls(frame,images,status);
		control.showMPanel();		
	}
	private void showStatus(){
		
		//status.displayStatusPanel();
	}
}