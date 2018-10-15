package views;

import controllers.ContasBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import models.Deposito;

public class fDeposito extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblPNLTitulo;
    JPanel pnlDestino, pnlTipo, pnlVlr, pnlResumo, pnlEnvelope, pnlFim;
    
    Deposito d;

    public fDeposito() {
        this.setTitle("Depósito");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        d = new Deposito();

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

        ExibePNLDestino();

    }

    public void ExibePNLDestino() {
        pnlDestino = new JPanel();
        pnlDestino.setLayout(null);
        //pnlDestino.setBackground(Color.red);

        lblPNLTitulo = new JLabel("Selecione a conta destino:");
        pnlDestino.add(lblPNLTitulo);
        lblPNLTitulo.setBounds(5, 5, 150, 20);

        JButton btnContaAtual = new JButton("Conta atual: " + UsuarioLogado.DescricaoConta);
        pnlDestino.add(btnContaAtual);
        btnContaAtual.setBounds(25, 30, 425, 50);
        btnContaAtual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setContaID(UsuarioLogado.ContaID);
            }
        });
        

        int pos = 90;
        if (ContasBLL.ObterQTDContaAtivas(UsuarioLogado.ClienteID) > 1) {
            JButton btnOutraContaSua = new JButton("Outra conta sua");
            pnlDestino.add(btnOutraContaSua);
            btnOutraContaSua.setBounds(25, 90, 425, 50);
            pos = 150;
            btnOutraContaSua.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
        }

        JButton btnOutraConta = new JButton("Conta de outro titular");
        pnlDestino.add(btnOutraConta);
        btnOutraConta.setBounds(25, pos, 425, 50);

        this.getContentPane().add(pnlDestino);
        pnlDestino.setBounds(0, 60, 475, 400);
    }
    
    public void ExibePNL

    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }

}
