/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import model.enums.CategoriaReceita;

/**
 *
 * @author iara9
 */
public class Receita extends Lancamento{
     
    private CategoriaReceita categoria;

    public Receita(String nome, LocalDate data, double valor, CategoriaReceita categoria) {
        super(nome, data, valor, categoria.toString());
    }  
    
}
