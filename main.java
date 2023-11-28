// Name: Aaliyan Muhammad
// Date: 2022-10-14
// Purpose: To create a GUI for a maze game that calls different classes

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MazeMenu extends JFrame {
    private JButton playButton;
    private JButton instructionsButton;
    private JButton creditsButton;
    private JButton quitButton;
    private JPanel buttonsPanel;
    private String backgroundImageFilePath = "C:\\Users\\692138\\OneDrive - Peel District School Board\\Downloads\\COVERPAGE.jpg";
    public static final Color BLUESCLUES = new Color(51,204,255);

    public MazeMenu() {
        super("The A-Mazing Game - Menu");

        // Create a JPanel to hold the buttons
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add the buttons to the panel
        playButton = new JButton("Play");
        buttonsPanel.add(playButton);
       
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MazeGUI().main(null); // This will call the main method of the class MazeGUI
            }
        });
       
        instructionsButton = new JButton("Instructions");
        buttonsPanel.add(instructionsButton);
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame size2 = new JFrame("Intructions");
                size2.setSize(500, 100);
                size2.setLayout(new BorderLayout());
                size2.setVisible(true);

                JLabel messageLabel2 = new JLabel("Welcome to the Maze!");
                messageLabel2.setForeground(Color.BLACK);
                messageLabel2.setFont(new Font("Georgia", Font.BOLD, 15));
               
                JLabel messageLabel3 = new JLabel("Your goal is to reach the red box on the maze grid.");
                messageLabel3.setForeground(Color.BLACK);
                messageLabel3.setFont(new Font("Georgia", Font.BOLD, 15));
               
                JLabel messageLabel4 = new JLabel("Avoid dead-ends, complete all three levels and escape the maze!");
                messageLabel4.setForeground(Color.BLACK);
                messageLabel4.setFont(new Font("Georgia", Font.BOLD, 15));
               
                JPanel messagePanel = new JPanel();
                messagePanel.setBackground(BLUESCLUES);
                messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
                messagePanel.add(messageLabel2);
                messagePanel.add(messageLabel3);
                messagePanel.add(messageLabel4);
                size2.add(messagePanel, BorderLayout.CENTER);
            }
        });
       
       
        creditsButton = new JButton("Credits");
        buttonsPanel.add(creditsButton);
        creditsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Created by Ishpreet Bal & Aaliyan Muhammad");
            }
        });

        quitButton = new JButton("Quit");
        buttonsPanel.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
       
        // Create a label to hold the background image
        JLabel background = new JLabel(new ImageIcon(backgroundImageFilePath));
        add(background);
        background.setLayout(new BorderLayout());
        background.add(buttonsPanel, BorderLayout.SOUTH);
       
        // Set the properties of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MazeMenu();
    }
}