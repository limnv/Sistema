package views;

import controllers.*;
import java.awt.Font;
import java.awt.event.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;
import models.*;

/**
 *
 * @author luism
 */
public class fPagamentos extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblConta, lblContaDescricao, lblCodigoBarras, lblPonto1, lblPonto2, lblPonto3,
            lblBanco, lblBancoVlr, lblValor, lblDataVencimento, lblDescricao;
    JFormattedTextField txtValor, txtDataVencimento, txtBloco1, txtBloco2, txtBloco3, txtBloco4, txtBloco5, txtBloco6, txtBloco7, txtBloco8;
    JTextField txtDescricao;
    JButton btnEfetuar, btnCancelar;
    String CodigoBarras = "";

    Pagamento p;

    public fPagamentos() {
        this.setTitle("Pagamento");
        this.setSize(352, 510);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);

        Date DataBase = new Date("1997/10/07");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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

        lblCodigoBarras = new JLabel("Código de Barras:");
        this.getContentPane().add(lblCodigoBarras);
        lblCodigoBarras.setBounds(5, 95, 130, 20);

        try {

            txtBloco1 = new JFormattedTextField(new MaskFormatter("#####"));
            this.getContentPane().add(txtBloco1);
            txtBloco1.setBounds(5, 120, 60, 20);

            lblPonto1 = new JLabel(" . ");
            this.getContentPane().add(lblPonto1);
            lblPonto1.setBounds(65, 120, 10, 20);

            txtBloco2 = new JFormattedTextField(new MaskFormatter("#####"));
            this.getContentPane().add(txtBloco2);
            txtBloco2.setBounds(75, 120, 60, 20);

            txtBloco3 = new JFormattedTextField(new MaskFormatter("#####"));
            this.getContentPane().add(txtBloco3);
            txtBloco3.setBounds(5, 145, 60, 20);

            lblPonto2 = new JLabel(" . ");
            this.getContentPane().add(lblPonto2);
            lblPonto2.setBounds(65, 145, 10, 20);

            txtBloco4 = new JFormattedTextField(new MaskFormatter("######"));
            this.getContentPane().add(txtBloco4);
            txtBloco4.setBounds(75, 145, 70, 20);

            txtBloco5 =  new JFormattedTextField(new MaskFormatter("#####"));
            this.getContentPane().add(txtBloco5);
            txtBloco5.setBounds(5, 170, 60, 20);

            lblPonto3 = new JLabel(" . ");
            this.getContentPane().add(lblPonto3);
            lblPonto3.setBounds(65, 170, 10, 20);

            txtBloco6 =  new JFormattedTextField(new MaskFormatter("######"));
            this.getContentPane().add(txtBloco6);
            txtBloco6.setBounds(75, 170, 70, 20);

            txtBloco7 =  new JFormattedTextField(new MaskFormatter("#"));
            this.getContentPane().add(txtBloco7);
            txtBloco7.setBounds(150, 170, 15, 20);

            txtBloco8 =  new JFormattedTextField(new MaskFormatter("##############"));
            this.getContentPane().add(txtBloco8);
            txtBloco8.setBounds(5, 195, 110, 20);
            txtBloco8.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    String Banco = txtBloco1.getText().substring(0, 3);
                    switch (Banco) {
                        case "237":
                            lblBancoVlr.setText("Banco Bradesco S.A.");
                            break;
                        case "184":
                            lblBancoVlr.setText("Banco Itaú BBA S.A.");
                            break;
                        case "033":
                            lblBancoVlr.setText("Banco Santander (Brasil) S.A.");
                            break;
                        case "104":
                            lblBancoVlr.setText("Caixa Econômica Federal");
                            break;
                        case "001":
                            lblBancoVlr.setText("Banco do Brasil S.A.");
                            break;
                        default:
                            lblBancoVlr.setText("Outro banco");
                            break;
                    }
                    int Dias = Integer.parseInt(txtBloco8.getText().substring(0, 4));
                    if (Dias != 0) {
                        Calendar c = Calendar.getInstance();
                        c.setTime(DataBase);
                        c.add(Calendar.DAY_OF_MONTH, +Dias);
                        txtDataVencimento.setText(df.format(c.getTime()));
                    }
                    String VlrInteiro = txtBloco8.getText().substring(4, 12);
                    String VlrDecimal = txtBloco8.getText().substring(12, 14);
                    String sValor = VlrInteiro + "," + VlrDecimal;
                    txtValor.setText(sValor);

                    StringBuilder sb = new StringBuilder();
                    sb.append(txtBloco1.getText());
                    sb.append(txtBloco2.getText());
                    sb.append(txtBloco3.getText());
                    sb.append(txtBloco4.getText());
                    sb.append(txtBloco5.getText());
                    sb.append(txtBloco7.getText());
                    sb.append(txtBloco8.getText());

                    CodigoBarras = sb.toString();

                }
            });

            lblDescricao = new JLabel("Descrição:");
            this.getContentPane().add(lblDescricao);
            lblDescricao.setBounds(5, 225, 130, 20);

            txtDescricao = new JTextField();
            this.getContentPane().add(txtDescricao);
            txtDescricao.setBounds(5, 250, 130, 20);

            lblBanco = new JLabel("Banco:");
            this.getContentPane().add(lblBanco);
            lblBanco.setBounds(5, 280, 130, 20);

            lblBancoVlr = new JLabel("...");
            this.getContentPane().add(lblBancoVlr);
            lblBancoVlr.setFont(new Font("Arial", Font.BOLD, 12));
            lblBancoVlr.setBounds(5, 305, 250, 20);

            lblDataVencimento = new JLabel("Data de Vencimento:");
            this.getContentPane().add(lblDataVencimento);
            lblDataVencimento.setBounds(5, 335, 130, 20);

            txtDataVencimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
            this.getContentPane().add(txtDataVencimento);
            txtDataVencimento.setBounds(5, 360, 130, 20);
        } catch (ParseException ex) {
            Logger.getLogger(fPagamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        lblValor = new JLabel("Valor:");
        this.getContentPane().add(lblValor);
        lblValor.setBounds(5, 390, 130, 20);

        txtValor = new JFormattedTextField();
        txtValor.setFormatterFactory(dfFactory);
        this.getContentPane().add(txtValor);
        txtValor.setBounds(5, 415, 130, 20);

        btnEfetuar = new JButton("Efetuar");
        this.getContentPane().add(btnEfetuar);
        btnEfetuar.setBounds(230, 445, 100, 25);
        btnEfetuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double vlrConta = Double.parseDouble(txtValor.getText().replace(",", "."));
                if (CodigoBarras.equals("")) {
                    JOptionPane.showMessageDialog(null, "Você deve informar o código de barra.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (vlrConta < 0){ 
                    JOptionPane.showMessageDialog(null, "O valor informado não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (vlrConta > ContasBLL.ObterSaldo(UsuarioLogado.ContaID)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar esta operação.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente efetuar esta operação?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        p = new Pagamento();
                        p.setContaID(UsuarioLogado.ContaID);
                        p.setDescricao(txtDescricao.getText());
                        p.setValorOperacao(vlrConta);
                        Date date = new Date();
                        p.setDataOperacao(formatter.format(date));
                        p.setCodigoBarras(CodigoBarras);
                        PagamentosBLL.Efetuar(p);
                        setVisible(false);
                    }
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(5, 445, 100, 25);
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
