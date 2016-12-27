package swingBms.com;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusDisp extends MyUIElements {
	JPanel statContainer;
	JPanel roomPanel;
	
	private JLabel roomName;
	private JLabel roomStatus;
	int roomCount;
		
	StatusDisp(JFrame frame) {
		super(frame);
		
		statContainer = new JPanel(new CardLayout(0, 0));//container for all controls
		
		roomPanel = new JPanel();
				
		setRoomLayout();
		// TODO Auto-generated constructor stub
	}
	public void displayStatus(){
		frame.getContentPane().add(statContainer, BorderLayout.EAST);
		setRoomLayout();
		addRoomElements("swiatlo","default");
		addRoomElements("swiatlo2","default");
		statContainer.add(roomPanel, "panel1");
	}
	
	
	private GridBagLayout gblR = new GridBagLayout();
	private GridBagConstraints gbcR = new GridBagConstraints();	
	private void setRoomLayout(){		
		gblR.columnWidths = new int[]{0, 0};
		gblR.rowHeights = new int[]{0, 0, 0, 0};
		gblR.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gblR.rowWeights = new double[]{0.0, 0.0, 0.0,1.0,0.0, Double.MIN_VALUE};
		roomPanel.setLayout(gblR);
		//roomPanel.setLayout(new GridBagLayout());
			
		gbcR.insets = new Insets(0,0,20,0);
		gbcR.fill = GridBagConstraints.HORIZONTAL;
		
		roomCount=0;
	}
	private void addRoomElements(String name,String status){
		roomName = new JLabel();
		roomName.setText(name+" ");
		gbcR.gridx = 0;
		gbcR.gridy = roomCount;
		roomPanel.add(roomName, gbcR);
		
		roomStatus = new JLabel();
		roomStatus.setText(status+" ");
		gbcR.gridx = 1;
		gbcR.gridy = roomCount;
		roomPanel.add(roomStatus, gbcR);		
		roomCount++;
	}

}
