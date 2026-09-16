public class Tanque {
    private double capacidade;

    private static final double CAPACIDADE_MAX;
    private static final double RESERVA;
    private static final double NORMAL;
    static {
        CAPACIDADE_MAX = 50.0;
        RESERVA = 5.0;
        NORMAL = 40.0;
    }

    public Tanque(double capacidade) {
        this.capacidade = capacidade;
    }

    public double abastecer(double quantidade) {
        if (quantidade < 0) {
            return -1;
        } else {
            double faltam = CAPACIDADE_MAX - this.capacidade;
            if (quantidade >= faltam) {
                this.capacidade += faltam;
                return faltam;
            } else {
                this.capacidade += quantidade;
                return quantidade;
            }
        }
    }

    public boolean consumo(double quantidade) {
        if (this.capacidade < quantidade) {
            return false;
        } else {
            this.capacidade -= quantidade;
            return true;
        }
    }

    public String nivel() {
        if (this.capacidade < RESERVA)
            return "RESERVA";
        else if (this.capacidade <= NORMAL)
            return "NORMAL";
        else
            return "CHEIO";
    }
}
