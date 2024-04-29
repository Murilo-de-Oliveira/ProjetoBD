package br.inatel;

import br.inatel.Model.*;
import br.inatel.DAO.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Estanciando variáveis de entrada e controle
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        Boolean flag2;
        Boolean flag3;
        Boolean flag4;

        //Estanciando as classes de BD utilizadas
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpregadoDAO empregadoDAO = new EmpregadoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        RemedioDAO remedioDAO = new RemedioDAO();
        PedidoHasRemedioDAO pedidoHasRemedioDAO = new PedidoHasRemedioDAO();

        //Informações do cliente
        int id;
        String nome;
        String telefone;
        String endereco;
        String dataCliente;

        //Informações do pedido
        int idPedido;
        String dataPedido;

        //Informações do remédio
        String nomeRemedio;
        String fabricante;
        String tipoRemedio;
        int estoque;
        String validade;
        double preco;

        //Instanciando a classe de adquirir a data
        Data data = new Data();

        while(flag){
            System.out.println("Bem vindo ao sistema da Farmácia");
            System.out.println("Selecione uma das opções abaixo: ");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar remédio");
            System.out.println("3 - Criar pedido");
            System.out.println("4 - Sair");
            System.out.print("\nOpção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1 -> {
                    System.out.println("Cadastro de Cliente");
                    System.out.println("Entre com as informações do cliente: ");
                    System.out.println("Nome: ");
                    nome = sc.nextLine();
                    System.out.println("Telefone: ");
                    telefone = sc.nextLine();
                    System.out.println("Endereço: ");
                    endereco = sc.nextLine();
                    System.out.println("Data: ");
                    dataCliente = sc.nextLine();

                    Cliente cliente = new Cliente(
                            nome,
                            telefone,
                            endereco,
                            dataCliente
                    );

                    clienteDAO.insertCliente(cliente);
                }

                case 2 -> {
                    System.out.println("Cadastro de Remédio");
                    System.out.println("Entre com as informações do remédio: ");
                    System.out.println("Nome: ");
                    nomeRemedio = sc.nextLine();
                    System.out.println("Fabricante: ");
                    fabricante = sc.nextLine();
                    System.out.println("Tido de Remédio: ");
                    tipoRemedio = sc.nextLine();
                    System.out.println("Validade: ");
                    validade = sc.nextLine();
                    System.out.println("Estoque: ");
                    estoque = sc.nextInt();
                    System.out.println("Preço: ");
                    preco = sc.nextDouble();

                    Remedio remedio = new Remedio(
                            nomeRemedio,
                            fabricante,
                            tipoRemedio,
                            estoque,
                            validade,
                            preco
                    );

                    remedioDAO.insertRemedio(remedio);
                }

            }
        }
    }
}