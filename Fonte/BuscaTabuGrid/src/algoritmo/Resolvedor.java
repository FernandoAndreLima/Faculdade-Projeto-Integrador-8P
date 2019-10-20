package algoritmo;

import java.util.ArrayList;
import java.util.List;

import entities.Disciplina;
import entities.Professor;
import entities.grade.GradeHoraria;
import entities.grade.Aula;
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
		 * foi criado essas variaveis do tipo list, pois o hashset não permite ordenacao
		 */
		List<Professor> professores = new ArrayList<Professor>();
		professores.addAll(grade.getProfessores());

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.addAll(grade.getDisciplinas());

		List<DiasEnum> dias = new ArrayList<DiasEnum>();
		dias.addAll(grade.getDias());

		while (true) {

			/*
			 * Primeiro loop o de disciplinas
			 */
			DisciplinaLoop: for (Disciplina disciplina : disciplinas) {

				if (grade.getDisciplinasNomes().contains(disciplina.getNome())) {

					/*
					 * Segundo loop o de professores
					 */
					ProfessorLoop: for (Professor professor : professores) {
						/*
						 * Terceiro loop o de dias
						 */
						DiasLoop: for (DiasEnum dia : dias) {

							if (validaDiaProfessor(dia, professor)) {

								if (professorConheceDisciplina(professor, disciplina)) {
									grade.addProfessorDisciplinaDia(professor, disciplina, dia);
									grade.atualizaDisponibilidadeProfessor(dia, professor);
									grade.removeDisciplinasDisponiveis(disciplina.getNome());

								}
							}
						}
					}
				}
			}
			grade.professorDisciplinaDiaToString();
			
			break;
		}
		return grade;
	}

	private static GradeHoraria removeExcessos(GradeHoraria grade) {

		return grade;
	}

	public static GradeHoraria finalizaGrade(GradeHoraria grade, int qtdaAulas) {

		ProfessorDiciplinaDiaLoop:

		for (Aula gradeDia : grade.getProfessorDisciplinaDia()) {

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
