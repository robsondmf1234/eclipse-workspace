public class Designer extends Funcionario {

	@Override
	public double getBonificacao() {
		System.out.println("Chamando o método de bonificacao de Designer");
		return 200;
	}
}