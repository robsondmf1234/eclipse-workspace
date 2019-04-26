package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();

	//Bloco opcional, utilizado para a classe já inicializar com 2 empresas cadastradas.
	
	/*
	 * static { Empresa empresa = new Empresa(); empresa.setNome("Amazon"); Empresa
	 * empresa2 = new Empresa(); empresa2.setNome("Google"); lista.add(empresa);
	 * lista.add(empresa2); }
	 */
	
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
		System.out.println(getEmpresas());
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
