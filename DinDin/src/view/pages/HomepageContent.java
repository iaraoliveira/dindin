
package view.pages;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Despesa;
import model.Exportador;
import model.Importador;
import model.Lancamento;
import model.Receita;
import view.app.CadastroLancamento;
import view.component.ScrollBar;
import view.model.ModelCard;

public class HomepageContent extends javax.swing.JPanel {

    
    String pathDespesasCSV = new File("res/despesas.csv").getAbsolutePath();
    String pathReceitasCSV = new File("res/receitas.csv").getAbsolutePath();
    
    File arquivoDespesas = new File(pathDespesasCSV);
    File arquivoReceitas = new File(pathReceitasCSV);
    
    Conta c = new Conta();
    
    DecimalFormat df = new DecimalFormat("0.00"); 
    Locale locale = new Locale("pt", "BR");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
    
    public HomepageContent() {
        initComponents();
        init();
        setOpaque(false);
   
        JFrame parent = (JFrame) this.getParent();
    }

    public void init() {
        
        importaDados(c);
        populaCards(c, LocalDate.now());
        populaTabelaLancamentos(c, LocalDate.now());

        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
                
    }
  
    public void importaDados(Conta c) {
        Importador importador = new Importador(c);
                       
        try {
            importador.carregarArquivoDespesas(arquivoDespesas);
            importador.carregarArquivoReceitas(arquivoReceitas);
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void exportarDados() {
        Exportador exportador = new Exportador(c);
        exportador.exportaDespesas(arquivoDespesas);
        exportador.exportaReceitas(arquivoReceitas);
    }
    
    public void filtrarPorData(LocalDate data) {
        populaCards(c, data);
        populaTabelaLancamentos(c, data);
    }
    
    public void populaCards(Conta c, LocalDate dt) {
       
        double totalDespesas = 0;
        double totalReceitas = 0;
        double totalSaldo = c.getSaldo(dt);
        
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
           
        card1.setData(new ModelCard("SALDO EM CONTA", currencyFormatter.format(totalSaldo), "Ver todos os lançamentos"));
        card2.setData(new ModelCard("DESPESAS TOTAIS", currencyFormatter.format(totalDespesas), "Ver todas as despesas"));
        card3.setData(new ModelCard("RECEITAS TOTAIS", currencyFormatter.format(totalReceitas), "Ver todas as receitas"));
        
    }
    
    public void populaTabelaLancamentos(Conta c, LocalDate dt){
        ArrayList<Lancamento> lancamentosList = c.getLancamentos();
       
        for (Lancamento l : lancamentosList) {
            if (l.getData().isBefore(dt) || l.getData().isEqual(dt))
            table.addRow(new Object[]{l.getNome(), dateFormatter.format(l.getData()), currencyFormatter.format(l.getValor()), l.getCategoria()});
        }
    }
    
    public void populaTabelaDespesas(Conta c, LocalDate dt){
        ArrayList<Despesa> despesasList = c.getDespesas();
       
        for (Despesa d : despesasList) {
            if (d.getData().isBefore(dt) || d.getData().isEqual(dt))
            table.addRow(new Object[]{d.getNome(), dateFormatter.format(d.getData()),currencyFormatter.format(d.getValor()), d.getCategoria()});
          
        }
    }
    
    public void populaTabelaReceitas(Conta c, LocalDate dt){
        ArrayList<Receita> receitaList = c.getReceitas();
       
        for (Receita r : receitaList) {
            if (r.getData().isBefore(dt) || r.getData().isEqual(dt))
            table.addRow(new Object[]{r.getNome(), dateFormatter.format(r.getData()), currencyFormatter.format(r.getValor()), r.getCategoria()});
          
        }
    }
    
    
    
    public void actionButton(){
        JFrame parent = (JFrame) new HomepageContent().getParent();
        CadastroLancamento dialogCadastro = new CadastroLancamento(parent, true);
        dialogCadastro.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialogCadastro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogCadastro.setVisible(true);
        
        Despesa novaDespesa = dialogCadastro.getDespesa();
        Receita novaReceita = dialogCadastro.getReceita();
        
        if (novaDespesa != null){
            c.incluirDespesa(novaDespesa);
        } else if (novaReceita != null) {
            c.incluirReceita(novaReceita);
        }
        
        populaCards(c, LocalDate.now());
        populaTabelaLancamentos(c, LocalDate.now());
    }
    
    private void clearTableRows() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardContainerPanel = new javax.swing.JLayeredPane();
        card1 = new view.component.Card();
        card2 = new view.component.Card();
        card3 = new view.component.Card();
        tableContainerPanel = new view.component.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new view.component.Table();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        bntSearch = new view.component.Button();
        searchText1 = new view.component.SearchText();

        setMaximumSize(new java.awt.Dimension(917, 591));
        setMinimumSize(new java.awt.Dimension(917, 591));
        setPreferredSize(new java.awt.Dimension(917, 591));

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
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setText("Boa Noite!");

        lblSubtitle.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(102, 102, 102));
        lblSubtitle.setText("Aqui está um resumo das suas movimentações até o dia de hoje");

        bntSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(lblSubtitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(tableContainerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardContainerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblSubtitle))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(1, 1, 1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(bntSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(cardContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(tableContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        clearTableRows();
        populaTabelaLancamentos(c, getDataFiltragem());                
    }//GEN-LAST:event_card1MouseClicked

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked
        clearTableRows();
        populaTabelaDespesas(c, getDataFiltragem());
    }//GEN-LAST:event_card2MouseClicked

    private void card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3MouseClicked
        clearTableRows();
        populaTabelaReceitas(c, getDataFiltragem());
    }//GEN-LAST:event_card3MouseClicked

    private void card3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_card3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_card3KeyPressed

    private void bntSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSearchActionPerformed
       
        filtrarPorData(getDataFiltragem());
    }//GEN-LAST:event_bntSearchActionPerformed

    public LocalDate getDataFiltragem() {
        if(isAValidLocalDate(searchText1.getText())){
            
            return LocalDate.parse(searchText1.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }else{
            return LocalDate.now();
        }
    }
    public boolean isAValidLocalDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.Button bntSearch;
    private view.component.Card card1;
    private view.component.Card card2;
    private view.component.Card card3;
    private javax.swing.JLayeredPane cardContainerPanel;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private view.component.SearchText searchText1;
    private javax.swing.JScrollPane spTable;
    private view.component.Table table;
    private view.component.PanelBorder tableContainerPanel;
    // End of variables declaration//GEN-END:variables
}
