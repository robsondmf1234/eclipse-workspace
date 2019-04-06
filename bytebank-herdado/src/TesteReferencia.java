//Codigo para exemplificar Polimorfismos
public class TesteReferencia {

	public static void main(String[] args) {

		Gerente g1 = new Gerente();
		g1.setNome("Flavio");
		g1.setSalario(5000.0);

		// Utilizando polimorfismo
		// Funcionario g1 = new Gerente();

/*		Funcionario f1 = new Funcionario();
		f1.setNome("Tulio");
		f1.setSalario(2000.0);*/

		EditorVideo e1 = new EditorVideo();
		e1.setNome("Joacir");
		e1.setSalario(2500.0);

		Designer d1 = new Designer();
		e1.setNome("Joao");
		e1.setSalario(2000.0);

		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g1);
	//	controle.registra(f1);
		controle.registra(e1);
		controle.registra(d1);

		System.out.println(controle.getSoma());

	}

}
