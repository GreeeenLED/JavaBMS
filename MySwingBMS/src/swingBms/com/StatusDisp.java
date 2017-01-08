package swingBms.com;

/*
 * panel 1 living room
 * panel 2 bed room
 * panel 3 atrium
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusDisp extends MyUIElements {
	
	private JPanel statContainer;
	//private JPanel roomPanel;
	
	public JPanel livingRoomPanel;
	public JLabel[] livingName = new JLabel[5];
	public JLabel[] livingval = new JLabel[5];
	int countL;
	public LivingRoomClass livingObject;
	
	public JPanel bedRoomPanel;
	public JLabel bedName[] = new JLabel[5];
	public JLabel[] bedVal = new JLabel[5];
	public int countB;
	public BedRoomClass bedRoomObject;
	
	public JPanel atriumPanel;
	public JLabel atriumName[] = new JLabel[5];
	public JLabel[] atriumVal = new JLabel[5];
	public int countA;
	public AtriumClass atriumObject;
	
	//private JLabel roomName;
	//private JLabel roomStatus;
	int roomCount;
	
	private ArrayList<String> updateVals;
	FTPconnection forUpdate;
	
	StatusDisp(JFrame frame) {
		super(frame);
		statContainer = new JPanel(new CardLayout(0, 0));//container for all controls
		frame.getContentPane().add(statContainer, BorderLayout.EAST);
		
		bedRoomObject = new BedRoomClass();
		bedRoomPanel = new JPanel();
		countB = 0;
		
		livingObject = new LivingRoomClass();
		livingRoomPanel = new JPanel();
		countL = 0;
		
		atriumObject =  new AtriumClass();
		atriumPanel = new JPanel();
		countA = 0;
		
		setPanels();	
		//timer to update label values!
		forUpdate = new FTPconnection(1);
		Timer timer2= new Timer(true);
		updateVals = new ArrayList<String>();
		timer2.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				update();
			}
			
		},10000,5000);
		// TODO Auto-generated constructor stub
	}
	
	private GridBagConstraints gbcR = new GridBagConstraints();	
	
	private void setPanels(){
		//setting layouts for panels
		bedRoomPanel.setLayout(new GridBagLayout());
		livingRoomPanel.setLayout(new GridBagLayout());
		atriumPanel.setLayout(new GridBagLayout());
		
		gbcR.insets = new Insets(0,20,20,20);
		gbcR.fill = GridBagConstraints.HORIZONTAL;
		//adding elements to living room panel
		addRoomElement(livingObject.getLight(),"default1",1);
		addRoomElement(livingObject.getFan(),"default2",1);
		addRoomElement(livingObject.getWindow(),"default3",1);
		//adding elements to bed room panel
		addRoomElement(bedRoomObject.getLight(),"default4",2);
		addRoomElement(bedRoomObject.getFan(),"default5",2);
		addRoomElement(bedRoomObject.getWindow(),"default6",2);
		//adding elements to atrium panel
		addRoomElement(atriumObject.getLight(),"default11",3);
		addRoomElement(atriumObject.getMoveSensor(),"default55",3);
		
		statContainer.add(bedRoomPanel, "panel2");
		statContainer.add(livingRoomPanel, "panel1");
		statContainer.add(atriumPanel, "panel3");
		
	}
	private void addRoomElement(String name,String status,int panel){
		switch (panel){
		case 1: //living room
			////label with name
			gbcR.gridx = 0;
			gbcR.gridy = countL;
			livingName[countL] = new JLabel();
			livingName[countL].setText(name);
			livingRoomPanel.add(livingName[countL], gbcR);
			////label with actual status
			gbcR.gridx = 1;
			gbcR.gridy = countL;
			livingval[countL] = new JLabel();
			livingval[countL].setText(status);
			livingRoomPanel.add(livingval[countL], gbcR);
			countL++;			
			break;
		case 2:
			gbcR.gridx = 0;
			gbcR.gridy = countB;
			bedName[countB] = new JLabel();
			bedName[countB].setText(name);
			bedRoomPanel.add(bedName[countB], gbcR);
			////label with actual status
			gbcR.gridx = 1;
			gbcR.gridy = countB;
			bedVal[countB] = new JLabel();
			bedVal[countB].setText(status);
			bedRoomPanel.add(bedVal[countB], gbcR);
			countB++;
			break;
		case 3:
			gbcR.gridx = 0;
			gbcR.gridy = countA;
			atriumName[countA] = new JLabel();
			atriumName[countA].setText(name);
			atriumPanel.add(atriumName[countA], gbcR);
			////label with actual status
			gbcR.gridx = 1;
			gbcR.gridy = countA;
			atriumVal[countA] = new JLabel();
			atriumVal[countA].setText(status);
			atriumPanel.add(atriumVal[countA], gbcR);
			countA++;
			System.out.println(" "+countA);
			break;
		}
		
		for(int i =countL;i<=countL+10;i++){
			gbcR.gridy = i;
			bedRoomPanel.add(new JLabel(" "), gbcR);
			livingRoomPanel.add(new JLabel(" "), gbcR);
			atriumPanel.add(new JLabel(" "), gbcR);
		}				
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
		case 3:
			cardLayout.show(statContainer, "panel3");
			break;
		}
	}
	
	public void update(){
		updateVals = forUpdate.getStatusVals();
		System.out.println("size: "+updateVals.size());
		for(int i =0;i<3;i++){
			//System.out.println("wazrtosci: "+updateVals.get(i));
			//livingObject.
			//livingval[i].setText(updateVals.get(i));
			//livingval[i].setText("woa");
		}
		System.out.println("test");
	}

}