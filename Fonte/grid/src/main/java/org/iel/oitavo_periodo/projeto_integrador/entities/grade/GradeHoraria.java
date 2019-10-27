package org.iel.oitavo_periodo.projeto_integrador.entities.grade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.iel.oitavo_periodo.projeto_integrador.entities.Disciplina;
import org.iel.oitavo_periodo.projeto_integrador.entities.Professor;
import org.iel.oitavo_periodo.projeto_integrador.enums.DiasEnum;

/**
 * Objeto Grade Horária por periodo/turma
 * 
 * @author anderson
 *
 */
@Entity
@Table(name = "tab_grade_horaria")
@XmlRootElement
public class GradeHoraria {
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gradeHoraria")
	private PeriodoAno periodoAno;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gradeHoraria")
	private Aula aulaSegunda;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gradeHoraria")
	private Aula aulaTerca;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gradeHoraria")
	private Aula aulaQuarta;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gradeHoraria")
	private Aula aulaQuinta;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "gradeHoraria")
	private Aula aulaSexta;

	private List<Professor> professores = new ArrayList<Professor>();

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	private List<Disciplina> listaTabu = new ArrayList<Disciplina>();

	public GradeHoraria(PeriodoAno periodoAnoInformado, List<Professor> professoresInformados,
			List<Disciplina> disciplinasInformadas) {

		this.periodoAno = periodoAnoInformado;
		this.professores.addAll(professoresInformados);
		this.disciplinas.addAll(disciplinasInformadas);

		this.aulaSegunda = new Aula(buscaDisciplina(), DiasEnum.SEGUNDA_FEIRA);
		this.aulaTerca = new Aula(buscaDisciplina(), DiasEnum.TERCA_FEIRA);
		this.aulaQuarta = new Aula(buscaDisciplina(), DiasEnum.QUARTA_FEIRA);
		this.aulaQuinta = new Aula(buscaDisciplina(), DiasEnum.QUINTA_FEIRA);
		this.aulaSexta = new Aula(buscaDisciplina(), DiasEnum.SEXTA_FEIRA);

	}
	
	public GradeHoraria() {}

	private Disciplina buscaDisciplina() {
		Disciplina retorno = new Disciplina();
		boolean sair = false;
		while (!sair) {
			loopDisciplina: for (Disciplina disciplinaAtual : disciplinas) {
				if (!listaTabu.contains(disciplinaAtual)) {
					retorno = disciplinaAtual;
					listaTabu.add(disciplinaAtual);
					sair = true;
					break loopDisciplina;
				}
			}
		}
		return retorno;
	}
	
	public PeriodoAno getPeriodoAno() {
		return periodoAno;
	}

	public void setPeriodoAno(PeriodoAno periodoAno) {
		this.periodoAno = periodoAno;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getListaTabu() {
		return listaTabu;
	}

	public void setListaTabu(List<Disciplina> listaTabu) {
		this.listaTabu = listaTabu;
	}



	public Aula getAulaSegunda() {
		return aulaSegunda;
	}

	public void setAulaSegunda(Aula aulaSegunda) {
		this.aulaSegunda = aulaSegunda;
	}

	public Aula getAulaTerca() {
		return aulaTerca;
	}

	public void setAulaTerca(Aula aulaTerca) {
		this.aulaTerca = aulaTerca;
	}

	public Aula getAulaQuarta() {
		return aulaQuarta;
	}

	public void setAulaQuarta(Aula aulaQuarta) {
		this.aulaQuarta = aulaQuarta;
	}

	public Aula getAulaQuinta() {
		return aulaQuinta;
	}

	public void setAulaQuinta(Aula aulaQuinta) {
		this.aulaQuinta = aulaQuinta;
	}

	public Aula getAulaSexta() {
		return aulaSexta;
	}

	public void setAulaSexta(Aula aulaSexta) {
		this.aulaSexta = aulaSexta;
	}

	@Override
	public String toString() {
		return "GradeHoraria [periodoAno=" + periodoAno + ", \naulaSegunda=" + aulaSegunda + ", \naulaTerca=" + aulaTerca
				+ ", \naulaQuarta=" + aulaQuarta + ", \naulaQuinta=" + aulaQuinta + ", \naulaSexta=" + aulaSexta + "]";
	}
	
}
