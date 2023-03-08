public class Estoque {
    private Produto produto;
    private int quantMin;
    private int quantDisp;

    //Método construtor de estoque
    public Estoque(Produto produto, int quantMin, int quantDisp) {
        this.produto = produto;
        this.quantMin = quantMin;
        this.quantDisp = quantDisp;
    }
    //Método para verificar se produto está dispónivel
    public boolean estaDisponivel() {
        return quantDisp > 0;
    }
    //Método para adicionar quantidade ao produto
    public void addQuantidade(Produto produto, int quant) {
        this.quantDisp += quant;
    }
    //Método para diminuir quantidade do produto
    public void abaterQuantidade(Produto produto, int quant) {
        if (quant <= quantDisp) {
            this.quantDisp -= quant;
        } else {
            System.out.println("Quantidade a ser abatida maior que quantidade disponível: valor inválido");
        }
        
    }

    public int getQuantDisponivel() {
        return quantDisp;
    }
    //Método que verifica se produto está em falta com base na quantidade mínima especificada
    // e imprime relatório
    public String relatorioProdutoEmFalta() {
        if (quantDisp < quantMin) {
            return "Produto em falta: " + produto.getDescricao() + "\n";
        }
        return "Produto não está em falta";
    }
}

