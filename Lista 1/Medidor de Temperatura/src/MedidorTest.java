import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MedidorTest {
    @Test
    public void rejeitaValorForaDaFaixaTest() {
        Medidor m = new Medidor(20.0);
        boolean aceito = m.registrarMedicao(100.0);
        assertFalse(aceito, "Valor acima de 80 deve ser rejeitado");
        assertEquals(20.0, m.getTemperaturaAtual(), 0.001, "Deve manter o último valor válido");
    }

    @Test
    public void classificaCriticoTest() {
        Medidor m = new Medidor(0.0);
        m.registrarMedicao(70.0);
        assertEquals("crítico", m.classificarEstado(), "Acima de 60 graus deve ser crítico");
    }

    @Test
    public void detectaInstabilidadeTest() {
        Medidor m = new Medidor(10.0);
        m.registrarMedicao(16.0);
        assertTrue(m.instabilidade(), "Variação de 6 graus entre leituras válidas indica instabilidade");
    }
}