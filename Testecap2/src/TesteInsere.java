import java.util.Calendar;

public class TesteInsere {

	public static void main(String[] args) {
		
		
		Contato contato = new Contato();
		contato.setNome("Douglas");
		contato.setEmail("rrooror@gmail.com");
		contato.setEndereco("r paje ,80");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Contatos gravado");
	}

}
