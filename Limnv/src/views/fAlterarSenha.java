package views;

import controllers.ClientesBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import models.Cliente;

/**
 *
 * @author luism
 */
public class fAlterarSenha extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblSenhaAtual, lblNovaSenha, lblConfirmaSenha;
    JTextField txtSenhaAtual, txtNovaSenha, txtConfirmaSenha;
    JButton btnSalvar, btnCancelar;

    public fAlterarSenha() {
        this.setTitle("Alterar Senha");
        this.setSize(230, 295);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);

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

        lblCabecalho = new JLabel("Alterar Senha");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setFont(new Font("Arial", Font.BOLD, 13));
        lblCabecalho.setBounds(5, 30, 350, 25);

        lblSenhaAtual = new JLabel("Senha Atual:");
        this.getContentPane().add(lblSenhaAtual);
        lblSenhaAtual.setBounds(5, 65, 205, 20);

        txtSenhaAtual = new JPasswordField();
        this.getContentPane().add(txtSenhaAtual);
        txtSenhaAtual.setBounds(5, 90, 205, 20);

        lblNovaSenha = new JLabel("Nova Senha:");
        this.getContentPane().add(lblNovaSenha);
        lblNovaSenha.setBounds(5, 120, 205, 20);

        txtNovaSenha = new JPasswordField();
        this.getContentPane().add(txtNovaSenha);
        txtNovaSenha.setBounds(5, 145, 205, 20);

        lblConfirmaSenha = new JLabel("Confirme a nova senha:");
        this.getContentPane().add(lblConfirmaSenha);
        lblConfirmaSenha.setBounds(5, 175, 205, 20);

        txtConfirmaSenha = new JPasswordField();
        this.getContentPane().add(txtConfirmaSenha);
        txtConfirmaSenha.setBounds(5, 200, 205, 20);

        btnSalvar = new JButton("Salvar");
        this.getContentPane().add(btnSalvar);
        btnSalvar.setBounds(5, 230, 100, 20);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSenhaAtual.getText().equals("") && txtNovaSenha.getText().equals("") && txtConfirmaSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente c = ClientesBLL.ObterPorCPF(UsuarioLogado.CPF);
                    if (txtSenhaAtual.getText().equals(c.getSenha())) {
                        if (txtNovaSenha.getText().equals(txtConfirmaSenha.getText())) {
                            if (txtSenhaAtual.getText().equals(txtNovaSenha.getText())) {
                                JOptionPane.showMessageDialog(null, "A nova senha não pode ser igual a atual.", "Erro", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if (JOptionPane.showConfirmDialog(null, "Deseja alterar?", "Confirmação...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    c.setSenha(txtNovaSenha.getText());
                                    ClientesBLL.AlterarSenha(c);
                                    JOptionPane.showMessageDialog(null, "Senha alterada.", "Aviso...", JOptionPane.INFORMATION_MESSAGE);
                                    setVisible(false);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "A nova senha e a confirmação não conferem.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "A senha atual não confere.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(110, 230, 100, 20);
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
