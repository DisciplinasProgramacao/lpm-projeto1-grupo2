
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collections;

public class EstoqueTest {


//   //Teste para verificar o metodo se produto está disponivel
//  @Test
//  public void testEstaDisponivel() {
//    Produto p = new Produto("Cachaça", 0, 10,5);
//    Estoque estoque = new Estoque2(5); //@itensEstoque = qtd. de itens que o estoque vai ter
//    Assertions.assertTrue(estoque.estaDisponivel());
//    estoque.abaterQuantidade(p, 5);
//    Assertions.assertTrue(estoque.estaDisponivel());
//    estoque.abaterQuantidade(p, 6);
//    Assertions.assertFalse(estoque.estaDisponivel());
//  }

    //Teste para verificar a quantidade total produtos distintos no estoque
    @Test
    public void testQtdProdutosEstoque() {

        Estoque estoque = new Estoque(3); //passando qtd. de itens que o estoque vai ter
        Produto p1 = new Produto("Cachaça", 0, 10.2, 0.6);
        Produto p2 = new Produto("Torradas", 10, 3.4, 0.5);
        Produto p3 = new Produto("Refrigerante", 5, 5, 0.5);

        ArrayList<Produto> produtos = new ArrayList<>();
        Collections.addAll(produtos, p1, p2, p3);
        estoque.incluiProdutos(produtos);

        int qtdEstoque = estoque.getQtdProdutosEstoque();
        Assertions.assertEquals(3, qtdEstoque);
        System.out.printf("Quantidade de produtos no estoque: %d", qtdEstoque);
    }

//    @Test
//    public void testRelatorioProdutoEmFalta() {
//        Produto p1 = new Produto("Espumante", 0, 5, 5);
//        Estoque estoque = new Estoque(p1, 7, 5);
//        estoque.addQuantidade(p1, 8);
//        estoque.abaterQuantidade(p1, 5);
//        Assertions.assertEquals("Produto em falta: Espumante\n", estoque.relatorioProdutoEmFalta());
//
//    }


//  //Teste para verificar se a quantidade adicionada ao produto está certa
//  @Test
//  public void testAddQuant() {
//    Produto p = new Produto("Conhaque", 0,15,5);
//    Estoque estoque = new Estoque(p, 1, 5);
//    estoque.addQuantidade(p, 3);
//    Assertions.assertEquals(8, estoque.getQuantDisponivel());
//
//  }
//  //Teste para verificar se a quantidade retirada do produto está certa
//  @Test
//  public void testAbaterQuant() {
//    Produto p = new Produto("Macarrão", 0,20,5);
//    Estoque estoque = new Estoque(p, 1, 5);
//    estoque.abaterQuantidade(p, 3);
//    Assertions.assertEquals(2, estoque.getQuantDisponivel());
//
//  }


}
