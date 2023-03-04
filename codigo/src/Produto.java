
public class Produto {
	private static int ultimoCodigo;
	private int codigo;
	private String descricao;
	private static final int MIN_CARACTERES_DESCRICAO = 3;
	private static double MIN_MARGEM_LUCRO = 0.3;
	private static double MAX_MARGEM_LUCRO = 0.8;
	private double precoCusto;
	private double valorVenda;
	private double margemLucro;
	private int qtdInicial;
	private static double IMPOSTO = 0.18;

	/*
	 * Construtor de Produto, que é chamado pelo factory method registrarProduto()
	 * São feitas as validações do tamanho de caracteres da descrição, da margem de lucro
	 * mínima e máxima e do valor de venda, a partir do preço de custo, margem de lucro e
	 * impostos. Se a criação for bem sucedida, uma mensagem com alguns dados do produto é
	 * retornada. Senão, a exceção é capturada e exibida ao usuário (ex.: margem de lucro
	 * inválida).
	 */
	public Produto(String descricao, int qtdInicial, double precoCusto, double margemLucro){

		try {
			validarCaracteresProduto(descricao);
			validaMargemLucro(margemLucro);

			//Cria automaticamente o código do produto de acordo com o último código criado.
			this.codigo = Produto.ultimoCodigo + 1;
			Produto.ultimoCodigo = this.codigo;

			this.descricao = descricao;
			this.qtdInicial = qtdInicial;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
			this.valorVenda = calcularPrecoVenda(precoCusto, margemLucro);

			System.out.printf("O produto '%s' foi registrado com o código %d." +
					"\n- Custo: R$ %.2f" +
					"\n- Qtd. inicial: %d" +
					"\n- Custo total: R$ %.2f" +
					"\n- Margem de lucro: %.1f%%" +
					"\n- Valor dos impostos: R$ %.2f" +
					"\n- Valor de venda: R$ %.2f\n",
					descricao, this.codigo, precoCusto, qtdInicial, (precoCusto * qtdInicial),
					(margemLucro * 100), this.getValorImposto(), valorVenda);
			System.out.println("----------------------");

		} catch (Exception e) {
			String errorMsg = e.getMessage();
			System.out.printf("\nErro ao cadastrar o produto '%s': %s\n", descricao, errorMsg);
			System.out.println("----------------------");
		}

	}
	/*
	 * Factory method responsável por criar um novo produto, de forma que
	 * o método de criação tenha um nome mais amigável.
	 */
	static Produto registrarProduto(String descricao, int qtdInicial, double precoCusto, double margemLucro){
		return new Produto(descricao, qtdInicial, precoCusto, margemLucro);
	}

	/*
	 * Método que calcula o valor do imposto de determinado produto
	 */
	public double getValorImposto() {
		double valorImposto = this.valorVenda * IMPOSTO;

		return valorImposto;
	}

	/*
	 * Método para validar quantidade de caracteres na descrição de um produto
	 */
	public void validarCaracteresProduto(String descricao) {
		if(descricao.length() < MIN_CARACTERES_DESCRICAO) {
			throw new IllegalArgumentException("Descrição Inválida!\nNúmero de caracteres menor que 3. ");
		}
	}

	/*
	 * Método que calcula o preço da venda de um produto
	 * a partir do preço de custo e da margem de lucro desejada
	 */
	public double calcularPrecoVenda(double precoCusto, double margemLucro) {

		double valorSemImposto = precoCusto + (margemLucro * precoCusto);
		double precoVenda = valorSemImposto + (IMPOSTO * valorSemImposto);

		return precoVenda;
	}

	public void validaMargemLucro(double margemLucro) {
		if (margemLucro < MIN_MARGEM_LUCRO || margemLucro > MAX_MARGEM_LUCRO) {
			throw new IllegalArgumentException("Margem de lucro baixa! Deve ser entre 30% e 80%. " +
					"Foi informado " + (margemLucro*100) + "%.");
		}
	}

	/*
	 * Método que retorna a descrição do produto
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/*
	 * Método que retorna a quantidade inicial de produtos cadastrados
	 */
	public int getQuantidadeInicial() {
		return qtdInicial;
	}

	/*
	 * Método que calcula o custo total, a partir da quantidade
	 * de itens e do valor de custo. A consulta é feita diretamente pelo estoque
	 *
	 * TODO
	 * Consultar a quantidade pelo estoque ao invés da qtd. inicial.
	 */
	public double getCustoTotal(){
		double custoTotal = this.qtdInicial * this.precoCusto;

		return custoTotal;


	}



}
