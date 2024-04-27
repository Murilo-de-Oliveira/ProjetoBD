package br.inatel.DAO;

import br.inatel.Model.Cliente;
import br.inatel.Model.Remedio;

import java.sql.SQLException;
public class RemedioDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Inserir remédio no Banco de Dados
    public boolean insertRemedio(Remedio remedio){

        connect();

        String sql = "INSERT INTO cliente (id,nomeRemedio,fabricante,tipoRemedio,estoque,validade,preco) values (?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,remedio.getId());
            pst.setString(2,remedio.getNomeRemedio());
            pst.setString(7,remedio.getFabricante());
            pst.setString(4,remedio.getTipoRemedio());
            pst.setInt(5,remedio.getEstoque());
            pst.setString(6,remedio.getValidade());
            pst.setDouble(7,remedio.getPreco());
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
