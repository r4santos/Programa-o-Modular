public class GuardaChuva {
    private int codigo;
    private int diasAluguel;

    private static final double VALOR_DIARIA;
    private static final int MAX_DIAS;
    private static final double VALOR_MULTA;
    static {
        VALOR_DIARIA = 5.0;
        MAX_DIAS = 10;
        VALOR_MULTA = 8.0;
    }

    public GuardaChuva(int codigo, int diasAluguel) {
        this.codigo = codigo;
        this.diasAluguel = diasAluguel;
    }

    public boolean podeDevolver() {
        return this.diasAluguel > 0;
    }

    public double devolucao() {
        if (!podeDevolver()) {
            return -1.0;
        }

        if (this.diasAluguel <= MAX_DIAS) {
            return this.diasAluguel * VALOR_DIARIA;
        } else {
            return ((this.diasAluguel - 10) * VALOR_MULTA) + 10 * VALOR_DIARIA;
        }
    }
}