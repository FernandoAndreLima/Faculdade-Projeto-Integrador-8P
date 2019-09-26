package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;

	private int version;

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	private String nome;

	private String descricao;

	private String tempoDuracao;

	private Set<Disciplina> disciplinas = new HashSet<>();
	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Curso)) {
			return false;
		}
		Curso other = (Curso) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(String tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		if (descricao != null && !descricao.trim().isEmpty())
			result += ", descricao: " + descricao;
		if (tempoDuracao != null && !tempoDuracao.trim().isEmpty())
			result += ", tempoDuracao: " + tempoDuracao;
		return result;
	}
}