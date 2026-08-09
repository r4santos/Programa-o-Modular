import java.util.ArrayList;
import java.util.List;

public class App {
    public static class Funcoes {

        public static int[] entrada() {
            int[] valores = new int[3];
            for (int i = 0; i < 3; i++) {
                int x = Integer.parseInt(IO.readln(String.format("%dº Valor: ", i + 1)));
                valores[i] = x;
            }

            return valores;
        }

        public static int maior(int[] vetor) {
            int maior = vetor[0];
            for (int i = 1; i < vetor.length; i++) {
                if (maior < vetor[i]) {
                    maior = vetor[i];
                }
            }
            return maior;
        }

        public static int menor(int[] vetor) {
            int menor = vetor[0];
            for (int i = 1; i < vetor.length; i++) {
                if (menor > vetor[i]) {
                    menor = vetor[i];
                }
            }
            return menor;
        }

        public static List<Integer> listaImpares(int[] vetor) {
            int maior = maior(vetor);
            int menor = menor(vetor);
            List<Integer> listaImpares = new ArrayList<>();

            if (menor % 2 == 0) {
                    menor++;
                } 

            for (int i = menor; i <= maior; i += 2) {
                listaImpares.add(i);
            }

            return listaImpares;
        }

        public static int multiImpares(List<Integer> numeros) {
            int produto = numeros.get(0);
            for (int i = 1; i < numeros.size(); i++) {
                produto *= numeros.get(i);
            }

            return produto;
        }

        public static List<Integer> divisiveisPeloMenor(List<Integer> numeros, int menor) {
            List<Integer> divisiveis = new ArrayList<>();

            for (int i = 0; i < numeros.size(); i++) {
                if (numeros.get(i) % menor == 0) {
                    divisiveis.add(numeros.get(i));
                } 
            }

            return divisiveis;
        }

    }

    public static void main(String[] args) throws Exception {

        int[] entrada =  Funcoes.entrada();
        List<Integer> listaImpares = Funcoes.listaImpares(entrada);
        int produto = Funcoes.multiImpares(listaImpares);

        IO.println(String.format("O produto dos números ímpares entre o menor e o maior número dos três lidos, incluindo ambos é: %d", produto));

        int menor = Funcoes.menor(entrada);
        List<Integer> divisiveis = Funcoes.divisiveisPeloMenor(listaImpares, menor);
        IO.println(String.format("Os números divisíveis pelo menor número na faixa entre os dois maiores incluindo ambos é: %s", divisiveis));
    }
}
