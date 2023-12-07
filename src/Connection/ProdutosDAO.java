package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Produtos;
import logs.RegistroOperacoes;


public class ProdutosDAO {

    private Connection connection;
    private List<Produtos> produtos;

    public ProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos_lojaprodutos (NOME VARCHAR(255), DESCRICAO VARCHAR(255), PRECO VARCHAR(255) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        produtos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM produtos_lojaprodutos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos produto = new Produtos(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("preco")
                );
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return produtos;
    }

    public void cadastrar(String nome, String descricao, String preco) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO produtos_lojaprodutos (nome, descricao, preco) VALUES (?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, preco);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
            new RegistroOperacoes().registrarOperacao("Produto '" + nome + "' Cadastrado com Sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void atualizar(String nome, String descricao, String preco) {
        PreparedStatement stmt = null;
        String sql = "UPDATE produtos_lojaprodutos SET descricao = ?, preco = ? WHERE nome = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, descricao);
            stmt.setString(2, preco);
            stmt.setString(3, nome);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
            new RegistroOperacoes().registrarOperacao("Produto '" + nome + "' Atualizado com Sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void apagar(String nome) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM produtos_lojaprodutos WHERE nome = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
            new RegistroOperacoes().registrarOperacao("Produto '" + nome + "' Apagado do Banco com Sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
