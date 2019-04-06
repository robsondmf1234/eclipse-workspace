//Programa que demonstra o uso do Scanner
package br.com.projeto.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteScanner2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("contas.csv"));

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			System.out.println(linha);
			
//			String[] valores = linha.split(",");
//			System.out.println(Arrays.toString(valores));
			
			Scanner linhascanner = new Scanner(linha);
			linhascanner.useDelimiter(",");
			linhascanner.useLocale(Locale.US);
			
			String valor1 = linhascanner.next();
			int valor2 = linhascanner.nextInt();
			int valor3 = linhascanner.nextInt();
			String valor4 = linhascanner.next();
			double valor5 = linhascanner.nextDouble();
			
			System.out.println(valor1+valor2+valor3+valor4+valor5);
		}

		scanner.close();
	}

}
