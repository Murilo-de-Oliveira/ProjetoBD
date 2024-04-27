package br.inatel.DAO;

import br.inatel.Model.Cliente;
import br.inatel.Model.PedidoHasRemedio;

import java.sql.SQLException;
public class PedidoHasRemedioDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Inserir relação de pedido e remédio no Banco de Dados
    public boolean insertPedidoRemedio(PedidoHasRemedio pedidoHasRemedio){

        connect();

        String sql = "INSERT INTO pedidoHasremedio (idPedido,idRemedio,preco,qntPedida) values (?,?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,pedidoHasRemedio.getIdPedido());
            pst.setInt(2,pedidoHasRemedio.getIdRemedio());
            pst.setDouble(3,pedidoHasRemedio.getPreco());
            pst.setInt(4,pedidoHasRemedio.getQntPedido());
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
