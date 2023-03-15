import java.util.ArrayList;

public class Mercearia {
	ArrayList<Produto> produtos;
	ArrayList<Venda> vendas;
	Estoque estoque;

	public Mercearia (int tamEstoque){
		this.produtos = new ArrayList<>();
		this.vendas = new ArrayList<>();
		this.estoque = new Estoque(tamEstoque);
	}

	public void addProduto(String descricao, int quantidadeInicial, double preco, double margemLucro){
		Produto p = new Produto(descricao, quantidadeInicial, preco, margemLucro);
		this.estoque.incluiProduto(p);

	}

	public void getTotal() {

	}

	public void relatorioVendas() {

	}

}
