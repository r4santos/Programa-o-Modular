import org.junit.jupiter.api.*;

public class TesteCofre {
    @Test 
    public void testeCriacaoPin() {
        Cofre c = new Cofre(131313);
        Assertions.assertEquals("0000", c.pinFormatado(),
        "O pin formatado deveria ser 0000");
    }
}
