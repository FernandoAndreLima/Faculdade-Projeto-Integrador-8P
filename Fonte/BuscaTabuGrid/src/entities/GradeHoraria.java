package entities;

import java.util.HashSet;
import java.util.Set;

import enums.SemestreEnum;

public class GradeHoraria {

	private SemestreEnum semestre;
	private Set<Professor> professores = new HashSet<Professor>();
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();
//	private Set<GradeAulaDia> turmaA = new HashSet<GradeAulaDia>();
//	private Set<GradeAulaDia> turmaB = new HashSet<GradeAulaDia>();
//	private Set<GradeAulaDia> turmaC = new HashSet<GradeAulaDia>();
//	private Set<GradeAulaDia> turmaD = new HashSet<GradeAulaDia>();
	
	public GradeHoraria(SemestreEnum semestre,Set<Professor> professores, Set<Disciplina> disciplinas) {
		
		this.semestre = semestre;
		this.professores.addAll(professores);
		this.disciplinas.addAll(disciplinas);
		
	}
	
	
}
