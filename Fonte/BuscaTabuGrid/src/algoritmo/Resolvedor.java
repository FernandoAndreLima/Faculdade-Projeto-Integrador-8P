package algoritmo;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Iterator;
import java.util.List;
import java.util.Random;
>>>>>>> 1a7d953f1541b29276816d40d1157048b3b12ee8

import entities.Disciplina;
import entities.Professor;
import entities.grade.Aula;
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

		List<Professor> listaTabu = new ArrayList<Professor>();
		int contTabu = 0;
		Random gerador = new Random();

		/*
		 * Variaveis para fazer os loops
		 */
		List<Professor> professores = new ArrayList<Professor>();
		professores.addAll(grade.getProfessores());

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.addAll(grade.getDisciplinas());

		List<DiasEnum> dias = new ArrayList<DiasEnum>();
		dias.addAll(grade.getDias());

		/*
		 * Loop 1 rodo um loop dos dias
		 */
		for (Iterator<DiasEnum> rator = dias.iterator(); rator.hasNext();) {
			DiasEnum diaAtual = rator.next();

			/*
			 * Loop 2 rodo um loop das disciplinas
			 */
			for (Iterator<Disciplina> iter = disciplinas.iterator(); iter.hasNext();) {
				Disciplina disciplinaAtual = iter.next();

				/*
				 * Verifico se a disciplina atual está dentro da lista da grade e se o dia atual
				 * está disponivel
				 */
				if (grade.getDisciplinasNomes().contains(disciplinaAtual.getNome())
						&& grade.getDias().contains(diaAtual)) {
					grade.addDisciplinaAula(disciplinaAtual, diaAtual);
					System.out.println(diaAtual + " " + disciplinaAtual.toString());
					break;
				}
			}

		}

		List<Aula> aulasCadastradas = new ArrayList<Aula>();
		aulasCadastradas.addAll(grade.getProfessorDisciplinaDia());
		System.out.println(" ");
		List<Aula> aulaInterada = new ArrayList<Aula>();
		
		for (Aula aula : aulasCadastradas) {
			aula.setProfessor(professores.get(gerador.nextInt(professores.size()-1)));
			if(aula.getProfessor().conheceDisciplina(aula.getDisciplina()) && aula.getProfessor().possuiDisponibilidadeNoDia(aula.getDiasSemana())){
				aulaInterada.add(aula);
			}
		}


		grade.getProfessorDisciplinaDia().clear();
		grade.getProfessorDisciplinaDia().addAll(aulaInterada);
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


//for (Iterator<Aula> iterator = aulasCadastradas.iterator(); iterator.hasNext();) {
//	Aula aulaAtual = iterator.next();
//	
//	for (Iterator<Professor> iteratorProfessor = professores.iterator(); iteratorProfessor.hasNext();) {
//		Professor professorAtual = iteratorProfessor.next();
//
//		if (professorAtual.conheceDisciplina(aulaAtual.getDisciplina())
//				&& professorAtual.possuiDisponibilidadeNoDia(aulaAtual.getDiasSemana())) {
//
//			if (!listaTabu.contains(professorAtual)) {
//
//				aulaAtual.setProfessor(professorAtual);
//				grade.atualizaDisponibilidadeProfessor(aulaAtual.getDiasSemana(), professorAtual);
////				grade.removeDisciplinasDisponiveis(aulaAtual.getDisciplina().getNome());
//				aulaInterada.add(aulaAtual);
//				listaTabu.add(professorAtual);
//				System.out.println(aulaAtual.toString());
//				contTabu++;
//
//			}
//		}
//		if (contTabu > 1) {
//			contTabu = 0;
//			listaTabu.remove(gerador.nextInt(1));
//		}
//	}
//}
