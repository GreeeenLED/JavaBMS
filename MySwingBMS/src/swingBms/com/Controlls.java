package swingBms.com;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controlls extends MyUIElements implements ActionListener {
	JPanel ctrlContainer;
	JPanel panelM;
	JLabel lblControls;
	JButton buttonLr;
	JButton buttonBr;
	JButton buttonA;

	Controlls(JFrame frame) {
		super(frame);
		
		ctrlContainer = new JPanel(new CardLayout(0, 0));//container for all controls
		
		panelM = new JPanel();
		
		lblControls = new JLabel("CONTROLS");
		
		buttonLr = new JButton("Living room");
		buttonLr.addActionListener(this);
		buttonLr.setActionCommand("L");
		
		buttonBr = new JButton("Bed room");
		buttonBr.addActionListener(this);
		buttonBr.setActionCommand("B");
		
		buttonA = new JButton("Atrium");
		buttonA.addActionListener(this);
		buttonA.setActionCommand("A");
		
		// TODO Auto-generated constructor stub
	}
	public void viewMieszkanie(){
		GridBagLayout gblM = new GridBagLayout();
		gblM.columnWidths = new int[]{0, 0};
		gblM.rowHeights = new int[]{0, 0, 0, 0};
		gblM.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gblM.rowWeights = new double[]{0.0, 0.0, 0.0,1.0,0.0, Double.MIN_VALUE};
		panelM.setLayout(gblM);
				
		JLabel lblControls = new JLabel("CONTROLS");
		GridBagConstraints gbcB = new GridBagConstraints();		
		gbcB.insets = new Insets(0,0,20,0);
		gbcB.fill = GridBagConstraints.HORIZONTAL;
	
		gbcB.gridy = 0;
		panelM.add(lblControls, gbcB);
		
		gbcB.gridy = 1;
		panelM.add(buttonBr, gbcB);
		
		gbcB.gridy = 2;
		panelM.add(buttonLr, gbcB);
		
		gbcB.gridy = 3;
		panelM.add(buttonA, gbcB);			
		
		//empty labels to move nuttons to top of GridbagConstrainsts
		gbcB.weighty =1;
		for(int i =4;i<=12;i++){
			gbcB.gridy = i;
			panelM.add(new JLabel(" "), gbcB);
		}
		
	}
	public void showMPanel(){		
		frame.getContentPane().add(ctrlContainer, BorderLayout.WEST);
		viewMieszkanie();
		
		ctrlContainer.add(panelM, "mieszkanie");
			
	}
	
	MyImage images = new MyImage(frame);
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch(event){
		case "L":
			System.out.println("living room");
			images.switchImage("liv");
			//panelM.setVisible(false);
			break;
		case "B":
			System.out.println("bed room");
			images.switchImage("mie");
			break;
		case "A":
			System.out.println("atrium");
			images.switchImage("atr");
			break;
			}
		// TODO Auto-generated method stub
		
	}
	
}