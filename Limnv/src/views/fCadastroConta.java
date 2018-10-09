package views;

import java.awt.event.*;
import javax.swing.*;
import models.*;
import controllers.*;

public class fCadastroConta extends JDialog {

    JTextField txtDescricao;
    JLabel lblDescricao, lblTipo;
    JRadioButton rbCorrente, rbPoupanca;
    JButton btnSalvar;

    public int ClienteID;
    private boolean Cadastrado = false;

    public fCadastroConta() {
        this.setTitle("Cadastrar Conta");
        this.setSize(325, 325);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);

        lblDescricao = new JLabel("Descrição:");
        this.getContentPane().add(lblDescricao);
        lblDescricao.setBounds(30, 30, 80, 20);

        txtDescricao = new JTextField();
        this.getContentPane().add(txtDescricao);
        txtDescricao.setBounds(30, 50, 250, 20);

        lblTipo = new JLabel("Tipo:");
        this.getContentPane().add(lblTipo);
        lblTipo.setBounds(30, 80, 50, 20);

        rbCorrente = new JRadioButton("Conta Corrente");
        this.getContentPane().add(rbCorrente);
        rbCorrente.setBounds(30, 100, 120, 20);
        rbCorrente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbPoupanca.isSelected()) {
                    rbPoupanca.setSelected(false);
                }
            }
        });

        rbPoupanca = new JRadioButton("Conta Poupança");
        this.getContentPane().add(rbPoupanca);
        rbPoupanca.setBounds(30, 120, 120, 20);
        rbPoupanca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbCorrente.isSelected()) {
                    rbCorrente.setSelected(false);
                }
            }
        });

        btnSalvar = new JButton("Salvar");
        this.getContentPane().add(btnSalvar);
        btnSalvar.setBounds(90, 150, 120, 25);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((txtDescricao.equals("")) || ((!rbCorrente.isSelected()) && (!rbPoupanca.isSelected()))) {
                    JOptionPane.showMessageDialog(null, "Você deve preencher a descrição " + System.lineSeparator() + " e selecionar o tipo de conta.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String Tipo;
                    if (rbCorrente.isSelected()) {
                        Tipo = "C";
                    } else {
                        Tipo = "P";
                    }
                    Conta ct = new Conta();
                    ct.setDescricao(txtDescricao.getText());
                    ct.setClienteID(ClienteID);
                    ct.setTipo(Tipo);
                    ContasBLL.Inserir(ct);
                    JOptionPane.showMessageDialog(null, "Oba..." + System.lineSeparator() + "Sua conta foi criada," + System.lineSeparator() + " você já pode fazer o login", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    Cadastrado = true;
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Se você fechar esta tela agora," + System.lineSeparator() + " irá anular o seu cadastro. " + System.lineSeparator() + " Deseja realmente fechar?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    setVisible(false);
                }
            }
        });
    }

    public boolean exibir() {
        this.setModal(true);
        this.setVisible(true);
        return Cadastrado;
    }
}
