public class Plano {
    private static final double VALOR_BASE;
    private static final double VALOR_EXTRA;
    private static final int MAX_EXTRAS;
    private static final int MENSALIDADES_FIDELIDADE;
    private static final double DESCONTO_FIDELIDADE;
    static {
        VALOR_BASE = 119.90;
        VALOR_EXTRA = 35.00;
        MAX_EXTRAS = 2;
        MENSALIDADES_FIDELIDADE = 12;
        DESCONTO_FIDELIDADE = 0.10;
    }

    private final String codigo;
    private final String nomeAluno;
    private int extras;
    private int mensalidadesPagasConsecutivas;

    public Plano(String codigo, String nomeAluno, int mensalidadesPagasConsecutivas) {
        this.codigo = codigo.length() == 6 ? codigo : "000000";
        this.nomeAluno = nomeAluno;
        this.extras = 0;
        this.mensalidadesPagasConsecutivas = mensalidadesPagasConsecutivas;
    }

    public boolean adicionarModalidadeExtra() {
        if (extras < MAX_EXTRAS) {
            extras++;
            return true;
        }
        return false;
    }

    private boolean temDesconto() {
        return mensalidadesPagasConsecutivas >= MENSALIDADES_FIDELIDADE;
    }

    public double valorFinal() {
        double total = VALOR_BASE + extras * VALOR_EXTRA;
        if (temDesconto()) {
            total -= total * DESCONTO_FIDELIDADE;
        }
        return total;
    }

    public String gerarDemonstrativo() {
        return String.format("Plano %s - %s | Extras: %d | Desconto: %s | Valor final: R$%.2f",
                codigo, nomeAluno, extras, temDesconto() ? "sim" : "não", valorFinal());
    }
}