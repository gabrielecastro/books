import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeaderPanel extends JPanel {
    private JFrame parentFrame;

    public HeaderPanel(JFrame frame) {
        this.parentFrame = frame;
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));

        // carrega a imagem da logo
        ImageIcon logoIcon = resizeImageIcon("src/Images/logo.png", 100, 50);
        JButton logoButton = new JButton(logoIcon);
        logoButton.setContentAreaFilled(false);
        logoButton.setBorderPainted(false);
        logoButton.addActionListener(e -> {
            parentFrame.getContentPane().removeAll();
            parentFrame.add(new BookStoreScreen(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        add(logoButton, BorderLayout.WEST);


        JPanel rightPanel = new JPanel(new FlowLayout());
        rightPanel.setOpaque(false);
        rightPanel.setBorder(BorderFactory.createEmptyBorder());
        BorderFactory.createLineBorder(Color.WHITE, 1);

        // carrega ícone de perfil
        ImageIcon profileIcon = resizeImageIcon("src/Icons/profile.png", 30, 30);
        JButton profileButton = new JButton(profileIcon);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profileButton.addActionListener(e -> {
            parentFrame.getContentPane().removeAll();
            parentFrame.add(new LoginScreen(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        // carrega ícone de carrinho
        ImageIcon cartIcon = resizeImageIcon("src/Icons/shopping-cart.png", 30, 30);
        JButton cartButton = new JButton(cartIcon);
        cartButton.setContentAreaFilled(false);
        cartButton.setBorderPainted(false);
        cartButton.addActionListener(e -> {
            parentFrame.getContentPane().removeAll();
            parentFrame.add(new CartScreen(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        rightPanel.add(profileButton);
        rightPanel.add(cartButton);

        add(rightPanel, BorderLayout.EAST);
    }

    private ImageIcon resizeImageIcon(String path, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
