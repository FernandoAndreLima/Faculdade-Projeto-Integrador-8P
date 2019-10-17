package algoritmo;

import java.util.HashSet;
import java.util.Set;

import entities.Disciplina;
import entities.GradeHoraria;
import entities.Professor;
import enums.DiasEnum;

public class Resolvedor {

	public Set<Professor> professoresDisponiveis = new HashSet<Professor>();
	public Set<Disciplina> disciplinasDisponiveis = new HashSet<Disciplina>();

	public Set<GradeHoraria> grade = new HashSet<GradeHoraria>();

	public Resolvedor(Set<Professor> professoresDisponiveis, Set<Disciplina> disciplinasDisponiveis) {
		this.professoresDisponiveis.addAll(professoresDisponiveis);
		this.disciplinasDisponiveis.addAll(disciplinasDisponiveis);
	}

	public void constroiGrade(GradeHoraria grade) {
		for (Disciplina disciplina : grade.getDisciplinas()) {
			for (Professor professor : grade.getProfessores()) {
				for (DiasEnum dia : grade.getDias()) {

					if (professor.possuiDisponibilidadeNoDia(dia)) {

						if (professor.conheceDisciplina(disciplina)) {
							grade.addProfessorDisciplinaDia(professor, disciplina, dia);
						}
					}
				}
			}
		}
	}
}
