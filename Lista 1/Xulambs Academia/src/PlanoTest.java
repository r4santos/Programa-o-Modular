import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlanoTest {
    @Test
    public void valorFinalSemDescontoTest() {
        Plano p = new Plano("123456", "Carlos", 5);
        p.adicionarModalidadeExtra();
        p.adicionarModalidadeExtra();
        double valor = p.valorFinal();
        assertEquals(189.90, valor, 0.001, "Sem fidelidade, valor deve ser base + 2 extras");
    }

    @Test
    public void valorFinalComDescontoTest() {
        Plano p = new Plano("123456", "Carlos", 12);
        p.adicionarModalidadeExtra();
        p.adicionarModalidadeExtra();
        double valor = p.valorFinal();
        assertEquals(170.91, valor, 0.001, "Com 12+ mensalidades, deve aplicar 10% de desconto");
    }
}