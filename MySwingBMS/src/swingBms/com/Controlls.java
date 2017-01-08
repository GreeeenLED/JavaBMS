package swingBms.com;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controlls extends JFrame implements ActionListener {
	
	public JFrame frame;
	
	MyImage images;
	StatusDisp status;
	
	JPanel ctrlContainer;
	JPanel panelM;
	JLabel lblControls;
	JButton[] mieszButtons = new JButton[5];
	
	//StatusDisp status = new StatusDisp(frame);
		
	int buttonsCount; // counter counting buttons in JPanel Mieszkanie

	Controlls(JFrame frame,MyImage images,StatusDisp status) {
		this.frame = frame;
		this.images = images;
		this.status = status;
		
		//super(frame);		
		ctrlContainer = new JPanel(new CardLayout(0, 0));//container for all controls		
		panelM = new JPanel(); //JPnael - Mieszkanie		
		lblControls = new JLabel("CONTROLS"); // label in JPanel Mieszkanie		
		buttonsCount=1; //from 1 because panel MIeszkanie has label with gridy=0		
		// TODO Auto-generated constructor stub
	}
	
	private GridBagConstraints gbcB = new GridBagConstraints();
	private void addButton(String name){
		//method to add new buttons to JPanel Mieszkanie (panelM)
		mieszButtons[buttonsCount]=new JButton(name);
		mieszButtons[buttonsCount].addActionListener(this);
		mieszButtons[buttonsCount].setActionCommand(String.valueOf(buttonsCount));
		gbcB.gridy = buttonsCount;
		panelM.add(mieszButtons[buttonsCount], gbcB);
		buttonsCount++;
	}
	public void viewMieszkanie(){		
		
		panelM.setLayout(new GridBagLayout());
				
		JLabel lblControls = new JLabel("CONTROLS");
				
		gbcB.insets = new Insets(0,0,20,0);
		gbcB.fill = GridBagConstraints.HORIZONTAL;
	
		gbcB.gridy = 0;
		panelM.add(lblControls, gbcB);
		
		addButton("Living room");
		addButton("Bed room");
		addButton("Atrium");
		
		//empty labels to move nuttons to top of GridbagConstrainsts
		gbcB.weighty =1;
		for(int i =buttonsCount;i<=10;i++){
			gbcB.gridy = i;
			panelM.add(new JLabel(" "), gbcB);
		}
		
	}
	public void showMPanel(){		
		frame.getContentPane().add(ctrlContainer, BorderLayout.WEST);
		viewMieszkanie();		
		ctrlContainer.add(panelM, "mieszkanie");			
	}
	
	//MyImage images = new MyImage(frame);
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch(event){
		case "1":
			System.out.println("living room");
			images.switchImage("liv");
			status.switchPanel(1);			
			//panelM.setVisible(false);
			break;
		case "2":
			System.out.println("bed room");
			images.switchImage("mie");
			status.switchPanel(2);
			break;
		case "3":
			System.out.println("atrium");
			images.switchImage("atr");
			status.switchPanel(3);
			//status.updateTEST();	
			break;
			}
		// TODO Auto-generated method stub		
	}
	
}