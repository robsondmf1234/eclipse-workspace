//Codigo funcionando
//Pega os dados do json de acordo com o CEP informado
//MELHORAR(SEPARANDO AS CLASSES)
package model;

//Programa para preencher o endere�o de acordo com o cep informado.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BuscaCep {

	private String rua = "";
	private String bairro = "";
	private String cidade = "";
	private String estado = "";
	private String cep = "";

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public BuscaCep buscarCep(int codigo) {
		BufferedReader rd;
		StringBuilder sb = new StringBuilder();
		Scanner ler = new Scanner(System.in);
		BuscaCep bc = new BuscaCep();
		int codigoPostal = codigo;

		// Pega o cep a ser consultado com o usu�rio
		//System.out.printf("Informe o cep que deseja consultar: ");
		//codigoPostal = ler.nextInt(); // 3.1 entrada de dados (lendo um valor inteiro)

		// completa a url com o cep digitado
		String url2 = "https://viacep.com.br/ws/" + codigoPostal + "/json/";

		//System.out.printf("Teste: " + url2);

		// Cria o parse de tratamento
		JSONParser parser = new JSONParser();

		String resposta = "";

		String rua = "";
		String bairro = "";
		String cidade = "";
		String estado = "";
		String cep = "";

		try {
			// montando a url
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
		// System.out.printf("String Builder: \n %s .\n",sb);
		//System.out.printf("Resposta:\n %s \n", resposta);

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
		//System.out.println("Rua: " + rua);
		//System.out.println("Bairro: " + bairro);
		//System.out.println("Cidade: " + cidade);
		//System.out.println("Estado: " + estado);
		//System.out.println("CEP: " + cep);
		bc.setRua(rua);
		bc.setBairro(bairro);
		bc.setCidade(cidade);
		bc.setEstado(estado);
		bc.setCep(cep);
		return bc;
	}
}
