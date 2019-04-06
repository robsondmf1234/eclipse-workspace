import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;

//import org.jsoup.Jsoup;

public class Principal {

	private static final String URL_STR = "http://sistemasinter.cetesb.sp.gov.br/produtos/ficha_completa1.asp?consulta=ACETONITRILA";

	public static void main(String[] args) {
		HttpURLConnection con = null;
		try {
			URL url = new URL(URL_STR);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();

			switch (con.getResponseCode()) {
			case 200:
				System.out.println("Encontrou algo");
				System.out.println(getHtml(url));
				
				//inicializar objeto para parse com a string do html usando o Jsoup
	//			Document doc = Jsoup.parse(getHtml(url));
				//selecionar todas as tabelas do html
	//			Elements tabelas = doc.select("table");
				break;
			case 500:
				System.out.println("Não Encontrou");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.disconnect();
		}

	}

	public static String getHtml(URL url) {
		if (url == null)
			throw new RuntimeException("URL é null");

		String html = null;
		StringBuilder sB = new StringBuilder();
		try (BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()))) {
			while ((html = bR.readLine()) != null)
				sB.append(html);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sB.toString();
	}

}