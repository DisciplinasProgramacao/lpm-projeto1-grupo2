public class Produto {

	private static int ultimoCodigo;

	private int codigo;

	private String nome;

	private String descricao;

	private static final int MIN_CARACTERES_DESCRICAO =  3;

	private static double MIN_MARGEM_LUCRO = 0.3;

	private static double MAX_MARGEM_LUCRO = 0.8;

	private double precoCusto;

	private int qtdInicial = 0;

	private static double IMPOSTO = 0.18;

	private double valorVenda;

	public void registrarProduto(String descricao, double valorCusto, double margemLucro) {

	}

	public double getValorImposto() {
		return 0;
	}

	public double getValorTotal() {
		return 0;
	}

	public double getCustoTotal() {
		return 0;
	}

	private void validarCaracteres(String descricao) {

	}

	private void validarMargemLucro(double margemLucro) {

	}

}
