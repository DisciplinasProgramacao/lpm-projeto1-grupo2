import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProdutoTest {
	private Produto produto;
	
	@BeforeEach
	void init() {
		produto = Produto.registrarProduto("Lápis", 10, 5.0, 0.5);
	}
	
	@Test 
	void testandoValorImposto() {
		Assertions.assertEquals(1.593, produto.getValorImposto());
	}
//	@Test
//    void testandoValidacaoDeCaractetesDoProduto() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//           produto = Produto.registrarProduto("La", 10, 5.0, 0.5);
//        });
//    }
	
//    @Test
//    void testandoValidacaoMargemDeLucro() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            produto = Produto.registrarProduto("Lápis", 10, 5.0, 0.1);
//        });
//    }
	@Test
	void testantoCalcularPrecoVenda() {
		Assertions.assertEquals(8.85, produto.calcularPrecoVenda(5.0, 0.5));
	}
	@Test
	void testandoCustoTotal() {
		Assertions.assertEquals(50.0, produto.getCustoTotal());
	}

}
