package exercicioCapitulo2174;

public class MainFuncionario {

	public static void main(String[] args) {
			
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Douglas");
		funcionario.setUsuario("rgoud");
		funcionario.setSenha("123456");
		//funcionario.setId(3L);
		FuncionarioDao dao = new FuncionarioDao();
		
		//método para adicionar Funcionários
		dao.adiciona(funcionario);
		
		//método para alterar um Funcionário
		//dao.altera(funcionario);
		
		//método para buscar um Funcionário por Id
		//dao.busca();
		
		//método para excluir um Funcionário
		//dao.remove(funcionario);
		
		//método para buscar(com lista) uma lista de Funcionarios
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
