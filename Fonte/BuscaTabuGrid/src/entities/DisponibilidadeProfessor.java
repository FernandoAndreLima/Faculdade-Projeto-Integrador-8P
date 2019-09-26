package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import enums.DiasEnum;
import enums.SemestreEnum;

public class DisponibilidadeProfessor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private Professor professor;

	private String ano;

	private SemestreEnum semestre;

	private Set<DiasEnum> diasDisponiveis = new HashSet<>();

	private Set<DiaNaoDisponivel> diasNaoDisponiveis = new HashSet<>();

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DisponibilidadeProfessor)) {
			return false;
		}
		DisponibilidadeProfessor other = (DisponibilidadeProfessor) obj;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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
		if (professor != null)
			result += ", professor: " + professor;
		if (ano != null && !ano.trim().isEmpty())
			result += ", ano: " + ano;
		if (semestre != null)
			result += ", semestre: " + semestre;
		return result;
	}
}
