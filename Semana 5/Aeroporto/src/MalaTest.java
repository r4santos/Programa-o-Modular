import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class MalaTest {
    Mala m;
    @BeforeEach
    public void setUp() {
        m = new Mala("12345678",25);
    }

    @Test
    public void pesoInvalidoTest () {
        assertFalse(m.pesarMala(-2));
    }

    @Test
    public void pesoValidoTest() {
        assertTrue(m.pesarMala(4));
    }

    @Test
    public void classificarMalaTest() {
        assertEquals("Pesado", m.classificarPeso());
    }

    @Test
    public void taxaTest() {
        double taxa = m.calcularTaxa();
        assertEquals(90.0, taxa, 0.001);
    }
}
 