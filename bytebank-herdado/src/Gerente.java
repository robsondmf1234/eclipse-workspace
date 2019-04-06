
public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;

	public Gerente() {
		this.autenticador = new AutenticacaoUtil();
	}

	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		return autenticador.autentica(senha);
	}

	@Override
	public double getBonificacao() {
		System.out.println("Chamando o metodo Bonificacao Gerente");
		return super.getSalario();
	}

}