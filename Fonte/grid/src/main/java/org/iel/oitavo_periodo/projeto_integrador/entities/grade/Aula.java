package org.iel.oitavo_periodo.projeto_integrador.entities.grade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.iel.oitavo_periodo.projeto_integrador.entities.Disciplina;
import org.iel.oitavo_periodo.projeto_integrador.entities.Professor;
import org.iel.oitavo_periodo.projeto_integrador.enums.DiasEnum;

@Entity
@Table(name = "tab_aula")
@XmlRootElement
public class Aula implements Comparable<Aula>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	private Disciplina disciplina;
	private DiasEnum diasSemana;

	private boolean diaPreenchido = false;

	public boolean contemDisciplina(Disciplina dis) {
		return this.disciplina.equals(dis);
	}
	@Override
	public String toString() {
		return "Aula do dia [professor=" + professor.getNomeCompleto() + ",\t\t disciplina=" + disciplina.getNome()
				+ ",\t\t diasSemana=" + diasSemana.toString() + "]";
	}

	public Aula(Professor professor, Disciplina disciplina, DiasEnum diasSemana) {
		this.professor = professor;
		this.disciplina = disciplina;
		this.diasSemana = diasSemana;
		setDiaPreenchido(validaDiaPreenchido());
	}

	public Aula(Disciplina disciplina, DiasEnum diasSemana) {
		this.disciplina = disciplina;
		this.diasSemana = diasSemana;
		setDiaPreenchido(validaDiaPreenchido());
	}
	
	public boolean validaDiaPreenchido() {
		return (this.disciplina.contemDisciplina()
				&& this.diasSemana.ordinal() > 0);
	}

	public boolean isProfessor() {
		return this.professor.contemProfessor();
	}

	public boolean isDiciplina() {
		return this.disciplina.contemDisciplina();
	}

	public boolean isDiasSemana() {
		return this.diasSemana.ordinal() > 0 ? true : false;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public DiasEnum getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(DiasEnum diasSemana) {
		this.diasSemana = diasSemana;
	}

	public boolean isDiaPreenchido() {
		return diaPreenchido;
	}

	public void setDiaPreenchido(boolean diaPreenchido) {
		this.diaPreenchido = diaPreenchido;
	}

	@Override
	public int compareTo(Aula o) {
		return 0;
	}
	public boolean contemProfessor() {
		return professor.contemProfessor();
	}
}
