package fileInputStream2;

//Programa utilizado para leitura do arquivo.txt.

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TestaEntrada {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		int c = isr.read();
		System.out.println(c);
	}
}