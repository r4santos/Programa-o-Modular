import java.util.ArrayList;
import java.util.List;

public class App {
    public static class Funcoes {
        public static List<Integer> entrada() {
            int i = 0;
            List<Integer> lista = new ArrayList<>();

            int num = 0;
            do {
                num = Integer.parseInt(IO.readln(String.format("%dº Valor: ", i + 1)));
                lista.add(num);
                i++;
            } while (num != 0);

            return lista;
        }

        public static boolean listaValida(List<Integer> X) {
            return (X.size() > 0);
        }

        public static double calcMedia(List<Integer> X) {
            int soma = X.stream().mapToInt(Integer::intValue).sum();
            double media = soma / X.size();
            return media;
        }

        public static void acimaMedia(List<Integer> X) {
            if (listaValida(X)) {
                double media = calcMedia(X);
                List<Integer> numAcima = new ArrayList<>();

                for (int i = 0; i < X.size(); i++) {
                    if (X.get(i) > media) {
                        numAcima.add(X.get(i));
                    }
                }

                IO.println(String.format("Os números acima da média %f são: ", media));
                for (int i = 0; i < numAcima.size(); i++) {
                    IO.println(numAcima.get(i));
                }
            } else {
                IO.println("A lista não é válida");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> lista = Funcoes.entrada();
        Funcoes.acimaMedia(lista);
    }
}
