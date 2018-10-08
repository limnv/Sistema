package views;

import java.awt.Font;
import javax.swing.*;

public class fMain extends JFrame{
    
    JLabel lblLogo, lblBorda, lblBemVindo;
    JButton btnSaldo, btnDeposito, btnSacar, btnTransferir, btnPagamentos, btnExtrato;
    
    public fMain(){
        this.setTitle("LIMNV - ATM");
        this.setSize(637, 305);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        lblLogo = new JLabel("LIMNV");
        this.getContentPane().add(lblLogo);
        lblLogo.setBounds(5, 5, 60, 20);
        
        String s = "";
        for (int i = 0; i < 40; i++) {
            s += "_";
        }
        
        lblBorda = new JLabel();
        lblBorda.setText(s);
        this.getContentPane().add(lblBorda);
        lblBorda.setBounds(5,10,350,20);
        
        lblBemVindo = new JLabel("Bem vindo, Fulano");
        this.getContentPane().add(lblBemVindo);
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 18));
        lblBemVindo.setBounds(5, 30, 200, 25);
        
        btnSacar = new JButton("Saque");
        this.getContentPane().add(btnSacar);
        btnSacar.setBounds(5, 60, 300, 60);
        
        btnSaldo = new JButton("Saldo");
        this.getContentPane().add(btnSaldo);
        btnSaldo.setBounds(315, 60, 300, 60);
        
        btnDeposito = new JButton("Depositar");
        this.getContentPane().add(btnDeposito);
        btnDeposito.setBounds(5, 130, 300, 60);
        
        btnTransferir = new JButton("Transferir");
        this.getContentPane().add(btnTransferir);
        btnTransferir.setBounds(315, 130, 300, 60);
        
        btnPagamentos = new JButton("Pagamentos");
        this.getContentPane().add(btnPagamentos);
        btnPagamentos.setBounds(5, 200, 300, 60);
        
        btnExtrato = new JButton("Extrato");
        this.getContentPane().add(btnExtrato);
        btnExtrato.setBounds(315, 200, 300, 60);
        
        this.setVisible(true);
        
        
    }
}
