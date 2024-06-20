import javax.swing.*;
import java.awt.*;

public class FeaturedSection extends CustomPanel {
    public FeaturedSection() {
        super("src/Images/hobbit-fundo.jpg");

        setLayout(new BorderLayout());

        // texto descritivo com padding
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 30));

        JLabel descriptionLabel = new JLabel("<html>Um dos melhores clássicos, <br>da fantasia mundial!</html>");
        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionLabel.setForeground(Color.WHITE);
        textPanel.add(descriptionLabel);

        textPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel subDescriptionLabel = new JLabel("Comece a jornada pela Terra-média por aqui!");
        subDescriptionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        subDescriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        subDescriptionLabel.setForeground(Color.WHITE);
        textPanel.add(subDescriptionLabel);

        textPanel.add(Box.createVerticalGlue());

        JButton shopNowButton = new JButton("Comprar");
        shopNowButton.setFont(new Font("Serif", Font.BOLD, 16));
        shopNowButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        shopNowButton.setBackground(Color.decode("#5FCB29"));
        shopNowButton.setForeground(Color.WHITE);
        shopNowButton.setBorderPainted(false);
        shopNowButton.setPreferredSize(new Dimension(180, 40));
        shopNowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // adiciona o item ao carrinho
        shopNowButton.addActionListener(e -> {
            Cart.getInstance().addBook(new Book(
                    "O Hobbit",
                    "J.R.R. Tolkien",
                    44.56,
                    "src/Images/hobbit.jpg",
                    5,
                    "Bilbo Bolseiro era um dos mais respeitáveis hobbits de todo o Condado até que, um dia, o mago Gandalf bate à sua porta. A partir de então, toda sua vida pacata e campestre soprando anéis de fumaça com seu belo cachimbo começa a mudar. Ele é convocado a participar de uma aventura por ninguém menos do que Thorin Escudo-de-Carvalho, um príncipe do poderoso povo dos Anãos.\n" +
                            "\n" +
                            "Esta jornada fará Bilbo, Gandalf e 13 anãos atravessarem a Terra-média, passando por inúmeros perigos, como os imensos trols, as Montanhas Nevoentas infestadas de gobelins ou a muito antiga e misteriosa Trevamata, até chegarem (se conseguirem) na Montanha Solitária. Lá está um incalculável tesouro, mas há um porém. Deitado em cima dele está Smaug, o Dourado, um dragão malicioso que... bem, você terá que ler para descobrir."
            ));
            JOptionPane.showMessageDialog(this, "Item adicionado ao carrinho!");
        });

        textPanel.add(shopNowButton);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);
        leftPanel.add(textPanel, BorderLayout.CENTER);

        ImageIcon originalIcon = new ImageIcon("src/Images/hobbit.jpg");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel bookImageLabel = new JLabel(resizedIcon);
        bookImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel bookPanel = new JPanel(new BorderLayout());
        bookPanel.setOpaque(false);
        bookPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        bookPanel.add(bookImageLabel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setOpaque(false);
        mainPanel.add(leftPanel);
        mainPanel.add(bookPanel);

        add(mainPanel, BorderLayout.CENTER);
    }
}
