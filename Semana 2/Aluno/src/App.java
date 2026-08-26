import java.util.ArrayList;
import java.util.List;

public class App {
    public static class Aluno {
        private String nome;
        private int matricula;
        private List<Double> notasAvaliacoes;
        private Double notaReavaliacao;

        public Aluno(String nome, int matricula) {
            this.nome = nome;
            this.matricula = matricula;
            this.notasAvaliacoes = new ArrayList<>();
            this.notaReavaliacao = null;
        }

        public void adicionarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser entre 0 e 10.");
        }
        this.notasAvaliacoes.add(nota);
        }

        public void registrarReavaliacao(double nota) {
        if (nota > 0 && nota < 10) 
            this.notaReavaliacao = nota;
        }

        public double calcularNotaFinal() {
            if (notasAvaliacoes.isEmpty()) {
                return 0.0;
            }

            double soma = 0;
            for (Double nota : notasAvaliacoes) {
                soma += nota;
            }
            double mediaSemestre = soma / notasAvaliacoes.size();

            if (notaReavaliacao != null) {
                return (mediaSemestre + notaReavaliacao) / 2.0;
            }

            return mediaSemestre;
        }

        public String obterSituacao() {
            double notaFinal = calcularNotaFinal();

            if (notaFinal >= 6.0) {
                return "aprovado";
            } 

            if (notaReavaliacao != null) {
                return "reprovado";
            }

            if (notaFinal >= 4.0) {
                return "em reavaliação";
            }

            return "reprovado";
        }
    }
    public static void main(String[] args) throws Exception {
        Aluno a = new Aluno("Caio", 54637);
        a.adicionarNota(4);
        a.adicionarNota(6);
        IO.println("Situação inicial: " + a.obterSituacao());
        a.registrarReavaliacao(7);
        IO.println("Situação após reavaliação: " + a.obterSituacao());
    }
}
