public class Seller extends User {
    private double salario;

    public Seller(String nome, String cpf, String email, double salario) {
        super(nome, cpf, email);
        this.salario = salario;
    }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String getUserDetails() {
        return "Seller: " + getNome() + ", Salário: " + getSalario();
    }
}