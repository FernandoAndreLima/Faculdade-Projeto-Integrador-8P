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
		
		//cria os cursos
		Curso curso1 = new Curso();
		curso1.setNome("Bacharelado em sistemas da informação");		
		curso1.setTempoDuracao("4");
		curso1.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Sistemas de Informação");
		disciplina1.setCargaHoraria("80");
		disciplina1.setDescricao("");

		//cria as disciplinas
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Java 1");
		disciplina2.setCargaHoraria("80");
		disciplina2.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("Projeto Integrador");
		disciplina3.setCargaHoraria("80");
		disciplina3.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setNome("Programação de Computadores");
		disciplina4.setCargaHoraria("80");
		disciplina4.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina5 = new Disciplina();
		disciplina5.setNome("Algoritmos e Estruturas de Dados");
		disciplina5.setCargaHoraria("80");
		disciplina5.setDescricao("");
		
		//cria os professores
		Professor professor1 = new Professor();
		professor1.setNomeCompleto("Arsène Lupin");
		professor1.setRegime(RegimeEnum.NOITE);
		professor1.setCargo(CargoEnum.PROFESSOR);
		professor1.setFormacao(FormacaoEnum.BACHAREL);
		
		//cria os professores
		Professor professor2 = new Professor();
		professor2.setNomeCompleto("Miss Marple");
		professor2.setRegime(RegimeEnum.NOITE);
		professor2.setCargo(CargoEnum.PROFESSOR);
		professor2.setFormacao(FormacaoEnum.BACHAREL);
		
		//cria os professores
		Professor professor3 = new Professor();
		professor3.setNomeCompleto("Arthur Conan Doyle");
		professor3.setRegime(RegimeEnum.NOITE);
		professor3.setCargo(CargoEnum.PROFESSOR);
		professor3.setFormacao(FormacaoEnum.BACHAREL);
		
		//adiciona os professores na disciplinas
		disciplina1.addProfessor(professor1);
		disciplina1.addProfessor(professor2);
		disciplina2.addProfessor(professor3);
		disciplina3.addProfessor(professor1);
		disciplina4.addProfessor(professor3);
		disciplina5.addProfessor(professor1);
		disciplina5.addProfessor(professor3);

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
