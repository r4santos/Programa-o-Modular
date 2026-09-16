public class Ticket {
    private static final double TARIFA;
    private static final double ADICIONAL;
    private static final int TEMPO_MAXIMO;
    static{
        TARIFA = 2.0;
        ADICIONAL = 1.5;
        TEMPO_MAXIMO = 240;
    }

    private final String placa;
    private int minutos;
    private boolean situacao;

    public Ticket(String placa, int minutos) {
        this.placa = placa;
        this.minutos = minutos < 0 ? 0 : minutos;
        this.situacao = true; 
    }

    public boolean atualizarTempo(int novoTempo) {
        if (novoTempo >= this.minutos) {
            this.minutos = novoTempo;
            return true;
        } else
            return false;
    }

    private boolean tempoEhValido() {
        return (this.minutos <= TEMPO_MAXIMO);
    }

    public double fechar() {
        if (!tempoEhValido() || !situacao) 
            return 0; 
        else {
            double total = TARIFA;
            situacao = false;
            if (this.minutos <= 30)
                return total;

            for (int restante = this.minutos - 30; restante > 0; restante -= 15) {
                total += ADICIONAL; 
            }
            return total;
        }
    }
}