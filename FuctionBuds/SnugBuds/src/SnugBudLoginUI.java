import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnugBudLoginUI extends JFrame {
    public static void main(String[] args) {
        
        JFrame loginFrame = new JFrame("SnugBud");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(1720, 800);
        loginFrame.setLayout(null);
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Load custom font
        Font snugFont = new Font("SansSerif", Font.BOLD, 28);

        // Top bar
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topBar.setBackground(new Color(255, 102, 51));
        topBar.setBounds(0, 0, 1720, 50);
        
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

        // SEAL
        ImageIcon sealImage = new ImageIcon("./images/seal.jpg");
        Image scaledImage = sealImage.getImage().getScaledInstance(1720, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImage));
        background.setBounds(0, 0, 1720, 800);
        loginFrame.setContentPane(background); 
        background.setLayout(null); 
        

        // Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBounds(1050, 120, 400, 500);
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

        //Forgot Password
        JLabel forgot = new JLabel("FORGOT PASSWORD?");
        forgot.setAlignmentX(Component.CENTER_ALIGNMENT);
               
        //Sign up
        loginPanel.add(Box.createHorizontalGlue());
        JLabel newAcc = new JLabel("<html><a href=''>Sign Up</a></html>");
        newAcc.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        newAcc.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        new SnugBudSignUpUI();  // This now works without blank pages
        loginFrame.dispose();
    }
    });
        loginPanel.add(Box.createHorizontalGlue());
        
        loginPanel.add(forgot);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 5))); 
        loginPanel.add(newAcc);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        
    //Login Button
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

        // Convert all inputs to lowercase (or uppercase) for case-insensitive comparison
        if(username.equalsIgnoreCase("username") && 
           email.equalsIgnoreCase("usls@edu.ph") && 
           password.equalsIgnoreCase("password")) {
            JOptionPane.showMessageDialog(null, "Login Successful!");
            loginFrame.dispose(); 
            SnugBudMainFrame mainFrame = new SnugBudMainFrame();
            mainFrame.setVisible(true);
            mainFrame.getContentPane().setSize(1720,800);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
        
       loginFrame.setVisible(true);
    }
}