package entities;

import java.util.HashSet;
import java.util.Set;

import enums.DiasEnum;
import enums.Periodo;

public class GradeHoraria {
	PeriodoAno periodoAno;

	private Set<Professor> professores = new HashSet<Professor>();
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	Set<ProfessorDiciplinaDia> professorDiciplinaDia = new HashSet<ProfessorDiciplinaDia>();

	public GradeHoraria(PeriodoAno periodoAno, Set<Professor> professores, Set<Disciplina> disciplinas) {
		this.periodoAno = periodoAno;
		addAllProfessores(professores);
		addAllDisciplina(disciplinas);
	}

	public void addProfessore(Professor professor) {
		professores.add(professor);
	}

	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	
	public void addAllProfessores(Set<Professor> professoresEntrada) {
		professores.addAll(professoresEntrada);
	}
	
	public void addAllDisciplina(Set<Disciplina> disciplinas) {
		disciplinas.addAll(disciplinas);
	}
	
	public Set<Professor> getProfessores() {
		return professores;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void addProfessorDiciplinaDiaParaColecao(ProfessorDiciplinaDia objeto) {
		professorDiciplinaDia.add(objeto);
	}

	public PeriodoAno getPeriodoAno() {
		return periodoAno;
	}

	public void setPeriodoAno(PeriodoAno periodoAno) {
		this.periodoAno = periodoAno;
	}
}

class ProfessorDiciplinaDia {
	private Professor professor;
	private Disciplina disciplina;
	private DiasEnum diasSemana;

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

}

class PeriodoAno {
	private Periodo periodo;
	private String ano;

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