import java.util.HashSet;
import java.util.Set;

import algoritmo.Resolvedor;
import dao.BancoDao;
import entities.Curso;
import entities.Disciplina;
import entities.GradeHoraria;
import entities.Professor;
import enums.Periodo;

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

		GradeHoraria grade = new GradeHoraria(Periodo.PRIMEIRO, "2019", professores, disciplinas);
		Resolvedor resolve = new Resolvedor(professores, disciplinas);
		resolve.constroiGrade(grade);
		System.out.println(resolve.grade);
	}
}
