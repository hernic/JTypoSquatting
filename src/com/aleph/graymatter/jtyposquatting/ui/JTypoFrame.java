package com.aleph.graymatter.jtyposquatting.ui;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.JTypoSquatting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class JTypoFrame extends JFrame implements ActionListener {

    private final JTextField jTextFieldInput;
    private final JTextArea jTextAreaOutput;
    private final JTextArea jTextAreaConsole;

    public JTypoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Aleph Typosquatting Tool");
        setMinimumSize(new Dimension(1024, 768));

        this.jTextFieldInput = new JTextField();

        JButton jButton = new JButton("OK");
        jButton.addActionListener(this);

        this.jTextAreaOutput = new JTextArea();
        jTextAreaOutput.setText("");
        jTextAreaOutput.setAutoscrolls(true);

        this.jTextAreaConsole = new JTextArea();
        jTextAreaConsole.setText("");
        jTextAreaConsole.setAutoscrolls(true);


        JScrollPane jScrollPane = new JScrollPane(jTextAreaOutput);
        jScrollPane.setPreferredSize(new Dimension(800, 600));
        jScrollPane.setWheelScrollingEnabled(true);

        Panel contentPanel = new Panel();
        contentPanel.add(jScrollPane, BorderLayout.CENTER);
        contentPanel.add(jTextAreaConsole, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);
        add(jTextFieldInput, BorderLayout.NORTH);
        add(jButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTypoSquatting jTypoSquatting = null;
        try {
            jTypoSquatting = new JTypoSquatting(jTextFieldInput.getText());
        } catch (FileNotFoundException | InvalidDomainException ex) {
            this.jTextAreaConsole.setText(ex.getMessage());
            throw new RuntimeException(ex);
        }
            jTextAreaOutput.setText("");
            jTextAreaOutput.setText(jTypoSquatting.getListOfDomainsAsURL());
    }
}
