import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


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

	}

	@Nested
	class ExceptionTests {

		@Test
		void testDescricaoInvalida() {
			Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Produto.registrarProduto("Pr", 10, 5, 0.5));
			Assertions.assertEquals("Descrição Inválida!\nNúmero de caracteres menor que 3. ", exception.getMessage());

			System.out.printf("Mensagem de erro: %s", exception.getMessage());
		}

//    @Test
//    void testandoValidacaoMargemDeLucro() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            produto = Produto.registrarProduto("Lápis", 10, 5.0, 0.1);
//        });
//    }


	}


}
