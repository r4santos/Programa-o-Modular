import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    @Test
    public void taxaAte3kmTest() {
        Pedido p = new Pedido(1, 2.0);
        p.adicionarItem(new Item("Pizza", 30.0));
        assertEquals(4.00, p.taxaEntrega(), 0.001, "Até 3km, taxa deve ser o valor base");
    }

    @Test
    public void taxaAcimaDe3kmTest() {
        Pedido p = new Pedido(2, 5.0);
        p.adicionarItem(new Item("Pizza", 30.0));
        assertEquals(6.40, p.taxaEntrega(), 0.001, "Acima de 3km, deve somar adicional por km excedente");
    }
}