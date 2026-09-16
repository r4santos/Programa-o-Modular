public class Emprestimo {
    private final static double MULTA_DEVOLUCAO;
    private final static int PRAZO;
    static {
        MULTA_DEVOLUCAO = 1.25;
        PRAZO = 7;
    } 

    private final Aluno aluno;
    private final Livro livro;
    private boolean estahAtivo;

    public Emprestimo(Aluno aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
        this.estahAtivo = true;
    }

    private boolean diasDeUsoEhValido(int diasDeUso) {
        return (diasDeUso > 0);
    }

    private double calcularMulta(int diasDeUso) {
        if (diasDeUso > PRAZO) 
            return (diasDeUso - PRAZO) * MULTA_DEVOLUCAO;
        
        return 0;
    } 

    public double devolucao(int diasDeUso) {
        if (!diasDeUsoEhValido(diasDeUso))
            return 0;
        
        estahAtivo = false;
        return calcularMulta(diasDeUso);
        
    }
}
