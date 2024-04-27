package br.inatel.Model;

public class Empregado {
    private int id;
    private String nome;
    private String sobrenome;
    private String funcao;
    private int salario;
    private int telefone;

    public Empregado(int id, String nome, String sobrenome, String funcao, int salario, int telefone) {
        this.id = id;
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

    public int getTelefone() {
        return telefone;
    }
}
