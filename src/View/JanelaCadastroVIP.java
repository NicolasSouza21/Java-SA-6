package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JanelaCadastroVIP extends JPanel {

  // Componentes
  private JButton cadastrar, apagar, editar;
  private JTextField cpf, endereco, tell, nome, idade;
  private JTable table;
  private DefaultTableModel tableModel;

  public JanelaCadastroVIP() {
    super();

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.WEST;

    // Título
    JLabel labelTitulo = new JLabel("Seja VIP!");
    labelTitulo.setFont(new Font("Arial", Font.BOLD, 32)); // Definindo uma fonte maior
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 5;
    add(labelTitulo, gbc);

    // Nome
    JLabel labelNome = new JLabel("Seu Nome");
    JTextField nomeField = new JTextField(20);
    nomeField.setPreferredSize(new Dimension(200, 25));

    // Idade
    JLabel labelIdade = new JLabel("Sua Idade");
    SpinnerModel spinnerModel = new SpinnerNumberModel(18, 18, 120, 1);
    JSpinner rodinha = new JSpinner(spinnerModel);
    rodinha.setPreferredSize(new Dimension(50, 25));

    // CPF
    JLabel labelCpf = new JLabel("Seu CPF");
    JTextField cpfField = new JTextField(20);
    cpfField.setPreferredSize(new Dimension(200, 25));

    // Telefone
    JLabel labelTell = new JLabel("Seu Telefone");
    JTextField tellField = new JTextField(20);
    tellField.setPreferredSize(new Dimension(200, 25));

    // Endereço
    JLabel labelEndereco = new JLabel("Seu Endereço");
    JTextField enderecoField = new JTextField(20);
    enderecoField.setPreferredSize(new Dimension(200, 25));

    // Botão
    JButton cadastrarButton = new JButton("Cadastrar-se");

    gbc.gridwidth = 1;
    gbc.gridy = 1;
    gbc.gridx = 0;
    add(labelNome, gbc);

    gbc.gridx = 1;
    add(nomeField, gbc);

    gbc.gridy = 2;
    gbc.gridx = 0;
    add(labelIdade, gbc);

    gbc.gridx = 1;
    add(rodinha, gbc);

    gbc.gridy = 3;
    gbc.gridx = 0;
    add(labelCpf, gbc);

    gbc.gridx = 1;
    add(cpfField, gbc);

    gbc.gridy = 4;
    gbc.gridx = 0;
    add(labelTell, gbc);

    gbc.gridx = 1;
    add(tellField, gbc);

    gbc.gridy = 5;
    gbc.gridx = 0;
    add(labelEndereco, gbc);

    gbc.gridx = 1;
    add(enderecoField, gbc);

    gbc.gridy = 6;
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    add(cadastrarButton, gbc);

  }

}
