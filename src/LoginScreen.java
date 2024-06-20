import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JPanel {
    private JFrame parentFrame;

    public LoginScreen(JFrame frame) {
        this.parentFrame = frame;
        setLayout(new BorderLayout());
        setBackground(Color.decode("#fbfefb"));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.decode("#fbfefb"));

        // logo
        ImageIcon logoIcon = resizeImageIcon("src/Images/logo-login.png", 200, 200);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(logoLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // campo de email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(200, 30));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(emailField);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // campo de senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(200, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(passwordField);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // botão de login
        JButton loginButton = new JButton("Entrar");
        loginButton.setBackground(Color.decode("#594A47"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(parentFrame, "Todos os campos devem ser preenchidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            } else if (email.equals("leitor@top") && password.equals("java")) {
                parentFrame.getContentPane().removeAll();
                parentFrame.add(new BookStoreScreen(parentFrame));
                parentFrame.revalidate();
                parentFrame.repaint();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Email ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
        });
        mainPanel.add(loginButton);

        add(mainPanel, BorderLayout.CENTER);
    }

    private ImageIcon resizeImageIcon(String path, int width, int height) {
        try {
            Image img = new ImageIcon(path).getImage();
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
