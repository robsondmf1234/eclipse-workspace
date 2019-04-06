//Programa que le os dados vindo do teclado e salva em um arquivo.txt

package teste;

import java.io.PrintStream;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		PrintStream ps = new PrintStream("arquivo.txt");
		while (s.hasNextLine()) {
			ps.println(s.nextLine());
		}
	}
}
