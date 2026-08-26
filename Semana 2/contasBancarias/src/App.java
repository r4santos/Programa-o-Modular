public class App {
    static class ContaBancaria {
        private String numero;
        private String cpf;
        private double saldo;
        private double limite;

        public ContaBancaria(String numero, String cpf, double limite) {
            this.numero = numero;
            this.cpf = cpf;
            this.saldo = 0.0;
            this.limite = limite;
        }

        public void depositar(double valor) {
            double valorLiquido = valor;

            if (this.saldo < 0) {
                double taxa = Math.abs(this.saldo) * 0.03;
                valorLiquido -= taxa;
            }

            this.saldo += valorLiquido;
        }

        public void sacar(double valor) {
            if (valor <= (this.saldo + this.limite)) {
                this.saldo -= valor;
            }
        }

        public double getSaldo() {
            return this.saldo;
        }
    }

    public static void main(String[] args) throws Exception {
        ContaBancaria conta = new ContaBancaria("12345", "111.222.333-44", 100.0);

        conta.depositar(200.0);
        IO.println("Depositou R$200. Saldo: " + conta.getSaldo());

        conta.sacar(150.0);
        IO.println("Sacou R$150. Saldo esperado: 50.0 | Saldo real: " + conta.getSaldo());

        conta.sacar(100.0);
        IO.println("Sacou R$100 (usou o limite). Saldo esperado: -50.0 | Saldo real: " + conta.getSaldo());

        conta.depositar(100.0);
        IO.println("Depositou R$100 com saldo negativo. Cobrou taxa de 3%.");
        IO.println("Saldo esperado: 48.5 | Saldo real: " + conta.getSaldo());
    }
}