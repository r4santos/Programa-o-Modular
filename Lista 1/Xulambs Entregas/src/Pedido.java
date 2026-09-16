import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static final double TAXA_BASE;
    private static final double DISTANCIA_BASE;
    private static final double TAXA_POR_KM_ADICIONAL;
    private static final int MAX_ITENS;
    static {
        TAXA_BASE = 4.00;
        DISTANCIA_BASE = 3.0;
        TAXA_POR_KM_ADICIONAL = 1.20;
        MAX_ITENS = 10;
    }

    private final int numero;
    private final double distanciaKm;
    private final List<Item> itens;
    private boolean finalizado;
    private boolean cancelado;

    public Pedido(int numero, double distanciaKm) {
        this.numero = numero;
        this.distanciaKm = distanciaKm <= 0 ? 1.0 : distanciaKm;
        this.itens = new ArrayList<>();
        this.finalizado = false;
        this.cancelado = false;
    }

    public boolean adicionarItem(Item item) {
        if (itens.size() < MAX_ITENS) {
            itens.add(item);
            return true;
        }
        return false;
    }

    public double taxaEntrega() {
        if (distanciaKm <= DISTANCIA_BASE) {
            return TAXA_BASE;
        }
        return TAXA_BASE + (distanciaKm - DISTANCIA_BASE) * TAXA_POR_KM_ADICIONAL;
    }

    public double valorTotal() {
        double soma = 0;
        for (Item item : itens) {
            soma += item.getPreco();
        }
        return soma + taxaEntrega();
    }

    public boolean cancelar() {
        if (!finalizado) {
            cancelado = true;
            return true;
        }
        return false;
    }

    public Cupom finalizar() {
        if (finalizado || cancelado) {
            return null;
        }
        finalizado = true;
        return new Cupom(numero, itens.size(), taxaEntrega(), valorTotal());
    }
}