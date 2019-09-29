import java.util.HashSet;
import java.util.Set;

import entities.Curso;
import entities.DiaNaoDisponivel;
import entities.Disciplina;
import entities.DisponibilidadeProfessor;
import entities.Professor;
import enums.CargoEnum;
import enums.DiasEnum;
import enums.FormacaoEnum;
import enums.GrauMotivoEnum;
import enums.RegimeEnum;
import enums.SemestreEnum;

public class Main {

	public static void main(String[] args) {
		//instancia as colecoes
		Set<Professor> professores = new HashSet<>();
		Set<Disciplina> disciplinas = new HashSet<>();
		Set<Curso> cursos = new HashSet<>();
		
		//cria os cursos
		Curso curso1 = new Curso();
		curso1.setId(new Long(1));
		curso1.setNome("Bacharelado em sistemas da informação");		
		curso1.setTempoDuracao("4");
		curso1.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setId(new Long(1));
		disciplina1.setNome("Sistemas de Informação");
		disciplina1.setCargaHoraria("80");
		disciplina1.setDescricao("");

		//cria as disciplinas
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setId(new Long(2));
		disciplina2.setNome("Java 1");
		disciplina2.setCargaHoraria("80");
		disciplina2.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setId(new Long(3));
		disciplina3.setNome("Projeto Integrador");
		disciplina3.setCargaHoraria("80");
		disciplina3.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setId(new Long(4));
		disciplina4.setNome("Programação de Computadores");
		disciplina4.setCargaHoraria("80");
		disciplina4.setDescricao("");
		
		//cria as disciplinas
		Disciplina disciplina5 = new Disciplina();
		disciplina5.setId(new Long(5));
		disciplina5.setNome("Algoritmos e Estruturas de Dados");
		disciplina5.setCargaHoraria("80");
		disciplina5.setDescricao("");
		
		//cria os professores
		Professor professor1 = new Professor();
		professor1.setId(new Long(1));
		professor1.setNomeCompleto("Arsène Lupin");
		professor1.setRegime(RegimeEnum.NOITE);
		professor1.setCargo(CargoEnum.PROFESSOR);
		professor1.setFormacao(FormacaoEnum.BACHAREL);
		
		//disponibilidade professor 01
		DisponibilidadeProfessor dispoUmProfe01 = new DisponibilidadeProfessor();
		dispoUmProfe01.setId(new Long(1));
		dispoUmProfe01.setAno("2019");
		dispoUmProfe01.setSemestre(SemestreEnum.primeiro);
		dispoUmProfe01.setProfessor(professor1);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		//dia nao disponivel
		DiaNaoDisponivel dNDProfe01 = new DiaNaoDisponivel();
		dNDProfe01.setDia(DiasEnum.QUINTA_FEIRA);
		dNDProfe01.setDisponibilidade(dispoUmProfe01);
		dNDProfe01.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe01.setId(new Long(1));
		dNDProfe01.setMotivo("Trabalho voluntário");
		dispoUmProfe01.addDiasNaoDisponiveis(dNDProfe01);
		
		//disponibilidade 02 professor 01
		DisponibilidadeProfessor dispoDoisProfe01 = new DisponibilidadeProfessor();
		dispoDoisProfe01.setId(new Long(2));
		dispoDoisProfe01.setAno("2019");
		dispoDoisProfe01.setSemestre(SemestreEnum.segundo);
		dispoDoisProfe01.setProfessor(professor1);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		//dia nao disponivel
		DiaNaoDisponivel dNDProfe01Segundo = new DiaNaoDisponivel();
		dNDProfe01Segundo.setDia(DiasEnum.TERCA_FEIRA);
		dNDProfe01Segundo.setDisponibilidade(dispoUmProfe01);
		dNDProfe01Segundo.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe01Segundo.setId(new Long(1));
		dNDProfe01Segundo.setMotivo("Trabalho voluntário");
		dispoDoisProfe01.addDiasNaoDisponiveis(dNDProfe01Segundo);
		
		//cria os professores
		Professor professor2 = new Professor();
		professor2.setId(new Long(2));
		professor2.setNomeCompleto("Miss Marple");
		professor2.setRegime(RegimeEnum.NOITE);
		professor2.setCargo(CargoEnum.PROFESSOR);
		professor2.setFormacao(FormacaoEnum.BACHAREL);
		
		//disponibilidade professor 02
		DisponibilidadeProfessor dispoUmProfe02 = new DisponibilidadeProfessor();
		dispoUmProfe02.setAno("2019");
		dispoUmProfe02.setSemestre(SemestreEnum.primeiro);
		dispoUmProfe02.setProfessor(professor2);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		//dia nao disponivel
		DiaNaoDisponivel dNDProfe02 = new DiaNaoDisponivel();
		dNDProfe02.setDia(DiasEnum.SEGUNDA_FEIRA);
		dNDProfe02.setDisponibilidade(dispoUmProfe01);
		dNDProfe02.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe02.setMotivo("Trabalho em outra instituicao");
		dispoUmProfe01.addDiasNaoDisponiveis(dNDProfe02);
		
		//disponibilidade 02 professor 02
		DisponibilidadeProfessor dispoDoisProfe02 = new DisponibilidadeProfessor();
		dispoDoisProfe02.setAno("2019");
		dispoDoisProfe02.setSemestre(SemestreEnum.segundo);
		dispoDoisProfe02.setProfessor(professor2);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		//dia nao disponivel
		DiaNaoDisponivel dNDProfe02Segundo = new DiaNaoDisponivel();
		dNDProfe02Segundo.setDia(DiasEnum.SEXTA_FEIRA);
		dNDProfe02Segundo.setDisponibilidade(dispoUmProfe01);
		dNDProfe02Segundo.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe02Segundo.setMotivo("Trabalho voluntário");
		dispoDoisProfe02.addDiasNaoDisponiveis(dNDProfe02Segundo);
		
		
		
		//cria os professores
		Professor professor3 = new Professor();
		professor3.setNomeCompleto("Arthur Conan Doyle");
		professor3.setRegime(RegimeEnum.NOITE);
		professor3.setCargo(CargoEnum.PROFESSOR);
		professor3.setFormacao(FormacaoEnum.BACHAREL);
		
		//disponibilidade professor 02
		DisponibilidadeProfessor dispoUmProfe03 = new DisponibilidadeProfessor();
		dispoUmProfe03.setAno("2019");
		dispoUmProfe03.setSemestre(SemestreEnum.primeiro);
		dispoUmProfe03.setProfessor(professor2);
		dispoUmProfe03.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		dispoUmProfe03.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		//dia nao disponivel
		DiaNaoDisponivel dNDProfe03 = new DiaNaoDisponivel();
		dNDProfe03.setDia(DiasEnum.SEGUNDA_FEIRA);
		dNDProfe03.setDisponibilidade(dispoUmProfe01);
		dNDProfe03.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe03.setMotivo("Trabalho em outra instituicao");
		dispoUmProfe03.addDiasNaoDisponiveis(dNDProfe03);
		
		DiaNaoDisponivel dNDDoisProfe03 = new DiaNaoDisponivel();
		dNDDoisProfe03.setDia(DiasEnum.TERCA_FEIRA);
		dNDDoisProfe03.setDisponibilidade(dispoUmProfe01);
		dNDDoisProfe03.setGrauMotivo(GrauMotivoEnum.BAIXO);
		dNDDoisProfe03.setMotivo("Descanso");
		dispoUmProfe03.addDiasNaoDisponiveis(dNDDoisProfe03);
		
		//disponibilidade 02 professor 02
		DisponibilidadeProfessor dispoDoisProfe03 = new DisponibilidadeProfessor();
		dispoDoisProfe03.setAno("2019");
		dispoDoisProfe03.setSemestre(SemestreEnum.segundo);
		dispoDoisProfe03.setProfessor(professor2);
		dispoDoisProfe03.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoDoisProfe03.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoDoisProfe03.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoDoisProfe03.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		//dia nao disponivel
		DiaNaoDisponivel dNDProfe02Segundo = new DiaNaoDisponivel();
		dNDProfe02Segundo.setDia(DiasEnum.SEXTA_FEIRA);
		dNDProfe02Segundo.setDisponibilidade(dispoUmProfe01);
		dNDProfe02Segundo.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe02Segundo.setId(new Long(1));
		dNDProfe02Segundo.setMotivo("Trabalho voluntário");
		dispoDoisProfe02.addDiasNaoDisponiveis(dNDProfe02Segundo);
		
		
		
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
