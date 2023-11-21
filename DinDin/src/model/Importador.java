/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.enums.CategoriaDespesa;
import model.enums.CategoriaReceita;

/**
 *
 * @author iara9
 */
public class Importador {
    private Conta conta;
    
    public Importador(Conta conta){
       this.conta = conta; 
    }
    
    public void carregarArquivoDespesas(File arquivo) throws FileNotFoundException {
      
        try(Scanner sc = new Scanner(arquivo,"UTF-8")){
            
            //desprezando o cabeçalho do arquivo
            if (sc.hasNextLine()){
                sc.nextLine();
            }
                       
            while(sc.hasNextLine()){
                
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                           
                String nomeDespesa = dados[0];
                LocalDate dataDespesa = LocalDate.parse(dados[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                double valorDespesa = Double.parseDouble(dados[2]);
                CategoriaDespesa categoriaDespesa = CategoriaDespesa.findByDescricao(dados[3]);
                
                Despesa d = new Despesa(
                        nomeDespesa,
                        dataDespesa,
                        valorDespesa,
                        categoriaDespesa
                );
                
               conta.incluirDespesa(d);
                
            }
        }
        
    }
    
    public void carregarArquivoReceitas(File arquivo) throws FileNotFoundException {
      
        try(Scanner sc = new Scanner(arquivo,"UTF-8")){
            
            if (sc.hasNextLine()){
                sc.nextLine();
            }
            
            while(sc.hasNextLine()){
                
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                
                String nomeReceita = dados[0];
                LocalDate dataReceita = LocalDate.parse(dados[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                double valorReceita = Double.parseDouble(dados[2]);
                CategoriaReceita categoriaReceita = CategoriaReceita.findByDescricao(dados[3]);
                
                Receita r = new Receita(
                        nomeReceita,
                        dataReceita,
                        valorReceita,
                        categoriaReceita
                );
                
               conta.incluirReceita(r);
                
            }
        }
        
    }
}
