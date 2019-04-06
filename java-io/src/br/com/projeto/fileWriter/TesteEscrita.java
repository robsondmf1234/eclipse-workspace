//Clase que demonstra a leitura de arquivos

package br.com.projeto.fileWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TesteEscrita {
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("lorem2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("omoamopsmaopasoanpansaponp");
		bw.newLine();
		bw.write("omaassasdcscxvdsoamopsmaopasoanpansaponp");
		bw.flush();
		
		bw.close();
	}

}