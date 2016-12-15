package swingBms.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
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
			myImage = ImageIO.read(getClass().getResource("/images/mieszkanie.png"));
			iconM = new ImageIcon(ImageIO.read(getClass().getResource("/images/mieszkanie.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no path or image");
		}
		imageLabel =new JLabel (" label");
		imageLabel = new JLabel(new ImageIcon(myImage));
		imageContainer.add(imageLabel);		
		
		try {
			myImage = ImageIO.read(getClass().getResource("/images/pokoj.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//icon = new ImageIcon(myImage);
		
	}
	
	public void switchImage(){
		//imageLabel.setIcon(icon);
	}
		

}
