package iel.org.projeto_grid.controller;

import java.util.ArrayList;
import java.util.List;

import iel.org.projeto_grid.model.entities.Aula;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.DiaNaoDisponivel;
import iel.org.projeto_grid.model.entities.Professor;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.GrauMotivoEnum;

/**
 * Classe responsável por atribuir um professor a uma disciplina em um dis especifico
 * 
 * @author anderson
 *
 */
public class Resolvedor {
	//primeiro loop dos cursos -> irei ignorar por enquanto
	// segundo loop das turmas
	//terceiro loop professores nas aulas
	
	protected List<Professor> listaProfessoresAtualizados = new ArrayList<Professor>();
	
	/**
	 * Método responsável por entregar a grade completa de um curso
	 * @param curso
	 * @return
	 */
	public Curso resolveGradesCurso(Curso curso) {
		/*
		 * Primeiro instancio as listas de apoio
		 */
		List<Professor> professores = new ArrayList<Professor>(curso.getProfessores());
		List<Turma> turmas = new ArrayList<Turma>(curso.getTurmas());
		
		//limpo a variavel que será enviada
		curso.setTurmas( new ArrayList<Turma>());
		
		int index = 0;
		
		//loop de turma
		for(Turma turma : turmas) {
			turma.setProfessores(professores);
			Turma turma2 = resolveGradeTurma(turma);
			turma = turma2;
			
			curso.getTurmas().add(index, turma);
			index ++;
		}
		return curso;
	}
	
	/**
	 * metodo resolve a grade de uma turma
	 * @param turma
	 * @return
	 */
	private Turma resolveGradeTurma(Turma turma) {
		
		for(Professor professor : turma.getProfessores()) {
			//professor não pode lecionar duas vezes na mesma turma
			if(!turma.getGrade().verificaSeProfessorJaLecionaNaGrade(professor)) {
				if(validaProfessorParaAAula(professor,turma.getGrade().getAulaSegunda())) {
					turma.getGrade().getAulaSegunda().setProfessor(resolveAulaBuscaProfessor(professor,turma.getGrade().getAulaSegunda()));
					updateListaProfessores(turma.getGrade().getAulaSegunda().getProfessor());
					break;
				}
				if(validaProfessorParaAAula(professor,turma.getGrade().getAulaTerca())) {
					turma.getGrade().getAulaTerca().setProfessor(resolveAulaBuscaProfessor(professor,turma.getGrade().getAulaTerca()));
					updateListaProfessores(turma.getGrade().getAulaTerca().getProfessor());
					break;
				}
				if(validaProfessorParaAAula(professor,turma.getGrade().getAulaQuarta())) {
					turma.getGrade().getAulaQuarta().setProfessor(resolveAulaBuscaProfessor(professor,turma.getGrade().getAulaQuarta()));
					updateListaProfessores(turma.getGrade().getAulaQuarta().getProfessor());
					break;
				}
				if(validaProfessorParaAAula(professor,turma.getGrade().getAulaQuinta())) {
					turma.getGrade().getAulaQuinta().setProfessor(resolveAulaBuscaProfessor(professor,turma.getGrade().getAulaQuinta()));
					updateListaProfessores(turma.getGrade().getAulaQuinta().getProfessor());
					break;
				}
				if(validaProfessorParaAAula(professor,turma.getGrade().getAulaSexta())) {
					turma.getGrade().getAulaSexta().setProfessor(resolveAulaBuscaProfessor(professor,turma.getGrade().getAulaSexta()));
					updateListaProfessores(turma.getGrade().getAulaSexta().getProfessor());
					break;
				}
			}

		}
		
		return turma;
	}

	private void updateListaProfessores(Professor professor) {
		int index = listaProfessoresAtualizados.indexOf(professor);
		if(index > 0) {
			listaProfessoresAtualizados.remove(index);
			listaProfessoresAtualizados.add(professor);	
		}
	}
	
	private Professor resolveAulaBuscaProfessor(Professor professor, Aula aula) {	
		Professor escolhido = new Professor();
		
		if(validaProfessorParaAAula(professor,aula)) {
			escolhido = professor;
			DiaNaoDisponivel diaNaoDisponivel = new DiaNaoDisponivel(
					aula.getDiasSemana(),
					"lecionar disciplina "+aula.getDisciplina().getNome(),
					GrauMotivoEnum.TRABALHO
					);
			escolhido.getDisponibilidade().addDiasNaoDisponiveis(diaNaoDisponivel);
			escolhido.getDisponibilidade().removeDiaDisponivel(aula.getDiasSemana());
		}
		return escolhido;
	}


