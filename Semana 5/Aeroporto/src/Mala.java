public class Mala {
    private String etiqueta;
    private double peso;

    private static final double TAXA_EXCESSO = 45.00;
    private static final double MALA_LEVE = 10.00;
    private static final double MALA_PADRAO = 23.00;

    public Mala(String etiqueta, double peso) {
        this.etiqueta = etiqueta;
        this.peso = 0;
        if (peso > 0)
            this.peso = peso;
    }

    public boolean pesarMala(double peso) {
        if (peso > 0) {
            this.peso = peso;
            return true;
        } else {
            return false;
        }
    }

    public String classificarPeso() {
        if (this.peso <= MALA_LEVE) {
            return "Leve";
        } else if (this.peso <= MALA_PADRAO) {
            return "Padrão";
        } else {
            return "Pesado";
        }
    }

    public double calcularTaxa() {
        if (classificarPeso().equals("Pesado")) {
            double taxa = (this.peso - 23) * TAXA_EXCESSO;
            return taxa;
        } else {
            return 0.0;
        }
    }

    public double getPeso() {
        return this.peso;
    }
}
