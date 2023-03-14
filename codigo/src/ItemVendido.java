public class ItemVendido {

	private int quant;
	private Produto produto;
	private double valorTotalItem;

	public ItemVendido(Produto produto, int quant){
		this.produto = produto;
		this.quant = quant;
	}
	public double getValorTotal() {
		return this.quant * this.produto.getValorVenda();

	}
	//Retorna o produto relacionado ao ItemVendido em questão
	public Produto getProdutoItem(){
		return this.produto;
	}
	public int getQuantItem(){
		return this.quant;
	}
	//Adiciona uma quantidade de itens referente a um ItemVendido de uma Venda
	public void addQuantItem(int quant){
		this.quant += quant;
	}
}
