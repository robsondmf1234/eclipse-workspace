package exercicioCapitulo2174;

public class MainFuncionario {

	public static void main(String[] args) {
			
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Douglas");
		funcionario.setUsuario("rgoud");
		funcionario.setSenha("123456");
		//funcionario.setId(3L);
		FuncionarioDao dao = new FuncionarioDao();
		
		//m�todo para adicionar Funcion�rios
		dao.adiciona(funcionario);
		
		//m�todo para alterar um Funcion�rio
		//dao.altera(funcionario);
		
		//m�todo para buscar um Funcion�rio por Id
		//dao.busca();
		
		//m�todo para excluir um Funcion�rio
		//dao.remove(funcionario);
		
		//m�todo para buscar(com lista) uma lista de Funcionarios
		//List<Funcionario> funcionarios = dao.buscaLista();
		
		/*		
		for (Funcionario funcionario1 : funcionarios) {
			System.out.println("Nome: "+funcionario1.getNome());
			System.out.println("Usuario: "+funcionario1.getUsuario());
			System.out.println("Senha: "+funcionario1.getSenha()+"\n");
		}
		*/
	}

}
