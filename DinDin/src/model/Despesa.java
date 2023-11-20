/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import model.categorias.CategoriaDespesa;

/**
 *
 * @author iara9
 */
public class Despesa extends Lancamento {
    
    

    private CategoriaDespesa categoria;
    
    public Despesa(String nome, LocalDate data, double valor, CategoriaDespesa categoria) {
        super(nome, data, valor, categoria.getDescricao());
    }

    
}
