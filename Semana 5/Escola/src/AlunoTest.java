import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    Aluno aluno;
    @BeforeEach
    public void SetUp() {
        aluno = new Aluno("Ana", "13240226", "Psicologia");
    }
    
    @Test
    @DisplayName("Calcular corretamante a nota final")
    public void lancarNotaTest() {
        aluno.lancarNotas(15.0,0);
        aluno.lancarNotas(10.0,1);
        aluno.lancarNotas(20.0,2);
        aluno.lancarNotas(15.0,3);

        double total = aluno.notaFinal();
        assertEquals(60, total, "A soma deve ser 60.0");
    }

    @Test
    public void registrarFrequenciaTest() {
        aluno.lancarNotas(15.0,0);
        aluno.lancarNotas(10.0,1);
        aluno.lancarNotas(20.0,2);
        aluno.lancarNotas(15.0,3);
        aluno.registrarFrequencia(80);
        
        assertTrue(aluno.situacao());
    }
}
