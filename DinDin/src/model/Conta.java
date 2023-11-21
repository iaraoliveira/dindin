package model;

import java.time.LocalDate;
import java.util.ArrayList;
import model.enums.CategoriaDespesa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iara9
 */
public class Conta {
    private float saldo;

    //listas de despesas e receitas
    private ArrayList<Despesa> despesas;
    private ArrayList<Receita> receitas;
    
    
    public Conta() {
        despesas = new ArrayList<>();
        receitas = new ArrayList<>();
    }
    
    public ArrayList<Despesa> getDespesas(){
        return despesas;
    }
    
    public ArrayList<Receita> getReceitas(){
        return receitas;
    }
    
    public void getLancamentos(){
        
    }
    
    /**
     * inclui nova despesa
     * @param despesa 
     */
    public void incluirDespesa(Despesa d){
        despesas.add(d);
    }
    
    /**
     * inclui nova receita
     * @param receita
     */
    public void incluirReceita(Receita r){
        receitas.add(r);
    }

    
    /**
     * Este método é utilizado para consultar o saldo disponível em conta no dia atual (now)
     * @return saldo - valor com duas casa decimais após a vírgula referente ao saldo atual da conta
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Este método é utilizado para consultar o saldo disponível em conta 
     * considerando os lancamentos com data igual ou menos que o dia informado pro parâmetro
     * @param data - data para filtragem dos lancamentos
     * @return saldo - valor com duas casa decimais após a vírgula referente ao saldo da conta até o dia especificado
     */
    public double getSaldo(LocalDate data){
        return saldo;

    }
    
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
      
    
}
