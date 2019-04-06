package teste;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//Classe para testar data formatada.
		Date d = new Date();
		System.out.print(d + "\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(d));
		sdf = new SimpleDateFormat("dd/MM");
		System.out.println(sdf.format(d));
		sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(d));
	}
}
