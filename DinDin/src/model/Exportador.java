/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * @author iara9
 */
public class Exportador {
    
    private Conta conta;
    
    public Exportador(Conta conta){
       this.conta = conta; 
    }
    
    /**
     * Exporta todas as despesas de Conta para o arquivo csv recebido por parâmetro
     * @param arquivo 
     */
    public void exportaDespesas(File arquivo) {
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(arquivo));){
            csvWriter.println("Nome;Data;Valor;Categoria");
            for(Despesa d : conta.getDespesas()){
                
                String nome = d.getNome();
                String data = d.getData().toString();
                String valor = String.valueOf(d.getValor());
                String categoria = d.getCategoria();
                
                csvWriter.printf("%s;%s;%s;%s\n", nome, data, valor, categoria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Exporta todas as receitas de Conta para o arquivo csv recebido por parâmetro
     * @param arquivo 
     */
    public void exportaReceitas (File arquivo) {
        
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(arquivo));){
            csvWriter.println("Nome;Data;Valor;Categoria");
            for(Receita r : conta.getReceitas()){
                
                String nome = r.getNome();
                String data = r.getData().toString();
                String valor = String.valueOf(r.getValor());
                String categoria = r.getCategoria();
                
                csvWriter.printf("%s;%s;%s;%s\n", nome, data, valor, categoria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
