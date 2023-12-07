package View;

import javax.swing.*;
import java.awt.*;

public class JanelaCaixa extends JPanel {

    public JanelaCaixa() {
        super();

        // Painel principal com GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(3, 3, 10, 10)); // 3 linhas, 3 colunas, espaçamento de 10 pixels

        // Adiciona produtos ao painel
        mainPanel.add(new JLabel("Leite"));
        mainPanel.add(new JLabel("Pão"));
        mainPanel.add(new JLabel("Arroz"));
        mainPanel.add(new JLabel("Maçãs"));
        mainPanel.add(new JLabel("Cereal"));
        mainPanel.add(new JLabel("Café"));
        mainPanel.add(new JLabel("Sabonete"));
        mainPanel.add(new JLabel("Detergente"));
        mainPanel.add(new JLabel("Shampoo"));

        // Adiciona o mainPanel ao painel principal (JanelaCaixa)
        add(mainPanel);
    }


    }