	private boolean validaProfessorParaAAula(Professor professor, Aula aula) {
		boolean validado = true;
		try {
			if(!professor.getDisponibilidade().getDiasDisponiveis().contains(aula.getDiasSemana()))
				validado = false;

			if(professor.getDisponibilidade().retornaGrauDiaIndisponivel(aula.getDiasSemana()).equals(GrauMotivoEnum.ALTO) || professor.getDisponibilidade().retornaGrauDiaIndisponivel(aula.getDiasSemana()).equals(GrauMotivoEnum.TRABALHO))
				validado = false;
			
		} catch (Exception e) {}
	
		return validado;
	}

//
//	/*
//	 * Professores
//	 */
//	private List<Professor> professores;
//
//	/**
//	 * Método que atribui os professores nas matérias e retorna uma grade
//	 * 
//	 * @param grade
//	 */
//	
//	public Curso controiGradeCurso(Curso curso) {
//		this.professores = new ArrayList<Professor>();
//		
//		List<Turma>turmasAtualizadas = new ArrayList<Turma>();
//		List<Turma>turmasFinalizadas = new ArrayList<Turma>();
//		
//		for (Turma turma : curso.getTurmas()) {
//			if(professores.isEmpty()) {
//				professores.addAll(turma.getProfessores());
//			}
//			
//			GradeHoraria grade = new GradeHoraria();
//			
//			grade = constroiGradeTurma(turma.getGrade());
//			turma.setGrade(grade);
//			turmasAtualizadas.add(turma);
//			
//		}
//		//ultima atualizacao de professores
//		for (Turma turma : turmasAtualizadas) {
//			Turma nova = new Turma();
//			nova = turma;
//			nova.setProfessores(this.professores);
//			nova.getGrade().setProfessores(this.professores);
//			turmasFinalizadas.add(nova);
//		}
//		curso.setTurmas(turmasFinalizadas);
//		
//		return curso;
//	}
//	
//	
//	public GradeHoraria constroiGradeTurma(GradeHoraria grade) {
//		/*
//		 * Busca o professor que atenda as restrições para cada aula
//		 */
//		grade.setAulaSegunda(resolveAula(grade.getAulaSegunda()));
//		grade.setAulaTerca(resolveAula(grade.getAulaTerca()));
//		grade.setAulaQuarta(resolveAula(grade.getAulaQuarta()));
//		grade.setAulaQuinta(resolveAula(grade.getAulaQuinta()));
//		grade.setAulaSexta(resolveAula(grade.getAulaSexta()));
//		
//		/*
//		 * Retorna a grade
//		 */
//		return grade;
//	}
//	
//	/**
//	 * Método atribui o professor a aula em questão, levando em conta disponibilidade conhecimento da disciplina
//	 * @param aula
//	 * @return
//	 */
//	private Aula resolveAula(Aula aula) {
//		Professor professorEscolhido = new Professor();
//		/*
//		 * boolean do loop do while
//		 */
//		boolean sair = false;
//		/*
//		 * Enquanto sair não for verdadeiro continua no loop
//		 */
//		while (!sair) {
//			if(!aula.getDisciplina().getNome().equals("Estudo auto dirigido")) {	
//				/*
//				 * Forach de profesores
//				 */
//				int index = 0;
//				for (Professor professor : professores) {
//
//					if (validaProfessorParaOdia(professor, aula.getDiasSemana())) {
//						index = professores.indexOf(professor);
//						
//						DiaNaoDisponivel diaNaoDisponivel = new DiaNaoDisponivel(
//								aula.getDiasSemana(),
//								"lecionar disciplina "+aula.getDisciplina().getNome(),
//								GrauMotivoEnum.TRABALHO
//								);
//						
//						professor.getDisponibilidade().getDiasNaoDisponiveis().add(diaNaoDisponivel);
//						aula.setProfessor(professor);
//						professorEscolhido = professor;
//						sair = true;
//					}
//				}
//				professores.remove(index);
//				professores.add(professorEscolhido);
//			}else {
//				aula.setProfessor(professorEscolhido);
//			}
//		}
//		/*
//		 * Retorna a aula
//		 */
//		return aula;
//	}
//	
//	private boolean validaProfessorParaOdia(Professor professor, DiasEnum diasSemana) {
//		boolean validado = true;
//		try {
//			if(!professor.getDisponibilidade().getDiasDisponiveis().contains(diasSemana))
//				validado = false;
//
//			if(professor.getDisponibilidade().retornaGrauDiaIndisponivel(diasSemana).equals(GrauMotivoEnum.ALTO) || professor.getDisponibilidade().retornaGrauDiaIndisponivel(diasSemana).equals(GrauMotivoEnum.TRABALHO))
//				validado = false;
//		} catch (Exception e) {
//		}
//
//		
//		return validado;
//	}
}