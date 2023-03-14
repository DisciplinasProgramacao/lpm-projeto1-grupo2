public class ItemVendido {

	private int quant;
	private Produto produto;

	//Construtor que recebe um Produto e a quantidade de itens desse Produto na Venda
	public ItemVendido(Produto produto, int quant){
		this.produto = produto;
		this.quant = quant;
	}

	//Retorna o valor total de um Produto na Venda, de acordo com sua quantidade e valor de venda
	public double getValorTotal() {
		return this.quant * this.produto.getValorVenda();
	}
	//Retorna o produto relacionado ao ItemVendido em questão
	public Produto getProdutoItem(){
		return this.produto;
	}
	//Retorna a quantidade de itens de um Produto na Venda
	public int getQuantItem(){
		return this.quant;
	}
	//Adiciona uma quantidade de itens referente a um ItemVendido de uma Venda
	public void addQuantItem(int quant){
		this.quant += quant;
	}

}
