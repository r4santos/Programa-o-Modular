import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(IO.readln("Quantidade de números: "));
        int[] vetor = new int[n];
        int par = 0;
        int impar = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(IO.readln(String.format("Informe o %dº número: ", i + 1)));
            vetor[i] = x;
            if ( x % 2 == 0) {
                par++;
            } else {
                impar++;
            }
        }

        IO.println(Arrays.toString(vetor));
        IO.println(String.format("O vetor acima apresente %d números pares e %d números ímpares", par, impar));
    }
}
