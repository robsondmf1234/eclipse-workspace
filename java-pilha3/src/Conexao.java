
public class Conexao implements AutoCloseable{

	public Conexao() {
	System.out.println("Abrindo Conex�o.");
	}
	
	public void leDados() {
		System.out.println("Recebendo dados.");
		throw new IllegalStateException();
	}
	
	public void fecha() {
	}

	@Override
	public void close() {
		System.out.println("Fechando conex�o");
		
	}
	
}
