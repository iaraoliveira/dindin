/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author iara9
 */
public class Lancamento {
    private String nome;
    private LocalDate data;
    private double valor;
    private String categoria;
    
    public Lancamento(String nome, LocalDate data, double valor, String categoria) {
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.categoria = categoria;
    }
    
    public LocalDate getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
