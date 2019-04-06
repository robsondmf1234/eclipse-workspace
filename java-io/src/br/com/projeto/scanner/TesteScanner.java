//Programa que demonstra o uso do Scanner
package br.com.projeto.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteScanner {

	public static void main(String[] args) throws FileNotFoundException {

		
		Scanner scanner = new Scanner(new File("contas.csv"));
		
		while (scanner.hasNextLine()) {

			String linha = scanner.nextLine();
			System.out.println(linha);
		}
		
		scanner.close();
	}

}
