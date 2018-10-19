package views;

import controllers.ContasBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class fMain extends JFrame{
    
    JLabel lblLogo, lblBorda, lblBemVindo, lblConta;
    JButton btnSaldo, btnDeposito, btnSacar, btnTransferir, btnPagamentos, btnExtrato, btnConfiguracoes, btnSair;
    JComboBox<String> cbConta;
    
    public fMain(){
        this.setTitle("LIMNV - ATM");
        this.setSize(627, 365);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
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
        
        lblBemVindo = new JLabel("Bem vindo, " + UsuarioLogado.Nome);
        this.getContentPane().add(lblBemVindo);
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 13));
        lblBemVindo.setBounds(5, 30, 350, 25);
        
        lblConta = new JLabel("Conta selecionada:");
        this.getContentPane().add(lblConta);
        lblConta.setBounds(300, 15, 120, 25);
        
        cbConta = new JComboBox<String>();
        this.getContentPane().add(cbConta);
        cbConta.setBounds(415, 15, 200, 25);        
        List<String> descricoes = new ArrayList<String>();
        descricoes = ContasBLL.ObterDescricaoContas(UsuarioLogado.ClienteID);
        for (int i = 0; i < descricoes.size(); i++) {
            cbConta.addItem(descricoes.get(i));
        }
        cbConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioLogado.ContaID = ContasBLL.ObterContaIDPorDescricoes(cbConta.getSelectedItem().toString());
                UsuarioLogado.DescricaoConta = cbConta.getSelectedItem().toString();
            }
        });
        UsuarioLogado.ContaID = ContasBLL.ObterContaIDPorDescricoes(cbConta.getSelectedItem().toString());
        UsuarioLogado.DescricaoConta = cbConta.getSelectedItem().toString();
        
        btnSacar = new JButton("Saque");
        this.getContentPane().add(btnSacar);
        btnSacar.setBounds(5, 60, 300, 60);
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fSaque frmSaque = new fSaque();
                frmSaque.Exibir();
            }
        });
        
        btnSaldo = new JButton("Saldo");
        this.getContentPane().add(btnSaldo);
        btnSaldo.setBounds(315, 60, 300, 60);
        btnSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fSaldo frmSaldo = new fSaldo();
                frmSaldo.Exibir();
            }
        });
        
        btnDeposito = new JButton("Depositar");
        this.getContentPane().add(btnDeposito);
        btnDeposito.setBounds(5, 130, 300, 60);
        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fDeposito frmDeposito = new fDeposito();
                frmDeposito.Exibir();
            }
        } );
        
        btnTransferir = new JButton("Transferir");
        this.getContentPane().add(btnTransferir);
        btnTransferir.setBounds(315, 130, 300, 60);
        btnTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fTransferencias frmTransferencias = new fTransferencias();
                frmTransferencias.Exibir();
            }
        });
        
        btnPagamentos = new JButton("Pagamentos");
        this.getContentPane().add(btnPagamentos);
        btnPagamentos.setBounds(5, 200, 300, 60);
        btnPagamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fPagamentos frmPagamentos = new fPagamentos();
                frmPagamentos.Exibir();
            }
        });
        
        btnExtrato = new JButton("Extrato");
        this.getContentPane().add(btnExtrato);
        btnExtrato.setBounds(315, 200, 300, 60);
        
        btnConfiguracoes = new JButton("Configurações");
        this.getContentPane().add(btnConfiguracoes);
        btnConfiguracoes.setBounds(5, 270, 300, 60);
        btnConfiguracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fConfiguracoes frmConfiguracoes = new fConfiguracoes();
                frmConfiguracoes.Exibir();
            }
        });
        
        btnSair = new JButton("Sair");
        this.getContentPane().add(btnSair);
        btnSair.setBounds(315, 270, 300, 60);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        this.setVisible(true);
        
        
    }
}
