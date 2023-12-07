package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {

    private JTabbedPane tab;

    public JanelaPrincipal() {

        tab = new JTabbedPane();
        add(tab);

        // JanelaCadastroP tab1 = new JanelaCadastroP();
        JanelaCadastroVIP tab2 = new JanelaCadastroVIP();
        JanelaCaixa tab3 = new JanelaCaixa();
        //JanelaEstoque tab4 = new JanelaEstoque();

        // tab.add("Cadastro produtos", tab1);
        tab.add("Cadastro Cliente VIP", tab2);
        tab.add("Caixa", tab3);
       // tab.add("Estoque", tab4);

        setBounds(100, 100, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
