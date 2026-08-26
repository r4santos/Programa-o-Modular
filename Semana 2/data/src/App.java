public class App {

    public static class Data {
        private int dia;
        private int mes;
        private int ano;

        public Data(int dia, int mes, int ano) {
            if (!isDataValida(dia, mes, ano)) {
                throw new IllegalArgumentException("Data inválida.");
            }
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }

        private boolean isBissexto(int ano) {
            return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
        }

        private int obterDiasDoMes(int mes, int ano) {
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) return 30;
            if (mes == 2) return isBissexto(ano) ? 29 : 28;
            return 31;
        }

        private boolean isDataValida(int d, int m, int a) {
            if (a < 1 || m < 1 || m > 12) return false;
            return d >= 1 && d <= obterDiasDoMes(m, a);
        }

        private int converterParaDiasAbsolutos() {
            int totalDias = this.dia;
            
            for (int i = 1; i < this.ano; i++) {
                totalDias += isBissexto(i) ? 366 : 365;
            }
            
            for (int i = 1; i < this.mes; i++) {
                totalDias += obterDiasDoMes(i, this.ano);
            }
            
            return totalDias;
        }

        public String formatar() {
            return String.format("%02d/%02d/%04d", dia, mes, ano);
        }

        public Data somarDias(int diasParaSomar) {
            int novoDia = this.dia;
            int novoMes = this.mes;
            int novoAno = this.ano;

            while (diasParaSomar > 0) {
                int diasRestantesNoMes = obterDiasDoMes(novoMes, novoAno) - novoDia;
                
                if (diasParaSomar <= diasRestantesNoMes) {
                    novoDia += diasParaSomar;
                    diasParaSomar = 0; 
                } else {
                    diasParaSomar -= (diasRestantesNoMes + 1);
                    novoDia = 1;
                    novoMes++;
                    
                    if (novoMes > 12) {
                        novoMes = 1;
                        novoAno++;
                    }
                }
            }
            return new Data(novoDia, novoMes, novoAno);
        }

        public boolean isFrente(Data outra) {
            if (this.ano > outra.ano) return true;
            if (this.ano == outra.ano && this.mes > outra.mes) return true;
            if (this.ano == outra.ano && this.mes == outra.mes && this.dia > outra.dia) return true;
            
            return false;
        }

        public int diferencaEmDias(Data outra) {
            int meusDias = this.converterParaDiasAbsolutos();
            int outrosDias = outra.converterParaDiasAbsolutos();
            
            return Math.abs(meusDias - outrosDias);
        }
    }

    public static void main(String[] args) throws Exception {
        
        Data d1 = new Data(10, 5, 2024);
        Data novaData1 = d1.somarDias(5);
        IO.println("10/05/2024 + 5 dias = " + novaData1.formatar());

        Data d2 = new Data(30, 12, 2023);
        Data novaData2 = d2.somarDias(2);
        IO.println("30/12/2023 + 2 dias = " + novaData2.formatar());
        
        Data d3 = new Data(20, 10, 2024);
        Data d4 = new Data(15, 10, 2024);
        IO.println("20/10/2024 está à frente de 15/10/2024? " + d3.isFrente(d4));

        Data d5 = new Data(10, 1, 2023);
        Data d6 = new Data(10, 2, 2023);
        IO.println("10/01/2023 está à frente de 10/02/2023? " + d5.isFrente(d6));

        Data d7 = new Data(10, 8, 2024);
        Data d8 = new Data(25, 8, 2024);
        IO.println("Diferença entre 10/08/2024 e 25/08/2024: " + d7.diferencaEmDias(d8));

        Data d9 = new Data(28, 2, 2024);
        Data d10 = new Data(1, 3, 2024);
        IO.println("Diferença entre 28/02/2024 e 01/03/2024: " + d9.diferencaEmDias(d10));
    }
}