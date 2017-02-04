package com.shevtsod.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * FILENAME: ProductsPanel.java
 *
 * PURPOSE:
 *  Main window of Swing GUI application - Products Panel (shows categories of products to choose from)
 *
 * CLASS: ENSE471
 * ASSIGNMENT: lab2
 * DATE: Feb. 02, 2017
 *
 * NAME: Daniel Shevtsov
 * SID: 200351253
 */
public class ProductsPanel {

    private static final int NUM_CATEGORIES = 4;

    private JPanel prodPanel;
    private Form form;
    private JLabel topLabel;
    private JButton buttons[];

    String categories[];

    /**
     * Constructor. Creates a new PaymentPanel
     * @param prodPanel JPanel to bind to this class (this class draws to that prodPanel)
     * @param form Form to bind to this class (this class outputs to the centerPanel based on events)
     */
    public ProductsPanel(JPanel prodPanel, Form form) {
        this.prodPanel = prodPanel;
        this.form = form;

        //Top Label (Categories)
        topLabel = new JLabel("Menu Categories");
        prodPanel.add(BorderLayout.NORTH, topLabel);

        //Buttons (Category buttons)
        buttons = new JButton[NUM_CATEGORIES];
        categories = new String[NUM_CATEGORIES];
        categories[0] = "Appetizers";
        categories[1] = "Vegetarian Flavours";
        categories[2] = "Non-Vegetarian Flavours";
        categories[3] = "Beverages";

        for(int i = 0; i < NUM_CATEGORIES; i++) {
            buttons[i] = new JButton(categories[i]);
            buttons[i].setPreferredSize(new Dimension(160, 45));
            buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            addCategoryButtonListener(buttons[i], i);
            prodPanel.add(BorderLayout.SOUTH, buttons[i]);
        }
    }

    /**
     * Creates an action listener for a button on the products panel
     * @param button The button to associate the event listener to
     * @param index The category index associated with the button clicked
     */
    void addCategoryButtonListener(JButton button, int index) {
        ActionListener categoryButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setCategory(index);
                form.renderCenterPanel();
            }
        };

        button.addActionListener(categoryButtonListener);

    }
}
