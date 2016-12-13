package swingBms.com;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controlls extends MyUIElements implements ActionListener {
	JPanel panelM;
	JLabel lblControls;
	JPanel controlPanelElements;
	JPanel controlButtons;
	JButton buttonLr;
	JButton buttonBr;
	JButton buttonA;
		
	
	Controlls(JFrame frame) {
		super(frame);
		
		//myUielements = new MyUIElements();
		
		panelM = new JPanel(new GridBagLayout());//panel with apartment buttons
		lblControls = new JLabel("CONTROLS");
		controlPanelElements = new JPanel(new GridLayout(2,1));
		controlButtons = new JPanel(new GridLayout(3,1));
		
		buttonLr = new JButton("Living room");
		buttonLr.addActionListener(this);
		buttonLr.setActionCommand("L");
		
		buttonBr = new JButton("Bed room");
		buttonBr.addActionListener(this);
		buttonBr.setActionCommand("B");
		
		buttonA = new JButton("Atrium");
		buttonA.addActionListener(this);
		buttonA.setActionCommand("A");
		
		//dopisac actione listenery!!!
		//dziala
		//kkk
		
		// TODO Auto-generated constructor stub
	}
	public void showMPanel(){		
		frame.getContentPane().add(panelM, BorderLayout.WEST);
	
		showSettingsLabel();
		showPanelButtons();
	}
	private void showSettingsLabel(){
		JLabel lblControls = new JLabel("CONTROLS");
		controlPanelElements.add(lblControls);
	}
	private void showPanelButtons(){
		controlPanelElements.add(controlButtons);
		controlButtons.add(buttonLr);
		controlButtons.add(buttonBr);
		controlButtons.add(buttonA);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 1;
		panelM.add(controlPanelElements,gbc);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch(event){
		case "L":
			System.out.println("living room");
			break;
		case "B":
			System.out.println("bed room");
			break;
		case "A":
			System.out.println("atrium");
			break;
			}
		// TODO Auto-generated method stub
		
	}
}