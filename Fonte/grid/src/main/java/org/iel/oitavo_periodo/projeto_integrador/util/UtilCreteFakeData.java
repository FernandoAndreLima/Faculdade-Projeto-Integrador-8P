package org.iel.oitavo_periodo.projeto_integrador.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.iel.oitavo_periodo.projeto_integrador.dao.CursoDao;
import org.iel.oitavo_periodo.projeto_integrador.dao.DisciplinaDao;
import org.iel.oitavo_periodo.projeto_integrador.dao.ProfessorDao;
import org.iel.oitavo_periodo.projeto_integrador.entities.Curso;
import org.iel.oitavo_periodo.projeto_integrador.entities.DiaNaoDisponivel;
import org.iel.oitavo_periodo.projeto_integrador.entities.Disciplina;
import org.iel.oitavo_periodo.projeto_integrador.entities.DisponibilidadeProfessor;
import org.iel.oitavo_periodo.projeto_integrador.entities.Professor;
import org.iel.oitavo_periodo.projeto_integrador.enums.CargoEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.DiasEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.FormacaoEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.GrauMotivoEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.RegimeEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.TitulacaoEnum;

@Stateless
public class UtilCreteFakeData {

	private Set<Professor> professores = new HashSet<>();
	private Set<Disciplina> disciplinas = new HashSet<>();
	private Set<Curso> cursos = new HashSet<>();

	@Inject
	private CursoDao cursoDao;

	@Inject
	private ProfessorDao professorDao;

	@Inject
	private DisciplinaDao disciplinaDao;

	public void createData() {
		fakeData();

//		for (Professor professor : professores) {
//			professor.setDataAdmissao(new Date(System.currentTimeMillis()));
//			professor.setTitulacao(TitulacaoEnum.COLABORADOR);
//			professorDao.save(professor);
//		}

//		for (Curso curso : cursos) {
//			cursoDao.save(curso);
//		}
//
//		for (Disciplina disciplina : disciplinas) {
//			disciplinaDao.save(disciplina);
//		}

		System.out.println("all data created");
	}

