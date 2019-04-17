//Aula 5.4
public abstract class Conta {

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	//Atributo estático, armazena o numero de contas criadas.
	private static int total = 0;

	//Construtor Classe Conta
	public Conta(int agencia, int numero) {
		//Adicionando 1 ao atributo estático
		Conta.total++;
		this.numero = numero;
	}
	
	//Método abstrato, deverá sempre ser escrito pelas classes filhas
	public abstract void deposita(double valor);
	
	public void saca(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: "+this.saldo+", Valor: "+valor);
		}
		this.saldo -= valor;
	}
	
	//Método para transferir dinheiro para conta de destino
	public void transfere(double valor, Conta destino) {
		this.saca(valor);
		destino.deposita(valor);
	}
	
	//Método que recupera o saldo
	public double getSaldo() {
		return this.saldo;
	}
	
	//Método que recupera o número
	public int getNumero() {
		return this.numero;
	}

	//Método para setar o numero da Agencia
	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.numero = numero;
	}
	
	//Método que recupera a agência
	public int getAgencia() {
		return this.agencia;
	}
	
	//Método para setar o numero da Agencia
	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.agencia = agencia;
	}
	
	//Setar um titular para a conta, classe tipo Cliente
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	//Método para recuperar o titular da Conta
	public Cliente getTitular() {
		return this.titular;
	}
	
	//Método que retorna a quantidade de Contas criadas
	public static int getTotal() {
		return Conta.total;
	}

}
