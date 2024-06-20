import javax.swing.*;
import java.awt.*;

public class BookDetailsScreen extends JPanel {
    private JFrame parentFrame;
    private Book book;

    public BookDetailsScreen(JFrame frame, Book book) {
        this.parentFrame = frame;
        this.book = book;

        setLayout(new BorderLayout());
        add(new HeaderPanel(parentFrame), BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        detailsPanel.setBackground(Color.decode("#fbfefb"));

        JPanel coverPanel = new JPanel(new BorderLayout());
        coverPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 40));
        coverPanel.setBackground(Color.decode("#fbfefb"));

        ImageIcon originalIcon = book.getCoverImage();
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel coverLabel = new JLabel(resizedIcon);
        coverLabel.setHorizontalAlignment(JLabel.CENTER);
        coverPanel.add(coverLabel, BorderLayout.CENTER);

        // informações do livro
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
        infoPanel.setBackground(Color.decode("#fbfefb"));

        JLabel titleLabel = new JLabel(book.getTitle());
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(titleLabel);

        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel authorLabel = new JLabel("Author: " + book.getAuthor());
        authorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(authorLabel);

        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel priceLabel = new JLabel(String.format("Price: $%.2f", book.getPrice()));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(priceLabel);

        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // alinha ratingPanel com outros textos
        JPanel ratingPanelContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ratingPanelContainer.setBackground(Color.decode("#fbfefb"));
        ratingPanelContainer.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ratingPanel.setBackground(Color.decode("#fbfefb"));
        for (int i = 0; i < 5; i++) {
            if (i < book.getRating()) {
                ratingPanel.add(new JLabel("<html><font color='rgb(252,163,17)' style='font-size: 18px;'>★</font></html>"));
            } else {
                ratingPanel.add(new JLabel("<html><font color='rgb(252,163,17)' style='font-size: 18px;'>☆</font></html>"));
            }
        }
        ratingPanelContainer.add(ratingPanel);
        infoPanel.add(ratingPanelContainer);

        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel synopsisLabel = new JLabel("<html><body style='width: 400px; margin-top: -100px; line-height: 1.5;'>" + book.getSynopsis() + "</body></html>");
        synopsisLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(synopsisLabel);

        // painel para o botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        buttonPanel.setBackground(Color.decode("#fbfefb"));

        JButton addToCartButton = new JButton("Adicionar ao Carrinho");
        addToCartButton.setBackground(Color.decode("#594A47"));
        addToCartButton.setForeground(Color.WHITE);
        addToCartButton.setPreferredSize(new Dimension(200, 40));
        addToCartButton.setMaximumSize(new Dimension(200, 40));
        addToCartButton.setFont(new Font("Serif", Font.BOLD, 16));

        addToCartButton.addActionListener(e -> {
            Cart.getInstance().addBook(book);
            JOptionPane.showMessageDialog(parentFrame, "Livro adicionado ao carrinho!");
        });

        buttonPanel.add(addToCartButton);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(buttonPanel);

        detailsPanel.add(infoPanel);
        detailsPanel.add(coverPanel);

        add(detailsPanel, BorderLayout.CENTER);
    }
}
