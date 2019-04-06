package fileInputStream5;

//Programa para ler os dados inseridos no teclado e depois mostrar no console

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TestaEntrada {
	public static void main(String[] args) throws IOException {
		//Fonte de dados padrao é o teclado.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
		}
	}
}