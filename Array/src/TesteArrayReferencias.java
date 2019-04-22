//Array para armazenar objetos do tipo ContaCorrente

public class TesteArrayReferencias {

	public static void main(String[] args) {
		
		//Array de ContaCorrente
		ContaCorrente[] contas = new ContaCorrente[5];
		
		//Instanciando objetos
		ContaCorrente cc1 = new ContaCorrente(22, 11);
		ContaCorrente cc2 = new ContaCorrente(22, 22);
		
		//Adicionando os objetos ao Array
		contas[0] = cc1;
		contas[1] = cc2;
		
		//Recuperando o numero do objeto da array posição 1
		System.out.println(contas[1].getNumero());
		
		//Atribuindo endereço da memória do objeto conta posição 1 a variavel a ref
		ContaCorrente ref = contas[1];
		System.out.println(ref.getNumero());
	}
}
