public class Recepcionista {
    private Turma turmaAssociada;

    public void associarTurma(Turma turma) {
        this.turmaAssociada = turma;
    }

    public boolean matricularAluno(AlunoMatriculado aluno) {
        if (turmaAssociada == null) {
            return false;
        }
        return turmaAssociada.matricular(aluno);
    }
}