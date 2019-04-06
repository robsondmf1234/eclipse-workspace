package br.com.projeto;

import java.io.Serializable;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	//Versao ID da classe
	private static final long serialVersionUID = 7727668067740964488L;
	private String nome;
	private String cpf;
	private String profissao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
