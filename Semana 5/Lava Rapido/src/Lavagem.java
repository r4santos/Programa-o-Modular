public class Lavagem {
    private int tipoLavagem;
    private int qntdAdicionais;

    private final double LAVAGEM_SIMPLES = 30.00;
    private final double LAVAGEM_COMPLETA = 50.00;
    private final double VALOR_ADICIONAIS = 18.00;
    private final int MAX_ADICIONAIS = 3;

    public Lavagem(int tipo, int qntdAdicionais) {
        if (tipo == 1 || tipo == 2) {
            this.tipoLavagem = tipo;
            if (qntdAdicionais <= MAX_ADICIONAIS && qntdAdicionais > 0) {
                this.qntdAdicionais = qntdAdicionais;
            }
        } else {
            IO.println("Erro ao gerar o objeto");
        }
    }

    public void addAdicional(int x) {
        int restam = MAX_ADICIONAIS - this.qntdAdicionais;
        if (x <= restam && x > 0) {
            this.qntdAdicionais += x;
        } else {
            IO.println("Quantidade inválida de adicionais");
        }
    }

    public String gerarCupom() {
        double valorTotal = 0.0;
        String lavagem = "";
        if (this.tipoLavagem == 1) {
            valorTotal += LAVAGEM_SIMPLES;
            lavagem = "Lavagem Simples";
        } else {
            valorTotal += LAVAGEM_COMPLETA;
            lavagem = "Lavagem Completa";
        }

        if (qntdAdicionais == MAX_ADICIONAIS) {
            valorTotal += 2 * VALOR_ADICIONAIS;
        } else {
            valorTotal += qntdAdicionais * VALOR_ADICIONAIS;
        }

        return String.format("=== CUPOM DE VENDA ===\nTipo: %s\nValor Total: %.2f", lavagem, valorTotal);
    }
}