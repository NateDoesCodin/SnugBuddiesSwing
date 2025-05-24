import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import java.awt.Color;


public class SnugBudLoginUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnugBudLoginUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame loginFrame = new JFrame("SnugBud");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(1720, 800);
        loginFrame.setLayout(null);
        loginFrame.getContentPane().setBackground(Color.WHITE);

        // Load custom font
        Font snugFont = new Font("SansSerif", Font.BOLD, 28);

        // Top bar
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topBar.setBackground(new Color(255, 102, 51));
        topBar.setBounds(0, 0, 900, 50);

        topBar.add(new JLabel("Home"));
        topBar.add(new JLabel("Shop"));
        topBar.add(new JLabel("Product"));
        topBar.add(new JLabel("About"));

        loginFrame.add(topBar);

        // Logo
        JLabel logo = new JLabel("SnugBud");
        logo.setFont(snugFont);
        logo.setForeground(new Color(255, 102, 51));
        logo.setBounds(30, 60, 300, 40);
        loginFrame.add(logo);

        // Seal Image
        JLabel seal = new JLabel();
        ImageIcon sealImage = new ImageIcon("seal.jpg");
        seal.setIcon(new ImageIcon(sealImage.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
        seal.setBounds(50, 110, 400, 350);
        loginFrame.add(seal);

        // Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBounds(550, 120, 300, 350);
        loginPanel.setBackground(new Color(255, 153, 102));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel loginTitle = new JLabel("LOGIN INTO YOUR ACCOUNT");
        loginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginPanel.add(loginTitle);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //User Info
        JTextField usernameField = new JTextField("USERNAME");
        JTextField emailField = new JTextField("EMAIL ADDRESS");
        JPasswordField passwordField = new JPasswordField("PASSWORD");

        for (JComponent field : new JComponent[]{usernameField, emailField, passwordField}) {
            field.setMaximumSize(new Dimension(260, 30));
            loginPanel.add(field);
            loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JLabel forgot = new JLabel("FORGOT PASSWORD?");
        forgot.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(forgot);

        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(255, 102, 51));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(200, 30));
        loginPanel.add(loginButton);
        loginFrame.add(loginPanel);
        
        // Add action on button click
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if(username.equals("username") && email.equals("usls@edu.ph") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    loginFrame.dispose(); 
                    SnugBudMainFrame mainFrame = new SnugBudMainFrame();
                    mainFrame.setVisible(true);
                
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        loginFrame.setVisible(true);
    }
}
