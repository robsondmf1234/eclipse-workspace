//Clase que demonstra a escrita utilizando FileWriter

package br.com.projeto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscrita2 {
	
	public static void main(String[] args) throws IOException {
		
//		FileOutputStream fos = new FileOutputStream("lorem2.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem3.txt"));
		bw.write("loremmmm aaammamamamoaosojaos");
		bw.newLine();
		bw.newLine();
		bw.write("oamo testets ");
		
		bw.close();
	}

}