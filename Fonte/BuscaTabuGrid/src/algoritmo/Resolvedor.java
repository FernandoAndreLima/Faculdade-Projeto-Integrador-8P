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
	public Set<GradeHoraria> grades = new HashSet<GradeHoraria>();

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
					if (validaDiaProfessor(dia, professor)) {

						if (professorConheceDisciplina(professor, disciplina)) {
							grade.addProfessorDisciplinaDia(professor, disciplina, dia);
						}
					}
				}
			}
		}
		grade.professorDisciplinaDiaToString();
	}
	
	public boolean finalizaGrade(GradeHoraria grade){
		
		if(!grade.isEmpty()) {
			for (GradeHoraria g : grade) {
				if(g.)
			}
		}		
		return false;
	}
	
	public static boolean validaDiaProfessor(DiasEnum dia, Professor professor) {
			
		return professor.getDisponibilidade().getDiasDisponiveis().contains(dia);
	}
	
	public static boolean professorConheceDisciplina(Professor professor, Disciplina disciplina){
		
		return professor.getDisciplinas().contains(disciplina);
	}
}

