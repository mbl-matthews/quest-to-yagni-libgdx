package com.questtoyagni.GUI;

import java.awt.Dimension;

import javax.swing.*;

public class Launcher extends JFrame {
	
	public static void main(String[] args) {
		new Launcher();
	}
	
	public Launcher() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600,700));
		setVisible(true);
	}
}