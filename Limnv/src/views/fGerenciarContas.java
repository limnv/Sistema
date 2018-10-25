package views;

import controllers.ContasBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import models.Conta;

/**
 *
 * @author luism
 */
public class fGerenciarContas extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblCodigo, lblStatus, lblStatusVlr, lblDescricao, lblTipo;
    JTextField txtCodigo, txtDescricao;
    JRadioButton rbPoupanca, rbCorrente;
    JButton btnNovo, btnEditar, btnInativar, btnSalvar, btnCancelar;
    JTable tblContas;
    JScrollPane sp;
    ContasTableModel contasTableModel;
    Boolean Operando, Selecionado;
    Conta ct;

    public fGerenciarContas() {
        this.setTitle("Gerenciar Contas");
        this.setSize(335, 512);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        Operando = false;
        Selecionado = false;

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

        lblCabecalho = new JLabel("Gerenciar Contas");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setFont(new Font("Arial", Font.BOLD, 13));
        lblCabecalho.setBounds(5, 30, 350, 25);

        lblCodigo = new JLabel("Código:");
        this.getContentPane().add(lblCodigo);
        lblCodigo.setBounds(5, 65, 120, 20);

        txtCodigo = new JTextField();
        this.getContentPane().add(txtCodigo);
        txtCodigo.setBounds(5, 90, 100, 20);
        txtCodigo.setEditable(false);

        lblStatus = new JLabel("Status:");
        this.getContentPane().add(lblStatus);
        lblStatus.setBounds(130, 65, 120, 20);

        lblStatusVlr = new JLabel();
        this.getContentPane().add(lblStatusVlr);
        lblStatusVlr.setBounds(130, 90, 120, 20);
        lblStatusVlr.setFont(new Font("Arial", Font.BOLD, 13));

        lblDescricao = new JLabel("Descrição:");
        this.getContentPane().add(lblDescricao);
        lblDescricao.setBounds(5, 130, 120, 20);

        txtDescricao = new JTextField();
        this.getContentPane().add(txtDescricao);
        txtDescricao.setBounds(5, 155, 250, 20);
        txtDescricao.setEnabled(false);

        lblTipo = new JLabel("Tipo:");
        this.getContentPane().add(lblTipo);
        lblTipo.setBounds(5, 185, 120, 20);

        rbPoupanca = new JRadioButton("Poupança");
        this.getContentPane().add(rbPoupanca);
        rbPoupanca.setBounds(5, 210, 100, 20);
        rbPoupanca.setEnabled(false);
        rbPoupanca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbCorrente.isSelected()) {
                    rbCorrente.setSelected(false);
                }
            }
        });

        rbCorrente = new JRadioButton("Corrente");
        this.getContentPane().add(rbCorrente);
        rbCorrente.setBounds(5, 235, 100, 20);
        rbCorrente.setEnabled(false);
        rbCorrente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbPoupanca.isSelected()) {
                    rbPoupanca.setSelected(false);
                }
            }
        });

        btnNovo = new JButton("Nova");
        this.getContentPane().add(btnNovo);
        btnNovo.setBounds(5, 265, 100, 20);
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaCampos();
                ControlaComponentesGravacao(true);
                lblStatusVlr.setText("Ativo");
            }
        });

        btnEditar = new JButton("Editar");
        this.getContentPane().add(btnEditar);
        btnEditar.setBounds(110, 265, 100, 20);
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControlaComponentesGravacao(true);
            }
        });

        btnInativar = new JButton("Inativar");
        this.getContentPane().add(btnInativar);
        btnInativar.setBounds(215, 265, 100, 20);
        btnInativar.setEnabled(false);
        btnInativar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza que deve inativar?", "Certeza...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    ContasBLL.Inativar(ct);
                    ControlaComponentesGravacao(false);
                    limpaCampos();
                }
            }
        });

        btnSalvar = new JButton("Salvar");
        this.getContentPane().add(btnSalvar);
        btnSalvar.setBounds(5, 290, 150, 20);
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDescricao.getText().equals("") || ((!rbCorrente.isSelected()) && (!rbPoupanca.isSelected()))) {
                    JOptionPane.showMessageDialog(null, "Você deve preencher a descrição " + System.lineSeparator() + " e selecionar o tipo de conta.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (Selecionado) {
                        String Tipo;
                        if (rbCorrente.isSelected()) {
                            Tipo = "C";
                        } else {
                            Tipo = "P";
                        }
                        ct.setDescricao(txtDescricao.getText());
                        ct.setClienteID(UsuarioLogado.ClienteID);
                        ct.setTipo(Tipo);
                        ContasBLL.Inserir(ct);
                        JOptionPane.showMessageDialog(null, "Sua conta foi editada.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                        ControlaComponentesGravacao(false);
                        limpaCampos();
                    } else {
                        String Tipo;
                        if (rbCorrente.isSelected()) {
                            Tipo = "C";
                        } else {
                            Tipo = "P";
                        }
                        ct = new Conta();
                        ct.setDescricao(txtDescricao.getText());
                        ct.setClienteID(UsuarioLogado.ClienteID);
                        ct.setTipo(Tipo);
                        ContasBLL.Inserir(ct);
                        JOptionPane.showMessageDialog(null, "Sua conta foi criada.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                        ControlaComponentesGravacao(false);
                        limpaCampos();
                    }
                    PopulaTabela();
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(160, 290, 155, 20);
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaCampos();
                ControlaComponentesGravacao(false);
            }
        });

        contasTableModel = new ContasTableModel(ContasBLL.ObterListaContasPorClienteID(UsuarioLogado.ClienteID));

        tblContas = new JTable();
        tblContas.setBounds(5, 320, 310, 150);
        PopulaTabela();
        tblContas.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblContas.getColumnModel().getColumn(1).setPreferredWidth(245);
        tblContas.getColumnModel().getColumn(2).setPreferredWidth(35);
        tblContas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Operando) {
                    int cod;
                    int selectedRow = tblContas.getSelectedRow();

                    if (selectedRow != -1) {
                        cod = (int) tblContas.getValueAt(selectedRow, 0);
                        preencheCampos(cod);
                    }
                }
            }
        });

        sp = new JScrollPane(tblContas);
        this.getContentPane().add(sp);
        sp.setBounds(5, 320, 310, 150);

    }
    
    public void PopulaTabela(){
        contasTableModel.setNumRows(0);
        contasTableModel = new ContasTableModel(ContasBLL.ObterListaContasPorClienteID(UsuarioLogado.ClienteID));
        tblContas.setModel(contasTableModel);
    }

    public void preencheCampos(int cod) {
        Selecionado = true;
        ct = ContasBLL.ObterContaPorId(cod);
        txtCodigo.setText(ct.getID() + "");
        if (ct.getAtivo().equals("S")) {
            lblStatusVlr.setText("Ativo");
        } else {
            lblStatusVlr.setText("Inativo");
        }
        txtDescricao.setText(ct.getDescricao());
        if (ct.getTipo() == "C") {
            rbCorrente.setSelected(true);
            rbPoupanca.setSelected(false);
        } else {
            rbPoupanca.setSelected(true);
            rbCorrente.setSelected(false);
        }
        ControlaComponentesGravacao(false);
    }

    public void limpaCampos() {
        Selecionado = false;
        txtCodigo.setText("");
        lblStatusVlr.setText("");
        txtDescricao.setText("");
        rbCorrente.setSelected(false);
        rbPoupanca.setSelected(false);
    }

    public void ControlaComponentesGravacao(boolean b) {
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(b);
        txtDescricao.setEnabled(b);
        rbCorrente.setEnabled(b);
        rbPoupanca.setEnabled(b);
        Operando = b;
        btnNovo.setEnabled(!b);
        if (Selecionado) {
            btnEditar.setEnabled(!b);
            btnInativar.setEnabled(!b);
        }
    }

    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }
}
