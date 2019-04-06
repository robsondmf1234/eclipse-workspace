package fileInputStream4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TestaEntrada {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//le o buffer e atribui a String s
		String s = br.readLine(); // primeira linha
		
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
		}
		br.close();
	}
}
