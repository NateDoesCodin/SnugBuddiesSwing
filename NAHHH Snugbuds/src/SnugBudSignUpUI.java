import javax.swing.*;
import java.awt.*;

public class SnugBudSignUpUI extends JFrame {
    
    public SnugBudSignUpUI() {
        setTitle("SnugBud - Sign Up");
        setSize(1720, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        // Background
        ImageIcon sealImage = new ImageIcon("./images/seal.jpg");
        Image scaledImage = sealImage.getImage().getScaledInstance(1720, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImage));
        background.setBounds(0, 0, 1720, 800);
        setContentPane(background);
        background.setLayout(null);

        // Navigation Bar
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topBar.setBackground(new Color(255, 102, 51));
        topBar.setBounds(0, 0, 1720, 50);
        topBar.add(new JLabel("Home"));
        topBar.add(new JLabel("Shop"));
        topBar.add(new JLabel("Product"));
        topBar.add(new JLabel("About"));
        background.add(topBar);

        // Logo
        JLabel logo = new JLabel("SnugBud");
        logo.setFont(new Font("SansSerif", Font.BOLD, 28));
        logo.setForeground(new Color(255, 102, 51));
        logo.setBounds(30, 60, 300, 40);
        background.add(logo);

        // Sign Up Panel
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(new BoxLayout(signupPanel, BoxLayout.Y_AXIS));
        signupPanel.setBounds(1050, 120, 400, 500);
        signupPanel.setBackground(new Color(255, 153, 102));
        signupPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel signupTitle = new JLabel("CREATE ACCOUNT");
        signupTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        signupPanel.add(signupTitle);
        signupPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Fields
        JTextField usernameField = new JTextField("USERNAME");
        JTextField emailField = new JTextField("EMAIL");
        JPasswordField passwordField = new JPasswordField("PASSWORD");
        JPasswordField confirmField = new JPasswordField("CONFIRM PASSWORD");

        for (JComponent field : new JComponent[]{usernameField, emailField, passwordField, confirmField}) {
            field.setMaximumSize(new Dimension(260, 30));
            signupPanel.add(field);
            signupPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Sign Up Button
        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(new Color(255, 102, 51));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Sign Up Successful!");
            dispose();
            new SnugBudMainFrame().setVisible(true);
        });
        signupPanel.add(signupButton);

        background.add(signupPanel);
        setVisible(true);
    }
}