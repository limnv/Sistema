package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        btnGerenciarContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fGerenciarContas frmGerenciarContas = new fGerenciarContas();
                frmGerenciarContas.Exibir();
            }
        });
        
        btnAlterarSenha = new JButton("Alterar Senha");
        this.getContentPane().add(btnAlterarSenha);
        btnAlterarSenha.setBounds(5, 75, 300, 60);
        btnAlterarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fAlterarSenha frmAlterarSenha = new fAlterarSenha();
                frmAlterarSenha.Exibir();
            }
        });
    }
    
    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }
    
}
