import org.junit.jupiter.api.*;

public class TanqueTest {
    Tanque tanque;
    @BeforeEach
    public void setUp() {
        tanque = new Tanque(45);
    }

    @Test
    public void abastecerTest() {
        Assertions.assertEquals(5.0, tanque.abastecer(5.0));
    }

    @Test
    public void consumirTest() {
        Assertions.assertEquals(false, tanque.consumo(50.0));
    }
}