import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;
 
        Estoque est = new Estoque(10);
        Produto p = new Produto("uiui", 1, 10, 2);

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Registrar produto");
            System.out.println("2. Adicionar produto");
            System.out.println("3. Retirar produto");
            System.out.println("4. Verificar quantidade de produtos no estoque");
            System.out.println("5. Imprimir relatório de produto");
            System.out.println("6. Verificar valor total do estoque");
            System.out.println("7. Sair");
            System.out.print("Digite uma opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:     
                est.incluiProduto(null);
                    break;
                case 2:
                System.out.println("Digite a quantidade a se adicionar ao produto");
                int quant = sc.nextInt();
                p.addQuantidade(quant); 
                    break;
                case 3:
                System.out.println("Digite a quantidade a se retirar do produto");
                quant = sc.nextInt();
                p.abaterQuantidade(quant); 
                    break;
                case 4:
                est.getTotalItensEstoque();                    
                    break;
                case 5:
                p.relatorioProdutoEmFalta();
                    break;
                case 6:
                // N ACHEI O METODO

                    break;
                case 7:

                    break;
                default:
                    System.out.println("Valor inválido. Insira um valor válido presente no menu");
                    break;
            }
            System.out.println();

        } while (op != 7);

        sc.close();

    }

    
    }



