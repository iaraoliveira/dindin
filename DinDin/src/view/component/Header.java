package view.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Conta;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
        setOpaque(false);
        lblIcon.setIcon(getResizedImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        searchText1 = new view.swing.SearchText();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        lblIcon.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lblIcon.setPreferredSize(new java.awt.Dimension(42, 42));
        lblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setText("Boa Noite!");

        lblSubtitle.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(102, 102, 102));
        lblSubtitle.setText("- Aqui está um resumo das suas movimentações até o dia de hoje");

        searchText1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSubtitle)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconMouseClicked
        System.exit(0);
        
    }//GEN-LAST:event_lblIconMouseClicked

    private ImageIcon getResizedImage() {
        
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\iara9\\Projects\\dindin\\DinDin\\src\\view\\icon\\close_icon.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(18, 18,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        ImageIcon resizedImage = new ImageIcon(newimg);
        
        return resizedImage;
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private view.swing.SearchText searchText1;
    // End of variables declaration//GEN-END:variables
}
