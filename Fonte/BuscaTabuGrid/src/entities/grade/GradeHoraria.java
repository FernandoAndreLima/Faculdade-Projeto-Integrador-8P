package entities.grade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	private Set<Aula> aulas = new HashSet<Aula>();

	private List<String> disciplinasNomes = new ArrayList<String>();

	public List<String> getDisciplinasNomes() {
		return disciplinasNomes;
	}

	public void setDisciplinasNomes(List<String> disciplinasNomes) {
		this.disciplinasNomes = disciplinasNomes;
	}

	private boolean todosAulasPreenchidas = false;

	@Override
	public int compareTo(GradeHoraria o) {

		return this.periodoAno == o.periodoAno ? 0 : 1;
	}

	/**
	 * atualiza disponibilidade do professor
	 * 
	 * @param dia
	 * @param professor
	 * @return
	 */
	public void atualizaDisponibilidadeProfessor(DiasEnum dia, Professor professor) {
		if (verificaProfessorNaListagem(professor)) {
			if (professor.getDisponibilidade().verificaDiaEstaDisponivel(dia)) {
				this.professores.remove(professor);
				professor.getDisponibilidade().alteraDiaDisponivelEmDiaAula(dia);
				this.professores.add(professor);
			}
		}
	}

	public void removeDisciplinasDisponiveis(String disc) {
		if (disciplinasNomes.contains(disc))
			disciplinasNomes.remove(disc);
	}

	public boolean verificaProfessorNaListagem(Professor professor) {
		return this.professores.contains(professor);
	}

	public void addProfessorDisciplinaDia(Professor professor, Disciplina disciplina, DiasEnum diasSemana) {
		if (!contemAulaFechada(professor, disciplina, diasSemana)) {
			aulas.add(new Aula(professor, disciplina, diasSemana));
		}
	}

	private boolean contemAulaFechada(Professor professor, Disciplina disciplina, DiasEnum diasSemana) {

		return (aulas.contains(new Aula(professor, disciplina, diasSemana))) ? true : false;
	}

	public Set<Aula> getProfessorDisciplinaDia() {
		return aulas;
	}

	public void setProfessorDisciplinaDia(Set<Aula> professorDisciplinaDia) {
		this.aulas = professorDisciplinaDia;
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
		for (Aula profDiscDia : aulas) {
			if (profDiscDia.isDiasSemana() && profDiscDia.isDiciplina() && profDiscDia.isProfessor()) {
				cont++;
			}
		}
		this.todosAulasPreenchidas = (cont == aulas.size() + 1);
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

		for (Disciplina disciplina : disciplinas) {
			this.disciplinasNomes.add(disciplina.getNome());
		}
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

	public void addProfessorDiciplinaDiaParaColecao(Aula objeto) {
		aulas.add(objeto);
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
		for (Aula elemento : aulas) {
			System.out.println(cont + " " + elemento.toString());
			cont++;
		}
	}

	public void removeProfessor(Professor professor) {
		if (this.professores.contains(professor))
			this.professores.remove(professor);
	}

	public void removeDiaDisponivel(DiasEnum dia) {
		if (this.dias.contains(dia))
			this.dias.remove(dia);
	}
	
	public void addDisciplinaAula(Disciplina disciplina, DiasEnum dia) {
		if(this.dias.contains(dia)) {
			if(this.disciplinas.contains(disciplina)) {
				this.aulas.add(new Aula(disciplina, dia));
				removeDiaDisponivel(dia);
				removeDisciplinasDisponiveis(disciplina.getNome());
			}
		}
	}
}
