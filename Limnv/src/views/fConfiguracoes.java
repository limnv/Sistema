package views;

import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author luism
 */
public class fConfiguracoes extends JDialog{
    JButton btnAlterarSenha, btnGerenciarContas;
    
    public fConfiguracoes(){
        this.setTitle("Configurações");
        this.setSize(328, 180);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        btnGerenciarContas = new JButton("Gerenciar Contas");
        this.getContentPane().add(btnGerenciarContas);
        btnGerenciarContas.setBounds(5, 5, 300, 60);
        
        btnAlterarSenha = new JButton("Alterar Senha");
        this.getContentPane().add(btnAlterarSenha);
        btnAlterarSenha.setBounds(5, 75, 300, 60);
    }
    
    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }
    
}
