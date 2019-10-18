package algoritmo;

import java.util.HashSet;
import java.util.Set;

import entities.Disciplina;
import entities.GradeHoraria;
import entities.Professor;
import enums.DiasEnum;

/**
 * Classe responsável por conter as regras para criar uma grade horária
 * @author anderson
 *
 */
public class Resolvedor {

	/*
	 * Variáveis públicas da classe
	 */
	public Set<Professor> professoresDisponiveis = new HashSet<Professor>();
	public Set<Disciplina> disciplinasDisponiveis = new HashSet<Disciplina>();
	public Set<GradeHoraria> grade = new HashSet<GradeHoraria>();

	/*
	 * Construtor
	 */
	public Resolvedor(Set<Professor> professoresDisponiveis, Set<Disciplina> disciplinasDisponiveis) {
		this.professoresDisponiveis.addAll(professoresDisponiveis);
		this.disciplinasDisponiveis.addAll(disciplinasDisponiveis);
	}

	/**
	 * Método que gera a grade
	 * @param grade
	 */
	public void constroiGrade(GradeHoraria grade) {
		/*
		 * Primeiro loop o de disciplinas
		 */
		for (Disciplina disciplina : grade.getDisciplinas()) {
			/*
			 * Segundo loop o de professores
			 */
			for (Professor professor : grade.getProfessores()) {
				/*
				 * Terceiro loop o de dias
				 */
				for (DiasEnum dia : grade.getDias()) {
					
					if (professor.possuiDisponibilidadeNoDia(dia)) {

						if (professor.conheceDisciplina(disciplina)) {
							System.out.println(professor.toString());
							grade.addProfessorDisciplinaDia(professor, disciplina, dia);
						}
					}
				}
			}
		}
	}
}
