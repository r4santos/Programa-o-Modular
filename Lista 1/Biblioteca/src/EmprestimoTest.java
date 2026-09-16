import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoTest {
    @Test 
    public void devolucaoTest() {
        Aluno a = new Aluno("Ana Luiza", "123456");
        Livro l = new Livro("098765", "Ainda Estou Aqui");
        Emprestimo e = new Emprestimo(a,l);
        assertEquals(3.75, e.devolucao(10), 0.001, "10 dias de uso (3 dias de atraso) deve gerar multa de R$3,75");
    }
}