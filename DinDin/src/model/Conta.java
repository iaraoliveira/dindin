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
    private String nome;
    private float saldo;

    //listas de despesas e receitas
    private ArrayList<Despesa> despesas;
    private ArrayList<Receita> receitas;
    
    
    public Conta(String nome) {
        this.nome = nome;
        
        despesas = new ArrayList<>();
        receitas = new ArrayList<>();
    }

    /**
     * Este método é utilizado para consultar o saldo disponível em conta no dia atual (now)
     * @return saldo - valor com duas casa decimais após a vírgula referente ao saldo atual da conta
     */
    public double consultarSaldo(){
        double saldo = 0;
        //TO-DO : implementar consultaSaldo
        
        return saldo;
    }
    
    /**
     * Este método é utilizado para consultar o saldo disponível em conta 
     * considerando os lancamentos com data igual ou menos que o dia informado pro parâmetro
     * @param data - data para filtragem dos lancamentos
     * @return saldo - valor com duas casa decimais após a vírgula referente ao saldo da conta até o dia especificado
     */
    public double consultarSaldo(LocalDate data){
        double saldo = 0;
        //TO-DO : implementar consultaSaldo
        
        return saldo;
    }
    
    public void getDespesas(){
        
    }
    
    public void getReceitas(){
        
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
    
    
    public String getNome() {
        return nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
      
    
}
