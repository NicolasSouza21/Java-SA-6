package Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Produtos;
import Connection.ProdutosDAO;


/**
 * ProdutosControl
 */
public class ProdutosControl {

    // Atributos
    private List<Produtos> produtos; // Lista de objetos Produtos
    private DefaultTableModel tableModel; // Modelo da tabela Swing para exibição dos dados
    private JTable table; // Tabela Swing onde os dados são exibidos

    // Construtor
    public ProdutosControl(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos; // Inicializa a lista de produtos
        this.tableModel = tableModel; // Inicializa o modelo da tabela
        this.table = table; // Inicializa a tabela Swing
    }

    public ProdutosControl() {
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos(); // Obtém os produtos atualizados do banco de dados
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getNome(), produto.getPreco(), produto.getDataValidade(), produto.getId() });
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String nome, String descricao, String preco) {
        new ProdutosDAO().cadastrar(nome, descricao, preco);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar(String nome, String descricao, String preco) {
        new ProdutosDAO().atualizar(nome, descricao, preco);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um produto do banco de dados
    public static void apagar(String nome) {
        new ProdutosDAO().apagar(nome);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }

    public List<Produtos> listarTodos() {
        return produtos;
    }
}
