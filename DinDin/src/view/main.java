/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import model.Conta;
import model.Importador;

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
        
        File arquivoDespesas = new File("C:\\Users\\iara9\\Projects\\dindin\\DinDin\\res\\despesas.csv");
        File arquivoReceitas = new File("C:\\Users\\iara9\\Projects\\dindin\\DinDin\\res\\receitas.csv");
        
        try {
            importador.carregarArquivoDespesas(arquivoDespesas);
            importador.carregarArquivoReceitas(arquivoReceitas);
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(c.getReceitas());
        
    }
    
}
