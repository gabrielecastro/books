import javax.swing.*;
import java.awt.*;

public class CartScreen extends JPanel {
    private JFrame parentFrame;
    private Cart cart;

    public CartScreen(JFrame frame) {
        this.parentFrame = frame;
        this.cart = Cart.getInstance();

        setLayout(new BorderLayout());
        add(new HeaderPanel(parentFrame), BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        mainPanel.setBackground(Color.decode("#fbfefb"));

        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        cartPanel.setBackground(Color.decode("#fbfefb"));
        double total = 0;

        for (Book book : cart.getBooks()) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            itemPanel.setBackground(Color.decode("#fbfefb"));

            // painel para imagem e detalhes
            JPanel imageAndDetailsPanel = new JPanel(new BorderLayout());
            imageAndDetailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


            // adiciona imagem do livro
            ImageIcon originalIcon = book.getCoverImage();
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon);
            imageAndDetailsPanel.add(imageLabel, BorderLayout.WEST);

            // adiciona detalhes do livro
            JPanel detailsPanel = new JPanel(new GridLayout(2, 1));
            detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            detailsPanel.setBackground(Color.decode("#fbfefb"));

            detailsPanel.add(new JLabel("Title: " + book.getTitle()));
            detailsPanel.add(new JLabel("Price: $" + book.getPrice()));

            total += book.getPrice();

            imageAndDetailsPanel.add(detailsPanel, BorderLayout.CENTER);
            itemPanel.add(imageAndDetailsPanel, BorderLayout.CENTER);
            cartPanel.add(itemPanel);
        }

        // adiciona total geral no final
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        totalPanel.setBackground(Color.decode("#fbfefb"));
        totalPanel.add(new JLabel("Total: $" + total));
        cartPanel.add(totalPanel);

        mainPanel.add(new JScrollPane(cartPanel), BorderLayout.CENTER);

        // botão de pagamento
        JButton paymentButton = new JButton("Prosseguir para pagamento");
        paymentButton.setBackground(Color.decode("#594A47"));
        paymentButton.setForeground(Color.WHITE);
        paymentButton.setFocusPainted(false);
        paymentButton.setPreferredSize(new Dimension(300, 40));
        paymentButton.addActionListener(e -> {
            parentFrame.getContentPane().removeAll();
            parentFrame.add(new PaymentScreen(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.decode("#fbfefb"));
        buttonPanel.add(paymentButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }
}
