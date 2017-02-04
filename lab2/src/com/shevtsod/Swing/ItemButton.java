package com.shevtsod.Swing;

import com.shevtsod.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import static com.shevtsod.Swing.Form.orangeColor;

/**
 * FILENAME: ItemButton.java
 *
 * PURPOSE:
 *  Swing GUI button component for Item class
 *
 * CLASS: ENSE471
 * ASSIGNMENT: lab2
 * DATE: Feb. 02, 2017
 *
 * NAME: Daniel Shevtsov
 * SID: 200351253
 */
public class ItemButton {
    private Item item;
    private JPanel panel;
    private JButton button;
    private JLabel title, price;
    private JTextArea desc;

    /**
     * Constructor
     * @param title Title of the item
     * @param desc Description of the item
     * @param price Price of the item
     */
    public ItemButton(String title, String desc, double price) {
        item = new Item(title, desc, price);

        button = new JButton();
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(Color.decode(orangeColor));

        panel = new JPanel();
        panel.setBackground(Color.decode(orangeColor));
        button.add(panel);

        this.title = new JLabel();
        this.title.setText(item.getTitle());
        this.title.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(BorderLayout.NORTH, this.title);

        this.price = new JLabel();
        DecimalFormat currency = new DecimalFormat("#,###.00");
        this.price.setText("$" + currency.format(item.getPrice()));
        this.price.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(BorderLayout.NORTH, this.price);

        /*
        NOTE: There is a bug here related to JTextArea that I am not sure how to work around
            If the JTextArea in a button is clicked, it does not generate an event for the button's event
            listener, while any other component inside the button would. Therefore, if the JTextArea is clicked,
            no item is added to the payment panel.
        */
        this.desc = new JTextArea(2, 18);
        this.desc.setFocusable(false);
        this.desc.setOpaque(false);
        this.desc.setEditable(false);
        this.desc.setWrapStyleWord(true);
        this.desc.setLineWrap(true);
        this.desc.setBackground(Color.decode(orangeColor));
        this.desc.setText(item.getDescription());
        this.desc.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
        panel.add(BorderLayout.SOUTH, this.desc);

    }

    /**
     * Returns a formatted Swing button to use in a container
     * @return JButton containing the data of this object
     */
    JButton getButton() {
        return button;
    }

    /**
     * Returns the underlying item of this ItemButton
     * @return Item object
     */
    Item getItem() {
        return item;
    }

    /**
     * Creates an action listener for the button of this ItemButton and outputs to paymentPanel when
     * it is clicked
     * @param payPanel The PaymentPanel to output to
     */
    void bindToPaymentPanel(PaymentPanel payPanel) {
        ActionListener ItemButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalFormat currency = new DecimalFormat("#,##0.00");
                payPanel.appendItem(
                        (getItem().getTitle() + " - " + currency.format(getItem().getPrice())),
                        getItem().getPrice()
                );
            }
        };

        button.addActionListener(ItemButtonListener);
    }


}
