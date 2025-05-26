import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class SnugBudMainFrame extends JFrame {
    
    public SnugBudMainFrame() {
        // Set up the frame
        setTitle("Snugbud - Naven the Frog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1720, 800);
        setLayout(new BorderLayout());
        getContentPane().setSize(400, 400);

        // Navigation panel
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        navPanel.setBackground(new Color(215, 154, 124));

        JLabel brandLabel = new JLabel("SNUGBUDS");
        brandLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        brandLabel.setForeground(new Color(102, 51, 0));
        navPanel.add(brandLabel);

        String[] tabs = {"Home", "About", "Shop", "Contact"};
        for (String tab : tabs) {
            JButton button = new JButton(tab);
            button.setFocusPainted(false);
            button.setBackground(new Color(215, 154, 124));
            button.setBorderPainted(false);
            button.setFont(new Font("Poppins", Font.PLAIN, 14));
            navPanel.add(button);
        }

        JTextField searchField = new JTextField(15);
        searchField.setFont(new Font("Poppins", Font.PLAIN, 14));
        navPanel.add(searchField);

        // Banner section
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.setBackground(new Color(255, 220, 202));
        bannerPanel.setPreferredSize(new Dimension(800, 100));

        JLabel bannerText = new JLabel("Welcome to Snugbud!", SwingConstants.CENTER);
        bannerText.setFont(new Font("Poppins", Font.BOLD, 28));
        bannerText.setForeground(new Color(102, 51, 0));
        bannerPanel.add(bannerText, BorderLayout.CENTER);

        // Image section
        ImageIcon frogImage = new ImageIcon("naven.jpg");
        Image scaledImage = frogImage.getImage().getScaledInstance(1720, 350, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Top content
        JPanel topContent = new JPanel();
        topContent.setLayout(new BoxLayout(topContent, BoxLayout.Y_AXIS));
        topContent.add(bannerPanel);
        topContent.add(imageLabel);

        // Reviews section
        JPanel reviewsPanel = new JPanel();
        reviewsPanel.setBackground(new Color(255, 220, 202));
        reviewsPanel.setLayout(new BoxLayout(reviewsPanel, BoxLayout.Y_AXIS));
        reviewsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JLabel reviewsLabel = new JLabel("Reviews");
        reviewsLabel.setFont(new Font("Poppins", Font.BOLD, 26));
        reviewsLabel.setForeground(new Color(102, 51, 0));
        reviewsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        reviewsPanel.add(reviewsLabel);
        reviewsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Review container with side-by-side layout
        JPanel reviewContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        reviewContainer.setOpaque(false);
        reviewsPanel.add(reviewContainer);

        String[][] reviews = {
            {"★★★★★ Great product, super cute and useful!", "★★★★★ Great product, super cute and useful! It really helps keep my desk organized and Naven's design is adorable. The quality is top-notch and I couldn't be happier!"},
            {"★★★★☆ Naven is the best mascot, love it!", "★★★★☆ Naven is the best mascot, love it! The only reason I didn't give five stars is because I wish there were more color options. Otherwise, it's fantastic!"},
            {"★★★★★ Excellent quality and fast delivery!", "★★★★★ Excellent quality and fast delivery! The packaging was eco-friendly and the product arrived sooner than expected. Highly recommend to everyone!"},
            {"★★★★☆ Friendly customer service and charming design.", "★★★★☆ Friendly customer service and charming design. They were very helpful when I had a question about my order. The design is lovely, though a bit smaller than I imagined."}
        };

        for (String[] review : reviews) {
            String previewText = review[0];
            String fullText = review[1];

            JPanel reviewBox = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                }
            };
            reviewBox.setOpaque(false);
            reviewBox.setBackground(Color.WHITE);
            reviewBox.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            reviewBox.setLayout(new BorderLayout());
            reviewBox.setPreferredSize(new Dimension(350, 80));
            reviewBox.setMaximumSize(new Dimension(350, 80));
            reviewBox.putClientProperty("expanded", false);

            JLabel reviewLabel = new JLabel("<html>" + previewText + "</html>");
            reviewLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
            reviewLabel.setForeground(new Color(102, 51, 0));

            JButton toggleBtn = new JButton("Read more");
            toggleBtn.setFont(new Font("Poppins", Font.PLAIN, 12));
            toggleBtn.setFocusPainted(false);
            toggleBtn.setBackground(new Color(255, 220, 202));
            toggleBtn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            rightPanel.setOpaque(false);
            rightPanel.add(toggleBtn);

            reviewBox.add(reviewLabel, BorderLayout.CENTER);
            reviewBox.add(rightPanel, BorderLayout.EAST);

            toggleBtn.addActionListener(e -> {
                boolean isExpanded = (boolean) reviewBox.getClientProperty("expanded");
                reviewBox.putClientProperty("expanded", !isExpanded);

                if (!isExpanded) {
                    reviewLabel.setText("<html>" + fullText + "</html>");
                    reviewBox.setPreferredSize(new Dimension(350, 150));
                    reviewBox.setMaximumSize(new Dimension(350, 150));
                    toggleBtn.setText("Read less");
                } else {
                    reviewLabel.setText("<html>" + previewText + "</html>");
                    reviewBox.setPreferredSize(new Dimension(350, 80));
                    reviewBox.setMaximumSize(new Dimension(350, 80));
                    toggleBtn.setText("Read more");
                }

                reviewContainer.revalidate();
                reviewContainer.repaint();
            });

            reviewContainer.add(reviewBox);
        }

        // Final layout
        add(navPanel, BorderLayout.NORTH);
        add(topContent, BorderLayout.CENTER);
        add(reviewsPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SnugBudMainFrame mainFrame = new SnugBudMainFrame();
        mainFrame.setVisible(true);
    }
}