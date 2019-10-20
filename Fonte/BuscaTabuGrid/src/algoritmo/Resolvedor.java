package algoritmo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.Disciplina;
import entities.Professor;
import entities.grade.GradeHoraria;
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

		List<Professor> professores = new ArrayList<Professor>();
		professores.addAll(grade.getProfessores());

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.addAll(grade.getDisciplinas());

		List<DiasEnum> dias = new ArrayList<DiasEnum>();
		dias.addAll(grade.getDias());

		// populo
		for (Iterator<DiasEnum> rator = dias.iterator(); rator.hasNext();) {
			DiasEnum diaAtual = rator.next();
			
			for (Iterator<Disciplina> iter = disciplinas.iterator(); iter.hasNext();) {
				Disciplina disciplinaAtual = iter.next();
				
				if (grade.getDisciplinasNomes().contains(disciplinaAtual.getNome()) && grade.getDias().contains(diaAtual)) {
					grade.addDisciplinaAula(disciplinaAtual, diaAtual);
					System.out.println(disciplinaAtual.toString());
					break;
				}
			}
			
		}
		return grade;
	}

	public static boolean validaDiaProfessor(DiasEnum dia, Professor professor) {

		return professor.getDisponibilidade().getDiasDisponiveis().contains(dia);
	}

	public static boolean professorConheceDisciplina(Professor professor, Disciplina disciplina) {

		return professor.getDisciplinas().contains(disciplina);
	}
}

//
///*
// * foi criado essas variaveis do tipo list, pois o hashset não permite ordenacao
// */
//List<Professor> professores = new ArrayList<Professor>();
//professores.addAll(grade.getProfessores());
//
//List<Disciplina> disciplinas = new ArrayList<Disciplina>();
//disciplinas.addAll(grade.getDisciplinas());
//
//List<DiasEnum> dias = new ArrayList<DiasEnum>();
//dias.addAll(grade.getDias());
//
//for (Iterator<Disciplina> iter = disciplinas.iterator(); iter.hasNext();) {
//	Disciplina disciplinaAtual = iter.next();
//	System.out.println(disciplinaAtual.toString());
//}
//
///*
// * Primeiro loop o de disciplinas
// */
//DisciplinaLoop: for (Disciplina disciplina : disciplinas) {
//
//	if (grade.getDisciplinasNomes().contains(disciplina.getNome())) {
//
//		/*
//		 * Segundo loop o de professores
//		 */
//		ProfessorLoop: for (Professor professor : professores) {
//			/*
//			 * Terceiro loop o de dias
//			 */
//			DiasLoop: for (DiasEnum dia : dias) {
//
//				if (validaDiaProfessor(dia, professor)) {
//
//					if (professorConheceDisciplina(professor, disciplina)) {
//						grade.addProfessorDisciplinaDia(professor, disciplina, dia);
//						grade.atualizaDisponibilidadeProfessor(dia, professor);
//						grade.removeDisciplinasDisponiveis(disciplina.getNome());
//
//					}
//				}
//			}
//		}
//	}
//}
//grade.professorDisciplinaDiaToString();
//
//return grade;
