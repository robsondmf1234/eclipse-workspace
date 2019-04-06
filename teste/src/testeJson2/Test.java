//Codigo funcionando
//Pega os dados do json de acordo com o CEP informado
//MELHORAR(SEPARANDO AS CLASSES)
package testeJson2;

//Programa para preencher o endereço de acordo com o cep informado.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	public static void main(String args[]) {
		BufferedReader rd;
		StringBuilder sb = new StringBuilder();
		Scanner ler = new Scanner(System.in);

		int codigoPostal = 0;
		
		//Pega o cep a ser consultado com o usuário
		System.out.printf("Informe o cep que deseja consultar: ");
	    codigoPostal = ler.nextInt(); // 3.1 entrada de dados (lendo um valor inteiro)
		
	    //completa a url com o cep digitado
		String url2 = "https://viacep.com.br/ws/"+codigoPostal+"/json/";
		
		System.out.printf("Teste: "+url2);
		
		// Cria o parse de tratamento
		JSONParser parser = new JSONParser();
				
		String resposta = "";
		
		String rua = "";
		String bairro = "";
		String cidade = "";
		String estado = "";
		String cep = "";
		
	    
		
		
		try {
			//montando a url
			URL url = new URL(url2);
			URLConnection conn = url.openConnection();
			// conn.setDoOutput(true);
			// wr = new OutputStreamWriter(conn.getOutputStream());
			// wr.flush();

			// Get the response
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
				sb.append(line);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		resposta = sb.toString();
		//System.out.printf("String Builder: \n %s .\n",sb);
		System.out.printf("Resposta:\n %s \n",resposta);
		
		
		
		try {
			JSONObject obj = (JSONObject) parser.parse(resposta);
			JSONObject jsonObject = (obj);
			
			cep = (String) jsonObject.get("cep");
			rua = (String) jsonObject.get("logradouro");
			cidade = (String) jsonObject.get("localidade");
			bairro = (String) jsonObject.get("bairro");
			estado = (String) jsonObject.get("uf");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Rua: "+rua);
		System.out.println("Bairro: "+bairro);
		System.out.println("Cidade: "+cidade);
		System.out.println("Estado: "+estado);
		System.out.println("CEP: "+cep);
	}
}