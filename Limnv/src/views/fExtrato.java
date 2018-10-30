package views;

import controllers.ExtratosBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author luism
 */
public class fExtrato extends JDialog {

    JLabel lblLogo, lblBorda, lblCabecalho, lblPeriodo;
    JTable tblExtrato;
    JComboBox<String> cbPrazo;
    JScrollPane sp;
    ExtratoTableModel extratosTableModel;
    String DataInicial, DataFinal;

    public fExtrato() {
        this.setTitle("Extrato");
        this.setSize(625, 488);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");

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

        lblCabecalho = new JLabel("Extrato");
        this.getContentPane().add(lblCabecalho);
        lblCabecalho.setFont(new Font("Arial", Font.BOLD, 13));
        lblCabecalho.setBounds(5, 30, 350, 25);

        lblPeriodo = new JLabel("Período:");
        this.getContentPane().add(lblPeriodo);
        lblPeriodo.setBounds(5, 65, 60, 20);

        cbPrazo = new JComboBox<String>();
        cbPrazo.addItem("7 Dias");
        cbPrazo.addItem("15 Dias");
        cbPrazo.addItem("30 Dias");
        this.getContentPane().add(cbPrazo);
        cbPrazo.setBounds(70, 65, 120, 20);
        cbPrazo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String escolha = cbPrazo.getSelectedItem().toString();
                int Dias = 0;
                switch(escolha){
                    case "7 Dias":
                        Dias = 7;
                        break;
                    case "15 Dias":
                        Dias = 15;
                        break;
                    case "30 Dias":
                        Dias = 30;
                        break;
                    default:
                        Dias = 1;
                }
                Date dt = new Date();
                dt.getTime();
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.add(Calendar.DAY_OF_MONTH, -Dias);
                
                DataFinal = formatter.format(dt);
                DataInicial = formatter.format(c.getTime());
                
                PopulaTabela();

            }
        });

        tblExtrato = new JTable();
        tblExtrato.setBounds(5, 95, 600, 350);

        sp = new JScrollPane(tblExtrato);
        this.getContentPane().add(sp);
        sp.setBounds(5, 95, 600, 350);

    }

    public void Exibir() {
        this.setModal(true);
        this.setVisible(true);
    }

    public void PopulaTabela() {
        if(extratosTableModel != null)
            extratosTableModel.setNumRows(0);
        extratosTableModel = new ExtratoTableModel(ExtratosBLL.ObterListaExtrato(DataInicial, DataFinal));
        tblExtrato.setModel(extratosTableModel);
        tblExtrato.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblExtrato.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblExtrato.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblExtrato.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

}
