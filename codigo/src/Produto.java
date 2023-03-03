
public class Produto {
	private String descricao;
	private static final int MIN_CARACTERES_DESCRICAO = 3;
	private static double MIN_MARGEM_LUCRO = 0.3;
	private static double MAX_MARGEM_LUCRO = 0.8;
	private double precoCusto;
	private double valorVenda;
	private double margemLucro;
	private int quant;
	private static double IMPOSTO = 1.18;
	
	public Produto(String descricao, double precoCusto, double margemLucro){
		
		try {
			validarCaracteresProduto(descricao);
			validaMargemLucro(margemLucro);

			this.descricao = descricao;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
			this.valorVenda = calcularPrecoVenda(precoCusto, margemLucro);

			System.out.println("O produto '" + descricao + "' foi registrado.\nValor de venda: R$ " + valorVenda);
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	/*
	 * Método que registra produto
	 */
//	public String registrarProduto() {
//
//        StringBuilder registraPedido = new StringBuilder("Produto: "+this.nome+"\n");
//        registraPedido.append("Quantidade: " +this.quant+"\n");
//        registraPedido.append("\nValor: R$ " + this.precoVenda(precoCusto));
//        registraPedido.append("\nDescrição: R$ " + this.validarCaracteresProduto());
//        return registraPedido.toString();
//	}
//
	/*
	 * Método que calcula o valor do imposto de determinado produto
	 */
//	public double getValorImposto() {
//		return (this.precoCusto + this.margemLucro(precoCusto))/ IMPOSTO;
//	}
	
	/*
	 * Método para validar quantidade de caracteres na descrição de um produto
	 */
	public void validarCaracteresProduto(String descricao) {
		if(descricao.length() < MIN_CARACTERES_DESCRICAO) {
			throw new IllegalArgumentException("Descrição Inválida!\nNúmero de caracteres menor que 3. ");
		}
	}
	
	/*
	 * Método que calcula o preço da Venda de um produto 
	 */
	public double calcularPrecoVenda(double precoCusto, double margemLucro) {

		return (precoCusto + (margemLucro * precoCusto)) * IMPOSTO ;
	}
	
	/*
	 * Método que verifica se o cálculo da margem é válida(a partir de uma fórmula). Se for válida, retorna a margem de Lucro. 
	 */
//	public double calculaMargemLucro(double precoCusto) {
//		double calculoMargem = (this.precoVenda(precoCusto) - this.precoCusto)/this.precoVenda(precoCusto);
//		if (calculoMargem >= MIN_MARGEM_LUCRO || calculoMargem >= MAX_MARGEM_LUCRO) {
//			return calculoMargem;
//		} else {
//			throw new IllegalArgumentException("Margem de lucro inválida!");
//		}
//	}

	public void validaMargemLucro(double margemLucro) {
		if (margemLucro < MIN_MARGEM_LUCRO || margemLucro > MAX_MARGEM_LUCRO) {
			throw new IllegalArgumentException("Margem de lucro baixa! Deve ser entre 30% e 80%");
		}
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	public int getQuantidade() {
		return quant;
	}

}
