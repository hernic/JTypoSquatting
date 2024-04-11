package com.aleph.graymatter.jtyposquatting.ui;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.JTypoSquatting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class JTypoFrame extends JFrame {

    private final JTextField jTextFieldInput;
    private final JTextArea jTextAreaOutput;
    private final JTextField jTextFieldConsole;

    public JTypoFrame() throws IOException {
        setVisible(false);

        setIconImage(read(new File("aleph_sg.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Aleph TypoSquatting Tool");
        setPreferredSize(new Dimension(1200, 800));

        // North Panel
        JPanel northPanel = new JPanel();
        jTextFieldInput = new JTextField("domain name formatted like www.xxx.yy");
        jTextFieldInput.setSize(200, 20);
        northPanel.add(new JLabel("domain name: "));
        northPanel.add(jTextFieldInput);

        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        jTextFieldConsole = new JTextField();

        jTextFieldConsole.setText("");
        jTextFieldConsole.setAutoscrolls(true);
        jTextFieldConsole.setHorizontalAlignment(JTextField.CENTER);
        southPanel.add(jTextFieldConsole);
        JButton jButton = new JButton("OK");
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.add(jButton);


        jTextAreaOutput = new JTextArea();
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
        add(southPanel, BorderLayout.SOUTH);

        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validateAction();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }


    private void validateAction() {
        JTypoSquatting jTypoSquatting = null;

        try {
            jTypoSquatting = new JTypoSquatting(jTextFieldInput.getText());
        } catch (FileNotFoundException | InvalidDomainException exception) {
            System.out.println(exception.getClass().toString());
            if (exception.getClass().toString().equals("java.io.FileNotFoundException")) {
                jTextFieldConsole.setForeground(Color.RED);
                jTextFieldConsole.setText("some files are missing");
            } else if (exception.getClass().toString().equals("class com.aleph.graymatter.jtyposquatting.InvalidDomainException")){
                jTextFieldConsole.setForeground(Color.RED);
                jTextFieldConsole.setText("invalid domain name");
            }
        }
        finally {
            if (jTypoSquatting!= null) {
                jTextFieldConsole.setForeground(Color.BLACK);
                jTextFieldConsole.setText("number of generated squatable domains: " + jTypoSquatting.getNumberOfDomains());
                jTextAreaOutput.setText("");
                jTextAreaOutput.setText(jTypoSquatting.getListOfDomainsAsURL());
            }
        }
    }
}
