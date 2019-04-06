package teste;

public class Main {

	public static void main(String[] args) {
		
		int pesomaximo =100;
		int capacidade = 3;
		int [] pacotes = {10,20,30,40};
		int pesoTemp=0;
			
		int i=0;
		while (pesoTemp<pesomaximo) {
			pesoTemp+=pacotes[i];
			i++;
		}
		
		
		
		System.out.println(pesoTemp);
	}

}
