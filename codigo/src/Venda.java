import java.util.ArrayList;
import java.util.List;

public class Venda {
	ArrayList<ItemVendido> itensVendidos;
	private double valorTotalVenda;

	public Venda(){
		this.itensVendidos = new ArrayList<>();
	}
	
    public double getValorVenda(){

    	for(ItemVendido item: itensVendidos) {
    		this.valorTotalVenda += item.getValorTotal();}
        System.out.printf("Valor total da venda: " + valorTotalVenda);

		return this.valorTotalVenda;
    }

	public ArrayList<ItemVendido> getItensVendidos(){
		return this.itensVendidos;
	}

	public void addItemVenda(Produto produto, int quant){
		//Verifica se o produto está disponível antes de incluir na venda
		if (produto.getStatusEstoque()) {
			if (produto.estaDisponivel()) {
				//Se o produto estiver disponível, verifica se o produto já foi adicionado à venda
				if (itensVendidos.contains(produto)) {
					//Se o produto já estiver adicionado à venda, abate-se sua quantidade
					// em seu estoque e se atualiza a quantidade de itens desse produto na venda
					int indiceProduto = itensVendidos.indexOf(produto);
					this.itensVendidos.get(indiceProduto).getProdutoItem().abaterQuantidade(quant);
					this.itensVendidos.get(indiceProduto).addQuantItem(quant);

				} else {
					//Se o produto não estiver na venda, cria-se um novo ItemVendido
					ItemVendido item = new ItemVendido(produto, quant);
					this.itensVendidos.add(item);

					produto.abaterQuantidade(quant);
				}
			} else {
				System.out.println("Produto fora de estoque!");
			}
		} else {
				System.out.println("O produto " + produto.getDescricao() + " não está associado ao estoque. Faça isso para incluí-lo na venda.");
		}

	}

	public void removeItemVenda(Produto produto){
		//Verifica se o produto foi adicionado à venda
		if (itensVendidos.contains(produto)) {
				//Se o produto estiver na venda, é localizado pelo seu índice
				int indiceProduto = itensVendidos.indexOf(produto);
				ItemVendido itemASerRemovido = this.itensVendidos.get(indiceProduto);

				//Verifica a quantidade do Produto que havia sido adicionada à
				//venda para reintegrar o estoque
				int qtdAReintegrarEstoque = itemASerRemovido.getQuantItem();
				this.itensVendidos.get(indiceProduto).getProdutoItem().addQuantidade(qtdAReintegrarEstoque);

				//Remove o produto da lista de ItemVendido da Venda
				this.itensVendidos.remove(indiceProduto);

				System.out.printf("\n%d unidade(s) do produto %s removida(s) com sucesso da venda e reintegrada ao estoque",
						qtdAReintegrarEstoque, produto.getDescricao());

		} else {
			System.out.println("Este produto não está na venda");
		}

	}
    
	
}
