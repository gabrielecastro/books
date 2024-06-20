import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CustomPanel extends JPanel {
    private BufferedImage backgroundImage;

    public CustomPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            int width = getWidth();
            int height = getHeight();

            // desenha a imagem de fundo
            g.drawImage(backgroundImage, 0, 0, width, height, this);

            // cria um gradiente mais escuro
            Graphics2D g2d = (Graphics2D) g.create();
            GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(0, 0, 0, 200),
                    0, height, new Color(0, 0, 0, 150)
            );
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
            g2d.dispose();
        }
    }
}
