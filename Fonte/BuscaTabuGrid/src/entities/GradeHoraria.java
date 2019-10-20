package entities;

import java.util.HashSet;
import java.util.Set;

import enums.DiasEnum;
import enums.Periodo;

/**
 * Objeto Grade Horária por periodo/turma
 * 
 * @author anderson
 *
 */
public class GradeHoraria {
	private PeriodoAno periodoAno;

	private Set<Professor> professores = new HashSet<Professor>();

	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	private Set<DiasEnum> dias = new HashSet<DiasEnum>();

	private Set<ProfessorDiciplinaDia> professorDisciplinaDia = new HashSet<ProfessorDiciplinaDia>();

	private boolean todosAulasPreenchidas = false;

	public void addProfessorDisciplinaDia(Professor professor, Disciplina disciplina, DiasEnum diasSemana) {
		professorDisciplinaDia.add(new ProfessorDiciplinaDia(professor, disciplina, diasSemana));
	}

	public Set<ProfessorDiciplinaDia> getProfessorDisciplinaDia() {
		return professorDisciplinaDia;
	}

	public void setProfessorDisciplinaDia(Set<ProfessorDiciplinaDia> professorDisciplinaDia) {
		this.professorDisciplinaDia = professorDisciplinaDia;
	}

	public boolean isTodosAulasPreenchidas() {
		return todosAulasPreenchidas;
	}

	public void setTodosAulasPreenchidas(boolean todosAulasPreenchidas) {
		this.todosAulasPreenchidas = todosAulasPreenchidas;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public boolean isTodasAulasPreenchidas() {
		return todosAulasPreenchidas;
	}

	public void setDias(Set<DiasEnum> dias) {
		this.dias = dias;
	}

	public void verificaTodasEstaoAulasPreenchidas() {
		int cont = 0;
		for (ProfessorDiciplinaDia profDiscDia : professorDisciplinaDia) {
			if (profDiscDia.isDiasSemana() && profDiscDia.isDiciplina() && profDiscDia.isProfessor()) {
				cont++;
			}
		}
		this.todosAulasPreenchidas = (cont == professorDisciplinaDia.size() + 1);
	}

	public GradeHoraria(Periodo periodo, String ano, Set<Professor> professores, Set<Disciplina> disciplinas) {

		this.periodoAno = new PeriodoAno(periodo, ano);
		addAllProfessores(professores);
		addAllDisciplina(disciplinas);
		dias.add(DiasEnum.SEGUNDA_FEIRA);
		dias.add(DiasEnum.TERCA_FEIRA);
		dias.add(DiasEnum.QUARTA_FEIRA);
		dias.add(DiasEnum.QUINTA_FEIRA);
		dias.add(DiasEnum.SEXTA_FEIRA);
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

	public void addAllDisciplina(Set<Disciplina> disciplinasEntrada) {
		disciplinas.addAll(disciplinasEntrada);
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void addProfessorDiciplinaDiaParaColecao(ProfessorDiciplinaDia objeto) {
		professorDisciplinaDia.add(objeto);
	}

	public PeriodoAno getPeriodoAno() {
		return periodoAno;
	}

	public void setPeriodoAno(PeriodoAno periodoAno) {
		this.periodoAno = periodoAno;
	}

	public Set<DiasEnum> getDias() {
		return this.dias;
	}

	public void professorDisciplinaDiaToString() {
		int cont = 1;
		for (ProfessorDiciplinaDia elemento : professorDisciplinaDia) {
			System.out.println(cont + " " + elemento.toString());
			cont++;
		}
	}
	
	public void removeProfessor(Professor professor) {
		if (this.professores.contains(professor))
			this.professores.remove(professor);
	}
	
	public void removeDisciplinaListaDisponivel(Disciplina disciplina) {
		if (this.disciplinas.contains(disciplina))
			this.disciplinas.remove(disciplina);
	}

	public void removeDiaDisponivel(DiasEnum dia) {
		if (this.dias.contains(dia))
			this.dias.remove(dia);
	}
}

class ProfessorDiciplinaDia {
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

	public ProfessorDiciplinaDia(Professor professor, Disciplina disciplina, DiasEnum diasSemana) {
		this.professor = professor;
		this.disciplina = disciplina;
		this.diasSemana = diasSemana;
		setDiaPreenchido(validaDiaPreenchido());
	}

	public boolean validaDiaPreenchido() {
		return (this.professor.contemProfessor() && this.disciplina.contemDisciplina()
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
}

class PeriodoAno {
	private Periodo periodo;
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