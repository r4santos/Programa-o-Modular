import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TurmaTest {
    @Test
    public void matriculaEsgotaCapacidadeTest() {
        Turma t = new Turma("T1", "Yoga", "Segunda", "08:00");
        Recepcionista r = new Recepcionista();
        r.associarTurma(t);
        boolean vigesimoAceito = false;
        for (int i = 0; i < 20; i++) {
            vigesimoAceito = r.matricularAluno(new AlunoMatriculado("Aluno" + i, "M" + i));
        }
        boolean vigesimoPrimeiroAceito = r.matricularAluno(new AlunoMatriculado("Aluno20", "M20"));
        assertTrue(vigesimoAceito, "20º aluno deve ser aceito");
        assertFalse(vigesimoPrimeiroAceito, "21ª tentativa deve ser rejeitada por capacidade esgotada");
    }
}