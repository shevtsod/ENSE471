/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253
 */

package com.shevtsod;

import javax.swing.*;
import java.awt.*;

public class Window {
	
	static final String yellowColor = 		"#f2e6d0";
	static final String greenColor = 		"#3ea011";
	static final String orangeColor = 		"#d89c24";
	static final String lightGreyColor = 	"#f2f0ed";
	
	private JFrame frame;
	private JPanel mainPanel,
				   header,
				   productsPanel,
				   centerPanel,
				   paymentPanel,
				   footer;
	private JLabel headerTitle,
				   headerSubtitle;

	public static void main(String[] args) {
		new Window();
	}
	
	public Window() {
		//Main window frame
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Flavours of India - Online Ordering Menu");
		
		//Main window panel
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.decode(yellowColor));
		frame.add(BorderLayout.CENTER, mainPanel);
		
		//Green header panel
		header = new JPanel();
		header.setPreferredSize(new Dimension(500, 100));
		header.setBackground(Color.decode(greenColor));
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		mainPanel.add(BorderLayout.NORTH, header);
		
		header.add(Box.createRigidArea(new Dimension(0, 10)));
		
		headerTitle = new JLabel("FLAVOURS OF INDIA");
		headerTitle.setForeground(Color.WHITE);
		headerTitle.setFont(new Font("Sans-Serif", Font.BOLD, 42));
		headerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		header.add(headerTitle);
		
		headerSubtitle = new JLabel("RESTAURANT & SWEETS");
		headerSubtitle.setForeground(Color.decode(orangeColor));
		headerSubtitle.setFont(new Font("Sans-Serif", Font.PLAIN, 17));
		headerSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		header.add(BorderLayout.CENTER, headerSubtitle);
		
		//Products panel
		//	This panel shows a list of categories of products to select from
		//  This panel changes the center panel to reflect the selected category
		productsPanel = new JPanel();
		productsPanel.setBackground(Color.decode(lightGreyColor));
		productsPanel.setPreferredSize(new Dimension(150, 450));
		frame.add(BorderLayout.WEST, productsPanel);
		
		//Center panel
		//	This panel shows the products in the selected category and allows
		//	adding products to the payment list
		centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(100, 450));
		centerPanel.setBackground(Color.WHITE);
		//frame.add(BorderLayout.CENTER, centerPanel);
		
		//Payment panel
		//	This panel shows a list of ordered products and a payment button
		paymentPanel = new JPanel();
		paymentPanel.setPreferredSize(new Dimension(150, 450));
		paymentPanel.setBackground(Color.decode(lightGreyColor));
		frame.add(BorderLayout.EAST, paymentPanel);
		
		
		frame.setVisible(true);
	}

}
