//Clase que demonstra a leitura de dados inseridos no console
package br.com.projeto.fileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteFileWriter {

	public static void main(String[] args) throws IOException {

		//FileWriter fw = new FileWriter("loremFileWriter.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("loremFileWriter.txt"));
		bw.write("Testando FileWrite");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("Testeando o flieWriter denovo");
		
		bw.close();
		

	}
}
