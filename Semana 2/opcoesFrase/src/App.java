public class App {
    public static class Frase {
        String texto;

        public Frase(String texto) {
            this.texto = texto;
        }

        public String lerFrase() {
            return IO.readln(String.format("Insira a frase: "));
        }

        public int tamanho() {
            return texto.length();
        }

        public int procurar(char c) {
            return texto.indexOf(c);
        }

        public String substituir(char antiga, char nova) {
            return texto.replace(antiga, nova);
        }

        public String recortar(int inicio, int fim) {
            return texto.substring(inicio, fim);
        }

        public int contarCaractere(char c) {
            int count = 0;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == c) count++;
            }

            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        String texto = IO.readln("Informe a frase: ");
        Frase frase = new Frase(texto);
        
        IO.println(frase.tamanho());
        IO.println(frase.procurar('h'));
        IO.println(frase.substituir('o', '0'));
        IO.println(frase.recortar(12,25));
        IO.println(frase.contarCaractere('r'));
    }
}
