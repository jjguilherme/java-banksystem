//NOME: JOAO GUILHERME DE SOUZA - RA:2479516
//TURMA: ADS 2023/1
//VERSAO NETBEANS 17

import java.util.ArrayList;
import java.time.LocalDate;
public class PessoaFisica extends Pessoa {

    private String cpf;
    private int rg;
    private LocalDate dataNascimento;
    public static int contadorFisica = 0;

    public PessoaFisica(String nome, String endereco, String contato, String cpf, int rg, LocalDate dataNascimento) {
        super(nome, endereco, contato);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }



    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public ArrayList<Conta> getContas(ArrayList<Banco> bancos) {
        ArrayList<Conta> contas = new ArrayList<>();

        for (int i = 0; i < bancos.size(); i++) {

            Banco banco = bancos.get(i); // representa o banco da iteração atual
            for (int j = 0; j < banco.getAgencias().size(); j++) {
                Agencia agencia = banco.getAgencias().get(j); // agência da iteração atual
                for (int x = 0; x < agencia.getContas().size(); x++) {
                    Conta conta = agencia.getContas().get(x); // conta da iteração atual
                    if (conta.getCliente() instanceof PessoaFisica pf) { // verifica se é uma pessoa física
                        if (pf.getCpf().equals(this.getCpf())) { // verifica o CPF da pessoa
                            contas.add(conta);
                        }
                    }
                }
            }

        }
        return contas;
    }
}
