public class App {
    public static class Retangulo {
        private int largura;
        private int altura;

        public Retangulo(int largura, int altura) {
            this.largura = largura;
            this.altura = altura;
        }

        public String linhaCompleta() {
            return "X".repeat(largura);
        }

        public String linhaIncompleta() {
            return "X" + " ".repeat(largura - 2) + "X";
        }

        public void Desenhar() {
            for (int i = 0; i < altura; i++) {
                if (i == 0 || i == altura - 1) {
                    IO.println(linhaCompleta());
                } else {
                    IO.println(linhaIncompleta());
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int largura = Integer.parseInt(IO.readln(String.format("Informe a largura: ")));
        int altura = Integer.parseInt(IO.readln(String.format("Informe a altura: ")));

        Retangulo retangulo = new Retangulo(largura, altura);
        retangulo.Desenhar();
    }
}
