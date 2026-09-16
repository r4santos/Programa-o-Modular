public class Item {
    private final String descricao;
    private final double preco;

    public Item(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}