//Clase que demonstra a leitura de dados inseridos no console
package br.com.projeto.fileWriter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestePrintStream {

	public static void main(String[] args) throws IOException {

		//PrintWriter pw = new PrintWriter("testePrintWrte.txt");
		PrintStream ps = new PrintStream("testePrintStream.txt");
		ps.println("Testando print stream ");
		ps.println();
		ps.println("testando print stream denaovo");
		ps.close();
		

	}
}
