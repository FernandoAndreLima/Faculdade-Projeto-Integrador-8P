package iel.org.projeto_grid.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import iel.org.projeto_grid.model.daos.CursoDao;
import iel.org.projeto_grid.model.daos.DisciplinaDao;
import iel.org.projeto_grid.model.daos.ProfessorDao;
import iel.org.projeto_grid.model.daos.TurmaDao;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.DiaNaoDisponivel;
import iel.org.projeto_grid.model.entities.Disciplina;
import iel.org.projeto_grid.model.entities.DisponibilidadeProfessor;
import iel.org.projeto_grid.model.entities.Professor;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.CargoEnum;
import iel.org.projeto_grid.model.enums.DiasEnum;
import iel.org.projeto_grid.model.enums.FormacaoEnum;
import iel.org.projeto_grid.model.enums.GrauMotivoEnum;
import iel.org.projeto_grid.model.enums.PeriodoEnum;
import iel.org.projeto_grid.model.enums.RegimeEnum;
import iel.org.projeto_grid.model.enums.SemestreEnum;
import iel.org.projeto_grid.model.enums.TitulacaoEnum;

/*
 * todo terminar a geracao da turma
 */

public class UtilCreteFakeData {

	private List<Professor> professores = new ArrayList<>();
	private List<Disciplina> disciplinas = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();
	private List<Turma> turmas = new ArrayList<>();
	private Curso bsi;
	
	private Random random = new Random();


	private CursoDao cursoDao;

	private ProfessorDao professorDao;

	private DisciplinaDao disciplinaDao;

	private TurmaDao turmaDao;

	public void createData() {
		this.bsi = new Curso();
		fakeData();

//		cursoDao = new CursoDao();
//		professorDao = new ProfessorDao();
//		disciplinaDao = new DisciplinaDao();
//		turmaDao = new TurmaDao();
//		
//		for (Curso curso : cursos)
//			cursoDao.save(curso);
//
//		for (Disciplina disciplina : disciplinas)
//			disciplinaDao.save(disciplina);
//
//		for (Professor professor : professores)
//			professorDao.save(professor);
//
//		for (Turma turma : turmas)
//			turmaDao.save(turma);

		System.out.println("all data created");
	}

	private void fakeData() {

		String[][] nomesCursos = { { "BACHARELADO EM SISTEMAS DA INFORMAÇÃO", "4" }, { "ADMINISTRAÇÃO", "4" },
				{ "DIREITO", "5" } };

		String[] nomesDisciplinasBSI = { "Algoritmos e Estruturas de Dados", "Comunicação Oral e Escrita",
				"Programação de Computadores", "Projeto Integrador", "Sistemas de Informação", "Lógica Matemática",
				"Organização e Arquitetura de Computadores", "Sistemas Operacionais", "Análise e Modelagem de Sistemas",
				"Gestão de Projetos", "Programação Orientada a Objetos", "Banco de Dados e suas Aplicações",
				"Engenharia de Software", "Redes de Computadores", "Desenvolvimento de Aplicações",
				"Estágio Supervisionado", "Garantia da Qualidade de Software", "Desenvolvimento Web",
				"Modelagem de Processos de Negócios", "Pesquisa Operacional", "Desenvolvimento Mobile",
				"Inteligência de Negócios", "Interface Humano Computador", "Eletiva", "Governança de TI",
				"Segurança e Auditoria de Sistemas" };

		String[] nomesProfessores = { "Arsene Lupin", "Cassiana Fagundes Da Silva", "Eunelson José da Silva Junior",
				"Mauricio Antonio Ferste", "Thiago Schaedler Uhlmann", "Miss Marple", "Hercule Poirot",
				"Comissário Maigret" };

		for (int i = 0; i < nomesDisciplinasBSI.length; i++) {
			Disciplina disciplina = new Disciplina(nomesDisciplinasBSI[i], "80", nomesDisciplinasBSI[i]);
			disciplina.ramdom = random.nextInt(2000);
			this.disciplinas.add(disciplina);
		}

		for (int i = 0; i < nomesProfessores.length; i++) {
			Professor professor = new Professor(nomesProfessores[i], RegimeEnum.NOITE,
					new Date(System.currentTimeMillis()), CargoEnum.PROFESSOR, FormacaoEnum.BACHAREL,
					TitulacaoEnum.COLABORADOR);
			professor.ramdom = random.nextInt(2000);
			this.professores.add(professor);
		}

		for (int i = 0; i < 3; i++) {
			Curso curso = new Curso(nomesCursos[i][0], "", nomesCursos[i][1]);
			if(curso.getNome().equals("BACHARELADO EM SISTEMAS DA INFORMAÇÃO"))
				this.bsi = curso;
			this.cursos.add(curso);
		}

		gerarProfessorConheceDisciplina();
		gerarDisponibilidadeProfessor();
		gerarTurma();

	}

