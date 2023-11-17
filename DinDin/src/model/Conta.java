package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iara9
 */
public class Conta {
    private int id;
    private String nome;
    private float saldo;

    public Conta(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    
}
