package br.com.bytebank.banco.modelo;
//Aula 5.4
public abstract class Object {

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;


	public Object(int agencia, int numero) {
		Object.total++;
	//	System.out.println("O total de contas � " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
	//	this.saldo = 100;
	//	System.out.println("Estou criando uma conta " + this.numero);
	}

	public abstract void deposita(double valor);

	public void saca(double valor) {
		
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: "+this.saldo+", Valor: "+valor);
		}
		this.saldo -= valor;
	}

	public void transfere(double valor, Object destino) {
		this.saca(valor);
		destino.deposita(valor);
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.agencia = agencia;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public static int getTotal() {
		return Object.total;
	}

}