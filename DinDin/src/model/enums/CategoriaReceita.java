/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.categorias;

/**
 *
 * @author iara9
 */
public enum CategoriaReceita {
    SALARIO("Salário"),
    DECIMOTERCEIRO("Décimo Terceiro"),
    FERIAS("Férias"),
    OUTROS("Outros");
    
    private String descricao;

    private CategoriaReceita(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
