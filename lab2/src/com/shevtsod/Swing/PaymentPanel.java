package com.shevtsod.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * FILENAME: PaymentPanel.java
 *
 * PURPOSE:
 *  Main window of Swing GUI application - Payment Panel (shows products added to cart and allows to check-out)
 *
 * CLASS: ENSE471
 * ASSIGNMENT: lab2
 * DATE: Feb. 02, 2017
 *
 * NAME: Daniel Shevtsov
 * SID: 200351253
 */
public class PaymentPanel {
    private JPanel payPanel;
    private JLabel topLabel, priceLabel;
    private JTextArea outputText;
    private JButton payButton;

    double totalPrice = 0;

    /**
     * Constructor. Creates a new PaymentPanel
     * @param payPanel JPanel to bind to this class (this class draws to that panel)
     */
    public PaymentPanel(JPanel payPanel) {
        this.payPanel = payPanel;

        //Top Label (Cart)
        topLabel = new JLabel("Your Order");
        payPanel.add(BorderLayout.NORTH, topLabel);

        //Text Area (output text)
        outputText = new JTextArea(23, 13);
        outputText.setFocusable(false);
        outputText.setOpaque(false);
        outputText.setEditable(false);
        outputText.setWrapStyleWord(true);
        outputText.setAutoscrolls(true);
        outputText.setLineWrap(true);
        JScrollPane outputTextScroll = new JScrollPane(outputText);
        outputTextScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        payPanel.add(BorderLayout.CENTER, outputTextScroll);

        //Price Label
        priceLabel = new JLabel();
        DecimalFormat currency = new DecimalFormat("#,##0.00");
        priceLabel.setText("Total Price: $" + currency.format(totalPrice));
        payPanel.add(BorderLayout.CENTER, priceLabel);

        //Button (payment button)
        payButton = new JButton("Check-Out");
        payButton.setPreferredSize(new Dimension(160, 44));
        payPanel.add(BorderLayout.CENTER, payButton);

        //Payment button listener
        ActionListener paymentButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
                totalPrice = 0;
                priceLabel.setText("Total Price: $" + currency.format(totalPrice));
                //Would transfer control to some payment processing service here, but we don't have one
            }
        };
        payButton.addActionListener(paymentButtonListener);
    }

    /**
     * Adds a new menu item to this payment panel
     * @param item The title of the item to be added
     * @param price The price of the item to store
     */
    void appendItem(String item, double price) {
        outputText.append(item + "\n");
        totalPrice += price;
        DecimalFormat currency = new DecimalFormat("#,##0.00");
        priceLabel.setText("Total Price: $" + currency.format(totalPrice));
    }
}
