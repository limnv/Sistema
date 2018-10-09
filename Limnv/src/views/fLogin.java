package views;

import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import models.*;
import controllers.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fLogin extends JDialog {

    JLabel lblCpf, lblSenha, lblCabecalho, lblLinha;
    JTextField txtCpf, txtSenha;
    JButton btnEntrar, btnCriarConta;

    public boolean Logado = false;
    private int Tentativa = 3;

    public fLogin() {
        this.setTitle("Login");
        this.setSize(250, 250);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //Tirar isso depois, apenas para testes
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);

        lblCabecalho = new JLabel("Entrar");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setBounds(100, 5, 50, 20);

        String s = "";
        for (int i = 0; i < 8; i++) {
            s += "_";
        }

        lblLinha = new JLabel();
        lblLinha.setText(s);
        this.getContentPane().add(lblLinha);
        lblLinha.setBounds(90, 10, 350, 20);

        lblCpf = new JLabel("CPF:");
        this.getContentPane().add(lblCpf);
        lblCpf.setBounds(60, 35, 50, 20);

        try {
            txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            this.getContentPane().add(txtCpf);
            txtCpf.setBounds(60, 55, 120, 20);
        } catch (ParseException ex) {
            Logger.getLogger(fLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        lblSenha = new JLabel("Senha:");
        this.getContentPane().add(lblSenha);
        lblSenha.setBounds(60, 85, 50, 20);

        txtSenha = new JPasswordField();
        this.getContentPane().add(txtSenha);
        txtSenha.setBounds(60, 105, 120, 20);

        btnEntrar = new JButton("Entrar");
        this.getContentPane().add(btnEntrar);
        btnEntrar.setBounds(80, 140, 80, 20);
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = txtSenha.getText();
                if ((txtCpf.getText().endsWith("-")) || (senha.equals(""))) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente c = ClientesBLL.ObterPorCPF(txtCpf.getText());
                    if (!(senha.equals(c.getSenha()))) {
                        JOptionPane.showMessageDialog(null, "Senha incorreta." + System.lineSeparator() + "Você tem " + Tentativa + " tentativas restantes", "Erro", JOptionPane.ERROR_MESSAGE);
                        Tentativa -= 1;
                        if (Tentativa == 0) {
                            System.exit(0);
                        }
                    } else {
                        UsuarioLogado.ClienteID = c.getId();
                        UsuarioLogado.CPF = c.getCpf();
                        UsuarioLogado.Nome = c.getNome();
                        Logado = true;
                        setVisible(false);
                    }

                }
            }
        });

        btnCriarConta = new JButton("Cadastre-se");
        this.getContentPane().add(btnCriarConta);
        btnCriarConta.setBounds(60, 170, 120, 20);
        btnCriarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fCadastroUsuario cadUsuario = new fCadastroUsuario();
                cadUsuario.exibir();
            }
        });

    }

    public boolean Exibir() {
        this.setModal(true);
        this.setVisible(true);
        return Logado;
    }
}
