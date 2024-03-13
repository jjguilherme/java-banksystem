//NOME: JOAO GUILHERME DE SOUZA - RA:2479516
//TURMA: ADS 2023/1



import java.util.ArrayList;

public class Agencia {

    private ArrayList<Conta> contas = new ArrayList<>();

    private Banco banco;

    private int id;

    private String numero;
    private String cidade;
    public static int contadorAgencias = 0;


    public Agencia(int id1, String numero1, String cidade1) {

    }


    public Agencia(Banco banco, int id, String numero, String cidade) {
        this.banco = banco;
        this.id = id;
        this.numero = numero;
        this.cidade = cidade;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
