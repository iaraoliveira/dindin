
package model;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.enums.CategoriaDespesa;
import model.enums.CategoriaReceita;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContaTest {
    
    Conta c = new Conta();
    
    public ContaTest() {
    }
    

    /**
     * Testa o incluir Receita
     */
    @Test
    public void incluirReceita() throws ParseException {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Receita r = new Receita("Salário", data, 3500.0, CategoriaReceita.SALARIO);
        c.incluirReceita(r);

        assertTrue(c.getReceitas().contains(r));

    }

    /**
     * Testa o incluir Despesa
     */
    @Test
    public void incluirDespesa() throws ParseException {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Despesa d = new Despesa("Mercado", data, 2000.0, CategoriaDespesa.ALIMENTACAO);
        c.incluirDespesa(d);

        assertTrue(c.getDespesas().contains(d));
    }

    /**
     * Lista todos os Lançamentos, Despesas e Receitas
     */
    @Test
    public void getLancamentos() throws ParseException {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Receita r = new Receita("Décimo Terceiro (Salário)", data, 6500.0, CategoriaReceita.DECIMOTERCEIRO);
        c.incluirReceita(r);

        LocalDate data2 = LocalDate.of(2023, 11, 17);

        Despesa d = new Despesa("Cinema", data2, 60.0, CategoriaDespesa.ENTRETENIMENTO);
        c.incluirDespesa(d);

        LocalDate data3 = LocalDate.of(2023, 11, 18);

        Despesa d1 = new Despesa("Passeio", data3, 120.0, CategoriaDespesa.OUTROS);
        c.incluirDespesa(d1);

        List<Lancamento> lancamento = new ArrayList<>(0);
        lancamento.add(r);
        lancamento.add(d);
        lancamento.add(d1);

        assertTrue(c.getLancamentos().equals(lancamento));

    }
    /** Testa se o Método retorna o saldo corretamente*/
    @Test
    public void buscarSaldodaConta() throws ParseException {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Receita r = new Receita("Décimo Terceiro (Salário)", data, 6500.0, CategoriaReceita.DECIMOTERCEIRO);
        c.incluirReceita(r);

        LocalDate data2 = LocalDate.of(2023, 11, 17);

        Despesa d = new Despesa("Cinema", data2, 60.0, CategoriaDespesa.ENTRETENIMENTO);
        c.incluirDespesa(d);

        LocalDate data3 = LocalDate.of(2023, 11, 18);

        Despesa d1 = new Despesa("Passeio", data3, 120.0, CategoriaDespesa.OUTROS);
        c.incluirDespesa(d1);

        assertEquals(6320.0, c.getSaldo(),6320);

    }

    /**
     * Testa o Método de Ordenação no momento de retornar o lançamento
     */
    @Test
    public void ordenacaoLancamentosPorData() {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Receita r = new Receita("Décimo Terceiro (Salário)", data, 6500.0, CategoriaReceita.DECIMOTERCEIRO);
        c.incluirReceita(r);

        LocalDate data2 = LocalDate.of(2023, 11, 17);

        Despesa d = new Despesa("Cinema", data2, 60.0, CategoriaDespesa.ENTRETENIMENTO);
        c.incluirDespesa(d);

        LocalDate data3 = LocalDate.of(2023, 11, 18);

        Despesa d1 = new Despesa("Passeio", data3, 120.0, CategoriaDespesa.OUTROS);
        c.incluirDespesa(d1);

        List<Lancamento> lancamento = new ArrayList<>(0);

        lancamento.add(d);
        lancamento.add(d1);
        lancamento.add(r);
        assertTrue(!c.getLancamentos().equals(lancamento));
    }

    /**
     * Lista todas as Receitas
     */
    @Test
    public void listarReceitas() {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Receita r = new Receita("Salário", data, 3500.0, CategoriaReceita.SALARIO);
        c.incluirReceita(r);

        LocalDate data1 = LocalDate.of(2023, 11, 17);

        Receita r1 = new Receita("Salário", data1, 3500.0, CategoriaReceita.SALARIO);
        c.incluirReceita(r1);

        List<Receita> receitas = new ArrayList<>(0);

        receitas.add(r);
        receitas.add(r1);

        assertTrue(c.getReceitas().equals(receitas));
    }

    /**
     * Lista todas as Despesas
     */
    @Test
    public void listarDespesas() {
        LocalDate data = LocalDate.of(2023, 11, 15);

        Despesa d = new Despesa("Mercado", data, 2000.0, CategoriaDespesa.ALIMENTACAO);
        c.incluirDespesa(d);

        LocalDate data2 = LocalDate.of(2023, 11, 18);

        Despesa d1 = new Despesa("Faculdade", data2, 2000.0, CategoriaDespesa.EDUCACAO);
        c.incluirDespesa(d1);

        List<Despesa> despesas = new ArrayList<>(0);

        despesas.add(d);
        despesas.add(d1);

        assertTrue(c.getDespesas().equals(despesas));
    }
    
}
