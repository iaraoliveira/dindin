/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author iara9
 */
public class Lancamento {
    private int id;
    private LocalDate data;
    private String nome;

    public Lancamento() {
    }

    public void adicionarLancamento(LocalDate data) {
        //TODO implementar adicionar novo lancamento
    }
    
    public ArrayList<Lancamento> listarLançamentos (){
        ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();
        
        // TODO implementar buscar todos os lançamentos
        
        return lancamentos;
    }
    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
