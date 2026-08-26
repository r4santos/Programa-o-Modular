import java.util.List;
import java.util.ArrayList;

public class App {
    public class Funcoes {
        public static List<Integer> listaValores(int N) {
            List<Integer> valores = new ArrayList();

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(IO.readln(String.format("%dº valor: ", i+1)));
                valores.add(x);
            }

            return valores;
        }

        public static int soma(List<Integer> valores) {
            int soma = 0;
            // for (int i = 0; i < valores.size(); i++) {
            //     soma += valores.get(i);
            // }
            for (int num : valores) {
                soma += num;
            }
            return soma;
        }

        public static double calcMedia(int soma, List<Integer> valores) {
            return (double) soma / valores.size();
        }

        public static int pares(List<Integer> valores) {
            int par = 0;
            for (int i = 0; i < valores.size(); i++) {
                if (valores.get(i) % 2 == 0) par++;
            }

            return par;
        }

        public static int acimaMedia(double media, List<Integer> valores) {
            int count = 0;
            for (int i = 0; i < valores.size(); i++) {
                if (valores.get(i) > media) count++;
            } 
            return count;
        }

        public static void exibir(int soma,double media,int par,int impar,int acimaMedia) {
            IO.println(String.format("Soma dos números: %d \nMédia dos números: %f \nPares: %d \nÍmpares: %d \nMaiores que a média: %d", soma, media, par, impar, acimaMedia));
        }
    }

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(IO.readln(String.format("Quantidade de valores: ")));
        List<Integer> valores = Funcoes.listaValores(N);

        int soma = Funcoes.soma(valores);
        double media = Funcoes.calcMedia(soma, valores);
        int par = Funcoes.pares(valores);
        int impar = valores.size() - par;
        int acimaMedia = Funcoes.acimaMedia(media, valores);

        Funcoes.exibir(soma, media, par, impar, acimaMedia);
    }
}
