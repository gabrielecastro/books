public class Client extends User {
    private String endereco;

    public Client(String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email);
        this.endereco = endereco;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    @Override
    public String getUserDetails() {
        return "Client: " + getNome() + ", Endereço: " + getEndereco();
    }
}