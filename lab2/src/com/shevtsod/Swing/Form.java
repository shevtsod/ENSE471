package com.shevtsod.Swing;

import javax.swing.*;
import java.awt.*;

/**
 * FILENAME: Form.java
 *
 * PURPOSE:
 *  Main window of Swing GUI application
 *
 * CLASS: ENSE471
 * ASSIGNMENT: lab2
 * DATE: Feb. 02, 2017
 *
 * NAME: Daniel Shevtsov
 * SID: 200351253
 */
public class Form {
	
    static final String yellowColor = 		"#f2e6d0";
    static final String greenColor = 		"#3ea011";
    static final String orangeColor = 		"#fb8f2d";
    static final String lightGreyColor = 	"#f2f0ed";

    static final int NUM_MENU_ITEMS_PER_CATEGORY = 4;
	
	private JFrame frame;
	private JPanel mainPanel,
				   header,
				   productsPanel,
				   centerPanel,
				   paymentPanel,
				   footer;
	private JLabel headerTitle,
				   headerSubtitle;

	ProductsPanel prodPanel;
	PaymentPanel payPanel;

	private int category = 0;

	public static void main(String[] args) {
		new Form();
	}

	/**
	 * Constructor. Creates a new Form with all the required UI elements
	 */
	public Form() {
		//Main window frame
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Flavours of India - Online Ordering Menu");
		
		//Main window panel
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800, 600));
		mainPanel.setBackground(Color.decode(yellowColor));
		frame.add(BorderLayout.CENTER, mainPanel);
		
		//Green header panel
		header = new JPanel();
		header.setBackground(Color.decode(greenColor));
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		frame.add(BorderLayout.NORTH, header);
		
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
		header.add(headerSubtitle);

        header.add(Box.createRigidArea(new Dimension(0, 10)));
		
		//Products panel
		//	This panel shows a list of categories of products to select from
		//  This panel changes the center panel to reflect the selected category
		productsPanel = new JPanel();
		productsPanel.setBackground(Color.decode(lightGreyColor));
		productsPanel.setPreferredSize(new Dimension(160, 350));
		frame.add(BorderLayout.WEST, productsPanel);

		//Bind this JPanel to a ProductsPanel class
		prodPanel = new ProductsPanel(productsPanel, this);
		
		//Payment panel
		//	This panel shows a list of ordered products and a payment button
		paymentPanel = new JPanel();
		paymentPanel.setPreferredSize(new Dimension(160, 350));
		paymentPanel.setBackground(Color.decode(lightGreyColor));
        frame.add(BorderLayout.EAST, paymentPanel);

        //Bind this JPanel to a PaymentPanel class
		payPanel = new PaymentPanel(paymentPanel);

        //Center panel
        //	This panel shows the products in the selected category and allows
        //	adding products to the payment list
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode(orangeColor));
        centerPanel.setPreferredSize(new Dimension(460, 1000));
        centerPanel.setLayout(new GridLayout(10, 2));
        mainPanel.add(BorderLayout.CENTER, centerPanel);

        // Draw the initial centerPanel items
        renderCenterPanel();


		frame.setVisible(true);
	}

	/**
	 * Redraws the center panel of this form to correspond to the selected category
	 */
	public void renderCenterPanel() {
		centerPanel.removeAll();

		ItemButtonFactory itmf1 = new ItemButtonFactory();

		for(int i = 0; i < NUM_MENU_ITEMS_PER_CATEGORY; i++) {
			ItemButton tempButton = itmf1.getMenuItemButton(category, i);
			tempButton.bindToPaymentPanel(payPanel);
			centerPanel.add(tempButton.getButton());
		}

		//Filler labels for proper spacing
		JPanel[] jp = new JPanel[16];
		for(int i = 0; i < jp.length; i++) {
			jp[i] = new JPanel();
			jp[i].setBackground(Color.decode(orangeColor));
			centerPanel.add(jp[i]);
		}

		centerPanel.revalidate();
		centerPanel.repaint();
	}

	//Setters and getters

	public void setCategory(int category) {
		this.category = category;
	}

}
