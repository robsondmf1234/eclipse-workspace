package fileInputStream3;


//Programa utilizado para leitura do arquivo.txt.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TestaEntrada {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo2.txt");
		//decodificador de bytes 
		InputStreamReader isr = new InputStreamReader(is);
		//Buffer para fo
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		br.close();
		System.out.println(s);
	}
}