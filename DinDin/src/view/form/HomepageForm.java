package view.form;

import view.model.ModelCard;
import view.swing.ScrollBar;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Despesa;
import model.Importador;
import model.Lancamento;
import model.Receita;
import view.pages.CadastroLancamento;

public class HomepageForm extends javax.swing.JPanel {
    
    Conta c = new Conta();
    DecimalFormat df = new DecimalFormat("0.00"); 
    
    public HomepageForm() {
        importaDados(c);
        initComponents();
        setOpaque(false);
                
        populaCards(c, LocalDate.now());
        populaTabelaLancamentos(c, LocalDate.now());
        
        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
    }

    public void populaCards(Conta c, LocalDate dt) {
       
        double totalDespesas = 0;
        double totalReceitas = 0;
        
        ArrayList<Despesa> despesasList = c.getDespesas();
        ArrayList<Receita> receitasList = c.getReceitas();
        
        for (Receita r : receitasList) {
            if (r.getData().isBefore(dt) || r.getData().isEqual(dt))
            totalReceitas = totalReceitas + r.getValor();
        }
        
        for (Despesa r : despesasList) {
            if (r.getData().isBefore(dt) || r.getData().isEqual(dt))
            totalDespesas = totalDespesas + r.getValor();
        }
           
        card1.setData(new ModelCard("SALDO EM CONTA", "R$" + String.valueOf(df.format(c.getSaldo())), "Ver todos os lançamentos"));
        card2.setData(new ModelCard("DESPESAS TOTAIS", "R$" + df.format(totalDespesas), "Ver todas as despesas"));
        card3.setData(new ModelCard("RECEITAS TOTAIS", "R$" + df.format(totalReceitas), "Ver todas as receitas"));
        
    }
    
    public void populaTabelaLancamentos(Conta c, LocalDate dt){
        ArrayList<Lancamento> lancamentosList = c.getLancamentos();;
       
        for (Lancamento l : lancamentosList) {
            if (l.getData().isBefore(dt) || l.getData().isEqual(dt))
            table.addRow(new Object[]{l.getNome(), l.getData().toString(), String.valueOf(df.format(l.getValor())), l.getCategoria()});
        }
    }
    
    public void populaTabelaDespesas(Conta c, LocalDate dt){
        ArrayList<Despesa> despesasList = c.getDespesas();;
       
        for (Despesa d : despesasList) {
            if (d.getData().isBefore(dt) || d.getData().isEqual(dt))
            table.addRow(new Object[]{d.getNome(), d.getData().toString(), String.valueOf(df.format(d.getValor())), d.getCategoria()});
          
        }
        
    }
    
    public void populaTabelaReceitas(Conta c, LocalDate dt){
        ArrayList<Receita> receitaList = c.getReceitas();;
       
        for (Receita r : receitaList) {
            if (r.getData().isBefore(dt) || r.getData().isEqual(dt))
            table.addRow(new Object[]{r.getNome(), r.getData().toString(), String.valueOf(df.format(r.getValor())), r.getCategoria()});
          
        }
        
    }

    public void importaDados(Conta c) {
        Importador importador = new Importador(c);
        
        String pathDespesasCSV = new File("res/despesas.csv").getAbsolutePath();
        String pathReceitasCSV = new File("res/receitas.csv").getAbsolutePath();
        
        File arquivoDespesas = new File(pathDespesasCSV);
        File arquivoReceitas = new File(pathReceitasCSV);
        
        try {
            importador.carregarArquivoDespesas(arquivoDespesas);
            importador.carregarArquivoReceitas(arquivoReceitas);
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
     
    public void actionButton(){
        System.out.println("Action Button");
        new CadastroLancamento().setVisible(true);
        
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardContainerPanel = new javax.swing.JLayeredPane();
        card1 = new view.component.Card();
        card2 = new view.component.Card();
        card3 = new view.component.Card();
        tableContainerPanel = new view.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new view.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        cardContainerPanel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(33, 147, 176));
        card1.setColor2(new java.awt.Color(109, 213, 237));
        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1MouseClicked(evt);
            }
        });
        cardContainerPanel.add(card1);

        card2.setColor1(new java.awt.Color(244, 107, 69));
        card2.setColor2(new java.awt.Color(246, 148, 121));
        card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card2MouseClicked(evt);
            }
        });
        cardContainerPanel.add(card2);

        card3.setColor1(new java.awt.Color(98, 160, 65));
        card3.setColor2(new java.awt.Color(141, 194, 111));
        card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card3MouseClicked(evt);
            }
        });
        card3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                card3KeyPressed(evt);
            }
        });
        cardContainerPanel.add(card3);

        tableContainerPanel.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nome", "Data", "Valor", "Categoria"
            }
        ));
        spTable.setViewportView(table);

        javax.swing.GroupLayout tableContainerPanelLayout = new javax.swing.GroupLayout(tableContainerPanel);
        tableContainerPanel.setLayout(tableContainerPanelLayout);
        tableContainerPanelLayout.setHorizontalGroup(
            tableContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
        );
        tableContainerPanelLayout.setVerticalGroup(
            tableContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableContainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cardContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(tableContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        clearTableRows();
        populaTabelaLancamentos(c, LocalDate.now());
    }//GEN-LAST:event_card1MouseClicked

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked
        clearTableRows();
        populaTabelaDespesas(c, LocalDate.now());
    }//GEN-LAST:event_card2MouseClicked

    private void card3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_card3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_card3KeyPressed

    private void card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3MouseClicked
        clearTableRows();
        populaTabelaReceitas(c, LocalDate.now());
    }//GEN-LAST:event_card3MouseClicked

    private void clearTableRows() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.Card card1;
    private view.component.Card card2;
    private view.component.Card card3;
    private javax.swing.JLayeredPane cardContainerPanel;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private view.swing.PanelBorder tableContainerPanel;
    // End of variables declaration//GEN-END:variables
}
