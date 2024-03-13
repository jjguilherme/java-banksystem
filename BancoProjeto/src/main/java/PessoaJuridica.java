//NOME: JOAO GUILHERME DE SOUZA - RA:2479516
//TURMA: ADS 2023/1
//VERSAO NETBEANS 17



import java.time.LocalDate;

public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String social;

    public static int contadorJuridicas = 0;

    public PessoaJuridica(String nome, String endereco, String contato, String cnpj, String social) {
        super(nome, endereco, contato);
        this.cnpj = cnpj;
        this.social = social;
    }

    @Override
    public LocalDate getDataNascimento() {
        // Como PessoaJuridica não tem data de nascimento, retorna null
        return null;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }
}
