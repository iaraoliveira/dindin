
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import model.enums.CategoriaDespesa;
import model.enums.CategoriaReceita;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImportadorTest {
    
    Conta c1 = new Conta();
    Conta c2 = new Conta();
    
    public ImportadorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     ** Testa o método de importar um arquivo com Despesas.
     */
    @Test
    public void testCarregarArquivoDespesas() throws Exception {
        String caminhoDespesa = "DespesaTeste2.csv";
        File file = new File(caminhoDespesa);
        LocalDate dt = LocalDate.of(2023, 11, 15);

        Despesa d1 = new Despesa("Conta de Luz", dt, 200.0, CategoriaDespesa.RESIDENCIA);
        c1.incluirDespesa(d1);

        Exportador exportador = new Exportador(c1);
        exportador.exportaDespesas(file);

        Importador importador = new Importador(c2);
        try {
            importador.carregarArquivoDespesas(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        assertTrue(c2.getDespesas().equals(c1.getDespesas()));

    }

    /**
     * Test of carregarArquivoReceitas method, of class Importador.
     */
    @Test
    public void testCarregarArquivoReceitas() throws Exception {
        String caminhoReceita = "ReceitaTeste2.csv";
        File file = new File(caminhoReceita);
        LocalDate dt = LocalDate.of(2023, 11, 22);

        Receita r1 = new Receita("Salário", dt, 2500.0, CategoriaReceita.SALARIO);
        c1.incluirReceita(r1);

        Exportador exportador = new Exportador(c1);
        exportador.exportaReceitas(file);

        Importador importador = new Importador(c2);
        try {
            importador.carregarArquivoReceitas(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        assertTrue(c2.getDespesas().equals(c1.getDespesas()));
    } 
}
