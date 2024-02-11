package com.aleph.graymatter.jtyposquatting;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTypoSquatting {
    private JTextField input;
    private JTextArea output;
    private JButton testButton;

    public JTypoSquatting() {
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(input.getText());
            }
        });
    }
}
