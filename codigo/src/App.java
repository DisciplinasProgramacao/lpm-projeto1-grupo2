import java.util.Scanner;
public class App {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int op;
//
//        do {
//            System.out.println("----- Menu -----");
//            System.out.println("1. Registrar produto");
//            System.out.println("2. Adicionar produto");
//            System.out.println("3. Retirar produto");
//            System.out.println("4. Verificar quantidade de produto");
//            System.out.println("5. Imprimir relatório de produto");
//            System.out.println("6. Sair");
//            System.out.print("Digite uma opção: ");
//            op = sc.nextInt();
//            switch (op) {
//                case 1:
//                    //COMPLETAR
//                    break;
//                case 2:
//                    //COMPLETAR
//                    break;
//                case 3:
//                    //COMPLETAR
//                    break;
//                case 4:
//                    //COMPLETAR
//                    break;
//                case 5:
//                    //COMPLETAR
//                    break;
//                case 6:
//
//                    break;
//                default:
//                    System.out.println("Valor inválido. Insira um valor válido presente no menu");
//                    break;
//            }
//            System.out.println();
//
//        } while (op != 6);
//
//        sc.close();
//
//    }

    try {

//        Produto p1 = Produto.registrarProduto("Bo", 89, 10, 0.5);
        Produto p2 = Produto.registrarProduto("Arroz 1kg", 10,11, 0.59);
        Produto p3 = Produto.registrarProduto("Feijão 1kg", 12,15, 0.6);
        Produto p4 = Produto.registrarProduto("Biscoito salgado", 15,8, 0.42);
        Produto p5 = Produto.registrarProduto("Biscoito doce", 5,5, 0.34);

        System.out.println(p2.getCustoTotal());

    } catch (Exception e) {
        String errorMsg = e.getMessage();
        System.out.printf("\nErro ao cadastrar o produto: %s\n", errorMsg);
        System.out.println("----------------------");
    }
    }
}


