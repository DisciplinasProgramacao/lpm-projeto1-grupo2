
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
	private static double IMPOSTO = 0.18;
	private int quantMin;
	private int quantDisp;
	private boolean estaNoEstoque;
	
	public Produto() {
	}
	/*
	 * Construtor de Produto, que é chamado pelo factory method registrarProduto()
	 * São feitas as validações do tamanho de caracteres da descrição, da margem de lucro
	 * mínima e máxima e do valor de venda, a partir do preço de custo, margem de lucro e
	 * impostos. Se a criação for bem sucedida, uma mensagem com alguns dados do produto é
	 * retornada. Senão, a exceção é capturada e exibida ao usuário (ex.: margem de lucro
	 * inválida).
	 */
	public Produto(String descricao, int qtdInicial, double precoCusto, double margemLucro) throws IllegalArgumentException {

			validarCaracteresProduto(descricao);
			validaMargemLucro(margemLucro);

			//Cria automaticamente o código do produto de acordo com o último código criado.
			this.codigo = Produto.ultimoCodigo + 1;
			Produto.ultimoCodigo = this.codigo;

			this.descricao = descricao;
			this.quantDisp = qtdInicial;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
			this.valorVenda = calcularPrecoVenda(precoCusto, margemLucro);

			System.out.printf("\nO produto '%s' foi registrado com o código %d." +
					"\n- Custo: R$ %.2f" +
					"\n- Qtd. inicial: %d" +
					"\n- Custo total: R$ %.2f" +
					"\n- Margem de lucro: %.1f%%" +
					"\n- Valor dos impostos: R$ %.2f" +
					"\n- Valor de venda: R$ %.2f\n",
					descricao, this.codigo, precoCusto, qtdInicial, (precoCusto * qtdInicial),
					(margemLucro * 100), this.getValorImposto(), valorVenda);
			System.out.println("----------------------");


	}

	/*
	 * Factory method responsável por criar um novo produto, de forma que
	 * o método de criação tenha um nome mais amigável.
	 */
	public static Produto registrarProduto(String descricao, int qtdInicial, double precoCusto, double margemLucro){
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
	 * Método que retorna o código do produto
	 */
	public int getCodigo() {
		return this.codigo;
	}

	/*
	 * Método que calcula o custo total, a partir da quantidade
	 * de itens e do valor de custo.
	 */
	public double getCustoTotal(){
		double custoTotal = this.quantDisp * this.precoCusto;

		return custoTotal;

	}

	public double getValorVenda(){
		return this.valorVenda;
	}

	//Método para verificar se produto está dispónivel
	public boolean estaDisponivel() {
		return quantDisp > 0;
	}

	//Método para adicionar quantidade ao produto
	public void addQuantidade(int quant) {
		this.quantDisp += quant;
	}

	//Método para diminuir quantidade do produto
	public void abaterQuantidade(int quant) {
		if (quant <= quantDisp) {
			this.quantDisp -= quant;
		} else {
			System.out.println("\nQuantidade a ser abatida maior que quantidade disponível: valor inválido");
		}

	}
	//Método que retorna a quantidade de produtos disponíveis
	public int getQuantDisponivel() {
		return this.quantDisp;
	}


	//Método que seta se um produto está ou não no estoque, atualizando para o estado inverso
	public void updateStatusEstoque(){
		this.estaNoEstoque = !(this.estaNoEstoque);
	}

	//Método que retorna se o produto está ou não no estoque
	public boolean getStatusEstoque(){
		return this.estaNoEstoque;
	}

//	//Método que verifica se produto está em falta com base na quantidade mínima especificada
//	// e imprime relatório
	public String relatorioProdutoEmFalta() {
		if (quantDisp < quantMin) {
			return "Produto em falta: " + this.getDescricao() + "\n";
		}
		return "Produto não está em falta";
	}


}
