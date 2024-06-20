import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Book Store");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // define tela cheia
            frame.setUndecorated(true); // romove bordas e barra de título
            frame.setLocationRelativeTo(null);

            LoginScreen loginScreen = new LoginScreen(frame);
            frame.add(loginScreen);
            frame.setVisible(true);
        });
    }
}
