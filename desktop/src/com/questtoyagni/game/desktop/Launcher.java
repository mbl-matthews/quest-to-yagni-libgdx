package com.questtoyagni.game.desktop;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import com.questtoyagni.game.screens.PlayScreen;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
/**
 * Launcher who starts at begin. A window where you can select properties like window height, width etc.
 * @author Mathis B., Levent K.
 */
public class Launcher extends JFrame {
	
	private BufferedImage headerImg = null;
	private JLabel imgLabel = null;
	private JPanel headerPanel;
	private JPanel lowerPanel;
	private JPanel controlPanel;
	private JButton startButton;
	private JFrame thisFrame;
	private String displayMsg;
	
	/**
	 * Runs the Launcher
	 * @param args Holds arguments passed from the command line
	 */
	public static void main(String[] args) {
		//String str = "This is a string where every 6 characters a linebreak shall be added";
		//System.out.println(PlayScreen.splitTextInLines(str, 6));
		new Launcher();
	}
	
	/**
	 * Constructor for the Launcher,
	 */
	public Launcher() {
		
		thisFrame = this;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600,700));
		getContentPane().setLayout(null);
		
		try {
		      headerImg = ImageIO.read(new File("..\\core\\assets\\logo_trans_border_resized.png"));
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		} catch (IOException e) {
		      e.printStackTrace();
		} 
		
		headerPanel = new JPanel();
		headerPanel.setBounds(10, 10, 574, 200);
		getContentPane().add(headerPanel);
		headerPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setVisible(true);
		
		//imgLabel = new JLabel(new ImageIcon(resize(headerImg,480,270)));
		imgLabel = new JLabel(new ImageIcon(headerImg));
		headerPanel.add(imgLabel, BorderLayout.CENTER);
		
		lowerPanel = new JPanel();
		lowerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		lowerPanel.setBackground(Color.GRAY);
		lowerPanel.setBounds(10, 221, 574, 440);
		getContentPane().add(lowerPanel);
		lowerPanel.setLayout(null);
		
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.GRAY);
		controlPanel.setBounds(170, 135, 205, 115);
		lowerPanel.add(controlPanel);
		controlPanel.setLayout(null);
		
		startButton = new JButton("Start Game");
		startButton.addActionListener(new StartListener());
		startButton.setBounds(10, 11, 185, 97);
		controlPanel.add(startButton);

		this.controlPanel.updateUI();
	}
	
	/**
	 * 
	 * @author vMysterion
	 * 
	 * Class that implements the ActionListener to execute an action when the Start Button is pressed
	 *
	 */
	private class StartListener implements ActionListener {

		/**
		 * Starts the GUI with a resolution of 1280x720
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			MainGame.mainGame(1280, 720, false);
			
		}
		
	}
	
	/**
	 * Resizes a BufferedImage with the given sizes
	 * @param img BufferedImage to be resized
	 * @param newW new width
	 * @param newH new height
	 * @return The resized BufferedImage
	 */
	private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	} 
	
}