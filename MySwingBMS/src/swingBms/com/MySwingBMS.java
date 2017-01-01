package swingBms.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;



public class MySwingBMS {

	public JFrame frame;
	public JTextField txtSterowanie;

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
		showStatus();
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
	}
	private void showStatus(){
		
		//status.displayStatusPanel();
	}

}