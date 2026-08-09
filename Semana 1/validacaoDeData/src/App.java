public class App {
    public static class Funcoes {
        public static String data() {
            return IO.readln(String.format("Informe a data (DD/MM/AAAA): "));
        }

        public static boolean formatoDataValida(String data) {
            return data != null && data.length() == 10;
        }

        public static boolean dataValida(String data) {
            if (!formatoDataValida(data)) {
                return false;
            }
            
            // String diaS = "";
            // String mesS = "";
            // String anoS = "";

            // for (int i = 0; i < data.length(); i++) {
            //     if (i <= 1) {
            //         diaS += data.charAt(i);
            //     } else if (i != 2 && i <= 4) {
            //         mesS += data.charAt(i);
            //     } else if (i > 5) {
            //         anoS += data.charAt(i);
            //     }
            // }

            // int dia = Integer.parseInt(diaS);
            // int mes = Integer.parseInt(mesS);
            // int ano = Integer.parseInt(anoS);

            int dia = Integer.parseInt(data.substring(0,2));
            int mes = Integer.parseInt(data.substring(3,5));
            int ano = Integer.parseInt(data.substring(6,10));
            
            if (ano < 1 || mes < 1 || mes > 12) {
                return false;
            }

            boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

            int maxDias;
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                maxDias = 30;
            } else if (mes == 2) {
                if (bissexto) {
                    maxDias = 29;
                } else {
                    maxDias = 28;
                }
            } else {
                maxDias = 31;
            }

            return dia >= 1 && dia <= maxDias;
        }

        public static void run() {
            String data = data();
            if (dataValida(data)) {
                IO.println(String.format("A data %s é uma data válida", data));
            } else {
                IO.println(String.format("A data %s não é uma data válida", data));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Funcoes.run();
    }
}
