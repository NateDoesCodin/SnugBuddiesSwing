import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnugBudSignUpUI {
    private JFrame signupFrame;
    
    public SnugBudSignUpUI() {
        // Frame setup
        signupFrame = new JFrame("SnugBud - Sign Up");
        signupFrame.setLayout(null);
        signupFrame.setSize(1720, 800);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.setResizable(false);
        signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Background image
        ImageIcon sealImage = new ImageIcon("./images/seal.jpg");
        Image scaledImage = sealImage.getImage().getScaledInstance(1720, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImage));
        background.setBounds(0, 0, 1720, 800);
        signupFrame.setContentPane(background);
        background.setLayout(null);

        Font snugFont = new Font("SansSerif", Font.BOLD, 28);
        
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
        logo.setFont(snugFont);
        logo.setForeground(new Color(255, 102, 51));
        logo.setBounds(30, 60, 300, 40);
        background.add(logo);

        // Sign Up Panel
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(new BoxLayout(signupPanel, BoxLayout.Y_AXIS));
        signupPanel.setBounds(1050, 120, 400, 500);
        signupPanel.setBackground(new Color(255, 153, 102));
        signupPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel signupTitle = new JLabel("CREATE A NEW ACCOUNT");
        signupTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        signupPanel.add(signupTitle);
        signupPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField usernameField = new JTextField("USERNAME");
        JTextField emailField = new JTextField("EMAIL ADDRESS");
        JPasswordField passwordField = new JPasswordField("PASSWORD");
        JPasswordField confirmPasswordField = new JPasswordField("CONFIRM PASSWORD");

        for (JComponent field : new JComponent[]{usernameField, emailField, passwordField, confirmPasswordField}) {
            field.setMaximumSize(new Dimension(260, 30));
            signupPanel.add(field);
            signupPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(new Color(255, 102, 51));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.setPreferredSize(new Dimension(200, 30));
        signupPanel.add(signupButton);
        
        // Open Mainframe
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sign Up Successful!");
                signupFrame.dispose(); 
                SnugBudMainFrame mainFrame = new SnugBudMainFrame();
                mainFrame.setVisible(true);
            }
        });

        background.add(signupPanel);
        signupFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SnugBudSignUpUI();
    }
}