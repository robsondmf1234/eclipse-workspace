
public class TesteGerente {

	public static void main(String[] args) {

		Autenticavel referencia = new Gerente();

		Gerente g1 = new Gerente();
		g1.setNome("ferre");
		g1.setCpf("11111");
		g1.setSalario(5000);
		g1.setSenha(111);

		boolean autenticou = g1.autentica(111);
		System.out.println(g1.getNome());
		System.out.println(g1.getBonificacao());
		System.out.println(autenticou);

	}

}
