//Programa que demonstra o uso de Serialização com a classe Cliente
//Transforma uma classe em um objeto binario

package br.com.projeto2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.projeto.Cliente;

public class TesteSerializaçãoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Cliente cliente = new Cliente();
		cliente.setNome("Robson");
		cliente.setProfissao("Dev");
		cliente.setCpf("123456");

		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(222.3);
		cc.setTitular(cliente);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
		oos.writeObject(cc);
		oos.close();
		
	}

}
