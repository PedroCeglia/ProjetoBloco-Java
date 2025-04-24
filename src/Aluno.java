public class Aluno {
    String matricula, nome, endereco, telefone, email;

    Aluno(String matricula, String nome, String endereco, String telefone, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    String toCsvLine() {
        return matricula + "," + nome + "," + endereco + "," + telefone + "," + email;
    }
}