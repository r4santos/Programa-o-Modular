public class Tanque {
    private static final double RESERVA;
    private static final double NORMAL;
    static {
        RESERVA = 5.0;
        NORMAL = 40.0;
    }

    private double nivel;

    public Tanque(double nivel) {
        this.nivel = 0;
        if (nivel > 0 && nivel <= 50)
            this.nivel = nivel;
        else if (nivel > 50) 
            this.nivel = 50.0;
    }

    public boolean consumo(double consumo) {
        if (this.nivel >= consumo) {
            this.nivel -= consumo;
            return  true;
        } else 
            return false;
    }

    public String classificar() {
        if (this.nivel < RESERVA) {
            return "Reserva";
        } else if (this.nivel <= NORMAL) {
            return "Normal";
        } else {
            return "Cheio";
        }
    }

    public double abastecer(double quantidade) {
        double faltam = 50.0 - this.nivel;
        if (faltam < quantidade) {
            this.nivel += faltam;
            return faltam;
        } else {
            this.nivel += quantidade;
            return quantidade;
        }
    }
}