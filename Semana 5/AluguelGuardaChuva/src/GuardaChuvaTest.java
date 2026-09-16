import org.junit.jupiter.api.*;

public class GuardaChuvaTest { 
    @Test
    public void devolucaoNoPrazo() {
        GuardaChuva g1 = new GuardaChuva(532621, 7);
        Assertions.assertEquals(35, g1.devolucao());
    }

    @Test
    public void devolucaoAtrasada() {
        GuardaChuva g1 = new GuardaChuva(532621, 17);
        Assertions.assertEquals(106, g1.devolucao());
    }
}