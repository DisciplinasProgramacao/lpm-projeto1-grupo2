import org.junit.Assert;
import org.junit.Test;

public class EstoqueTest {

  // Teste para verificar o metodo se produto está disponivel
  @Test
  public void testEstaDisponivel() {
    Produto p = new Produto("Cachaça", 0, 10,5);
    Estoque estoque = new Estoque(p, 1, 5);
    assertTrue(estoque.estaDisponivel());
    estoque.abaterQuantidade(p, 5);
    assertTrue(estoque.estaDisponivel());
    estoque.abaterQuantidade(p, 6);
    assertFalse(estoque.estaDisponivel());
  }
  //Teste para verificar se a quantidade adicionada ao produto está certa
  @Test
  public void testAddQuant() {
    Produto p = new Produto("Conhaque", 0,15,5);
    Estoque estoque = new Estoque(p, 1, 5);
    estoque.addQuantidade(p, 3);
    assertEquals(8, estoque.getQuantDisponivel());

  }
  //Teste para verificar se a quantidade retirada do produto está certa
  @Test
  public void testAbaterQuant() {
    Produto p = new Produto("Macarrão", 0,20,5);
    Estoque estoque = new Estoque(p, 1, 5);
    estoque.abaterQuantidade(p, 3);
    assertEquals(2, estoque.getQuantDisponivel());

  }
  
  @Test
  public void testRelatorioProdutoEmFalta() {
    Produto p1 = new Produto("Espumante", 0,5,5);
    Estoque estoque = new Estoque(p1, 7, 5);
    estoque.addQuantidade(p1, 8);
    estoque.abaterQuantidade(p1, 5);
    assertEquals("Produto em falta: Espumante\n", estoque.relatorioProdutoEmFalta());

  }
  
}
