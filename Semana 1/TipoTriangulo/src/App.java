import java.util.ArrayList;
import java.util.List;

public class App {

    public static class Validacao {
        public static List<Integer> entrada(){
            List<Integer> lados = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int x = Integer.parseInt(IO.readln(String.format(("Valor do %dº lado: "), i + 1)));
                lados.add(x);
            }

            return lados;
        }

        public static boolean ehTriangulo(List<Integer> lados) {
            int a = lados.get(0);
            int b = lados.get(1);
            int c = lados.get(2);
            
            return (a + b > c) && (a + c > b) && (b + c > a);
        }

        public static String definirTipo(List<Integer> lados) {
            int a = lados.get(0);
            int b = lados.get(1);
            int c = lados.get(2);

            if (ehTriangulo(lados)) {
                if (a == b && b == c) {
                    return ("Triângulo Equilátero");
                } else if (a != b && a != c && b != c) {
                    return ("Triângulo Escaleno");
                } else {
                    return ("Triângulo Isósceles");
                }
            } else {
                return ("Triângulo impossível");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> lados = Validacao.entrada();        
        IO.println(Validacao.definirTipo(lados));
    }
}