package jComboBoxComJComboBox;

public class Cidades {

	public String[] getCidades(String pais) {

		String[] cidades = new String[5];

		if (pais.equals("MG")) {
			cidades[0] = "Belo Horizonte";
			cidades[1] = "Ipatinga";
			cidades[2] = "Juiz de Fora";
			cidades[3] = "Ouro Preto";
			cidades[4] = "Etc";
		} else if (pais.equals("SP")) {

			cidades[0] = "São Paulo";
			cidades[1] = "Ribeirao Preto";
			cidades[2] = "Itu";
			cidades[3] = "Campinas";
			cidades[4] = "Jundiai";

		} else if (pais.equals("RJ")) {

			cidades[0] = "Rio de Janeiro";
			cidades[1] = "Botafogo";
			cidades[2] = "Cabo Frio";
			cidades[3] = "Angra";
			cidades[4] = "Campo Grande";

		}

		return cidades;
	}
}
