import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BookStoreScreen extends JPanel {
    private JFrame parentFrame;
    private ArrayList<Book> books;

    public BookStoreScreen(JFrame frame) {
        this.parentFrame = frame;
        books = createBookList();

        setLayout(new BorderLayout());
        setBackground(Color.decode("#fbfefb"));
        add(new HeaderPanel(parentFrame), BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#fbfefb"));

        // seção em destaque logo abaixo do header
        JPanel featuredSectionContainer = new JPanel(new BorderLayout());
        featuredSectionContainer.setBackground(Color.decode("#fbfefb"));
        featuredSectionContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
        featuredSectionContainer.add(new FeaturedSection(), BorderLayout.CENTER);
        mainPanel.add(featuredSectionContainer);

        JPanel bookGrid = new JPanel(new GridLayout(0, 5, 0, 30));
        bookGrid.setBackground(Color.decode("#fbfefb"));
        for (Book book : books) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            bookPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            bookPanel.setBackground(Color.decode("#fbfefb"));

            JLabel coverLabel = new JLabel(book.getCoverImage());
            coverLabel.setHorizontalAlignment(JLabel.CENTER);
            coverLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bookPanel.add(coverLabel, BorderLayout.CENTER);

            JPanel infoPanel = new JPanel(new GridLayout(4, 1));
            infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
            infoPanel.setBackground(Color.decode("#fbfefb"));

            JLabel titleLabel = new JLabel(book.getTitle(), SwingConstants.CENTER);
            titleLabel.setFont(new Font("Serif", Font.BOLD, 14));
            infoPanel.add(titleLabel);

            JLabel authorLabel = new JLabel(book.getAuthor(), SwingConstants.CENTER);
            infoPanel.add(authorLabel);

            JLabel priceLabel = new JLabel(String.format("$%.2f", book.getPrice()), SwingConstants.CENTER);
            infoPanel.add(priceLabel);

            // adiciona estrelinhas de avaliação
            JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            ratingPanel.setBackground(Color.decode("#fbfefb"));
            for (int i = 0; i < 5; i++) {
                JLabel starLabel;
                if (i < book.getRating()) {
                    starLabel = new JLabel("<html><font color='rgb(252,163,17)' style='font-size: 14px;'>★</font></html>");
                } else {
                    starLabel = new JLabel("<html><font color='rgb(252,163,17)' style='font-size: 14px;'>☆</font></html>");
                }
                ratingPanel.add(starLabel);
            }
            infoPanel.add(ratingPanel);

            bookPanel.add(infoPanel, BorderLayout.SOUTH);
            bookPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    parentFrame.getContentPane().removeAll();
                    parentFrame.add(new BookDetailsScreen(parentFrame, book));
                    parentFrame.revalidate();
                    parentFrame.repaint();
                }
            });
            bookGrid.add(bookPanel);
        }

        // adiciona o painel de grade de livros ao painel principal
        mainPanel.add(bookGrid);

        // adiciona o painel principal a um JScrollPane para torná-lo rolável
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remover a borda do JScrollPane
        scrollPane.getViewport().setBackground(Color.decode("#fbfefb")); // Definindo a cor de fundo do JScrollPane

        // adiciona o JScrollPane à tela
        add(scrollPane, BorderLayout.CENTER);
    }

    private ArrayList<Book> createBookList() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("É Assim que Acaba", "Colleen Hoover", 43,"src/Images/e-assim-que-acaba.jpg", 5, "Em É assim que acaba , Colleen Hoover nos apresenta Lily, uma jovem que se mudou de uma cidadezinha do Maine para Boston, se formou em marketing e abriu a própria floricultura. E é em um dos terraços de Boston que ela conhece Ryle, um neurocirurgião confiante, teimoso e talvez até um pouco arrogante, com uma grande aversão a relacionamentos, mas que se sente muito atraído por ela.\n" +
                "\n" +
                "Quando os dois se apaixonam, Lily se vê no meio de um relacionamento turbulento que não é o que ela esperava. Mas será que ela conseguirá enxergar isso, por mais doloroso que seja?\n" +
                "\n" +
                "É assim que acaba é uma narrativa poderosa sobre a força necessária para fazer as escolhas certas nas situações mais difíceis. Considerada a obra mais pessoal de Hoover, o livro aborda sem medo alguns tabus da sociedade para explorar a complexidade das relações tóxicas, e como o amor e o abuso muitas vezes coexistem em uma confusão de sentimentos."));
        books.add(new Book("Orgulho e Preconceito", "Jane Austen", 41,"src/Images/orgulho-e-preconceito.jpg", 3, "Sinopse de Orgulho e Preconceito..."));
        books.add(new Book("P.S. Eu te amo", "Cecilia Ahern", 28,"src/Images/ps-eu-te-amo.jpg", 3, "Sinopse de P.S. Eu te amo..."));
        books.add(new Book("Diário de uma paixão", "Nicholas Sparks", 44, "src/Images/diar.paix.jpg", 2, "Sinopse de Diário de uma paixão..."));
        books.add(new Book("Imperfeitos", "Christina Lauren ", 44,"src/Images/imperfeito.jpg", 3, "Sinopse de Imperfeitos..."));
        books.add(new Book("Emma", "Jane Austen", 24,"src/Images/emma.jpg", 4, "Sinopse de Emma..."));
        books.add(new Book("A hipótese do amor", "Thaís Britto", 44.90, "src/Images/hip-amor.jpg", 2, "Sinopse de A hipótese do amor..."));
        books.add(new Book("Todas as suas (im)perfeições", "Colleen Hoover", 43.22,"src/Images/todas-as-suas-imperfeicoes.jpg", 3, "Sinopse de Todas as suas imperfeições..."));

        books.add(new Book("Rua do Medo", "R. L. Stine", 35.40,"src/Images/rua-do-medo.jpg", 2, "Não leia à noite!!!\n" +
                "\n" +
                "Edição especial em capa dura, reunindo três das histórias mais aterrorizantes da série que inspirou os filmes de sucesso da Netflix."));
        books.add(new Book("A psicologia financeira", " Morgan Housel", 28,"src/Images/psicologia-financeira.jpg", 4, "A maneira como lidamos com o dinheiro ― finanças pessoais, investimentos, decisões de negócios ― costuma ser explicada como um campo puramente matemático, no qual dados e fórmulas nos dizem o que fazer. A verdade, porém, é que grandes decisões monetárias não são tomadas diante de uma planilha, mas durante jantares com a família e reuniões com os colegas de trabalho. Além disso, cada uma delas é um reflexo da história pessoal e das dificuldades enfrentadas pelo indivíduo que as tomou.\n" +
                "\n" +
                "Abordando a gestão financeira de maneira inédita, Morgan Housel apresenta casos de sucessos e fracassos de investidores que demonstram a importância do fator psicológico no gerenciamento das finanças, oferecendo aprendizados para administrar e fazer o dinheiro render em busca do grande objetivo de todos nós: ser feliz."));
        books.add(new Book("O poder do hábito", "Charles Duhigg", 59.61, "src/Images/poder-do-hábito.jpg", 4, "Durante os últimos dois anos, uma jovem transformou quase todos os aspectos de sua vida. Parou de fumar, correu uma maratona e foi promovida. Em um laboratório, neurologistas descobriram que os padrões dentro do cérebro dela mudaram de maneira fundamental. Publicitários da Procter & Gamble observaram vídeos de pessoas fazendo a cama. Tentavam desesperadamente descobrir como vender um novo produto chamado Febreze, que estava prestes a se tornar um dos maiores fracassos na história da empresa. De repente, um deles detecta um padrão quase imperceptível - e, com uma sutil mudança na campanha publicitária, Febreze começa a vender um bilhão de dólares por anos. Um diretor executivo pouco conhecido assume uma das maiores empresas norte-americanas. Seu primeiro passo é atacar um único padrão entre os funcionários - a maneira como lidam com a segurança no ambiente de trabalho -, e logo a empresa começa a ter o melhor desempenho no índice Dow Jones.\n" +
                "\n" +
                "O que todas essas pessoas tem em comum? Conseguiram ter sucesso focando em padrões que moldam cada aspecto de nossas vidas. Tiveram êxito transformando hábitos. Com perspicácia e habilidade, Charles Duhigg apresenta um novo entendimento da natureza humana e seu potencial para a transformação."));

        books.add(new Book("O vilarejo", "Raphael Montes", 40.73,"src/Images/o-vilarejo.jpg", 2, "Em 1589, o padre e demonologista Peter Binsfeld fez a ligação de cada um dos pecados capitais a um demônio, supostamente responsável por invocar o mal nas pessoas. É a partir daí que Raphael Montes cria sete histórias situadas em um vilarejo isolado, apresentando a lenta degradação dos moradores do lugar, e pouco a pouco o próprio vilarejo vai sendo dizimado, maculado pela neve e pela fome.\n" +
                "As histórias podem ser lidas em qualquer ordem, sem prejuízo de sua compreensão, mas se relacionam de maneira complexa, de modo que ao término da leitura as narrativas convergem para uma única e surpreendente conclusão.\n" +
                "\n"));
        books.add(new Book("O Pequeno Príncipe", "Antoine de Saint-Exupéry ", 24,"src/Images/o-pequeno-principe.jpg", 5, "Nesta história que marcou gerações de leitores em todo o mundo, um piloto cai com seu avião no deserto do Saara e encontra um pequeno príncipe, que o leva a uma aventura filosófica e poética através de planetas que encerram a solidão humana.\n" +
                "\n" +
                "Um livro para todos os públicos, O pequeno príncipe é uma obra atemporal, com metáforas pertinentes e aprendizados sobre afeto, sonhos, esperança e tudo aquilo que é invisível aos olhos. "));
        books.add(new Book("A garota do lago", "harlie Donlea", 44.90, "src/Images/garota-do-lago.jpg", 3, "Summit Lake, uma pequena cidade entre montanhas, é esse tipo de lugar, bucólico e com encantadoras casas dispostas à beira de um longo trecho de água intocada.Duas semanas atrás, a estudante de direito Becca Eckersley foi brutalmente assassinada em uma dessas casas. Filha de um poderoso advogado, Becca estava no auge de sua vida. Atraída instintivamente pela notícia, a repórter Kelsey Castle vai até a cidade para investigar o caso. ...E LOGO SE ESTABELECE UMA CONEXÃO ÍNTIMA QUANDO UM VIVO CAMINHA NAS MESMAS PEGADAS DOS MORTOS...E enquanto descobre sobre as amizades de Becca, sua vida amorosa e os segredos que ela guardava, a repórter fica cada vez mais convencida de que a verdade sobre o que aconteceu com Becca pode ser a chave para superar as marcas sombrias de seu próprio passado."));

        return books;
    }
}
