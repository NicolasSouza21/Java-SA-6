package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.ProdutosControl;
import java.awt.event.*;
import Model.Clientes;
import Model.Produtos;

public class JanelaCadastroP extends JPanel {

    private JButton cadastrar, apagar, editar;
    private JTextField quantidade, produto, validade, valor;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public JanelaCadastroP() {
        super();

        // Entrada de Dados
         // Inicializa o controle de produtos
        ProdutosControl produtosControl = new ProdutosControl();

        // Entrada de Dados
        setLayout(new BorderLayout());
        add(new JLabel("Cadastro de Produtos"), BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        setLayout(new BorderLayout());
        add(new JLabel("Cadastro de Produtos"), BorderLayout.NORTH);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Quantidade"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        quantidade = new JTextField(20);
        inputPanel.add(quantidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Produto"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        produto = new JTextField(20);
        inputPanel.add(produto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Validade"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        validade = new JTextField(20);
        inputPanel.add(validade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Valor"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        valor = new JTextField(20);
        inputPanel.add(valor, gbc);

        add(inputPanel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes, BorderLayout.SOUTH);

       // ... (código anterior)

        add(inputPanel, BorderLayout.CENTER);

        
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");

        // Adiciona ação ao botão Cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        // Adiciona ação ao botão Editar
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProduto();
            }
        });

        // Adiciona ação ao botão Apagar
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagarProduto();
            }
        });

        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes, BorderLayout.SOUTH);

        // Tabela de Produtos
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Quantidade", "Produto", "Validade", "Valor" });
        table = new JTable(tableModel);
        JScrollPane jSPane = new JScrollPane(table);
        add(jSPane, BorderLayout.EAST);

        // Carrega os produtos na tabela ao iniciar
        carregarProdutos();
    }

    // Método para carregar os produtos na tabela
    private void carregarProdutos() {
        List<Produtos> listaProdutos = ProdutosControl.listarTodos();
        for (Produtos produto : listaProdutos) {
            adicionarProdutoNaTabela(produto);
        }
    }

    // Método para adicionar um produto na tabela
    private void adicionarProdutoNaTabela(Produtos produto) {
        tableModel.addRow(new Object[] { produto.getQuantidade(), produto.getProduto(), produto.getValidade(), produto.getValor() });
    }

    // Método para cadastrar um produto
    private void cadastrarProduto() {
        String qtd = quantidade.getText();
        String prod = produto.getText();
        String val = validade.getText();
        String valr = valor.getText();

        if (!qtd.isEmpty() && !prod.isEmpty() && !val.isEmpty() && !valr.isEmpty()) {
            ProdutosControl.cadastrar(qtd, prod, val, valr);
            adicionarProdutoNaTabela(new Produtos(qtd, prod, val, valr));
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para editar um produto
    private void editarProduto() {
        if (linhaSelecionada != -1) {
            String qtd = quantidade.getText();
            String prod = produto.getText();
            String val = validade.getText();
            String valr = valor.getText();

            if (!qtd.isEmpty() && !prod.isEmpty() && !val.isEmpty() && !valr.isEmpty()) {
                tableModel.setValueAt(qtd, linhaSelecionada, 0);
                tableModel.setValueAt(prod, linhaSelecionada, 1);
                tableModel.setValueAt(val, linhaSelecionada, 2);
                tableModel.setValueAt(valr, linhaSelecionada, 3);

                // Atualiza o produto no controle
                ProdutosControl.atualizar(qtd, prod, val, valr);

                linhaSelecionada = -1;
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para apagar um produto
    private void apagarProduto() {
        if (linhaSelecionada != -1) {
            ProdutosControl.apagar((String) tableModel.getValueAt(linhaSelecionada, 1));
            tableModel.removeRow(linhaSelecionada);
            linhaSelecionada = -1;
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para apagar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para limpar os campos de entrada
    private void limparCampos() {
        quantidade.setText("");
        produto.setText("");
        validade.setText("");
        valor.setText("");
    }
}