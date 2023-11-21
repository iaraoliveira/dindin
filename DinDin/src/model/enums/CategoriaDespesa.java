/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.categorias;

/**
 *
 * @author iara9
 */
public enum CategoriaDespesa {
    ALIMENTACAO("Alimentação"),
    TRANSPORTE("Transporte"),
    RESIDENCIA("Residência"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    ENTRETENIMENTO("Entretenimento"),
    OUTROS("Outros");
    
    private String descricao;

    private CategoriaDespesa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
