/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enums;

import java.util.HashMap;
import java.util.Map;

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
    
     // Cria uma listagem com as categorias existentes e suas descrições
    private static final Map<String, CategoriaReceita> categorias = new HashMap<String, CategoriaReceita>();
    
    static {
        for (CategoriaReceita c : CategoriaReceita.values()) {
            categorias.put(c.toString(), c);
        }
    }
    

    private CategoriaReceita(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Retorna a descrição da categoria
     * @return descrição
     */
    @Override
    public String toString() {
        return descricao;
    }
    
    /**
     * Busca o enum com descrição correspodente à String passada por parâmetro
     * @param descricao
     * @return categoria corresponde encontrada ou null
     */
    public static CategoriaReceita findByDescricao(String descricao){
        
        return categorias.get(descricao);
    }
}
