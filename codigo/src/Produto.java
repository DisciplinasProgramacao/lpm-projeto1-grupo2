
public class Produto {

	private String nome;

	private String descricao;

	private static final int MIN_CARACTERES_DESCRICAO = 3;

	private static double MIN_MARGEM_LUCRO = 0.3;

	private static double MAX_MARGEM_LUCRO = 0.8;

	private double precoCusto;

	private int quant;

	private static double IMPOSTO = 0.18;

	/*
	 * Método que registra produto
	 */
	public String registrarProduto() {
        StringBuilder registraPedido = new StringBuilder("Produto: "+this.nome+"\n");
        registraPedido.append("Quantidade: " +this.quant+"\n");
        registraPedido.append("\nValor: R$ " + this.precoVenda(precoCusto));
        registraPedido.append("\nDescrição: R$ " + this.validarCaracteresProduto());    
        return registraPedido.toString();
	}
	
	/*
	 * Método que calcula o valor do imposto de determinado produto
	 */
	public double getValorImposto() {
		return (this.precoCusto + this.margemLucro(precoCusto))/ IMPOSTO;
	}
	
	/*
	 * Método para validar quantidade de caracteres na descrição de um produto
	 */
	public String validarCaracteresProduto() {
		if(this.descricao.length() >= MIN_CARACTERES_DESCRICAO) {
			return this.descricao;
		} else {
			throw new IllegalArgumentException("Descrição Inválida!\nNúmero de caracteres menor que 3. ");
		}
	}
	
	/*
	 * Método que calcula o preço da Venda de um produto 
	 */
	public double precoVenda(double precoCusto) {
		return this.precoCusto + this.margemLucro(precoCusto) +IMPOSTO ;
	}
	
	/*
	 * Método que verifica se o cálculo da margem é válida(a partir de uma fórmula). Se for válida, retorna a margem de Lucro. 
	 */
	public double margemLucro(double precoCusto) {
		double calculoMargem = (this.precoVenda(precoCusto) - this.precoCusto)/this.precoVenda(precoCusto);
		if (calculoMargem >= MIN_MARGEM_LUCRO || calculoMargem >= MAX_MARGEM_LUCRO) {
			return calculoMargem;
		} else {
			throw new IllegalArgumentException("Margem de lucro inválida!");
		}
	}

	public String getNome() {
		return nome;
	}
	public int getQuantidade() {
		return quant;
	}

}
