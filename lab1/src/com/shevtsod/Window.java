package com.shevtsod;

import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
	private JPanel mainPanel, headerPanel, centerPanel;
	private JLabel headerLabel, centerTitleLabel, centerEmailLabel,
		            centerPasswordLabel, centerSignUpLabel,
		            centerForgotPassLabel, centerOrLabel;
	private JButton headerSignUpButton, centerLoginButton;
	private JCheckBox centerKeepLoggedInCB;
	private JTextField centerEmailText, centerPasswordText;
	
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
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        centerTitleLabel = new JLabel("Facebook Login");
        centerTitleLabel.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        centerTitleLabel.setSize(200, 20);
        centerTitleLabel.setLocation(20, 15);
        centerPanel.add(centerTitleLabel);

        //Separator
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setSize(420, 3);
        separator.setLocation(20, 45);
        centerPanel.add(separator);

		//"Email or Phone" Label
        centerEmailLabel = new JLabel("Email or Phone: ");
        centerEmailLabel.setSize(140, 25);
        centerEmailLabel.setLocation(40, 55);
        centerPanel.add(centerEmailLabel);

        //"Email or Phone" Text Field
        centerEmailText = new JTextField();
        centerEmailText.setSize(200, 25);
        centerEmailText.setLocation(140, 55);
        centerPanel.add(centerEmailText);

		//"Password" Label
        centerPasswordLabel = new JLabel("Password: ");
        centerPasswordLabel.setSize(140, 25);
        centerPasswordLabel.setLocation(40, 85);
        centerPanel.add(centerPasswordLabel);

        //"Password" Text Field
        centerEmailText = new JTextField();
        centerEmailText.setSize(200, 25);
        centerEmailText.setLocation(140, 85);
        centerPanel.add(centerEmailText);
		
		//"Keep me logged in" Check Box
        centerKeepLoggedInCB = new JCheckBox("Keep me logged in");
        centerKeepLoggedInCB.setSize(140, 25);
        centerKeepLoggedInCB.setBackground(Color.WHITE);
        centerKeepLoggedInCB.setLocation(140, 115);
        centerKeepLoggedInCB.setText("Keep me Logged In");
        centerPanel.add(centerKeepLoggedInCB);
		
		//Login Button
        centerLoginButton = new JButton("Log In");
        centerLoginButton.setSize(40, 23);
        centerLoginButton.setMargin(new Insets(0,0,0,0));
        centerLoginButton.setForeground(Color.WHITE);
        centerLoginButton.setBackground(Color.decode("#1a5aa8"));
        centerLoginButton.setLocation(140, 145);
        centerLoginButton.setBorder(null);
        centerPanel.add(centerLoginButton);
		
		//"or" Label
        centerOrLabel = new JLabel("or ");
        centerOrLabel.setSize(40, 25);
        centerOrLabel.setLocation(187, 143);
        centerPanel.add(centerOrLabel);
		
		//"Sign up for Facebook" clickable Label
        centerSignUpLabel = new JLabel("Sign up for Facebook ");
        centerSignUpLabel.setSize(140, 25);
        centerSignUpLabel.setLocation(203, 143);
        centerSignUpLabel.setEnabled(true);
        centerSignUpLabel.setForeground(Color.decode("#1a5aa8"));
        centerPanel.add(centerSignUpLabel);

		//"Forgot Password" clickable Label
        centerForgotPassLabel = new JLabel("Forgot Password?");
        centerForgotPassLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
        centerForgotPassLabel.setSize(120, 25);
        centerForgotPassLabel.setLocation(140, 170);
        centerForgotPassLabel.setEnabled(true);
        centerForgotPassLabel.setForeground(Color.decode("#1a5aa8"));
        centerPanel.add(centerForgotPassLabel);
	}
	
}
