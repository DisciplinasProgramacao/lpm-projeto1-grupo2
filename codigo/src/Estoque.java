import java.util.ArrayList;

public class Estoque {
    int tamEstoque;
    ArrayList<Produto> produtosEstoque;

    public Estoque (int tamEstoque){
        this.produtosEstoque = new ArrayList<>();
        this.tamEstoque = tamEstoque;
    }

    //Inclui um único Produto no Estoque, verificando se não está sendo ultrapassado o valor máximo
    //definido no momento da criação do Estoque
    public void incluiProduto (Produto p){
        if (this.produtosEstoque.size() == this.tamEstoque){
            System.out.println("Estoque cheio.");
        } else {
            this.produtosEstoque.add(p);
            p.updateStatusEstoque();
        }
    }

    //Inclui uma lista de Produtos no Estoque, verificando se não está sendo ultrapassado o valor máximo
    //definido no momento da criação do Estoque
    public void incluiProdutos (ArrayList<Produto> produtos){
        //Se a quantidade de Produtos na lista for maior que o espaço disponível no estoque, a operação é abortada
        if (this.produtosEstoque.size() == this.tamEstoque || produtos.size() > (this.tamEstoque - this.produtosEstoque.size())){
            System.out.println("Estoque cheio.");
        } else {
        //Caso contrário, inclui os Produtos no Estoque
            for (int i = 0; i < produtos.size(); i++) {
                produtos.get(i).updateStatusEstoque();
                this.incluiProduto(produtos.get(i));
            }
        }

    }
    public int getQtdProdutosEstoque() {
       return this.produtosEstoque.size();
    }



}

