public class App {

    public static class Repeticao {
        public static char caractere() {
            String entrada = IO.readln("Caractere: ");
            char x = entrada.charAt(0);
            return x;
        }

        public static int repetiu(char x, String p) {
            int count = 0;
            for (int letra=0; letra < p.length(); letra++) {
                if (p.charAt(letra) == x) {
                    count++;
                }
            }
            return count;
        }

        public static void saida(char x, String p) {
            IO.println(String.format("O caractere %c aparece em %s, %d vezes", x, p, repetiu(x, p)));
        }
    }

    public static void main(String[] args) throws Exception {
        String palavra = IO.readln("Frase: ");
        char x = Repeticao.caractere();
        Repeticao.saida(x, palavra);
    }
}
