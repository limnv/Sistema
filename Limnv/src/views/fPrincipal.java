package views;

import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class fPrincipal extends javax.swing.JFrame {

    ArrayList<JPanel> lstPnl = new ArrayList<JPanel>();

    private void AddPnl() {
        if (lstPnl.size() == 0) {
            lstPnl.add(pnlIndicador);
            lstPnl.add(pnlIndicador1);
            lstPnl.add(pnlIndicador2);
            lstPnl.add(pnlIndicador3);
            lstPnl.add(pnlIndicador4);
            lstPnl.add(pnlIndicador5);
            lstPnl.add(pnlIndicador6);
       }
    }

    private void AlteraBotoesClick(JPanel pnlIndi) {
        AddPnl();
        for (int i = 0; i < lstPnl.size(); i++) {
            JPanel get = lstPnl.get(i);
            if (get == pnlIndi) {
                get.setVisible(true);
            }
            else{
                get.setVisible(false);
            }
            
        }
        
    }

    public fPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlBtnHome = new javax.swing.JPanel();
        lblImage1 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        pnlIndicador = new javax.swing.JPanel();
        pnlBtnContas = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlIndicador1 = new javax.swing.JPanel();
        pnlBtnSaque = new javax.swing.JPanel();
        lblImage2 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        pnlIndicador2 = new javax.swing.JPanel();
        pnlBtnDeposito = new javax.swing.JPanel();
        lblImage3 = new javax.swing.JLabel();
        pnlIndicador3 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        pnlBtnTransferencia = new javax.swing.JPanel();
        lblImage4 = new javax.swing.JLabel();
        lblTitulo4 = new javax.swing.JLabel();
        pnlIndicador4 = new javax.swing.JPanel();
        pnlBtnExtrato = new javax.swing.JPanel();
        lblImage6 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        pnlIndicador5 = new javax.swing.JPanel();
        pnlBtnPagamentos = new javax.swing.JPanel();
        lblImage5 = new javax.swing.JLabel();
        lblTitulo5 = new javax.swing.JLabel();
        pnlIndicador6 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenu.setBackground(new java.awt.Color(42, 42, 42));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBtnHome.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnHomeMouseExited(evt);
            }
        });

        lblImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Home_24px.png"))); // NOI18N

        lblTitulo1.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo1.setText("Home");

        pnlIndicador.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicadorLayout = new javax.swing.GroupLayout(pnlIndicador);
        pnlIndicador.setLayout(pnlIndicadorLayout);
        pnlIndicadorLayout.setHorizontalGroup(
            pnlIndicadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicadorLayout.setVerticalGroup(
            pnlIndicadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBtnHomeLayout = new javax.swing.GroupLayout(pnlBtnHome);
        pnlBtnHome.setLayout(pnlBtnHomeLayout);
        pnlBtnHomeLayout.setHorizontalGroup(
            pnlBtnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnHomeLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lblImage1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pnlIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnHomeLayout.setVerticalGroup(
            pnlBtnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage1)
                    .addGroup(pnlBtnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnlIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        pnlBtnContas.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnContasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnContasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnContasMouseExited(evt);
            }
        });

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Money_24px.png"))); // NOI18N

        lblTitulo.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo.setText("Contas");

        pnlIndicador1.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicador1Layout = new javax.swing.GroupLayout(pnlIndicador1);
        pnlIndicador1.setLayout(pnlIndicador1Layout);
        pnlIndicador1Layout.setHorizontalGroup(
            pnlIndicador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicador1Layout.setVerticalGroup(
            pnlIndicador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBtnContasLayout = new javax.swing.GroupLayout(pnlBtnContas);
        pnlBtnContas.setLayout(pnlBtnContasLayout);
        pnlBtnContasLayout.setHorizontalGroup(
            pnlBtnContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnContasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIndicador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnContasLayout.setVerticalGroup(
            pnlBtnContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnContasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIndicador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage)
                    .addComponent(lblTitulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnContas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, -1));

        pnlBtnSaque.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnSaque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnSaqueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnSaqueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnSaqueMouseExited(evt);
            }
        });

        lblImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Request_Money_24px.png"))); // NOI18N

        lblTitulo2.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo2.setText("Saque");

        pnlIndicador2.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicador2Layout = new javax.swing.GroupLayout(pnlIndicador2);
        pnlIndicador2.setLayout(pnlIndicador2Layout);
        pnlIndicador2Layout.setHorizontalGroup(
            pnlIndicador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicador2Layout.setVerticalGroup(
            pnlIndicador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBtnSaqueLayout = new javax.swing.GroupLayout(pnlBtnSaque);
        pnlBtnSaque.setLayout(pnlBtnSaqueLayout);
        pnlBtnSaqueLayout.setHorizontalGroup(
            pnlBtnSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnSaqueLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblImage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIndicador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnSaqueLayout.setVerticalGroup(
            pnlBtnSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnSaqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo2)
                    .addComponent(lblImage2)
                    .addComponent(pnlIndicador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnSaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 210, -1));

        pnlBtnDeposito.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnDepositoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnDepositoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnDepositoMouseExited(evt);
            }
        });

        lblImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Initiate_Money_Transfer_24px.png"))); // NOI18N

        pnlIndicador3.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicador3Layout = new javax.swing.GroupLayout(pnlIndicador3);
        pnlIndicador3.setLayout(pnlIndicador3Layout);
        pnlIndicador3Layout.setHorizontalGroup(
            pnlIndicador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicador3Layout.setVerticalGroup(
            pnlIndicador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        lblTitulo3.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo3.setText("Depósito");

        javax.swing.GroupLayout pnlBtnDepositoLayout = new javax.swing.GroupLayout(pnlBtnDeposito);
        pnlBtnDeposito.setLayout(pnlBtnDepositoLayout);
        pnlBtnDepositoLayout.setHorizontalGroup(
            pnlBtnDepositoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnDepositoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblImage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlIndicador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnDepositoLayout.setVerticalGroup(
            pnlBtnDepositoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnDepositoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnDepositoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIndicador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage3)
                    .addComponent(lblTitulo3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, -1));

        pnlBtnTransferencia.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnTransferenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnTransferenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnTransferenciaMouseExited(evt);
            }
        });

        lblImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Money_Transfer_24px.png"))); // NOI18N

        lblTitulo4.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo4.setText("Transferência");

        pnlIndicador4.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicador4Layout = new javax.swing.GroupLayout(pnlIndicador4);
        pnlIndicador4.setLayout(pnlIndicador4Layout);
        pnlIndicador4Layout.setHorizontalGroup(
            pnlIndicador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicador4Layout.setVerticalGroup(
            pnlIndicador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBtnTransferenciaLayout = new javax.swing.GroupLayout(pnlBtnTransferencia);
        pnlBtnTransferencia.setLayout(pnlBtnTransferenciaLayout);
        pnlBtnTransferenciaLayout.setHorizontalGroup(
            pnlBtnTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnTransferenciaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblImage4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlIndicador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnTransferenciaLayout.setVerticalGroup(
            pnlBtnTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnTransferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIndicador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage4)
                    .addComponent(lblTitulo4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, -1));

        pnlBtnExtrato.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnExtrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnExtratoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnExtratoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnExtratoMouseExited(evt);
            }
        });

        lblImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Bill_24px.png"))); // NOI18N

        lblTitulo6.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo6.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo6.setText("Extrato");

        pnlIndicador5.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicador5Layout = new javax.swing.GroupLayout(pnlIndicador5);
        pnlIndicador5.setLayout(pnlIndicador5Layout);
        pnlIndicador5Layout.setHorizontalGroup(
            pnlIndicador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicador5Layout.setVerticalGroup(
            pnlIndicador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBtnExtratoLayout = new javax.swing.GroupLayout(pnlBtnExtrato);
        pnlBtnExtrato.setLayout(pnlBtnExtratoLayout);
        pnlBtnExtratoLayout.setHorizontalGroup(
            pnlBtnExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnExtratoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblImage6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlIndicador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnExtratoLayout.setVerticalGroup(
            pnlBtnExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnExtratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIndicador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage6)
                    .addComponent(lblTitulo6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnExtrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 210, -1));

        pnlBtnPagamentos.setBackground(new java.awt.Color(42, 42, 42));
        pnlBtnPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBtnPagamentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnPagamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnPagamentosMouseExited(evt);
            }
        });

        lblImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagens/icons8_Cash_in_Hand_24px.png"))); // NOI18N

        lblTitulo5.setBackground(new java.awt.Color(134, 189, 74));
        lblTitulo5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo5.setForeground(new java.awt.Color(134, 189, 74));
        lblTitulo5.setText("Pagamentos");

        pnlIndicador6.setBackground(new java.awt.Color(134, 189, 74));

        javax.swing.GroupLayout pnlIndicador6Layout = new javax.swing.GroupLayout(pnlIndicador6);
        pnlIndicador6.setLayout(pnlIndicador6Layout);
        pnlIndicador6Layout.setHorizontalGroup(
            pnlIndicador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        pnlIndicador6Layout.setVerticalGroup(
            pnlIndicador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBtnPagamentosLayout = new javax.swing.GroupLayout(pnlBtnPagamentos);
        pnlBtnPagamentos.setLayout(pnlBtnPagamentosLayout);
        pnlBtnPagamentosLayout.setHorizontalGroup(
            pnlBtnPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnPagamentosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblImage5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlIndicador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBtnPagamentosLayout.setVerticalGroup(
            pnlBtnPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnPagamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIndicador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage5)
                    .addComponent(lblTitulo5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlBtnPagamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 618, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBtnContasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnContasMouseEntered
        pnlBtnContas.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnContasMouseEntered

    private void pnlBtnContasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnContasMouseExited
        pnlBtnContas.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnContasMouseExited

    private void pnlBtnContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnContasMouseClicked
        AlteraBotoesClick(pnlBtnContas);
    }//GEN-LAST:event_pnlBtnContasMouseClicked

    private void pnlBtnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnHomeMouseClicked
        AlteraBotoesClick(pnlBtnHome);
    }//GEN-LAST:event_pnlBtnHomeMouseClicked

    private void pnlBtnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnHomeMouseEntered
        pnlBtnHome.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnHomeMouseEntered

    private void pnlBtnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnHomeMouseExited
        pnlBtnHome.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnHomeMouseExited

    private void pnlBtnSaqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnSaqueMouseClicked
        AlteraBotoesClick(pnlBtnSaque);
    }//GEN-LAST:event_pnlBtnSaqueMouseClicked

    private void pnlBtnSaqueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnSaqueMouseEntered
        pnlBtnSaque.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnSaqueMouseEntered

    private void pnlBtnSaqueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnSaqueMouseExited
        pnlBtnSaque.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnSaqueMouseExited

    private void pnlBtnDepositoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnDepositoMouseClicked
        AlteraBotoesClick(pnlBtnDeposito);
    }//GEN-LAST:event_pnlBtnDepositoMouseClicked

    private void pnlBtnDepositoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnDepositoMouseEntered
        pnlBtnDeposito.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnDepositoMouseEntered

    private void pnlBtnDepositoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnDepositoMouseExited
        pnlBtnDeposito.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnDepositoMouseExited

    private void pnlBtnTransferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnTransferenciaMouseClicked
        AlteraBotoesClick(pnlBtnTransferencia);
    }//GEN-LAST:event_pnlBtnTransferenciaMouseClicked

    private void pnlBtnTransferenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnTransferenciaMouseEntered
        pnlBtnTransferencia.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnTransferenciaMouseEntered

    private void pnlBtnTransferenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnTransferenciaMouseExited
        pnlBtnTransferencia.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnTransferenciaMouseExited

    private void pnlBtnPagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnPagamentosMouseClicked
        AlteraBotoesClick(pnlBtnPagamentos);
    }//GEN-LAST:event_pnlBtnPagamentosMouseClicked

    private void pnlBtnPagamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnPagamentosMouseEntered
        pnlBtnPagamentos.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnPagamentosMouseEntered

    private void pnlBtnPagamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnPagamentosMouseExited
        pnlBtnPagamentos.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnPagamentosMouseExited

    private void pnlBtnExtratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnExtratoMouseClicked
        AlteraBotoesClick(pnlBtnExtrato);
    }//GEN-LAST:event_pnlBtnExtratoMouseClicked

    private void pnlBtnExtratoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnExtratoMouseEntered
        pnlBtnExtrato.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_pnlBtnExtratoMouseEntered

    private void pnlBtnExtratoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnExtratoMouseExited
        pnlBtnExtrato.setBackground(new Color(42, 42, 42));
    }//GEN-LAST:event_pnlBtnExtratoMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblImage3;
    private javax.swing.JLabel lblImage4;
    private javax.swing.JLabel lblImage5;
    private javax.swing.JLabel lblImage6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JPanel pnlBtnContas;
    private javax.swing.JPanel pnlBtnDeposito;
    private javax.swing.JPanel pnlBtnExtrato;
    private javax.swing.JPanel pnlBtnHome;
    private javax.swing.JPanel pnlBtnPagamentos;
    private javax.swing.JPanel pnlBtnSaque;
    private javax.swing.JPanel pnlBtnTransferencia;
    private javax.swing.JPanel pnlIndicador;
    private javax.swing.JPanel pnlIndicador1;
    private javax.swing.JPanel pnlIndicador2;
    private javax.swing.JPanel pnlIndicador3;
    private javax.swing.JPanel pnlIndicador4;
    private javax.swing.JPanel pnlIndicador5;
    private javax.swing.JPanel pnlIndicador6;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
