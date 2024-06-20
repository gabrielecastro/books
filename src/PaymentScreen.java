import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaymentScreen extends JPanel {
    private JFrame parentFrame;

    public PaymentScreen(JFrame frame) {
        this.parentFrame = frame;

        setLayout(new BorderLayout());
        add(new HeaderPanel(parentFrame), BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Forma de pagamento", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 60, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        mainPanel.setBackground(Color.decode("#fbfefb"));

        // opções de pagamento
        JPanel paymentOptionsPanel = new JPanel();
        paymentOptionsPanel.setLayout(new BoxLayout(paymentOptionsPanel, BoxLayout.Y_AXIS));
        paymentOptionsPanel.setBackground(Color.decode("#fbfefb"));

        JRadioButton creditCardOption = new JRadioButton("Cartão de crédito");
        JRadioButton debitCardOption = new JRadioButton("Cartão de débito");
        JRadioButton pixOption = new JRadioButton("Pix");
        JRadioButton boletoOption = new JRadioButton("Boleto");

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(creditCardOption);
        paymentGroup.add(debitCardOption);
        paymentGroup.add(pixOption);
        paymentGroup.add(boletoOption);

        paymentOptionsPanel.add(creditCardOption);
        paymentOptionsPanel.add(debitCardOption);
        paymentOptionsPanel.add(pixOption);
        paymentOptionsPanel.add(boletoOption);

        // resumo de pagamento
        JPanel paymentSummaryPanel = new JPanel(new BorderLayout());
        paymentSummaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        paymentSummaryPanel.setBackground(Color.WHITE);

        JLabel summaryLabel = new JLabel("<html>Forma selecionada: Nenhuma</html>");
        summaryLabel.setVerticalAlignment(SwingConstants.TOP);
        paymentSummaryPanel.add(summaryLabel, BorderLayout.CENTER);

        // atualiza resumo quando uma opção é selecionada
        ActionListener updateSummary = e -> {
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            summaryLabel.setText("<html>Forma selecionada: " + selectedButton.getText() + "</html>");
        };

        creditCardOption.addActionListener(updateSummary);
        debitCardOption.addActionListener(updateSummary);
        pixOption.addActionListener(updateSummary);
        boletoOption.addActionListener(updateSummary);

        double total = Cart.getInstance().getTotal();
        JLabel totalLabel = new JLabel("Valor total: $" + total, SwingConstants.RIGHT);
        paymentSummaryPanel.add(totalLabel, BorderLayout.SOUTH);

        mainPanel.add(paymentOptionsPanel);
        mainPanel.add(paymentSummaryPanel);

        add(mainPanel, BorderLayout.CENTER);

        // botão de pagamento
        JButton payButton = new JButton("Pagar");
        payButton.setBackground(Color.decode("#594A47"));
        payButton.setForeground(Color.WHITE);
        payButton.setFocusPainted(false);
        payButton.setPreferredSize(new Dimension(300, 40));
        payButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(parentFrame, "Pagamento realizado com sucesso!");
            parentFrame.getContentPane().removeAll();
            parentFrame.add(new BookStoreScreen(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.decode("#fbfefb"));
        buttonPanel.add(payButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
