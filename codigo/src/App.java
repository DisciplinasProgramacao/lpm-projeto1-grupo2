import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Estoque estoque = new Estoque(5);
        ArrayList<Produto> meusProdutos = new ArrayList<>();
        String descricao;
        int quantidadeInicial;
        double preco;
        double margemLucro;
        int codigo;
        Scanner sc = new Scanner(System.in);

        Produto p1 = new Produto("Cachaça", 5, 10.2, 0.6);
        Produto p2 = new Produto("Torradas", 2, 3.4, 0.5);
        Produto p3 = new Produto("Refrigerante", 5, 5, 0.5);

        ArrayList<Produto> produtos = new ArrayList<>();
        Collections.addAll(produtos, p1, p2, p3);
        estoque.incluiProdutos(produtos);

        int op;


        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Registrar produto");
            System.out.println("2. Adicionar qtd. do produto ao produto");
            System.out.println("3. Retirar qtd. do produto do estoque");
            System.out.println("4. Verificar quantidade de produtos no estoque");
            System.out.println("5. Imprimir relatório de produto");
            System.out.println("6. Verificar valor total do estoque");
            System.out.println("7. Sair");
            System.out.print("Digite uma opção: ");
            op = sc.nextInt();
            try {
                switch (op) {
                    case 1:

                        if (estoque == null) {
                            System.out.println("Não existe estoque criado. Qual o tamanho desejado do estoque?");
                            int tamEstoque = sc.nextInt();
                            estoque = new Estoque(tamEstoque);
                        } else {
                            System.out.println("Digite a descrição, a quantidade inicial, o preço de custo e a margem de lucro do produto (em decimal):");
                            descricao = sc.next();
                            quantidadeInicial = sc.nextInt();
                            preco = sc.nextDouble();
                            margemLucro = sc.nextDouble();
                            Produto p = new Produto(descricao, quantidadeInicial, preco, margemLucro);
                            estoque.incluiProduto(p);
                            meusProdutos.add(p);
                        }

                        break;

                    case 2:
                        estoque.listarProdutos();
                        System.out.println("Digite o código do produto desejado");
                        codigo = sc.nextInt();
                        System.out.println("Digite a quantidade a se adicionar ao produto");
                        int quant = sc.nextInt();
                        estoque.adicionarQuantProduto(codigo, quant);
                        break;
                    case 3:

                        System.out.println("Digite o código do produto:");
                        estoque.listarProdutos();
                        codigo = sc.nextInt();
                        System.out.println("Digite a quantidade a se retirar do produto");
                        quant = sc.nextInt();
                        estoque.retirarQuantProduto(codigo, quant);

                        break;
                    case 4:
                        estoque.getTotalItensEstoque();
                        break;
                    case 5:
                        estoque.relatorioTodosProdutosEmFalta();
                        break;
                    case 6:
                        System.out.println("Não implementado");
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Valor inválido. Insira um valor válido presente no menu");
                        break;
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Verifique a entrada informada e tente novamente. \nErro: " + e.getMessage());
            }
        } while (op != 7);

        sc.close();

    }


}



