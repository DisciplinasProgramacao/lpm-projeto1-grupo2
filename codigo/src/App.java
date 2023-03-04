public class App {
    public static void main(String[] args) {
        Produto p1 = Produto.registrarProduto("Bo", 89, 10, 0.5);
        Produto p2 = Produto.registrarProduto("Arroz 1kg", 10,11, 0.59);
        Produto p3 = Produto.registrarProduto("Feijão 1kg", 12,15, 0.6);
        Produto p4 = Produto.registrarProduto("Biscoito salgado", 15,8, 0.42);
        Produto p5 = Produto.registrarProduto("Biscoito doce", 5,5, 0.34);

        System.out.println(p2.getCustoTotal());


    }
}
