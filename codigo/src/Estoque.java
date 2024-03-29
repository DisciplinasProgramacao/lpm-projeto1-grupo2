import java.util.ArrayList;

public class Estoque {
    private int tamEstoque;
    private ArrayList<Produto> produtosEstoque;


    public Estoque(int tamEstoque) {
        this.produtosEstoque = new ArrayList<>();
        this.tamEstoque = tamEstoque;
        System.out.printf("Estoque de tamanho %d criado com sucesso.", tamEstoque);
    }

    //Inclui um único Produto no Estoque, verificando se não está sendo ultrapassado o valor máximo
    //definido no momento da criação do Estoque
    public void incluiProduto(Produto p) {


        if (this.produtosEstoque.size() == this.tamEstoque) {
            System.out.println("\nEstoque cheio.");
        } else {
            this.produtosEstoque.add(p);
            p.updateStatusEstoque();
            int capacidadeAtualEstoque = this.tamEstoque - this.produtosEstoque.size();
            System.out.printf("\nO produto %s foi associado ao estoque. Espaço disponível no estoque: %d", p.getDescricao(), capacidadeAtualEstoque);
        }
    }

    //Inclui uma lista de Produtos no Estoque, verificando se não está sendo ultrapassado o valor máximo
    //definido no momento da criação do Estoque
    public void incluiProdutos(ArrayList<Produto> produtos) {
        int capacidadeAtualEstoque = this.tamEstoque - this.produtosEstoque.size();
        //Se a quantidade de Produtos na lista for maior que o espaço disponível no estoque, a operação é abortada
        if (this.produtosEstoque.size() == this.tamEstoque || produtos.size() > capacidadeAtualEstoque) {
            System.out.printf("\nEstoque cheio. A lista tem %d produtos e há %d vaga(s) disponíveis no estoque.", produtos.size(), capacidadeAtualEstoque);
        } else {
            //Caso contrário, inclui os Produtos no Estoque
            for (int i = 0; i < produtos.size(); i++) {
                produtos.get(i).updateStatusEstoque();
                this.incluiProduto(produtos.get(i));
                System.out.printf("\nO produto %s foi associado ao estoque. Espaço disponível: %d", produtos.get(i).getDescricao(), capacidadeAtualEstoque);
            }
        }

    }

    //Retorna a quantidade de produtos no estoque
    public int getQtdProdutosEstoque() {
        return this.produtosEstoque.size();
    }

    //Retorna a quantidade total de itens no estoque, a partir da quantidade de cada um dos Produtos
    public int getTotalItensEstoque() {
        int totalItensEstoque = 0;

        for (int i = 0; i < this.produtosEstoque.size(); i++) {
            totalItensEstoque += produtosEstoque.get(i).getQuantDisponivel();
        }

        return totalItensEstoque;
    }

    public void listarProdutos() {
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < this.produtosEstoque.size(); i++) {
            Produto p = this.produtosEstoque.get(i);
            System.out.println(p.getCodigo() + " - " + p.getDescricao() + " (" + p.getQuantDisponivel() + " disponíveis)");
        }
    }

    // Inclui a quantidade de um produto no estoque, a partir de seu código
    public void adicionarQuantProduto(int codigo, int quant) {

        for (Produto produto : produtosEstoque) {
            if (produto.getCodigo() == codigo) {
                produto.addQuantidade(quant);
                System.out.println(quant + " itens do produto " + produto.getDescricao() + " adicionados.");
                System.out.println("Quantidade disponível: " + produto.getQuantDisponivel());
            }

        }
    }

    // Retira a quantidade de um produto no estoque, a partir de seu código
    public void retirarQuantProduto(int codigo, int quant) {

        for (Produto produto : produtosEstoque) {
            if (produto.getCodigo() == codigo) {
                produto.abaterQuantidade(quant);
                System.out.println(quant + " itens do produto " + produto.getDescricao() + " removidos.");
                System.out.println("Quantidade disponível: " + produto.getQuantDisponivel());
            }
        }

    }

    public void relatorioTodosProdutosEmFalta() {
        for (Produto p : produtosEstoque) {
            p.relatorioProdutoEmFalta();
        }
    }

}

