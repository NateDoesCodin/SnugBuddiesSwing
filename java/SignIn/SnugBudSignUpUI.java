import javax.swing.*;
import java.awt.*;

public class SnugBudSignUpUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnugBudSignUpUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SnugBud - Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Allows absolute positioning

        // Manually set fullscreen-like size without exclusive fullscreen mode
        frame.setSize(1720, 800);
        frame.setLocationRelativeTo(null); // Center the frame on screen
        frame.setResizable(false);

        // Set seal image as background
        ImageIcon sealImage = new ImageIcon("seal.jpg");
        Image scaledImage = sealImage.getImage().getScaledInstance(1720, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImage));
        background.setBounds(0, 0, 1720, 800);
        frame.setContentPane(background); // Set background as the content pane
        background.setLayout(null); // Allows placement of elements on top

        Font snugFont = new Font("SansSerif", Font.BOLD, 28);
        
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topBar.setBackground(new Color(255, 102, 51));
        topBar.setBounds(0, 0, 1720, 50); // full width of screen

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
        background.add(logo); // Add to background

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

        //Open Mainframe (added by Jon)
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sign Up Successful!");
                    frame.dispose(); 
                    SnugBudMainFrame mainFrame = new SnugBudMainFrame();
                    mainFrame.setVisible(true);

        background.add(signupPanel); // Add panel to background

        frame.setVisible(true);
    }
}

