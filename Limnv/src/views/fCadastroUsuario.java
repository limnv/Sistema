package views;

import controllers.ClientesBLL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import models.Cliente;

public class fCadastroUsuario extends JDialog {
    JTextField txtNome, txtCpf, txtSenha, txtConfirmaSenha;
    JLabel lblNome, lblCpf, lblSenha, lblConfirmaSenha;
    JButton btnSalvar, btnCancelar;
    
    public fCadastroUsuario() {
        this.setTitle("Cadastre-se");
        this.setSize(325, 325);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        lblNome = new JLabel("Nome:");
        this.getContentPane().add(lblNome);
        lblNome.setBounds(30, 30, 50, 20);
        
        txtNome = new JTextField();
        this.getContentPane().add(txtNome);
        txtNome.setBounds(30, 50, 250, 20);
        
        lblCpf = new JLabel("CPF:");
        this.getContentPane().add(lblCpf);
        lblCpf.setBounds(30, 80, 50, 20);
        
        try {
            txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            this.getContentPane().add(txtCpf);
            txtCpf.setBounds(30, 100, 250, 20);
        } catch (ParseException ex) {
            Logger.getLogger(fCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        lblSenha = new JLabel("Senha:");
        this.getContentPane().add(lblSenha);
        lblSenha.setBounds(30, 130, 50, 20);
        
        txtSenha = new JPasswordField();
        this.getContentPane().add(txtSenha);
        txtSenha.setBounds(30, 150, 250, 20);
        
        lblConfirmaSenha = new JLabel("Confirme a senha:");
        this.getContentPane().add(lblConfirmaSenha);
        lblConfirmaSenha.setBounds(30, 180, 120, 20);
        
        txtConfirmaSenha = new JPasswordField();
        this.getContentPane().add(txtConfirmaSenha);
        txtConfirmaSenha.setBounds(30, 200, 250, 20);
        
        btnSalvar = new JButton("Salvar");
        this.getContentPane().add(btnSalvar);
        btnSalvar.setBounds(30, 230, 120, 25);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((txtNome.getText().equals("")) || (txtCpf.getText().equals("")) || (txtSenha.getText().equals("")) || (txtConfirmaSenha.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (!txtSenha.getText().equals(txtConfirmaSenha.getText())){
                    JOptionPane.showMessageDialog(null, "As senhas não conferem.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente c = new Cliente();
                    c.setNome(txtNome.getText());
                    c.setCpf(txtCpf.getText());
                    c.setSenha(txtSenha.getText());
                    ClientesBLL.Inserir(c);
                    JOptionPane.showMessageDialog(null, "Pronto..." + System.lineSeparator() + "Você já esta cadastrado." + System.lineSeparator() + "Agora, vamos criar a sua conta", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    int ID = ClientesBLL.ObterIDPorCPF(txtCpf.getText());
                    fCadastroConta cadConta = new fCadastroConta();
                    cadConta.ClienteID = ID;
                    if (!cadConta.exibir()){
                        ClientesBLL.ApagarPorID(ID);
                        JOptionPane.showMessageDialog(null, "Cadastro cancelado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        setVisible(false);
                    } else {
                        setVisible(false);
                    }
                        
                }
            }
        });
        
        btnCancelar = new JButton("Cancelar");
        this.getContentPane().add(btnCancelar);
        btnCancelar.setBounds(160, 230, 120, 25);
        
    }
    
    public void exibir(){
        this.setModal(true);
        this.setVisible(true);
    }
}
