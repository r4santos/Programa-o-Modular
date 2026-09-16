import java.util.ArrayList;
import java.util.List;

public class Turma {
    private static final int CAPACIDADE_MAXIMA;
    static {
        CAPACIDADE_MAXIMA = 20;
    }

    private final String codigo;
    private final String modalidade;
    private final List<AlunoMatriculado> alunos;
    private final Agenda agenda;

    public Turma(String codigo, String modalidade, String diaSemana, String horarioInicio) {
        this.codigo = codigo;
        this.modalidade = modalidade;
        this.alunos = new ArrayList<>();
        this.agenda = new Agenda(diaSemana, horarioInicio);
    }

    public boolean matricular(AlunoMatriculado aluno) {
        if (alunos.size() < CAPACIDADE_MAXIMA) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    public int totalMatriculados() {
        return alunos.size();
    }

    public int vagasRestantes() {
        return CAPACIDADE_MAXIMA - alunos.size();
    }
}