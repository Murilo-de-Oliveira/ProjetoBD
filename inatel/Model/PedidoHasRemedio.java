package br.inatel.Model;

public class PedidoHasRemedio {
    private int idPedido;
    private int idRemedio;
    private double preco;
    private int qntPedido;

    public PedidoHasRemedio(int idPedido, int idRemedio, double preco, int qntPedido) {
        this.idPedido = idPedido;
        this.idRemedio = idRemedio;
        this.preco = preco;
        this.qntPedido = qntPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdRemedio() {
        return idRemedio;
    }

    public double getPreco() {
        return preco;
    }

    public int getQntPedido() {
        return qntPedido;
    }
}