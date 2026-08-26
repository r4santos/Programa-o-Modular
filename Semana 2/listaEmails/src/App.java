import java.util.ArrayList;
import java.util.List;

public class App {
    public static class funcoes {
        public static List<String> lerEmails(){
            List<String> emails = new ArrayList<>(); 

            String email = IO.readln("Insira um email: ");
            do{
                emails.add(email);
                email = IO.readln("Insira um email (digite 'sair' para sair): ");
            } while (!email.equalsIgnoreCase("sair"));

            return emails;
        }

        public static String lerDominio() {
            return IO.readln("Insira o domínio: ");
        }

        public static List<String> filtrarEmails(List<String> emails, String dominio) {
            List<String> listaFiltrada = new ArrayList<>();

            for (String email : emails) {
                if (email.split("@")[1].equalsIgnoreCase(dominio)) listaFiltrada.add(email);
            }

            return listaFiltrada;
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> emails = funcoes.lerEmails();
        String dominio = funcoes.lerDominio();
        List<String> listaFiltrada = funcoes.filtrarEmails(emails, dominio);

        IO.println(listaFiltrada);
    }
}
