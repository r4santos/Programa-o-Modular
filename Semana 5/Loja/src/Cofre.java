public class Cofre {
    private int PIN;
    private boolean estadoCofre;

    private final int MAXIMO_DIGITOS = 4;

    public Cofre(int PIN) {
        if (PIN > 0 && PIN < 9999) {
            this.PIN = PIN;
        } else {
            this.PIN = 0;
        }

        this.estadoCofre = false;
    }

    public String pinFormatado() {
        return String.format("%0" + MAXIMO_DIGITOS + "d", this.PIN);
    }

    public void abrirCofre(int PIN) {
        if (this.PIN == PIN) {
            this.estadoCofre = true;
            IO.println("Cofre aberto");
        } else {
            IO.println("O pin digitado está incorreto");
        }
    }

    public void fecharCofre() {
        if (this.estadoCofre) {
            this.estadoCofre = false;
            IO.println("Cofre fechado");
        } else {
            IO.println("O cofre já está fechado");
        }
    }

    public void situacaoCofre() {
        if (this.estadoCofre) {
            IO.println("O cofre está aberto");
        } else {
            IO.println("O cofre está fechado");
        }
    }
}
