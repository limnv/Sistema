package views;

import controllers.ContasBLL;
import java.awt.Font;
import javax.swing.*;

public class fSaldo extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblConta, lblContaDescricao, lblSaldo, lblSaldoVlr;
    JRadioButton rbCheque, rbDinheiro;
    JFormattedTextField txtValor;
    JButton btnEfetuar, btnCancelar;
    
    public fSaldo(){
        this.setTitle("Saldo");
        this.setSize(280, 160);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
         lblLogo = new JLabel("LIMNV");
        this.getContentPane().add(lblLogo);
        lblLogo.setBounds(5, 5, 60, 20);

        String s = "";
        for (int i = 0; i < 20; i++) {
            s += "_";
        }

        lblBorda = new JLabel();
        lblBorda.setText(s);
        this.getContentPane().add(lblBorda);
        lblBorda.setBounds(5, 10, 200, 20);

        lblCabecalho = new JLabel("Depósito");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setFont(new Font("Arial", Font.BOLD, 13));
        lblCabecalho.setBounds(5, 30, 350, 25);

        lblConta = new JLabel("Conta selecionada:");
        this.getContentPane().add(lblConta);
        lblConta.setBounds(5, 65, 120, 20);

        lblContaDescricao = new JLabel("[" + UsuarioLogado.ContaID + "] " + UsuarioLogado.DescricaoConta);
        this.getContentPane().add(lblContaDescricao);
        lblContaDescricao.setBounds(120, 65, 200, 20);
        
        lblSaldo = new JLabel("Saldo Atual:");
        this.getContentPane().add(lblSaldo);
        lblSaldo.setBounds(5, 95, 120, 20);
        
        String Saldo = "R$ " + ContasBLL.ObterSaldo(UsuarioLogado.ContaID);      
        
        lblSaldoVlr = new JLabel(Saldo.replace(".", ","));
        this.getContentPane().add(lblSaldoVlr);
        lblSaldoVlr.setFont(new Font("Arial", Font.BOLD, 15));
        lblSaldoVlr.setBounds(80, 95, 120, 20);  
        
        
    }
    
    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }
    
}
