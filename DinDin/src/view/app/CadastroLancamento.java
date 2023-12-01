
package view.app;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import model.Despesa;
import model.Receita;
import model.enums.CategoriaDespesa;
import model.enums.CategoriaReceita;

public class CadastroLancamento extends javax.swing.JDialog {

    String[] catDespesaOptions;
    String[] catReceitaOptions;
   
    Despesa novaDespesa;
    Receita novaReceita;
    
    public CadastroLancamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    
    public void init() {
        setBackground(new Color(0, 0, 0, 0));
        
        catDespesaOptions = getOptionValues(CategoriaDespesa.values());
        catReceitaOptions = getOptionValues(CategoriaReceita.values());
    }
    
    private static <T extends Enum<T>> String[] getOptionValues(T[] values) {
        String[] optionList = new String[values.length];        

        int i = 0;
        for (T value : values) {
            optionList[i] = value.toString();
            i++;
        }
        
        return optionList;    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new view.component.PanelBorder();
        panelBorder = new view.component.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        lblTipoLancamento = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        rbTipoDespesa = new javax.swing.JRadioButton();
        rbTipoReceita = new javax.swing.JRadioButton();
        cbCategoria = new javax.swing.JComboBox<>();
        lblData = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnCancelar = new view.component.Button();
        btnCadastrar = new view.component.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(50, 50, 50, 90));
        bg.setMaximumSize(new java.awt.Dimension(791, 624));
        bg.setMinimumSize(new java.awt.Dimension(791, 624));
        bg.setPreferredSize(new java.awt.Dimension(917, 639));

        panelBorder.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jPanel1.setOpaque(false);

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setText("Cadastrar novo Lançamento");
        lblTitle.setOpaque(true);

        lblSubtitle.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(102, 102, 102));
        lblSubtitle.setText("Aqui você pode criar uma nova receita ou despesa");

        lblDescricao.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(51, 51, 51));
        lblDescricao.setText("Descrição");

        txtData.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        txtData.setToolTipText("");
        txtData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataKeyTyped(evt);
            }
        });

        lblValor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblValor.setForeground(new java.awt.Color(51, 51, 51));
        lblValor.setText("Valor");

        lblTipoLancamento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblTipoLancamento.setForeground(new java.awt.Color(51, 51, 51));
        lblTipoLancamento.setText("Tipo de Lançamento");

        lblCategoria.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(51, 51, 51));
        lblCategoria.setText("Categoria");

        rbTipoDespesa.setBackground(new java.awt.Color(255, 255, 255));
        rbTipoDespesa.setText("Despesa");
        rbTipoDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbTipoDespesaMouseClicked(evt);
            }
        });
        rbTipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTipoDespesaActionPerformed(evt);
            }
        });

        rbTipoReceita.setBackground(new java.awt.Color(255, 255, 255));
        rbTipoReceita.setText("Receita");
        rbTipoReceita.setToolTipText("");
        rbTipoReceita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbTipoReceitaMouseClicked(evt);
            }
        });

        cbCategoria.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        cbCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        cbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        lblData.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblData.setForeground(new java.awt.Color(51, 51, 51));
        lblData.setText("Data");

        txtDescricao.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        txtDescricao.setToolTipText("");
        txtDescricao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        txtValor.setToolTipText("");
        txtValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(238, 238, 238));
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(98, 160, 65));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblData)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCategoria, 0, 568, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbTipoDespesa)
                                .addGap(18, 18, 18)
                                .addComponent(rbTipoReceita))
                            .addComponent(lblCategoria)
                            .addComponent(lblTipoLancamento)
                            .addComponent(lblValor)
                            .addComponent(lblDescricao)
                            .addComponent(lblSubtitle)
                            .addComponent(lblTitle)
                            .addComponent(txtDescricao)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoLancamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTipoDespesa)
                    .addComponent(rbTipoReceita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout panelBorderLayout = new javax.swing.GroupLayout(panelBorder);
        panelBorder.setLayout(panelBorderLayout);
        panelBorderLayout.setHorizontalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelBorderLayout.setVerticalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
            .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(panelBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(panelBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataKeyTyped

    private void rbTipoDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbTipoDespesaMouseClicked
        //        DefaultComboBoxModel<String> newModel = new DefaultComboBoxModel<>(CategoriaDespesa.values());
        cbCategoria.setModel(new DefaultComboBoxModel<>(catDespesaOptions));
    }//GEN-LAST:event_rbTipoDespesaMouseClicked

    private void rbTipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTipoDespesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTipoDespesaActionPerformed

    private void rbTipoReceitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbTipoReceitaMouseClicked
        cbCategoria.setModel(new DefaultComboBoxModel<>(catReceitaOptions));
    }//GEN-LAST:event_rbTipoReceitaMouseClicked

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        Window w = SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
        System.out.println("botão cadastrar");

        String nome = txtDescricao.getText();
        LocalDate data = LocalDate.parse(txtData.getText());
        double valor = Double.parseDouble(txtValor.getText());
        String categoria = cbCategoria.getSelectedItem().toString();;;
        //
        System.out.println(nome);
        System.out.println(data);
        System.out.println(valor);
        System.out.println(CategoriaDespesa.findByDescricao(categoria));
        //
        if(rbTipoDespesa.isSelected()){
            novaDespesa = new Despesa(nome, data , valor, CategoriaDespesa.findByDescricao(categoria));
            //            c.incluirDespesa(d);
        } else if(rbTipoReceita.isSelected()){
            novaReceita = new Receita(nome, data , valor, CategoriaReceita.findByDescricao(categoria));
            //            c.incluirReceita(r);
        };
        //
//        Window w = SwingUtilities.getWindowAncestor(this);;
        this.setVisible(false);
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroLancamento dialog = new CadastroLancamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public Despesa getDespesa() {
        return novaDespesa;
    }
    
    public Receita getReceita() {
        return novaReceita;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.PanelBorder bg;
    private view.component.Button btnCadastrar;
    private view.component.Button btnCancelar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTipoLancamento;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValor;
    private view.component.PanelBorder panelBorder;
    private javax.swing.JRadioButton rbTipoDespesa;
    private javax.swing.JRadioButton rbTipoReceita;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}