import java.util.List;

public class Venda {
	List<ItemVendido> itensVendidos;
	private double valorTotalVenda;
	
    public void getValorVenda(){
    	for(ItemVendido item: itensVendidos) {
    		valorTotalVenda += item.getValorTotal();    	}
        System.out.printf("Valor total da venda: " + valorTotalVenda);

    }
    
    
	
}
