package br.com.projeto.Map.exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>();
	// private Set<Aluno> alunos = new TreeSet<>();
	private Set<Aluno> alunos = new HashSet<>();
	// private Set<Aluno> alunos = new LinkedHashSet();
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	// Retornando uma lista nao modificavel(Somente leitura)
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	// M�todo para adicionar aula na Lista
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public int getTempoTotal() {
		int tempoTotal = 0;
		for (Aula aula : aulas) {
			tempoTotal += aula.getTempo();
		}
		return tempoTotal;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Curso: " + nome + ", tempo total : " + getTempoTotal() + ", aulas: " + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		// Adicionando o Aluno ao Map
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) {
		if (!matriculaParaAluno.containsKey(numero))
			throw new NoSuchElementException();
		return matriculaParaAluno.get(numero);
	}
}
