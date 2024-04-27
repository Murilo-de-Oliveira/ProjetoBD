package br.inatel.DAO;

import br.inatel.Model.Cliente;

import java.sql.SQLException;

public class ClienteDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Inserir cliente no Banco de Dados
    public boolean insertCliente(Cliente cliente){

        connect();

        String sql = "INSERT INTO cliente (id,nome,telefone,endereco,dataNascimento) values (?,?,?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,cliente.getId());
            pst.setString(2,cliente.getNome());
            pst.setString(3,cliente.getTelefone());
            pst.setString(4,cliente.getEndereco());
            pst.setString(5,cliente.getData());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex){
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return sucesso;
    }
}
