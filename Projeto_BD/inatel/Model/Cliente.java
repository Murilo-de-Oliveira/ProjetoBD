package br.inatel.Model;

import java.util.Date;

public class Cliente {
    private static int id;
    private int idTemp;
    private String nome;
    private String telefone;
    private String endereco;
    private String data;

    public Cliente(String nome, String telefone, String endereco, String data) {
        id++;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.data = data;
    }

    public Cliente(int id, String nome, String telefone, String endereco, String data) {
        this.idTemp = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.data = data;
    }

    public int getId() {
        return id;
    }
    public int getIdTemp() {
        return idTemp;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getData() {
        return data;
    }
}
