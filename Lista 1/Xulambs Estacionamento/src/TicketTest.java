import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    Ticket t;
    
    @BeforeEach
    public void setUp() {
        t = new Ticket("TDA2E03", 30);
    }

    @Test
    public void fechar30Test() {
        assertEquals(2.0, t.fechar(), 0.001, "30 minutos deve cobrar apenas a tarifa base");
    }

    @Test
    public void fechar31Test() {
        t.atualizarTempo(31);
        assertEquals(3.5, t.fechar(), 0.001, "31 minutos deve cobrar tarifa base + 1 bloco adicional");
    }
}