package testeJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;

public class Test {

	public static void main(String args[]) {
		BufferedReader rd;
		StringBuilder sb = new StringBuilder();
		String resposta = "";
		
		try {
			URL url = new URL("https://viacep.com.br/ws/13188010/json/");
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
		System.out.printf("String Builder: \n %s",sb);
		JSONObject jsonObject = new JSONObject();
		
	}
}