	private void fakeData() {
		
		Random random = new Random();
		
		String[][] nomesCursos = {
				{"BACHARELADO EM SISTEMAS DA INFORMAÇÃO","4"},
				{"ADMINISTRAÇÃO","4"},
				{"DIREITO","5"}
		};
		String[] nomesDisciplinasBSI = {"Algoritmos e Estruturas de Dados", "Comunicação Oral e Escrita", "Programação de Computadores", 
				"Projeto Integrador","Sistemas de Informação", "Lógica Matemática", "Organização e Arquitetura de Computadores", "Sistemas Operacionais",
				"Análise e Modelagem de Sistemas", "Gestão de Projetos", "Programação Orientada a Objetos", "Banco de Dados e suas Aplicações",
				"Engenharia de Software","Redes de Computadores","Desenvolvimento de Aplicações","Estágio Supervisionado","Garantia da Qualidade de Software",
				"Desenvolvimento Web","Modelagem de Processos de Negócios","Pesquisa Operacional","Desenvolvimento Mobile","Inteligência de Negócios",
				"Interface Humano Computador","Eletiva","Governança de TI","Segurança e Auditoria de Sistemas"};
		
		String[] nomesProfessores = {"Arsene Lupin","Cassiana Fagundes Da Silva","Eunelson José da Silva Junior","Mauricio Antonio Ferste",
				"Thiago Schaedler Uhlmann","Miss Marple","Hercule Poirot","Comissário Maigret"};
		
		for(int i = 0; i < nomesDisciplinasBSI.length ; i++) {
			disciplinas.add(new Disciplina(nomesDisciplinasBSI[i],"80",nomesDisciplinasBSI[i]));
		}
		
		for(int i = 0; i < nomesProfessores.length; i++) {
			professores.add(new Professor(nomesProfessores[i], 
					RegimeEnum.NOITE, 
					new Date(System.currentTimeMillis()), 
					CargoEnum.PROFESSOR, 
					FormacaoEnum.BACHAREL,
					TitulacaoEnum.COLABORADOR));
		}
		
		for(int i = 0; i < 3; i++) {
			cursos.add(new Curso(nomesCursos[i][0], "", nomesCursos[i][1]));
		}
		
		for(Professor professor : professores) {
			int escolha = random.nextInt(10);
			
			switch (escolha) {
			case 1:
				DisponibilidadeProfessor disponibilidadeUm = new DisponibilidadeProfessor();
				disponibilidadeUm.setAno("2019");
				disponibilidadeUm.setSemestre(SemestreEnum.primeiro);
				disponibilidadeUm.setProfessor(professor);
				disponibilidadeUm.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeUm.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeUm.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeUm.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				// dia nao disponivel
				DiaNaoDisponivel dNDProfe01 = new DiaNaoDisponivel();
				dNDProfe01.setDia(DiasEnum.QUINTA_FEIRA);
				dNDProfe01.setDisponibilidade(disponibilidadeUm);
				dNDProfe01.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDProfe01.setMotivo("Trabalho voluntário");
				disponibilidadeUm.addDiasNaoDisponiveis(dNDProfe01);
				
				professor.setDisponibilidade(disponibilidadeUm);
				
				break;
			case 2:
				DisponibilidadeProfessor disponibilidadeDois = new DisponibilidadeProfessor();
				disponibilidadeDois.setAno("2019");
				disponibilidadeDois.setSemestre(SemestreEnum.primeiro);
				disponibilidadeDois.setProfessor(professor);
				disponibilidadeDois.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeDois.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeDois.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeDois.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				// dia nao disponivel
				DiaNaoDisponivel dNDProfe02 = new DiaNaoDisponivel();
				dNDProfe02.setDia(DiasEnum.SEGUNDA_FEIRA);
				dNDProfe02.setDisponibilidade(disponibilidadeDois);
				dNDProfe02.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDProfe02.setMotivo("Trabalho voluntário");
				disponibilidadeDois.addDiasNaoDisponiveis(dNDProfe02);
				
				professor.setDisponibilidade(disponibilidadeDois);
				
				break;
			
			case 3:
				DisponibilidadeProfessor disponibilidadeTres = new DisponibilidadeProfessor();
				disponibilidadeTres.setAno("2019");
				disponibilidadeTres.setSemestre(SemestreEnum.primeiro);
				disponibilidadeTres.setProfessor(professor);
				disponibilidadeTres.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeTres.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeTres.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeTres.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				// dia nao disponivel
				DiaNaoDisponivel dNDTres = new DiaNaoDisponivel();
				dNDTres.setDia(DiasEnum.TERCA_FEIRA);
				dNDTres.setDisponibilidade(disponibilidadeTres);
				dNDTres.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDTres.setMotivo("Trabalho voluntário");
				disponibilidadeTres.addDiasNaoDisponiveis(dNDTres);
				
				professor.setDisponibilidade(disponibilidadeTres);
				
				break;

			case 4:
				DisponibilidadeProfessor disponibilidadeQuatro = new DisponibilidadeProfessor();
				disponibilidadeQuatro.setAno("2019");
				disponibilidadeQuatro.setSemestre(SemestreEnum.primeiro);
				disponibilidadeQuatro.setProfessor(professor);
				disponibilidadeQuatro.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeQuatro.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeQuatro.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeQuatro.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				// dia nao disponivel
				DiaNaoDisponivel dNDQuatro = new DiaNaoDisponivel();
				dNDQuatro.setDia(DiasEnum.QUARTA_FEIRA);
				dNDQuatro.setDisponibilidade(disponibilidadeQuatro);
				dNDQuatro.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDQuatro.setMotivo("Trabalho voluntário");
				disponibilidadeQuatro.addDiasNaoDisponiveis(dNDQuatro);
				
				professor.setDisponibilidade(disponibilidadeQuatro);
				
				break;

			case 5:
				DisponibilidadeProfessor disponibilidadeCinco = new DisponibilidadeProfessor();
				disponibilidadeCinco.setAno("2019");
				disponibilidadeCinco.setSemestre(SemestreEnum.primeiro);
				disponibilidadeCinco.setProfessor(professor);
				disponibilidadeCinco.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeCinco.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeCinco.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeCinco.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				// dia nao disponivel
				DiaNaoDisponivel dNDCinco = new DiaNaoDisponivel();
				dNDCinco.setDia(DiasEnum.QUINTA_FEIRA);
				dNDCinco.setDisponibilidade(disponibilidadeCinco);
				dNDCinco.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDCinco.setMotivo("Trabalho voluntário");
				disponibilidadeCinco.addDiasNaoDisponiveis(dNDCinco);
				
				professor.setDisponibilidade(disponibilidadeCinco);
				
				break;
				
			case 6:
				DisponibilidadeProfessor disponibilidadeSeis = new DisponibilidadeProfessor();
				disponibilidadeSeis.setAno("2019");
				disponibilidadeSeis.setSemestre(SemestreEnum.primeiro);
				disponibilidadeSeis.setProfessor(professor);
				disponibilidadeSeis.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeSeis.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeSeis.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeSeis.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				// dia nao disponivel
				DiaNaoDisponivel dNDSeis = new DiaNaoDisponivel();
				dNDSeis.setDia(DiasEnum.SEXTA_FEIRA);
				dNDSeis.setDisponibilidade(disponibilidadeSeis);
				dNDSeis.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDSeis.setMotivo("Trabalho voluntário");
				disponibilidadeSeis.addDiasNaoDisponiveis(dNDSeis);
				
				professor.setDisponibilidade(disponibilidadeSeis);
				
				break;
				
			case 7:
				DisponibilidadeProfessor disponibilidadeSete = new DisponibilidadeProfessor();
				disponibilidadeSete.setAno("2019");
				disponibilidadeSete.setSemestre(SemestreEnum.primeiro);
				disponibilidadeSete.setProfessor(professor);
				disponibilidadeSete.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeSete.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeSete.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				
				// dia nao disponivel
				DiaNaoDisponivel dNDSeteUm = new DiaNaoDisponivel();
				dNDSeteUm.setDia(DiasEnum.QUINTA_FEIRA);
				dNDSeteUm.setDisponibilidade(disponibilidadeSete);
				dNDSeteUm.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDSeteUm.setMotivo("Trabalho voluntário");
				disponibilidadeSete.addDiasNaoDisponiveis(dNDSeteUm);
				
				// dia nao disponivel
				DiaNaoDisponivel dNDSete = new DiaNaoDisponivel();
				dNDSete.setDia(DiasEnum.SEXTA_FEIRA);
				dNDSete.setDisponibilidade(disponibilidadeSete);
				dNDSete.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDSete.setMotivo("Trabalho voluntário");
				disponibilidadeSete.addDiasNaoDisponiveis(dNDSete);
				
				professor.setDisponibilidade(disponibilidadeSete);
				
				break;
				
			case 8:
				DisponibilidadeProfessor disponibilidadeOito = new DisponibilidadeProfessor();
				disponibilidadeOito.setAno("2019");
				disponibilidadeOito.setSemestre(SemestreEnum.primeiro);
				disponibilidadeOito.setProfessor(professor);
				disponibilidadeOito.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeOito.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeOito.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				
				// dia nao disponivel
				DiaNaoDisponivel dNDOitoUm = new DiaNaoDisponivel();
				dNDOitoUm.setDia(DiasEnum.SEGUNDA_FEIRA);
				dNDOitoUm.setDisponibilidade(disponibilidadeOito);
				dNDOitoUm.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDOitoUm.setMotivo("Trabalho voluntário");
				disponibilidadeOito.addDiasNaoDisponiveis(dNDOitoUm);
				
				// dia nao disponivel
				DiaNaoDisponivel dNDOitoDois = new DiaNaoDisponivel();
				dNDOitoDois.setDia(DiasEnum.TERCA_FEIRA);
				dNDOitoDois.setDisponibilidade(disponibilidadeOito);
				dNDOitoDois.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDOitoDois.setMotivo("Trabalho voluntário");
				disponibilidadeOito.addDiasNaoDisponiveis(dNDOitoDois);
				
				professor.setDisponibilidade(disponibilidadeOito);
				
				break;
				
			case 9:
				DisponibilidadeProfessor disponibilidadeNove = new DisponibilidadeProfessor();
				disponibilidadeOito.setAno("2019");
				disponibilidadeOito.setSemestre(SemestreEnum.primeiro);
				disponibilidadeOito.setProfessor(professor);
				disponibilidadeOito.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeOito.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeOito.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
				
				// dia nao disponivel
				DiaNaoDisponivel dNDOitoUm = new DiaNaoDisponivel();
				dNDOitoUm.setDia(DiasEnum.SEGUNDA_FEIRA);
				dNDOitoUm.setDisponibilidade(disponibilidadeOito);
				dNDOitoUm.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDOitoUm.setMotivo("Trabalho voluntário");
				disponibilidadeOito.addDiasNaoDisponiveis(dNDOitoUm);
				
				// dia nao disponivel
				DiaNaoDisponivel dNDOitoDois = new DiaNaoDisponivel();
				dNDOitoDois.setDia(DiasEnum.TERCA_FEIRA);
				dNDOitoDois.setDisponibilidade(disponibilidadeOito);
				dNDOitoDois.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDOitoDois.setMotivo("Trabalho voluntário");
				disponibilidadeOito.addDiasNaoDisponiveis(dNDOitoDois);
				
				professor.setDisponibilidade(disponibilidadeOito);
				
				break;
				
			default:
				break;
			}
		}
		
		// cria os cursos
		Curso curso1 = new Curso();
		curso1.setNome("Bacharelado em sistemas da informação");
		curso1.setTempoDuracao("4");
		curso1.setDescricao("");

		cursos.add(curso1);

		// cria as disciplinas
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Sistemas de Informação");
		disciplina1.setCargaHoraria("80");
		disciplina1.setDescricao("");

		// cria as disciplinas
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Java 1");
		disciplina2.setCargaHoraria("80");
		disciplina2.setDescricao("");

		// cria as disciplinas
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("Projeto Integrador");
		disciplina3.setCargaHoraria("80");
		disciplina3.setDescricao("");

		// cria as disciplinas
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setNome("Programação de Computadores");
		disciplina4.setCargaHoraria("80");
		disciplina4.setDescricao("");

		// cria as disciplinas
		Disciplina disciplina5 = new Disciplina();
		disciplina5.setNome("Algoritmos e Estruturas de Dados");
		disciplina5.setCargaHoraria("80");
		disciplina5.setDescricao("");
		
		// cria as disciplinas
		Disciplina disciplina6 = new Disciplina();
		disciplina5.setNome("Algoritmos e Estruturas de Dados");
		disciplina5.setCargaHoraria("80");
		disciplina5.setDescricao("");

		// cria os professores
		Professor professor1 = new Professor();
		professor1.setNomeCompleto("Arsène Lupin");
		professor1.setRegime(RegimeEnum.NOITE);
		professor1.setCargo(CargoEnum.PROFESSOR);
		professor1.setFormacao(FormacaoEnum.BACHAREL);

		// disponibilidade professor 01
		DisponibilidadeProfessor dispoUmProfe01 = new DisponibilidadeProfessor();
		dispoUmProfe01.setAno("2019");
		dispoUmProfe01.setSemestre(SemestreEnum.primeiro);
		dispoUmProfe01.setProfessor(professor1);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoUmProfe01.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		// dia nao disponivel
		DiaNaoDisponivel dNDProfe01 = new DiaNaoDisponivel();
		dNDProfe01.setDia(DiasEnum.QUINTA_FEIRA);
		dNDProfe01.setDisponibilidade(dispoUmProfe01);
		dNDProfe01.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe01.setMotivo("Trabalho voluntário");
		dispoUmProfe01.addDiasNaoDisponiveis(dNDProfe01);

		// disponibilidade 02 professor 01
		DisponibilidadeProfessor dispoDoisProfe01 = new DisponibilidadeProfessor();
		dispoDoisProfe01.setAno("2019");
		dispoDoisProfe01.setSemestre(SemestreEnum.segundo);
		dispoDoisProfe01.setProfessor(professor1);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		dispoDoisProfe01.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		// dia nao disponivel
		DiaNaoDisponivel dNDProfe01Segundo = new DiaNaoDisponivel();
		dNDProfe01Segundo.setDia(DiasEnum.TERCA_FEIRA);
		dNDProfe01Segundo.setDisponibilidade(dispoUmProfe01);
		dNDProfe01Segundo.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe01Segundo.setMotivo("Trabalho voluntário");
		dispoDoisProfe01.addDiasNaoDisponiveis(dNDProfe01Segundo);

		// cria os professores
		Professor professor2 = new Professor();
		professor2.setNomeCompleto("Miss Marple");
		professor2.setRegime(RegimeEnum.NOITE);
		professor2.setCargo(CargoEnum.PROFESSOR);
		professor2.setFormacao(FormacaoEnum.BACHAREL);

		// disponibilidade professor 02
		DisponibilidadeProfessor dispoUmProfe02 = new DisponibilidadeProfessor();
		dispoUmProfe02.setAno("2019");
		dispoUmProfe02.setSemestre(SemestreEnum.primeiro);
		dispoUmProfe02.setProfessor(professor2);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		dispoUmProfe02.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		// dia nao disponivel
		DiaNaoDisponivel dNDProfe02 = new DiaNaoDisponivel();
		dNDProfe02.setDia(DiasEnum.SEGUNDA_FEIRA);
		dNDProfe02.setDisponibilidade(dispoUmProfe01);
		dNDProfe02.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe02.setMotivo("Trabalho em outra instituicao");
		dispoUmProfe01.addDiasNaoDisponiveis(dNDProfe02);

		// disponibilidade 02 professor 02
		DisponibilidadeProfessor dispoDoisProfe02 = new DisponibilidadeProfessor();
		dispoDoisProfe02.setAno("2019");
		dispoDoisProfe02.setSemestre(SemestreEnum.segundo);
		dispoDoisProfe02.setProfessor(professor2);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
		dispoDoisProfe02.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		// dia nao disponivel
		DiaNaoDisponivel dNDProfe02Segundo = new DiaNaoDisponivel();
		dNDProfe02Segundo.setDia(DiasEnum.SEXTA_FEIRA);
		dNDProfe02Segundo.setDisponibilidade(dispoUmProfe01);
		dNDProfe02Segundo.setGrauMotivo(GrauMotivoEnum.ALTO);
		dNDProfe02Segundo.setMotivo("Trabalho voluntário");
		dispoDoisProfe02.addDiasNaoDisponiveis(dNDProfe02Segundo);

		// cria os professores
		Professor professor3 = new Professor();
		professor3.setNomeCompleto("Arthur Conan Doyle");
		professor3.setRegime(RegimeEnum.NOITE);
		professor3.setCargo(CargoEnum.PROFESSOR);
		professor3.setFormacao(FormacaoEnum.BACHAREL);

		// disponibilidade professor 02
		DisponibilidadeProfessor dispoUmProfe03 = new DisponibilidadeProfessor();
		dispoUmProfe03.setAno("2019");
		dispoUmProfe03.setSemestre(SemestreEnum.primeiro);
		dispoUmProfe03.setProfessor(professor2);
		dispoUmProfe03.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
		dispoUmProfe03.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);
		// dia nao disponivel
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

