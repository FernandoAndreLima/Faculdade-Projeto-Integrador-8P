package entities.grade;

import java.util.HashSet;
import java.util.Set;

import entities.Disciplina;
import entities.Professor;
import enums.DiasEnum;
import enums.Periodo;

/**
 * Objeto Grade Horária por periodo/turma
 * 
 * @author anderson
 *
 */
public class GradeHoraria implements Comparable<GradeHoraria> {
	private PeriodoAno periodoAno;

	private Set<Professor> professores = new HashSet<Professor>();

	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	private Set<DiasEnum> dias = new HashSet<DiasEnum>();

	private Set<ProfessorDiciplinaDia> professorDisciplinaDia = new HashSet<ProfessorDiciplinaDia>();

	private boolean todosAulasPreenchidas = false;

	@Override
	public int compareTo(GradeHoraria o) {

		return this.periodoAno == o.periodoAno ? 0 : 1;
	}

	/**
	 * atualiza disponibilidade do professor
	 * @param dia
	 * @param professor
	 * @return
	 */
	public boolean atualizaDisponibilidadeProfessor(DiasEnum dia, Professor professor) {
		if (verificaProfessorNaListagem(professor) && (professor.getDisponibilidade().verificaDiaEstaDisponivel(dia))) {
			professor.getDisponibilidade().alteraDiaDisponivelEmDiaAula(dia);
			return true;
		} else {
			return false;
		}
	}

	public boolean verificaProfessorNaListagem(Professor professor) {
		return this.professores.contains(professor);
	}

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
