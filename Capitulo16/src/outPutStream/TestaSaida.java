package outPutStream;

//Programa para escrever dados no arquivo saida.txt

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TestaSaida {

	public static void main(String[] args) throws Exception{
		//Outputstream e indicando o arquivo que será usado para escrever 
		//OutputStream os = new FileOutputStream("saida.txt", true);
		
		//FileOutputStream com append
		OutputStream os = new FileOutputStream("saida.txt", true);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("\ncaelum39");
		
		bw.close();
	}

}
