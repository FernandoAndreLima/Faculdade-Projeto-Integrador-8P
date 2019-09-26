import java.util.HashSet;
import java.util.Set;

import entities.Curso;
import entities.Disciplina;
import entities.Professor;
import enums.CargoEnum;
import enums.FormacaoEnum;
import enums.RegimeEnum;

public class Main {

	public static void main(String[] args) {
		//instancia as colecoes
		Set<Professor> professores = new HashSet<>();
		Set<Disciplina> disciplinas = new HashSet<>();
		Set<Curso> cursos = new HashSet<>();
		
		//cria as disciplinas
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Sistemas Operacionais");
		disciplina1.setCargaHoraria("80");
		disciplina1.setDescricao("");
		
		//cria os cursos
		Curso curso1 = new Curso();
		curso1.setNome("Bacharelado em sistemas da informação");		
		curso1.setTempoDuracao("4");
		curso1.setDescricao("");
		
		//cria os professores
		Professor professor1 = new Professor();
		professor1.setNomeCompleto("José da Silva");
		professor1.setRegime(RegimeEnum.NOITE);
		professor1.setCargo(CargoEnum.PROFESSOR);
		professor1.setFormacao(FormacaoEnum.BACHAREL);
		
		//adiciona os professores na disciplinas
		disciplina1.addProfessor(professor1);

		//adiciona disciplina no professor
		professor1.addDisciplina(disciplina1);
		
		//adiciona curso na disciplina
		disciplina1.addCurso(curso1);
		
		//adiciona as disciplinas nos cursos
		curso1.addDisciplina(disciplina1);
		
		//popula os arrays
		professores.add(professor1);
		cursos.add(curso1);
		disciplinas.add(disciplina1);

	}
}
