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

	/**
	 * Método que gera a grade
	 * @param grade
	 */
	public static GradeHoraria constroiGrade(GradeHoraria grade) {
		/*
		 * Primeiro loop o de disciplinas
		 */
		DisciplinaLoop:
		for (Disciplina disciplina : grade.getDisciplinas()) {
			/*
			 * Segundo loop o de professores
			 */
			ProfessorLoop:
			for (Professor professor : grade.getProfessores()) {
				/*
				 * Terceiro loop o de dias
				 */
				DiasLoop:
				for (DiasEnum dia : grade.getDias()) {
					
					if (validaDiaProfessor(dia, professor)) {

						if (professorConheceDisciplina(professor, disciplina)) {
							grade.addProfessorDisciplinaDia(professor, disciplina, dia);
							grade.removeProfessor(professor);
							grade.removeDisciplinaListaDisponivel(disciplina);
							grade.removeDiaDisponivel(dia);
							break DisciplinaLoop;
						}
					}
				}
			}
		}
		grade.professorDisciplinaDiaToString();
		return grade;
	}
	
//	public boolean finalizaGrade(GradeHoraria grade){
//		
////		if() {
////			for (GradeHoraria g : grade) {
////				if(g.)
////			}
////		}		
////		return false;
//	}
	
	public static boolean validaDiaProfessor(DiasEnum dia, Professor professor) {
			
		return professor.getDisponibilidade().getDiasDisponiveis().contains(dia);
	}
	
	public static boolean professorConheceDisciplina(Professor professor, Disciplina disciplina){
		
		return professor.getDisciplinas().contains(disciplina);
	}
}

