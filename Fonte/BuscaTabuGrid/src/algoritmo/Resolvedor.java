package algoritmo;

import java.util.HashSet;
import java.util.Set;

import entities.Disciplina;
import entities.Professor;
import entities.grade.GradeHoraria;
import entities.grade.ProfessorDiciplinaDia;
import enums.DiasEnum;

/**
 * Classe responsável por conter as regras para criar uma grade horária
 * 
 * @author anderson
 *
 */
public class Resolvedor {

	/**
	 * Método que gera a grade
	 * 
	 * @param grade
	 */
	public static GradeHoraria constroiGrade(GradeHoraria grade) {
		/*
		 * Primeiro loop o de disciplinas
		 */
		DisciplinaLoop: for (Disciplina disciplina : grade.getDisciplinas()) {
			/*
			 * Segundo loop o de professores
			 */
			ProfessorLoop: for (Professor professor : grade.getProfessores()) {
				/*
				 * Terceiro loop o de dias
				 */
				DiasLoop: for (DiasEnum dia : grade.getDias()) {

					if (validaDiaProfessor(dia, professor)) {

						if (professorConheceDisciplina(professor, disciplina)) {
							grade.addProfessorDisciplinaDia(professor, disciplina, dia);
							grade.atualizaDisponibilidadeProfessor(dia, professor);
							
						}
					}
				}
			}
		}
		grade.professorDisciplinaDiaToString();
		return grade;
	}

	private static GradeHoraria removeExcessos(GradeHoraria grade) {
		
		
		return grade;
	}
	
	public static GradeHoraria finalizaGrade(GradeHoraria grade, int qtdaAulas) {

		ProfessorDiciplinaDiaLoop:

		for (ProfessorDiciplinaDia gradeDia : grade.getProfessorDisciplinaDia()) {

			if (qtdaAulas == grade.getProfessorDisciplinaDia().size() + 1) {
				break ProfessorDiciplinaDiaLoop;
			}
		}

		grade.professorDisciplinaDiaToString();

		return grade;
	}

	public static boolean validaDiaProfessor(DiasEnum dia, Professor professor) {

		return professor.getDisponibilidade().getDiasDisponiveis().contains(dia);
	}

	public static boolean professorConheceDisciplina(Professor professor, Disciplina disciplina) {

		return professor.getDisciplinas().contains(disciplina);
	}
}
