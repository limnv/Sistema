package views;

import javax.swing.*;

public class fLogin extends JFrame {
    JLabel lblCpf, lblSenha, lblCabecalho, lblLinha;
    JTextField txtCpf, txtSenha;
    JButton btnEntrar, btnCriarConta, btnAcessoEspecial;
    
    public fLogin(){
        this.setTitle("Login");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Tirar isso depois, apenas para testes
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        lblCabecalho = new JLabel("Entrar");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setBounds(5, 5, 50, 20);        
        
        String s = "";
        for (int i = 0; i < 25; i++) {
            s += "_";
        }
        
        lblLinha = new JLabel();
        lblLinha.setText(s);
        this.getContentPane().add(lblLinha);
        lblLinha.setBounds(5,10,350,20);
        
        lblCpf = new JLabel("CPF:");
        this.getContentPane().add(lblCpf);
        lblCpf.setBounds(5, 30, 50, 20);
        
        this.setVisible(true);
    }
}
