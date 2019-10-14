import java.util.HashSet;
import java.util.Set;

import dao.BancoDao;
import entities.Curso;
import entities.Disciplina;
import entities.GradeAulaDia;
import entities.GradeHoraria;
import entities.Professor;
import enums.SemestreEnum;

public class Main {

	public static void main(String[] args) {
		BancoDao dao = new BancoDao();

		dao.generateData();
		
		Set<Professor> professores = new HashSet<>();
		Set<Disciplina> disciplinas = new HashSet<>();
		Set<Curso> cursos = new HashSet<>();
		
		professores.addAll(dao.getProfessores());
		disciplinas.addAll(dao.getDisciplinas());
		cursos.addAll(dao.getCursos());
		
		System.out.println(professores.isEmpty());
		
		 GradeHoraria grade = new GradeHoraria(SemestreEnum.primeiro, professores, disciplinas);
	}
}
