public class App {

    public static class Calculadora {
        public double Adicao(double x, double y) {
            return x + y;
        }

        public double Subtracao(double x, double y) {
            return x - y;
        }

        public double Multiplicacao(double x, double y) {
            return x * y;
        }

        public double Divisao(double x, double y) {
            if (y == 0) return 0;
            return x / y;
        }
    }
    public static void main(String[] args) throws Exception {
        Calculadora c = new Calculadora();
        
        double x = 10;
        double y = 2;

        IO.println("Teste x = 10 e y = 2");
        IO.println(c.Adicao(x, y));
        IO.println(c.Subtracao(x, y));
        IO.println(c.Multiplicacao(x, y));
        IO.println(c.Divisao(x, y));
    }
}
