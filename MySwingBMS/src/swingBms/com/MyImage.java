package swingBms.com;

import java.awt.BorderLayout;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyImage extends MyUIElements{
	JPanel imageContainer;
	JLabel imageLabel;
	BufferedImage myImage;
	ImageIcon iconM;//dow zmiany
	ImageIcon iconL;//dow zmiany
	ImageIcon iconA;//dow zmiany
	
	MyImage(JFrame frame) {
		super(frame);
		imageContainer = new JPanel();
		frame.getContentPane().add(imageContainer, BorderLayout.CENTER);
		
		try {
			//myImage = ImageIO.read(getClass().getResource("/images/mieszkanie.png"));
			iconM = new ImageIcon(ImageIO.read(getClass().getResource("/images/mieszkanie.png")));
			iconL = new ImageIcon(ImageIO.read(getClass().getResource("/images/pokoj.png")));
			iconA = new ImageIcon(ImageIO.read(getClass().getResource("/images/przedsionek.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no path or image");
		}
		//imageLabel =new JLabel (" label");
		imageLabel = new JLabel(iconM);
		imageContainer.add(imageLabel);			
		//icon = new ImageIcon(myImage);		
	}
	
	public void switchImage(String img){
		switch (img){
		case "mie":
			imageLabel.setIcon(iconM);
			break;
		case "liv":
			imageLabel.setIcon(iconL);
			break;
		case "atr":
			imageLabel.setIcon(iconA);
			break;
		}
		//imageLabel.setIcon(icon);
	}
		

}
