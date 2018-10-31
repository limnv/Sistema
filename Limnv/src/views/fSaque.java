package views;

import controllers.*;
import java.awt.Font;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import models.Saque;

public class fSaque extends JDialog{
    JLabel lblLogo, lblBorda, lblCabecalho, lblConta, lblContaDescricao, lblValor;
    JFormattedTextField txtValor;
    JButton btnEfetuar, btnCancelar;
    
    Saque s;
    
    public fSaque(){
        this.setTitle("Saque");
        this.setSize(352, 220);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");

        DecimalFormat decimal = new DecimalFormat("###.00");
        NumberFormatter numFormatter = new NumberFormatter(decimal);
        numFormatter.setFormat(decimal);
        numFormatter.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);

        lblLogo = new JLabel("LIMNV");
        this.getContentPane().add(lblLogo);
        lblLogo.setBounds(5, 5, 60, 20);

        String sBorda = "";
        for (int i = 0; i < 20; i++) {
            sBorda += "_";
        }

        lblBorda = new JLabel();
        lblBorda.setText(sBorda);
        this.getContentPane().add(lblBorda);
        lblBorda.setBounds(5, 10, 200, 20);

        lblCabecalho = new JLabel("Saque");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setFont(new Font("Arial", Font.BOLD, 13));
        lblCabecalho.setBounds(5, 30, 350, 25);

        lblConta = new JLabel("Conta selecionada:");
        this.getContentPane().add(lblConta);
        lblConta.setBounds(5, 65, 120, 20);

        lblContaDescricao = new JLabel("[" + UsuarioLogado.ContaID + "] " + UsuarioLogado.DescricaoConta);
        this.getContentPane().add(lblContaDescricao);
        lblContaDescricao.setBounds(120, 65, 200, 20);

        lblValor = new JLabel("Valor:");
        this.getContentPane().add(lblValor);
        lblValor.setBounds(5, 95, 130, 20);

        txtValor = new JFormattedTextField();
        txtValor.setFormatterFactory(dfFactory);
        this.getContentPane().add(txtValor);
        txtValor.setBounds(5, 120, 130, 20);

        btnEfetuar = new JButton("Efetuar");
        this.getContentPane().add(btnEfetuar);
        btnEfetuar.setBounds(230, 150, 100, 25);
        btnEfetuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                double vlrSaque = Double.parseDouble(txtValor.getText().replace(",", "."));
                if (txtValor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Você deve informar o valor do saque.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (vlrSaque < 0){ 
                    JOptionPane.showMessageDialog(null, "O valor informado não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (vlrSaque > ContasBLL.ObterSaldo(UsuarioLogado.ContaID)){
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar esta operação.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente efetuar esta operação?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        s = new Saque();
                        s.setContaId(UsuarioLogado.ContaID);
                        s.setValorOperacao(Double.parseDouble(txtValor.getText().replace(",", ".")));
                        Date date = new Date();
                        s.setDataOperacao(formatter.format(date));
                        SaquesBLL.Efetuar(s);
                        setVisible(false);
                    }
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(5, 150, 100, 25);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }
    
}
