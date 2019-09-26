package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import enums.SemestreEnum;

public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private String ano;

	private SemestreEnum semestre;

	private Set<Disciplina> disciplinas = new HashSet<>();

	private Curso curso;

	private Set<Professor> professores = new HashSet<>();

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
		if (!(obj instanceof Turma)) {
			return false;
		}
		Turma other = (Turma) obj;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public SemestreEnum getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreEnum semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (ano != null && !ano.trim().isEmpty())
			result += ", ano: " + ano;
		if (semestre != null)
			result += ", semestre: " + semestre;
		return result;
	}
}