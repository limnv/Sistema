package views;

import controllers.ClientesBLL;
import controllers.ContasBLL;
import controllers.SaquesBLL;
import controllers.TransferenciasBLL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import models.Transferencia;

/**
 *
 * @author luism
 */
public class fTransferencias extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblConta, lblContaDescricao, lblValor, lblCpf, lblContaDestino;
    JFormattedTextField txtValor, txtCpf;
    JComboBox<String> cbContas;
    JButton btnEfetuar, btnCancelar;
    int ContaIDDestino;

    Transferencia t;

    public fTransferencias() {
        this.setTitle("Transferência");
        this.setSize(352, 330);
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

        lblCpf = new JLabel("CPF:");
        this.getContentPane().add(lblCpf);
        lblCpf.setBounds(5, 95, 130, 20);

        try {
            txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            this.getContentPane().add(txtCpf);
            txtCpf.setBounds(5, 120, 130, 20);
            txtCpf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!txtCpf.getText().equals("   .   .   -  ")) {
                        int ClienteID = ClientesBLL.ObterIDPorCPF(txtCpf.getText());
                        if (ClienteID == -1) {
                            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum cliente com este CPF", "Erro", JOptionPane.ERROR_MESSAGE);
                            txtCpf.requestFocus();
                        } else {
                            List<String> descricoes = new ArrayList<String>();
                            descricoes = ContasBLL.ObterDescricaoContasComFiltro(ClienteID);
                            for (int i = 0; i < descricoes.size(); i++) {
                                cbContas.addItem(descricoes.get(i));
                            }
                        }
                    }
                }

            });
        } catch (ParseException ex) {
            Logger.getLogger(fTransferencias.class.getName()).log(Level.SEVERE, null, ex);
        }

        lblContaDestino = new JLabel("Conta a ser transferido:");
        this.getContentPane().add(lblContaDestino);
        lblContaDestino.setBounds(5, 150, 150, 20);

        cbContas = new JComboBox<String>();
        this.getContentPane().add(cbContas);
        cbContas.setBounds(5, 175, 200, 25);
        cbContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContaIDDestino = ContasBLL.ObterContaIDPorDescricoes(cbContas.getSelectedItem().toString());
            }
        });

        lblValor = new JLabel("Valor:");
        this.getContentPane().add(lblValor);
        lblValor.setBounds(5, 205, 130, 20);

        NumberFormat f = NumberFormat.getCurrencyInstance();

        txtValor = new JFormattedTextField();
        txtValor.setFormatterFactory(dfFactory);
        this.getContentPane().add(txtValor);
        txtValor.setBounds(5, 230, 130, 20);

        btnEfetuar = new JButton("Efetuar");
        this.getContentPane().add(btnEfetuar);
        btnEfetuar.setBounds(230, 260, 100, 25);
        btnEfetuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double vlrOperacao = Double.parseDouble(txtValor.getText().replace(",", "."));
                if (txtValor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Você deve informar o valor do saque.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (vlrOperacao < 0){ 
                    JOptionPane.showMessageDialog(null, "O valor informado não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (vlrOperacao > ContasBLL.ObterSaldo(UsuarioLogado.ContaID)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar esta operação.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente efetuar esta operação?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        t = new Transferencia();
                        t.setContaIDOrigem(UsuarioLogado.ContaID);
                        t.setContaIDDestino(ContaIDDestino);
                        t.setValorOperacao(Double.parseDouble(txtValor.getText().replace(",", ".")));
                        Date date = new Date();
                        t.setDataOperacao(formatter.format(date));
                        TransferenciasBLL.Efetuar(t);
                        setVisible(false);
                    }
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(5, 260, 100, 25);
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
