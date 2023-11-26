/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Conta;
import model.Importador;
import model.Lancamento;
import model.enums.CategoriaDespesa;
import model.enums.CategoriaReceita;

/**
 *
 * @author iara9
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta c = new Conta();
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
        
        //Conta de Luz;2023-11-15;56.80;Residência
        LocalDate dataDespesa = LocalDate.of(2023, 11, 15);
        Despesa d = new Despesa("Conta de Luz", dataDespesa , 56.80, CategoriaDespesa.RESIDENCIA);
        c.incluirDespesa(d);
        
        System.out.println(c.getSaldo());
                
        ArrayList<Lancamento> lancamentos = c.getLancamentos(LocalDate.now());
        
        for (Lancamento l : lancamentos) {
            System.out.println(l.getNome() +" | "+ l.getData());
        }
        
        Exportador exportador = new Exportador(c);
        exportador.exportaDespesas(arquivoDespesas);
        exportador.exportaReceitas(arquivoReceitas);
        
    }
    
}