	private void gerarProfessorConheceDisciplina() {
		int i = 0;
		for (Professor professor : professores) {
			while (professor.getDisciplinas().size() < 15) {
				loopDisciplina: for (Disciplina disciplina : disciplinas) {
					if (disciplina.getNome().equals("Projeto Integrador") && !professor.conheceDisciplina(disciplina)) {
						professor.addDisciplina(disciplina);
						break loopDisciplina;
					} else {
						if (random.nextInt(10) > 5 || random.nextInt(10) == 1
								|| random.nextInt(10) != 8 && !professor.conheceDisciplina(disciplina)) {
							professor.addDisciplina(disciplina);
						}
					}

				}
			}
			this.professores.set(i, professor);
			i++;
		}
	}

	private void gerarTurma() {
		PeriodoEnum[] periodos = getPeriodos();
		List<Disciplina> disciplinasJaAtribuidas = new ArrayList<Disciplina>();
		
		for (PeriodoEnum periodo : periodos) {
			List<Disciplina> disciplinasInformadas = new ArrayList<Disciplina>();
			Curso curso = new Curso();

			loopCurso: for (Curso cursoLoop : this.cursos) {
				if (cursoLoop.getNome().equals("BACHARELADO EM SISTEMAS DA INFORMAÇÃO")) {
					curso = cursoLoop;
					break loopCurso;
				}
			}
			while(disciplinasInformadas.size() < 4) {
				loopDisciplinas: for (Disciplina disciplina : disciplinas) {
										
					if (!validaItemNaLista(disciplinasInformadas, disciplinasJaAtribuidas, disciplina)) {
						disciplinasInformadas.add(disciplina);
						disciplinasJaAtribuidas.add(disciplina);
						break loopDisciplinas;
					}
					
					if (!validaProjetoIntegradorNaLista(disciplinasInformadas,"Projeto Integrador")) {
						Disciplina projeto = new Disciplina("Projeto Integrador", "80", "Projeto Integrador");
						disciplinasInformadas.add(projeto);
						break loopDisciplinas;
					}
				}
			}
			Turma turma;
			
			if((periodo == PeriodoEnum.PRIMEIRO) || (periodo == PeriodoEnum.TERCEIRO)|| (periodo == PeriodoEnum.QUINTO) || (periodo == PeriodoEnum.SETIMO))
			{
				turma = new Turma(disciplinasInformadas, professores, curso, periodo, SemestreEnum.primeiro, "2019");
			}else {
				turma = new Turma(disciplinasInformadas, professores, curso, periodo, SemestreEnum.segundo, "2019");
			}
			
			turma.ramdom = random.nextInt(2000);
			this.turmas.add(turma);
		}
	}

	public static boolean validaItemNaLista(List<Disciplina> lista, List<Disciplina> listaAtribuida, Disciplina disciplinaRecebida) {
		boolean contemNaPrimeiraLista = false;
		boolean contemNaSegundaLista = false;
		
		for (Disciplina disciplina : lista) {
			if(disciplinaRecebida.getNome().equals(disciplina.getNome()))
				contemNaPrimeiraLista =  true;
		}
		
		for(Disciplina disciplina : listaAtribuida) {
			if(disciplinaRecebida.getNome().equals(disciplina.getNome()))
				contemNaSegundaLista =  true;
		}
		return (contemNaPrimeiraLista || contemNaSegundaLista) ? true : false;
	}
	
	public static boolean validaProjetoIntegradorNaLista(List<Disciplina> lista, String projetoIntegrador) {
		for (Disciplina disciplina : lista) {
			if(projetoIntegrador.equals(disciplina.getNome()))
				return true;
		}
		return false;
	}
	
	public static boolean validaProjetoIntegradorNaLista(List<Disciplina> lista, int qtda) {
		int i = 0;
		for (int j = 0; j < lista.size(); j++) {
			i++;
		}
		return i < qtda;
	}
	
