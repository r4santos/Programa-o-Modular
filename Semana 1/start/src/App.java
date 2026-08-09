public class App {

    public static class Validacao {
        public boolean ehTriangulo(double a, double b, double c) {
            return (a + b > c) && (a + c > b) && (b + c > a);
        }

        public String definirTipo(double a, double b, double c) {
            if (ehTriangulo(a, b, c)) {
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
        Double a = Double.parseDouble(IO.readln());
        Double b = Double.parseDouble(IO.readln());
        Double c = Double.parseDouble(IO.readln());

        Validacao validacao = new Validacao();
        IO.println(validacao.definirTipo(a, b, c));
    }
}
