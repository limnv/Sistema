package views;

import controllers.ContasBLL;
import controllers.DepositoBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.*;
import models.Deposito;

public class fDeposito extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblConta, lblContaDescricao, lblTipo, lblValor;
    JRadioButton rbCheque, rbDinheiro;
    JFormattedTextField txtValor;
    JButton btnEfetuar, btnCancelar;

    Deposito d;

    public fDeposito() {
        this.setTitle("Depósito");
        this.setSize(352, 300);
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

        lblTipo = new JLabel("Forma de Depósito:");
        this.getContentPane().add(lblTipo);
        lblTipo.setBounds(5, 95, 130, 20);

        rbCheque = new JRadioButton("Cheque");
        this.getContentPane().add(rbCheque);
        rbCheque.setBounds(5, 120, 130, 20);
        rbCheque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbDinheiro.isSelected()) {
                    rbDinheiro.setSelected(false);
                }
            }
        });

        rbDinheiro = new JRadioButton("Dinheiro");
        this.getContentPane().add(rbDinheiro);
        rbDinheiro.setBounds(5, 145, 130, 20);
        rbDinheiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbCheque.isSelected()) {
                    rbCheque.setSelected(false);
                }
            }
        });

        lblValor = new JLabel("Valor:");
        this.getContentPane().add(lblValor);
        lblValor.setBounds(5, 175, 80, 20);

        NumberFormat f = NumberFormat.getCurrencyInstance();

        txtValor = new JFormattedTextField();
        txtValor.setFormatterFactory(dfFactory);
        this.getContentPane().add(txtValor);
        txtValor.setBounds(5, 200, 100, 20);

        btnEfetuar = new JButton("Efetuar");
        this.getContentPane().add(btnEfetuar);
        btnEfetuar.setBounds(230, 230, 100, 25);
        btnEfetuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((!rbCheque.isSelected() && !rbDinheiro.isSelected()) || txtValor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Você deve informar o valor e o tipo de depósito.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (Double.parseDouble(txtValor.getText().replace(",", ".")) < 0){ 
                    JOptionPane.showMessageDialog(null, "O valor informado não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente efetuar esta operação?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        d = new Deposito();
                        d.setContaID(UsuarioLogado.ContaID);
                        if (rbCheque.isSelected()) {
                            d.setTipo("C");
                        } else {
                            d.setTipo("D");
                        }
                        d.setValorOperacao(Double.parseDouble(txtValor.getText().replace(",", ".")));
                        Date date = new Date();
                        d.setDataOperacao(formatter.format(date));
                        DepositoBLL.Efetuar(d);
                        setVisible(false);
                    }
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(5, 230, 100, 25);
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