		// dia nao disponivel
		DiaNaoDisponivel dNDTresProfe03 = new DiaNaoDisponivel();
		dNDTresProfe03.setDia(DiasEnum.QUARTA_FEIRA);
		dNDTresProfe03.setDisponibilidade(dispoUmProfe01);
		dNDTresProfe03.setGrauMotivo(GrauMotivoEnum.MEDIO);
		dNDTresProfe03.setMotivo("Estudo auto diciplinar");
		dispoDoisProfe02.addDiasNaoDisponiveis(dNDTresProfe03);

		// adiciona os professores na disciplinas
		disciplina1.addProfessor(professor1);
		disciplina1.addProfessor(professor2);
		disciplina2.addProfessor(professor3);
		disciplina3.addProfessor(professor1);
		disciplina4.addProfessor(professor3);
		disciplina5.addProfessor(professor1);
		disciplina5.addProfessor(professor3);

		// adiciona disciplina no professor 1
		professor1.addDisciplina(disciplina1);
		professor1.addDisciplina(disciplina3);
		professor1.addDisciplina(disciplina5);

		professor2.addDisciplina(disciplina3);

		professor3.addDisciplina(disciplina2);
		professor3.addDisciplina(disciplina4);
		professor3.addDisciplina(disciplina5);

//		// adiciona curso na disciplina
		disciplina1.addCurso(curso1);
		disciplina2.addCurso(curso1);
		disciplina3.addCurso(curso1);
		disciplina4.addCurso(curso1);
		disciplina5.addCurso(curso1);

		professor1.setDisponibilidade(dispoUmProfe01);
		professor2.setDisponibilidade(dispoUmProfe02);
		professor3.setDisponibilidade(dispoUmProfe03);

		professores.add(professor1);
		professores.add(professor2);
		professores.add(professor3);

		disciplinas.add(disciplina1);
		disciplinas.add(disciplina2);
		disciplinas.add(disciplina4);
		disciplinas.add(disciplina3);
		disciplinas.add(disciplina5);

		// adiciona disponibilidade em cada professor

	}

}
