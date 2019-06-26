//Classe utilizada para calcular imposto
public class CalculadorImposto {

	private double totalImposto;
	
	//método que recebe um objeto tipo Tributavel e acrescenta o valor do imposto
	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	//método que retorna o valor total do imposto
	public double getTotalImposto() {
		return totalImposto;
	}

}