	public void gerarDisponibilidadeProfessor() {
		int i = 0;

		for (Professor professor : professores) {
			int escolha = random.nextInt(10);

			switch (escolha) {
			case 0:
				DisponibilidadeProfessor disponibilidadeZero = new DisponibilidadeProfessor();
				disponibilidadeZero.setAno("2019");
				disponibilidadeZero.setSemestre(SemestreEnum.primeiro);
				disponibilidadeZero.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeZero.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeZero.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeZero.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeZero.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);

				professor.setDisponibilidade(disponibilidadeZero);

				break;

			case 1:
				DisponibilidadeProfessor disponibilidadeUm = new DisponibilidadeProfessor();
				disponibilidadeUm.setAno("2019");
				disponibilidadeUm.setSemestre(SemestreEnum.primeiro);
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
				disponibilidadeNove.setAno("2019");
				disponibilidadeNove.setSemestre(SemestreEnum.primeiro);
				disponibilidadeNove.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeNove.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeNove.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);

				// dia nao disponivel
				DiaNaoDisponivel dNDNoveUm = new DiaNaoDisponivel();
				dNDNoveUm.setDia(DiasEnum.TERCA_FEIRA);
				dNDNoveUm.setDisponibilidade(disponibilidadeNove);
				dNDNoveUm.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDNoveUm.setMotivo("Trabalho voluntário");
				disponibilidadeNove.addDiasNaoDisponiveis(dNDNoveUm);

				// dia nao disponivel
				DiaNaoDisponivel dNDNoveDois = new DiaNaoDisponivel();
				dNDNoveDois.setDia(DiasEnum.QUINTA_FEIRA);
				dNDNoveDois.setDisponibilidade(disponibilidadeNove);
				dNDNoveDois.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDNoveDois.setMotivo("Trabalho voluntário");
				disponibilidadeNove.addDiasNaoDisponiveis(dNDNoveDois);

				professor.setDisponibilidade(disponibilidadeNove);

				break;
			case 10:
				DisponibilidadeProfessor disponibilidadeDez = new DisponibilidadeProfessor();
				disponibilidadeDez.setAno("2019");
				disponibilidadeDez.setSemestre(SemestreEnum.primeiro);
				disponibilidadeDez.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeDez.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeDez.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);

				// dia nao disponivel
				DiaNaoDisponivel dNDDezUm = new DiaNaoDisponivel();
				dNDDezUm.setDia(DiasEnum.SEGUNDA_FEIRA);
				dNDDezUm.setDisponibilidade(disponibilidadeDez);
				dNDDezUm.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDDezUm.setMotivo("Trabalho voluntário");
				disponibilidadeDez.addDiasNaoDisponiveis(dNDDezUm);

				// dia nao disponivel
				DiaNaoDisponivel dNDDezDois = new DiaNaoDisponivel();
				dNDDezDois.setDia(DiasEnum.SEXTA_FEIRA);
				dNDDezDois.setDisponibilidade(disponibilidadeDez);
				dNDDezDois.setGrauMotivo(GrauMotivoEnum.ALTO);
				dNDDezDois.setMotivo("Trabalho voluntário");
				disponibilidadeDez.addDiasNaoDisponiveis(dNDDezDois);

				professor.setDisponibilidade(disponibilidadeDez);

				break;
			default:

				DisponibilidadeProfessor disponibilidadeDefault = new DisponibilidadeProfessor();
				disponibilidadeDefault.setAno("2019");
				disponibilidadeDefault.setSemestre(SemestreEnum.primeiro);
				disponibilidadeDefault.addDiasDisponiveis(DiasEnum.SEGUNDA_FEIRA);
				disponibilidadeDefault.addDiasDisponiveis(DiasEnum.TERCA_FEIRA);
				disponibilidadeDefault.addDiasDisponiveis(DiasEnum.QUARTA_FEIRA);
				disponibilidadeDefault.addDiasDisponiveis(DiasEnum.QUINTA_FEIRA);
				disponibilidadeDefault.addDiasDisponiveis(DiasEnum.SEXTA_FEIRA);

				professor.setDisponibilidade(disponibilidadeDefault);

				break;
			}
			this.professores.set(i, professor);
			i++;
		}
	}

	public PeriodoEnum[] getPeriodos() {
		PeriodoEnum[] periodos = { PeriodoEnum.PRIMEIRO,PeriodoEnum.SEGUNDO, PeriodoEnum.TERCEIRO,PeriodoEnum.QUARTO, PeriodoEnum.QUINTO,PeriodoEnum.SEXTO,
				PeriodoEnum.SETIMO, PeriodoEnum.OITAVO  };
		return periodos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public Curso getBsi() {
		return bsi;
	}

	public void setBsi(Curso bsi) {
		this.bsi = bsi;
	}

}
