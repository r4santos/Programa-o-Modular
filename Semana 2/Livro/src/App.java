public class App {
    public static class Livro {
        String titulo;
        String autor;
        int paginas;
        int totalAvaliacoes;
        int somaAvaliacoes;

        public Livro(String titulo, String autor, int paginas) {
            this.titulo = titulo;
            this.autor = autor;
            this.paginas = paginas;
            this.totalAvaliacoes = 0;
            this.somaAvaliacoes = 0;
        }

        public void avaliar(int estrelas) {
            totalAvaliacoes += 1;
            somaAvaliacoes += estrelas;
        }

        public double avaliacaoMedia() {
            if (totalAvaliacoes == 0) return 0.0;
            return somaAvaliacoes / totalAvaliacoes;
        }

        public String estimativa(int tempo) {
            int minutos = (tempo * paginas) % 60;
            int horas = ((tempo * paginas) - minutos) / 60;
            String texto = horas + " horas e " + minutos + " minutos.";
            return texto;
        }
    }

    public static void main(String[] args) throws Exception {
        Livro livro = new Livro("Pássaros", "Robertin", 349);
        livro.avaliar(5);
        livro.avaliar(4);
        livro.avaliar(1);
        livro.avaliar(2);
        livro.avaliar(5);
        IO.println("A avaliação média deste livro é " + livro.avaliacaoMedia());
        IO.println("O tempo estimado para concluir este livro é de "+ livro.estimativa(13));
        
    }
}