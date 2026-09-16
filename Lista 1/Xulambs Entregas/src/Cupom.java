public class Cupom {
    private final int numero;
    private final int quantidadeItens;
    private final double taxa;
    private final double total;

    public Cupom(int numero, int quantidadeItens, double taxa, double total) {
        this.numero = numero;
        this.quantidadeItens = quantidadeItens;
        this.taxa = taxa;
        this.total = total;
    }
}