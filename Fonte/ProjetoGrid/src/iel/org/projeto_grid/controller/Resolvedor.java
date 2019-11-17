package iel.org.projeto_grid.controller;

import java.util.ArrayList;
import java.util.List;

import iel.org.projeto_grid.model.entities.Aula;
import iel.org.projeto_grid.model.entities.GradeHoraria;
import iel.org.projeto_grid.model.entities.Professor;

/**
 * Classe responsável por atribuir um professor a uma disciplina em um dis especifico
 * 
 * @author anderson
 *
 */
public class Resolvedor {
	
	/*
	 * Professores
	 */
	public static List<Professor> professores = new ArrayList<Professor>();

	/**
	 * Método que atribui os professores nas matérias e retorna uma grade
	 * 
	 * @param grade
	 */

	public static GradeHoraria constroiGrade(GradeHoraria grade) {
		/*
		 * Atribui a lista de professores disponiveis a colecao da classe
		 */
		professores.addAll(grade.getProfessores());
		
		/*
		 * Busca o professor que atenda as restrições para cada aula
		 */
		grade.setAulaSegunda(resolveAula(grade.getAulaSegunda()));
		grade.setAulaTerca(resolveAula(grade.getAulaTerca()));
		grade.setAulaQuarta(resolveAula(grade.getAulaQuarta()));
		grade.setAulaQuinta(resolveAula(grade.getAulaQuinta()));
		grade.setAulaSexta(resolveAula(grade.getAulaSexta()));
		
		/*
		 * Retorna a grade
		 */
		return grade;
	}
	
	/**
	 * Método atribui o professor a aula em questão, levando em conta disponibilidade conhecimento da disciplina
	 * @param aula
	 * @return
	 */
	private static Aula resolveAula(Aula aula) {
		/*
		 * boolean do loop do while
		 */
		boolean sair = false;
		/*
		 * Enquanto sair não for verdadeiro continua no loop
		 */
		while (!sair) {
			/*
			 * Forach de profesores
			 */
			loopProfessor: for (Professor professor : professores) {
				/*
				 * Efetua as 2 verificações:
				 * Se o professor conhece a disciplina
				 * Se o professor possui disponibilidade no dia
				 * Caso seja verdadeiro atribui o professor na aula, 
				 * sair recebe true e para o loop dos professores
				 */
				if (professor.conheceDisciplina(aula.getDisciplina())
						&& professor.possuiDisponibilidadeNoDia(aula.getDiasSemana())) {
					aula.setProfessor(professor);
					sair = true;
					break loopProfessor;
				}
			}
		}
		/*
		 * Retorna a aula
		 */
		return aula;
	}
}