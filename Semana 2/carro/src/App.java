public class App {
    public static class Carro {
        private String placa;
        private double velocidade = 0.0;
        public final int velociadeMax = 160;
        public final int velocinadeMin = 0;


        public Carro(String placa) {
            this.placa = placa;
        }

        public void acelerar(int velecidade) {
            this.velocidade += velocidade;
            if (this.velocidade > velociadeMax) {
                this.velocidade = velociadeMax;
            }
        }

        public void freiar(int velecidade) {
            this.velocidade -= velocidade;
            if (this.velocidade < velocinadeMin) {
                this.velocidade = velocinadeMin;
            }
        }

        public void velocidadeAtual() {
            IO.println(this.velocidade);
        }

        public String getPlaca() {
            return this.placa;
        }
    }
}
