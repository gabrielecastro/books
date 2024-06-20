
## Livraria Online Books

A Livraria Books é um sistema de vendas de livros desenvolvido com Java Desktop utilizando a biblioteca Swing. Os usuários podem navegar, pesquisar e comprar livros de vários gêneros e autores. O sistema oferece uma interface amigável e intuitiva, proporcionando uma experiência agradável de compra de livros e demonstra o uso dos quatro pilares da orientação a objetos: herança, encapsulamento, polimorfismo e abstração.

![logo](src/Images/logo-login.png)


### Rodando a aplicação
1 - Clone o repositório:
```bash
  git clone https://github.com/seu-usuario/seu-repositorio.git
  cd seu-repositorio
```

2 - Compilar e Executar:

- Abra o projeto no seu ambiente de desenvolvimento Java.
- Compile o projeto.
- Execute a classe Main para iniciar a aplicação.
- **Email para login:** leitor@top
- **Senha para login:** java

![gif](src/Images/books.gif)

### Telas do Sistema

#### Tela de Login

**Descrição**: Tela inicial onde o usuário deve inserir suas credenciais para acessar o sistema.

**Funcionalidade**: Validação de email e senha
(email: leitor@top, senha: java).

**Classe**: LoginScreen

#### Tela Home (Vitrine de Produtos):

**Descrição**: Exibe uma lista de livros disponíveis para compra.

**Funcionalidade**: Mostra os detalhes dos livros (imagem, título, autor, preço, avaliação) e permite clicar em um livro para ver mais detalhes.

**Classe**: BookStoreScreen

#### Tela de Detalhes do Livro:

**Descrição**: Mostra informações detalhadas sobre um livro selecionado.

**Funcionalidade**: Exibe a imagem do livro, título, autor, sinopse, preço e avaliação.
Permite adicionar o livro ao carrinho de compras.

**Classe**: BookDetailsScreen

#### Tela de Carrinho de Compras

**Descrição**: Exibe os livros adicionados ao carrinho de compras.

**Funcionalidade**: Permite que os usuários revisem os itens antes de finalizar a compra.  Exibe o total da compra e permite prosseguir para a tela de pagamento.

**Classe**: CartScreen

#### Tela de Pagamento

**Descrição**: Permite ao usuário selecionar a forma de pagamento e finalizar a compra.

**Funcionalidade**: Oferece opções de pagamento (cartão de crédito, cartão de débito, Pix, boleto) e exibe o resumo da compra.

**Classe**: PaymentScreen

### Pilares da Orientação a Objetos
Exemplos de uso de cada pilar:

#### Herança
As classes Client e Seller herdam da classe abstrata User.

```bash
  public abstract class User {
    protected String nome;
    protected String cpf;
    protected String email;

    // Métodos comuns a todos os usuários
}

public class Client extends User {
    private String endereco;

    public Client(String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email);
        this.endereco = endereco;
    }
}

public class Seller extends User {
    private double salario;

    public Seller(String nome, String cpf, String email, double salario) {
        super(nome, cpf, email);
        this.salario = salario;
    }
}

```
#### Encapsulamento
Uso de getters e setters na classe User.

```bash
  public abstract class User {
    protected String nome;
    protected String cpf;
    protected String email;

    public User(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public abstract String getUserDetails();
}

```
#### Polimorfismo
Método getUserDetails nas classes Client e Seller.

```bash
 public abstract class User {
    // Outros atributos e métodos

    public abstract String getUserDetails();
}

public class Client extends User {
    private String endereco;

    @Override
    public String getUserDetails() {
        return "Client: " + getNome() + ", Endereço: " + getEndereco();
    }
}

public class Seller extends User {
    private double salario;

    @Override
    public String getUserDetails() {
        return "Seller: " + getNome() + ", Salário: " + getSalario();
    }
}


```

#### Abstração
A classe User é abstrata e serve de base para Client e Seller.

```bash
 public abstract class User {
    protected String nome;
    protected String cpf;
    protected String email;

    public User(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // Métodos abstratos e concretos
    public abstract String getUserDetails();
}

```

### Conlusão
O sistema de livros foi desenvolvido de forma a atender os requisitos solicitados, entretanto, existem diversas
melhorias que podem e devem ser feitas para que proporcione uma melhor experiencia para o 
usuário. Algumas dessas melhorias são:

- Validação de email e senha
- Opção para o usuário se registrar no sistema
- Sessão de perfil para o usuário cadastrar seus dados, alterar senha, etc.
- Adicionar no ícone de carrinho um número ou sinal para que o usuário veja que existe itens no carrinho dele
- Validação pra caso o usuário adicione mais de um livro do mesmo no carrinho (para que mude apenas a quantidade e não adicione um item novo)
- Formulário de cadastro dos dados do cartão
- Layout de forma geral
- Estrutura de organização de pastas no código
- Entre outras