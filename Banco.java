//NOME: JOAO GUILHERME DE SOUZA - RA:2479516
//TURMA: ADS 2023/1

import java.util.ArrayList;

public class Banco {

    private ArrayList<Agencia> agencias = new ArrayList<>(); //para listar as agencias

    private int id;
    private String nome;
    private String numero;

    public static int contadorBancos = 0;

    public Banco() {

    }

    public Banco(int id, String nome, String numero){
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public ArrayList<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
