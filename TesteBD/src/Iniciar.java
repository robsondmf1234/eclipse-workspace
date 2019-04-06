
public class Iniciar {

	public static void main(String[] args) {
		Conexao.getConnection();
		System.out.println(Conexao.status);
	}

}
