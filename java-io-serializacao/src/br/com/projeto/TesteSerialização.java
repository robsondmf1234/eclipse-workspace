//Programa que demonstra o uso de Serialização
//Transforma uma classe em um objeto binario

package br.com.projeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerialização {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String nome = "Robson Douglas";
		
		//Transformar um objeto em fluxo binario de dados (serialização) 
		//Sera persistido em hd, por esse motivo foi inserido o objeto.bin
		//Socket é utilizado para persistir via rede.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
		//Serializar passando o objeto
		oos.writeObject(nome);
		//fechando o objet
		oos.close();

		//Pegando o objeto serializado e mostrando o valor
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		//lendo o bejto e convertendo para String, pois o mesmo retorna um Object
		nome = (String) ois.readObject();
		//fechado o objeto
		ois.close();
		System.out.println(nome);
	}

}
