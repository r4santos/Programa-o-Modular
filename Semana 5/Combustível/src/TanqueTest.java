import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TanqueTest {
    Tanque t;

    @BeforeEach 
    public void setUp(){
        t = new Tanque(30);
    }

    @Test
    public void abastecerTest() {
        double abastecido = t.abastecer(30);
        assertEquals(20.0, abastecido, 0.001);
    }

    @Test
    public void cosumoTest() {
        assertFalse(t.consumo(40));
    }     
}
