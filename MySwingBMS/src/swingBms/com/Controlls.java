package swingBms.com;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	
	JPanel navigationPanel;
	JButton[] navigationButtons = new JButton[3];
	
	
	JPanel[] roomPanels = new JPanel[3]; //room panels to control room light and fan 0-living room 1-bed room 2-atrium
	JButton[] lbuttons = new JButton[2];//living room buttons
	JButton[] bbuttons = new JButton[2];//bed room buttons
	JButton[] abuttons = new JButton[2];//atrium buttons
		
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
		
		navigationPanel = new JPanel();
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
	//CardLayout cL = (CardLayout) ctrlContainer.getLayout();////////////////////do wywlaniea lubzmiany
	public void showMPanel(){		
		frame.getContentPane().add(ctrlContainer, BorderLayout.WEST);
		viewMieszkanie();		
		setNavigationB();//do usuniecia
		//ctrlContainer.add(panelM, "mieszkanie");
		//ctrlContainer.add(navigationPanel,"nav");
		//cL.show(ctrlContainer, "nav");
		//ctrlContainer.show("nav");
		setButtonsIcons();
		setLivingRoomPanel();
		setBedRoomPanel();
		setAtriumPanel();
		ctrlContainer.add(roomPanels[2],"2");		
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
	
	private GridBagConstraints gbcN = new GridBagConstraints();
	protected void setNavigationB(){
		try {
			BufferedImage backIcon = ImageIO.read(getClass().getResource("/images/arrow1.png"));
			BufferedImage forrIcon = ImageIO.read(getClass().getResource("/images/arrow2.png"));
			BufferedImage homeIcon = ImageIO.read(getClass().getResource("/images/home1.png"));
			navigationButtons[0] = new JButton(new ImageIcon(backIcon));
			navigationButtons[1] = new JButton(new ImageIcon(homeIcon));
			navigationButtons[2] = new JButton(new ImageIcon(forrIcon));
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		navigationPanel.setLayout(new GridBagLayout());
		gbcN.insets = new Insets(0,10,20,0);
		gbcN.fill = GridBagConstraints.HORIZONTAL;
		
		for(int i=0;i<3;i++){
			navigationButtons[i].setBorder(BorderFactory.createEmptyBorder());
			gbcN.gridx = i;
			gbcN.gridy = 0;
			navigationPanel.add(navigationButtons[i],gbcN);
			navigationButtons[i].addActionListener(this);
			navigationButtons[i].setActionCommand(String.valueOf(i+10));
		}	
	}
	
	BufferedImage switchIcon;
	BufferedImage fanIcon;
	private GridBagConstraints gbcL = new GridBagConstraints();
	private GridBagConstraints gbcBB = new GridBagConstraints();
	private GridBagConstraints gbcA = new GridBagConstraints();
	protected void setButtonsIcons(){
		try {
			switchIcon = ImageIO.read(getClass().getResource("/images/switch.jpg"));
			fanIcon = ImageIO.read(getClass().getResource("/images/went.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void setLivingRoomPanel(){
		roomPanels[0] = new JPanel();
		roomPanels[0].setLayout(new GridBagLayout());
		gbcL.insets = new Insets(0,0,20,0);
		gbcL.fill = GridBagConstraints.HORIZONTAL;
		lbuttons[0] = new JButton(new ImageIcon(switchIcon));
		lbuttons[1] = new JButton(new ImageIcon(fanIcon));
		gbcL.gridx = 0;
		gbcL.gridy = 0;
		roomPanels[0].add(navigationPanel);
		for(int i =0;i<2;i++){
			//lbuttons[i].setBorder(BorderFactory.createEmptyBorder());
			gbcL.gridx = 0;
			gbcL.gridy = i+1;
			roomPanels[0].add(lbuttons[i],gbcL);
			lbuttons[i].addActionListener(this);
			lbuttons[i].setActionCommand(String.valueOf(i+20));
		}		
	}
	protected void setBedRoomPanel(){
		roomPanels[1] = new JPanel();
		roomPanels[1].setLayout(new GridBagLayout());
		gbcBB.insets = new Insets(0,0,20,0);
		gbcBB.fill = GridBagConstraints.HORIZONTAL;
		bbuttons[0] = new JButton(new ImageIcon(switchIcon));
		bbuttons[1] = new JButton(new ImageIcon(fanIcon));
		gbcBB.gridx = 0;
		gbcBB.gridy = 0;
		roomPanels[1].add(navigationPanel);
		for(int i =0;i<2;i++){
			//lbuttons[i].setBorder(BorderFactory.createEmptyBorder());
			gbcBB.gridx = 0;
			gbcBB.gridy = i+1;
			roomPanels[1].add(bbuttons[i],gbcBB);
			bbuttons[i].addActionListener(this);
			bbuttons[i].setActionCommand(String.valueOf(i+30));
		}		
	}
	protected void setAtriumPanel(){
		roomPanels[2] = new JPanel();
		roomPanels[2].setLayout(new GridBagLayout());
		gbcA.insets = new Insets(0,0,20,0);
		gbcA.fill = GridBagConstraints.HORIZONTAL;
		abuttons[0] = new JButton(new ImageIcon(switchIcon));
		//abuttons[1] = new JButton(new ImageIcon(fanIcon));
		gbcA.gridx = 0;
		gbcA.gridy = 0;
		roomPanels[2].add(navigationPanel);
		for(int i =0;i<1;i++){
			//lbuttons[i].setBorder(BorderFactory.createEmptyBorder());
			gbcA.gridx = 0;
			gbcA.gridy = i+1;
			roomPanels[2].add(bbuttons[i],gbcA);
			abuttons[i].addActionListener(this);
			abuttons[i].setActionCommand(String.valueOf(i+40));
		}		
	}
}