import java.util.ArrayList;
import java.util.List;

import algoritmo.Resolvedor;
import dao.BancoDao;
import entities.Curso;
import entities.Disciplina;
import entities.Professor;
import entities.grade.GradeHoraria;
import entities.grade.PeriodoAno;
import enums.Periodo;

public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		BancoDao dao = new BancoDao();

		dao.generateData();

		List<Professor> professores = new ArrayList<>();

		List<Disciplina> disciplinasPrimeiro = new ArrayList<>();
		List<Disciplina> disciplinasSegundo = new ArrayList<>();

		List<Disciplina> disciplinasTerceiro = new ArrayList<>();
		List<Disciplina> disciplinasQuarto = new ArrayList<>();
		List<Disciplina> disciplinasQuinto = new ArrayList<>();
		List<Disciplina> disciplinasSexto = new ArrayList<>();
		List<Disciplina> disciplinasListimo = new ArrayList<>();
		List<Disciplina> disciplinasOitavo = new ArrayList<>();

		List<Curso> cursos = new ArrayList<>();

		professores.addAll(dao.getProfessores());
		disciplinasPrimeiro.addAll(dao.getDisciplinas());
		cursos.addAll(dao.getCursos());

		System.out.println(professores.isEmpty());

//		GradeHoraria gradePrimeiro = new GradeHoraria(Periodo.PRIMEIRO, "2019", professores, disciplinasPrimeiro);

		GradeHoraria gradePrimeiro = Resolvedor.constroiGrade(
				new GradeHoraria(new PeriodoAno(Periodo.PRIMEIRO, "2019"), professores, disciplinasPrimeiro));
		System.out.println("Primeira Grade "+gradePrimeiro.toString());
//		GradeHoraria gradeSegundo = Resolvedor.constroiGrade(
//				new GradeHoraria(new PeriodoAno(Periodo.SEGUNDO, "2019"), professores, disciplinasSegundo));

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("o metodo executou em " + elapsed +" milesegundos");
	}
}
