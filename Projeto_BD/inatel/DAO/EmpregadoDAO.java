package br.inatel.DAO;

import br.inatel.Model.Empregado;

import java.sql.SQLException;
public class EmpregadoDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Inserir empregado no Banco de Dados
    public boolean insertEmpregado(Empregado empregado){

        connect();

        String sql = "INSERT INTO cliente (id,nome,sobrenome,funcao,salario,telefone) values (?,?,?,?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,empregado.getId());
            pst.setString(2,empregado.getNome());
            pst.setString(3,empregado.getSobrenome());
            pst.setString(4,empregado.getFuncao());
            pst.setInt(5,empregado.getSalario());
            pst.setInt(6,empregado.getTelefone());
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
