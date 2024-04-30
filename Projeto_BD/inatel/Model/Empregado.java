package br.inatel.Model;

public class Empregado {
    private static int id;
    private int idTemp;
    private String nome;
    private String sobrenome;
    private String funcao;
    private int salario;
    private String telefone;

    public Empregado(String nome, String sobrenome, String funcao, int salario, String telefone) {
        id++;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.funcao = funcao;
        this.salario = salario;
        this.telefone = telefone;
    }
    public Empregado(int idTemp, String nome, String sobrenome, String funcao, int salario, String telefone) {
        this.idTemp = idTemp;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.funcao = funcao;
        this.salario = salario;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getFuncao() {
        return funcao;
    }

    public int getSalario() {
        return salario;
    }

    public String getTelefone() {
        return telefone;
    }
}
