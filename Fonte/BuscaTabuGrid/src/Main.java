import java.util.HashSet;
import java.util.Set;

import algoritmo.Resolvedor;
import dao.BancoDao;
import entities.Curso;
import entities.Disciplina;
import entities.Professor;
import entities.grade.GradeHoraria;
import enums.Periodo;

public class Main {

	public static void main(String[] args) {
		BancoDao dao = new BancoDao();

		dao.generateData();

		Set<Professor> professores = new HashSet<>();
		
		Set<Disciplina> disciplinasPrimeiro = new HashSet<>();
		Set<Disciplina> disciplinasSegundo = new HashSet<>();
//		Set<Disciplina> disciplinasTerceiro = new HashSet<>();
//		Set<Disciplina> disciplinasQuarto = new HashSet<>();
//		Set<Disciplina> disciplinasQuinto = new HashSet<>();
//		Set<Disciplina> disciplinasSexto = new HashSet<>();
//		Set<Disciplina> disciplinasSetimo = new HashSet<>();
//		Set<Disciplina> disciplinasOitavo = new HashSet<>();
		
		Set<Curso> cursos = new HashSet<>();

		professores.addAll(dao.getProfessores());
		disciplinasPrimeiro.addAll(dao.getDisciplinas());
		cursos.addAll(dao.getCursos());	

		System.out.println(professores.isEmpty());

		GradeHoraria gradePrimeiro = Resolvedor.constroiGrade(new GradeHoraria(Periodo.PRIMEIRO, "2019", professores, disciplinasPrimeiro));
		GradeHoraria gradeSegundo = Resolvedor.constroiGrade(new GradeHoraria(Periodo.TERCEIRO, "2019", professores, disciplinasSegundo));
		

	}
}
