package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private String nome;

	private String descricao;

	private String cargaHoraria;

	private Set<Curso> cursos = new HashSet<>();

	private Set<Professor> professores = new HashSet<>();

	public void addProfessor(Professor professor) {
		professores.add(professor);
	}

	public void addCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
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
		if (!(obj instanceof Disciplina)) {
			return false;
		}
		Disciplina other = (Disciplina) obj;
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

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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
		if (cargaHoraria != null && !cargaHoraria.trim().isEmpty())
			result += ", cargaHoraria: " + cargaHoraria;
		return result;
	}
}