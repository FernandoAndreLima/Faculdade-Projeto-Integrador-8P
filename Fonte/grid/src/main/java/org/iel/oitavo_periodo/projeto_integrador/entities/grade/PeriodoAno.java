package org.iel.oitavo_periodo.projeto_integrador.entities.grade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.iel.oitavo_periodo.projeto_integrador.enums.Periodo;

@Entity
@Table(name = "tab_grade_horaria")
@XmlRootElement
public class PeriodoAno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Periodo periodo;
	
	@Column(name = "ano")
	private String ano;

	public PeriodoAno(Periodo periodo, String ano) {
		super();
		this.periodo = periodo;
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "PeriodoAno [periodo=" + periodo + ", ano=" + ano + "]";
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}