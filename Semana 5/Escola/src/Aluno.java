public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private double[] notas;
    private double frequencia;

    private static final int MIN_NOTA;
    private static final int MIN_FREQUENCIA;
    private static final int MAX_CURSO;
    private static final int QUANT_AVALIACOES;
    static {
        MIN_NOTA = 60;
        MIN_FREQUENCIA = 75;
        MAX_CURSO = 1;
        QUANT_AVALIACOES = 4;
    }

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.notas = new double[QUANT_AVALIACOES];
        this.frequencia = 0.0;
    }

    public void lancarNotas(double nota, int posicao) {
        if(posicao >= 0 && posicao < QUANT_AVALIACOES){
            this.notas[posicao] = nota;
        } else {
            IO.println("Posição inválida");
        }
    }

    public void registrarFrequencia(double frequencia) {
        if(frequencia >= 0 && frequencia <= 100) {
            this.frequencia = frequencia;
        } else {
            IO.println("Frequência inválida");
        }
    }

    public double notaFinal() {
        double notaFinal = 0;
        for (double nota : this.notas) {
            notaFinal += nota;
        }
        return notaFinal;
    }

    public boolean situacao() {
        boolean aprovado = true;
        if(notaFinal() < MIN_NOTA || this.frequencia < MIN_FREQUENCIA) {
            aprovado = false;
        }

        return aprovado;
    }

    public String estahAprovado() {
        return String.format("Aluno com nota %d e frequencia %d", notaFinal(), this.frequencia);
    }
}