import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ProdutoTest {
	private Produto produto;

	@Nested
	class AssertionsTests {
		@BeforeEach
		void init() {
			produto = Produto.registrarProduto("Lápis", 10, 5.0, 0.5);
		}

		@Test
		void testandoValorImposto() {
			Assertions.assertEquals(1.593, produto.getValorImposto());
		}

		@Test
		void testantoCalcularPrecoVenda() {
			Assertions.assertEquals(8.85, produto.calcularPrecoVenda(5.0, 0.5));
		}

		@Test
		void testandoCustoTotal() {
			Assertions.assertEquals(50.0, produto.getCustoTotal());
		}

		@Test
		void testAddProdutoVenda(){
			Estoque estoque = new Estoque(4);
			estoque.incluiProduto(produto);

			//Produto não associado ao estoque não deve conseguir ser vendido.
			Produto p2 = Produto.registrarProduto("Detergente", 3, 1.20, 0.4);

			Venda venda = new Venda();
			venda.addItemVenda(produto, 3);
			venda.addItemVenda(p2, 2);

			ArrayList<ItemVendido> itensVenda = venda.getItensVendidos();

			//O produto p2 não deve estar na venda, pois não foi associado ao estoque
			Assertions.assertFalse(itensVenda.contains(p2));

		}
	}


	@Nested
	class ExceptionTests {

		@Test
		void testDescricaoInvalida() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
					() -> Produto.registrarProduto("Pr", 10, 5, 0.5));
			Assertions.assertEquals("Descrição Inválida!\nNúmero de caracteres menor que 3. ", exception.getMessage());

			System.out.printf("Mensagem de erro: %s", exception.getMessage());
		}

	}
}