
package view.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Conta;
import model.Despesa;
import model.Exportador;
import model.Importador;
import model.Lancamento;
import model.enums.CategoriaDespesa;


public class Main {

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                App aplication = new App();
                aplication.setSize(791, 624);
                aplication.setLocationRelativeTo(null);
                aplication.setVisible(true);
            }
        });
    }
    
    
   
        
        
//        Conta c = new Conta();
//        Importador importador = new Importador(c);
//        
//        String pathDespesasCSV = new File("res/despesas.csv").getAbsolutePath();
//        String pathReceitasCSV = new File("res/receitas.csv").getAbsolutePath();
//        
//        File arquivoDespesas = new File(pathDespesasCSV);
//        File arquivoReceitas = new File(pathReceitasCSV);
//        
//        try {
//            importador.carregarArquivoDespesas(arquivoDespesas);
//            importador.carregarArquivoReceitas(arquivoReceitas);
//        }catch(FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        
//        //Conta de Luz;2023-11-15;56.80;Residência
//        LocalDate dataDespesa = LocalDate.of(2023, 11, 15);
//        Despesa d = new Despesa("Conta de Luz", dataDespesa , 56.80, CategoriaDespesa.RESIDENCIA);
//        c.incluirDespesa(d);
//        
//        System.out.println(c.getSaldo());
//                
//        ArrayList<Lancamento> lancamentos = c.getLancamentos(LocalDate.now());
//        
//        for (Lancamento l : lancamentos) {
//            System.out.println(l.getNome() +" | "+ l.getData());
//        }
//        
//        Exportador exportador = new Exportador(c);
//        exportador.exportaDespesas(arquivoDespesas);
//        exportador.exportaReceitas(arquivoReceitas);
//        
    
}
