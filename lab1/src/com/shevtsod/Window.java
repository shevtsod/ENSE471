package com.shevtsod;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
	private JPanel mainPanel, headerPanel, centerPanel;
	private JLabel headerLabel, centerLoginLabel, centerEmailLabel,
		   centerPasswordLabel, centerSignUpLabel, 
		   centerForgotPassLabel, centerOrLabel;
	private JButton headerSignUpButton, centerLoginButton;
	private JRadioButton centerKeepLoggedInRB;
	private JTextArea centerEmailText, centerPasswordText;
	
	/*
	 * Main program entry point
	 */
	public static void main(String[] args) {
		new Window();
	}
	
	/*
	 * Initialize a Window object with a header panel and a center panel
	 */
	public Window() {
		this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Fakesbook");
		
		mainPanel = new JPanel();
		mainPanel.setSize(800, 450);
		mainPanel.setBackground(Color.decode("#d4d8db"));
		mainPanel.setLayout(null);
		this.add(mainPanel);
		
		createHeader();
		createCenter();
		
		this.setVisible(true);
		
	}
	
	/*
	 * Create the top (blue) header panel of the frame with
	 * all associated components
	 */
	private void createHeader() {
		headerPanel = new JPanel();
		headerPanel.setSize(800, 65);
		headerPanel.setBackground(Color.decode("#1a5aa8"));
		headerPanel.setLayout(null);
		mainPanel.add(headerPanel);
		
		//Main Logo
		headerLabel = new JLabel("facebook");
		headerLabel.setFont(new Font("Sans-Serif", Font.BOLD, 35));
		headerLabel.setSize(170, 65);
		headerLabel.setLocation(0, 5);
		headerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		headerLabel.setForeground(Color.WHITE);
		headerPanel.add(headerLabel);
		
		//Sign Up Button
		headerSignUpButton = new JButton("Sign Up");
		headerSignUpButton.setSize(55, 23);
		headerSignUpButton.setMargin(new Insets(0,0,0,0));
		headerSignUpButton.setForeground(Color.WHITE);
		headerSignUpButton.setBackground(Color.decode("#52a522"));
		headerSignUpButton.setLocation(180, 30);
		headerSignUpButton.setBorder(null);
		headerPanel.add(headerSignUpButton);
		
	}
	
	/*
	 * Create the center (white) login panel of the frame with
	 * all associated components
	 */
	private void createCenter() {
		centerPanel = new JPanel();
		centerPanel.setSize(460, 200);
		centerPanel.setLocation(160, 145);
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainPanel.add(centerPanel);
		
		//"Facebook Login" Label


		//"Email or Phone" Label
		
		//"Password" Label
		
		//"Keep me logged in" Radio Button
		
		//Login Button
		
		//"or" Label
		
		//"Sign up for Facebook" clickable Label
		
		//"Forgot Password" clickable Label
		
	}
	
}
