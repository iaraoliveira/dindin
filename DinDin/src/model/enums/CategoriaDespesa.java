/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enums;

import java.util.HashMap;
import java.util.Map;


public enum CategoriaDespesa {
    ALIMENTACAO("Alimentação"),
    TRANSPORTE("Transporte"),
    RESIDENCIA("Residência"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    ENTRETENIMENTO("Entretenimento"),
    OUTROS("Outros");
    
    private String descricao;

    // Cria uma listagem com as categorias existentes e suas descrições
    private static final Map<String, CategoriaDespesa> categorias = new HashMap<String, CategoriaDespesa>();
    
    static {
        for (CategoriaDespesa c : CategoriaDespesa.values()) {
            categorias.put(c.toString(), c);
        }
    }
    
    private CategoriaDespesa(String descricao) {
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
    public static CategoriaDespesa findByDescricao(String descricao){
        
        return categorias.get(descricao);
    }
    
}
