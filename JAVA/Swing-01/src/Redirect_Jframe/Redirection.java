package Redirect_Jframe;

import javax.swing.*;

public class Redirection extends JFrame {
    
    public Redirection() {
        setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        JButton redirectButton = new JButton("Redirect");
        redirectButton.addActionListener(e -> {
            setVisible(false); // Hide the current frame
            SecondFrame secondFrame = new SecondFrame();
            secondFrame.setVisible(true); // Show the second frame
        });
        
        add(redirectButton);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Redirection mainFrame = new Redirection();
            mainFrame.setVisible(true);
        });
    }
}

class SecondFrame extends JFrame {
    
    public SecondFrame() {
        setTitle("Second Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            setVisible(false); // Hide the current frame
            Redirection mainFrame = new Redirection();
            mainFrame.setVisible(true); // Show the main frame
        });
        
        add(backButton);
    }
}