package com.aleph.graymatter.jtyposquatting.ui;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.JTypoSquatting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class JTypoFrame extends JFrame implements ActionListener, KeyListener {

    private final JTextField jTextFieldInput;
    private final JTextArea jTextAreaOutput;
    private final JTextArea jTextAreaConsole;
    private final JLabel numberLabel;

    public JTypoFrame() throws IOException {
        //setIconImage(read(new File("aleph_sg.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Aleph TypoSquatting Tool");
        setMinimumSize(new Dimension(1024, 768));

        this.jTextFieldInput = new JTextField();

        JButton jButton = new JButton("OK");
        jButton.addActionListener(this);
        numberLabel = new JLabel();

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
        add(numberLabel, BorderLayout.WEST);
        super.addKeyListener(this);
        pack();
    }


    private void validateAction() {
        JTypoSquatting jTypoSquatting;
        try {
            jTypoSquatting = new JTypoSquatting(jTextFieldInput.getText());
        } catch (FileNotFoundException | InvalidDomainException ex) {
            this.jTextAreaConsole.setText(ex.getMessage());
            throw new RuntimeException(ex);
        }
        jTextAreaOutput.setText("");
        jTextAreaOutput.setText(jTypoSquatting.getListOfDomainsAsURL());
        numberLabel.setText(jTypoSquatting.getNumberOfDomains());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateAction();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            validateAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
