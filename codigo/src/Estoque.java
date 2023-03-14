import java.util.ArrayList;

public class Estoque {
    int tamEstoque;
    ArrayList<Produto> produtosEstoque;

    public Estoque (int tamEstoque){
        this.produtosEstoque = new ArrayList<>();
        this.tamEstoque = tamEstoque;
    }

    public void incluiProduto (Produto p){
        this.produtosEstoque.add(p);
    }

    public void incluiProdutos (ArrayList<Produto> produtos){
        for (int i = 0; i < produtos.size(); i++){
            this.incluiProduto(produtos.get(i));
        }
    }

}

