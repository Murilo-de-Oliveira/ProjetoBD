package br.inatel.DAO;

import br.inatel.Model.Empregado;
import br.inatel.Model.Pedido;

import java.sql.SQLException;
public class PedidoDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Inserir pedido no Banco de Dados
    public boolean insertPedido(Pedido pedido){

        connect();

        String sql = "INSERT INTO cliente (idPedido,data,clienteId, empregadoId) values (?,?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,pedido.getIdPedido());
            pst.setString(2,pedido.getData());
            pst.setInt(3,pedido.getClienteId());
            pst.setInt(4,pedido.getEmpregadoId());
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
