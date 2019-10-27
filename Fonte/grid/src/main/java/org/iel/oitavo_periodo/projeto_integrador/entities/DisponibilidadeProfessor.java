package org.iel.oitavo_periodo.projeto_integrador.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.iel.oitavo_periodo.projeto_integrador.enums.DiasEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum;

@Entity
@Table(name = "tab_disponibilidade_professor")
@XmlRootElement
public class DisponibilidadeProfessor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Version
	@Column(name = "version")
	private int version;

	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;

	@Column(length = 4, name = "ano", nullable = false, updatable = false)
	private String ano;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SemestreEnum semestre;

	@ElementCollection(targetClass = DiasEnum.class)
	@CollectionTable(
	        name = "tab_disponibilidade_diasenum", 
	        joinColumns = @JoinColumn(name = "id_disponibilidade")
	)
	@Column(name = "id_dia_enum")
	private List<DiasEnum> diasDisponiveis = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = DiaNaoDisponivel.class)
	private List<DiaNaoDisponivel> diasNaoDisponiveis = new ArrayList<>();
	
	public DisponibilidadeProfessor() {}
	
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
	public List<DiasEnum> getDiasDisponiveis() {
		return diasDisponiveis;
	}
}
