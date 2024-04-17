package com.aleph.graymatter.jtyposquatting.ui;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.JTypoSquatting;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class JTypoFrame extends JFrame {

    private final JTextField jTextFieldInput;
    private final JTextArea jTextAreaOutput;
    private final JTextField jTextFieldConsole;
    private final JButton jOKButton;
    private final JButton jCopyButton;
    private ImageIcon copyIcon;


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
        jOKButton = new JButton("OK");
        jOKButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(jOKButton);

        //East Panel
        JPanel eastPanel = new JPanel();
        jCopyButton = new JButton("");
        try {
            copyIcon = new ImageIcon(ImageIO.read(new File("copy-icon.png")));
        } catch (IOException ioe) {
            copyIcon = new ImageIcon();
            ioe.printStackTrace();
        }
        jCopyButton.setIcon(copyIcon);
        // not yet well implemented
        jCopyButton.setEnabled(false);
        eastPanel.add(jCopyButton);

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
        add(eastPanel, BorderLayout.EAST);

        jOKButton.addMouseListener(new MouseListener() {
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

        jCopyButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                copy();
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
            } else if (exception.getClass().toString().equals("class com.aleph.graymatter.jtyposquatting.InvalidDomainException")) {
                jTextFieldConsole.setForeground(Color.RED);
                jTextFieldConsole.setText("invalid domain name");
            }
        } finally {
            if (jTypoSquatting != null) {
                jTextFieldConsole.setForeground(Color.BLACK);
                jTextFieldConsole.setText("number of generated squatable domains: " + jTypoSquatting.getNumberOfDomains());
                jTextAreaOutput.setText("");
                jTextAreaOutput.setText(jTypoSquatting.getListOfDomainsAsURL());
            }
        }
    }

    private void copy() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        TransferHandler transfertHandler = jTextAreaOutput.getTransferHandler();
        transfertHandler.exportToClipboard(jTextAreaOutput, clipboard, TransferHandler.COPY);
        Transferable contents = clipboard.getContents(null);

        /*
        System.out.println(contents.isDataFlavorSupported(DataFlavor.stringFlavor));

        try {
            System.out.println((String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor));
            System.out.println(clipboard.getContents(null).getTransferDataFlavors());
        } catch (UnsupportedFlavorException ufe) {
            System.err.println(ufe.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
         */
    }
}
