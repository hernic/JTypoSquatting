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
        setIconImage(read(new File("aleph_sg.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Aleph TypoSquatting Tool");
        setMinimumSize(new Dimension(1024, 768));

        JPanel northPanel = new JPanel();
        jTextFieldInput = new JTextField("domain name formatted like www.xxx.yy");
        jTextFieldInput.setSize(200, 20);
        northPanel.add(new JLabel("domain name: "));
        northPanel.add(jTextFieldInput);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        this.jTextAreaConsole = new JTextArea();
        jTextAreaConsole.setText("console");
        jTextAreaConsole.setAutoscrolls(true);
        southPanel.add(jTextAreaConsole);
        JButton jButton = new JButton("OK");
        southPanel.add(jButton);


        jButton.addActionListener(this);
        numberLabel = new JLabel("");

        this.jTextAreaOutput = new JTextArea();
        jTextAreaOutput.setText("");
        jTextAreaOutput.setAutoscrolls(true);


        JScrollPane jScrollPane = new JScrollPane(jTextAreaOutput);
        jScrollPane.setPreferredSize(new Dimension(800, 600));
        jScrollPane.setWheelScrollingEnabled(true);

        JPanel contentPanel = new JPanel();
        contentPanel.add(jScrollPane, BorderLayout.CENTER);
        contentPanel.add(southPanel, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(jButton, BorderLayout.SOUTH);
        add(numberLabel, BorderLayout.WEST);
        super.addKeyListener(this);
        pack();
    }


    private void validateAction() {
        JTypoSquatting jTypoSquatting;
        try {
            jTypoSquatting = new JTypoSquatting(jTextFieldInput.getText());
        } catch (FileNotFoundException | InvalidDomainException exception) {
            if (exception.getClass().toString().equals("java.io.FileNotFoundException")) {
                this.jTextAreaConsole.setText("some files are missing");
            } else {
                this.jTextAreaConsole.setText("invalid domain name");
            }
            throw new RuntimeException(exception);
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
