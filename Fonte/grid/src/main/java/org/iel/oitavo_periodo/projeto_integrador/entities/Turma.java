package org.iel.oitavo_periodo.projeto_integrador.entities;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import org.iel.oitavo_periodo.projeto_integrador.entities.Curso;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "tab-turma")
@XmlRootElement
public class Turma implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 4, name = "ano", nullable = false, updatable = false)
	private String ano;

	@Enumerated(EnumType.STRING)
	private SemestreEnum semestre;

	@OneToMany
	private Set<Curso> curso = new HashSet<Curso>();

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

	public Set<Curso> getCurso() {
		return this.curso;
	}

	public void setCurso(final Set<Curso> curso) {
		this.curso = curso;
	}
}