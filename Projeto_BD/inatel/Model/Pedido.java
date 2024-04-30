package br.inatel.Model;
import java.util.Date;

public class Pedido {
    private static int idPedido;
    private int idPedidoTemp;
    private String data;
    private int clienteId;
    private int empregadoId;

    public Pedido(String data, int clienteId, int empregadoId) {
        idPedido++;
        this.data = data;
        this.clienteId = clienteId;
        this.empregadoId = empregadoId;
    }
    public Pedido(int idPedido, String data, int clienteId, int empregadoId) {
        this.idPedidoTemp = idPedido;
        this.data = data;
        this.clienteId = clienteId;
        this.empregadoId = empregadoId;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getData() {
        return data;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getEmpregadoId() {
        return empregadoId;
    }
}
