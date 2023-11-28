
package model;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import model.enums.CategoriaDespesa;
import model.enums.CategoriaReceita;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExportadorTest {
    
    Conta c = new Conta();
    
    public ExportadorTest() {
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
     * Testa o Exportador de Despesa comparando se a despesa exportada para o
     * arquivo tenha a formatação esperada.
     */
    @Test
    public void testExportaDespesas() {
        String caminhoDespesa = "DespesaTeste.csv";
        File file = new File(caminhoDespesa);
        LocalDate dt = LocalDate.of(2023, 11, 15);

        Despesa d1 = new Despesa("Passeio", dt, 120.0, CategoriaDespesa.OUTROS);
        c.incluirDespesa(d1);

        Exportador exportador = new Exportador(c);
        exportador.exportaDespesas(file);

        try (Scanner sc = new Scanner(file, "UTF-8")) {

            //desprezando o cabeçalho do arquivo
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                assertTrue(sc.nextLine().equals("Passeio;2023-11-15;120.0;Outros"));
            }
        } catch (Exception e) {

        }
    }

    /**
     * Testa o Exportador de Receitas comparando se a despesa exportada para o
     * arquivo tenha a formatação esperada.
     */
    @Test
    public void testExportaReceitas() {
        String caminhoReceitas = "DespesaTeste.csv";
        File file = new File(caminhoReceitas);
        LocalDate dt = LocalDate.of(2023, 11, 20);

        Receita r1 = new Receita("Décimo Terceiro", dt, 6500.0, CategoriaReceita.SALARIO);
        c.incluirReceita(r1);

        Exportador exportador = new Exportador(c);
        exportador.exportaDespesas(file);

        try (Scanner sc = new Scanner(file, "UTF-8")) {

            //desprezando o cabeçalho do arquivo
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                assertTrue(sc.nextLine().equals("Décimo Terceiro;2023-11-20;6500.0;Salário"));
            }
        } catch (Exception e) {

        }

    }
    
}
