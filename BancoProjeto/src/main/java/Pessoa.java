//NOME: JOAO GUILHERME DE SOUZA - RA:2479516
//TURMA: ADS 2023/1
//VERSAO NETBEANS 17



import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pessoa {

    private String nome;
    private String endereco;
    private String contato;

    public Pessoa() {

    }

    public Pessoa(String nome, String endereco, String contato) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContato() {
        return contato;
    }

    //O metodo getDataNascimento() eh sobrescrito na classe PessoaFisica,
    //utilizando a anotacao @Override. Isso indica que o método está substituindo o
    //comportamento definido na classe pai Pessoa.
    public abstract LocalDate getDataNascimento();

    public int calcularIdade() {
        LocalDate dataNascimento = getDataNascimento();
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataNascimento.getYear();
        if (dataNascimento.getMonthValue() > dataAtual.getMonthValue()
                || (dataNascimento.getMonthValue() == dataAtual.getMonthValue()
                && dataNascimento.getDayOfMonth() > dataAtual.getDayOfMonth())) {
            idade--;
        }
        return idade;
    }

    public ArrayList<Conta> getContas(ArrayList<Banco> bancos) {
        ArrayList<Conta> contas = new ArrayList<>();

        for (int i = 0; i < bancos.size(); i++) {

            Banco banco = bancos.get(i);
            for (int j = 0; j < banco.getAgencias().size(); j++) {
                Agencia agencia = banco.getAgencias().get(j);
                for (int x = 0; x < agencia.getContas().size(); x++) {
                    Conta conta = agencia.getContas().get(x);
                    if (conta.getCliente().getContato() == null ? this.getContato() == null : conta.getCliente().getContato().equals(this.getContato())) {
                        contas.add(conta);
                    }
                }
            }
        }

        return contas;
    }

}
