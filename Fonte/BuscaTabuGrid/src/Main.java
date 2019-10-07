import java.util.HashSet;
import java.util.Set;

import dao.BancoDao;
import entities.Curso;
import entities.Disciplina;
import entities.Professor;

public class Main {

	public static void main(String[] args) {
		BancoDao dao = new BancoDao();

		Set<Professor> professores = new HashSet<>();
		Set<Disciplina> disciplinas = new HashSet<>();
		Set<Curso> cursos = new HashSet<>();
		
		professores.addAll(dao.getProfessores());
		disciplinas.addAll(disciplinas);
		cursos.addAll(dao.getCursos());
		
		System.out.println(professores);
		
		 
	}
}
