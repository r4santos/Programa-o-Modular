public class Medidor {
    private static final double MIN;
    private static final double MAX;
    static {
        MIN = -40.0;
        MAX = 80.0;
    }

    private double temperaturaAtual;
    private double temperaturaAnterior;
    private int leiturasValidas;

    public Medidor(double valorInicial) {
        this.leiturasValidas = 0;
        this.temperaturaAtual = 0.0;
        registrarMedicao(valorInicial);
    }

    private boolean valorEhValido(double valor) {
        return valor >= MIN && valor <= MAX;
    }

    public boolean registrarMedicao(double valor) {
        if (!valorEhValido(valor)) {
            return false;
        }
        temperaturaAnterior = temperaturaAtual;
        temperaturaAtual = valor;
        leiturasValidas++;
        return true;
    }

    public String classificarEstado() {
        if (temperaturaAtual < 0) return "congelamento";
        if (temperaturaAtual <= 40) return "normal";
        if (temperaturaAtual <= 60) return "alerta";
        return "crítico";
    }

    public boolean instabilidade() {
        if (leiturasValidas < 2) return false;
        return Math.abs(temperaturaAtual - temperaturaAnterior) >= 5;
    }

    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }
}