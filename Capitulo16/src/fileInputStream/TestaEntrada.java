package fileInputStream;	


//Programa utilizado para leitura do arquivo.txt.

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestaEntrada {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo.txt");
		int b = is.read();
	}
}
