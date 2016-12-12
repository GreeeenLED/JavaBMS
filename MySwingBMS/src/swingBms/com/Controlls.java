package swingbms.com;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controlls extends MyUIElements {
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
		buttonBr = new JButton("Bed room");
		buttonA = new JButton("Atrium");
		
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
}