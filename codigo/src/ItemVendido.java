public class ItemVendido {

	private int quant;
	private Produto p;

	public int getQuant (){
		return this.quant;
	}
	public void setQuant (int q){
		this.quant= q;
	}

	public void getValorTotal() {
		return quant*p.getValorTotal();

	}

}
