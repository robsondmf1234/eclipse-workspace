
public class TesteFuncionario {

	public static void main(String[] args) {

		Gerente f1 = new Gerente();
		f1.setNome("Robson");
		f1.setCpf("124244-90");
		f1.setSalario(2200);

		System.out.println(f1.getNome());
		System.out.println(f1.getBonificacao());
	}

}
