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
	
	//TRZEBA PRZEROBIC TO TAK ZEBY BYLY ODDZIELNE LABELE !!!! 
	
	private JPanel statContainer;
	//private JPanel roomPanel;
	
	public JPanel livingRoomPanel;
	public JLabel[] livingName = new JLabel[5];
	public JLabel[] livingval = new JLabel[5];
	int livingRoomCounter;
	public LivingRoomClass livingObject;
	
	public JPanel bedRoomPanel;
	public JLabel bedName[] = new JLabel[5];
	public JLabel[] bedVal = new JLabel[5];
	public int bedRoomCounter;
	public BedRoomClass bedRoomObject;
	
	//private JLabel roomName;
	//private JLabel roomStatus;
	int roomCount;
			
	StatusDisp(JFrame frame) {
		super(frame);
		statContainer = new JPanel(new CardLayout(0, 0));//container for all controls
		frame.getContentPane().add(statContainer, BorderLayout.EAST);
		
		bedRoomObject = new BedRoomClass();
		bedRoomPanel = new JPanel();
		bedRoomCounter = 0;
		
		livingObject = new LivingRoomClass();
		livingRoomPanel = new JPanel();
		livingRoomCounter =0;
		
		setPanels();		
		// TODO Auto-generated constructor stub
	}
	
	private GridBagConstraints gbcR = new GridBagConstraints();	
	private void setPanels(){
		//setting layouts for panels
		bedRoomPanel.setLayout(new GridBagLayout());
		livingRoomPanel.setLayout(new GridBagLayout());
		
		gbcR.insets = new Insets(0,20,20,20);
		gbcR.fill = GridBagConstraints.HORIZONTAL;
		//roomCount=0;
		//adding elements to bed room panel
		addRoomElement(bedRoomObject.getLight(),"default11",1);
		//addRoomElement(bedRoomObject.getFan(),"default12",1);
		//addRoomElement(bedRoomObject.getWindow(),"default13",1);
		//roomCount=0;
		//adding elements to living room panel
		//addRoomElement(livingObject.getLight(),"default21",2);
		//addRoomElement(livingObject.getFan(),"default22",2);
		//addRoomElement(livingObject.getWindow(),"default23",2);
		//roomCount=0;
		//adding room panel with all elements to container
		statContainer.add(bedRoomPanel, "panel1");
		//statContainer.add(livingRoomPanel, "panel2");
		
	}
	private void addRoomElement(String name,String status,int panel){		
		bedName[0] = new JLabel();
		bedName[0].setText("test");
		bedRoomPanel.add(bedName[0], gbcR);
		
		/*
		roomName = new JLabel();
		roomName.setText(name);
		
		if(panel ==1)bedRoomPanel.add(roomName, gbcR);
		if(panel==2)livingRoomPanel.add(roomName,gbcR);
		
		roomStatus = new JLabel();
		roomStatus.setText(status); //deafult - all off
		gbcR.gridx = 1;
		gbcR.gridy = roomCount;
		if(panel==1)bedRoomPanel.add(roomStatus, gbcR);
		if(panel==2)livingRoomPanel.add(roomStatus,gbcR);
		
		roomCount++;
		
		for(int i =roomCount;i<=roomCount+10;i++){
			gbcR.gridy = i;
			bedRoomPanel.add(new JLabel(" "), gbcR);
			livingRoomPanel.add(new JLabel(" "), gbcR);
		}
		*/
		
	}
	
	public void switchPanel(int panel){
		CardLayout cardLayout = (CardLayout) statContainer.getLayout();
		switch(panel){
		case 1:
			cardLayout.show(statContainer, "panel1");
			break;
		case 2:
			cardLayout.show(statContainer, "panel2");
			break;
		}
	}
	public void updateTEST(){
		livingObject.setLight("test111");
	}

}