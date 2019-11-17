package iel.org.projeto_grid.controller;

import java.util.ArrayList;
import java.util.List;

import iel.org.projeto_grid.model.entities.Aula;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.DiaNaoDisponivel;
import iel.org.projeto_grid.model.entities.GradeHoraria;
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
	
	/*
	 * Professores
	 */
	private List<Professor> professores;
	protected List<Professor> professoresAtualizados;

	/**
	 * Método que atribui os professores nas matérias e retorna uma grade
	 * 
	 * @param grade
	 */

	public Curso controiGradeCurso(Curso curso) {
		this.professores = new ArrayList<Professor>();
		this.professoresAtualizados = new ArrayList<Professor>();
		
		List<Turma>turmasAtualizadas = new ArrayList<Turma>();
		List<Turma>turmasFinalizadas = new ArrayList<Turma>();
		
		for (Turma turma : curso.getTurmas()) {
			if(professores.isEmpty()) {
				professores.addAll(turma.getProfessores());
			}
			
			GradeHoraria grade = new GradeHoraria();
			
			grade = constroiGradeTurma(turma.getGrade());
			turma.setGrade(grade);
			turmasAtualizadas.add(turma);
			
		}
		
		for (Turma turma : turmasAtualizadas) {
			Turma nova = turma;
			nova.setProfessores(this.professoresAtualizados);
			nova.getGrade().setProfessores(this.professoresAtualizados);
			turmasFinalizadas.add(nova);
		}
		curso.setTurmas(turmasFinalizadas);
		
		return curso;
	}
	
	
	public GradeHoraria constroiGradeTurma(GradeHoraria grade) {
		/*
		 * Busca o professor que atenda as restrições para cada aula
		 */
		grade.setAulaSegunda(resolveAula(grade.getAulaSegunda()));
		grade.setAulaTerca(resolveAula(grade.getAulaTerca()));
		grade.setAulaQuarta(resolveAula(grade.getAulaQuarta()));
		grade.setAulaQuinta(resolveAula(grade.getAulaQuinta()));
		grade.setAulaSexta(resolveAula(grade.getAulaSexta()));
		
		/*
		 * Retorna a grade
		 */
		return grade;
	}
	
	/**
	 * Método atribui o professor a aula em questão, levando em conta disponibilidade conhecimento da disciplina
	 * @param aula
	 * @return
	 */
	private Aula resolveAula(Aula aula) {
		/*
		 * boolean do loop do while
		 */
		boolean sair = false;
		/*
		 * Enquanto sair não for verdadeiro continua no loop
		 */
		while (!sair) {
			/*
			 * Forach de profesores
			 */
			System.out.println(this.professores.size() == this.professoresAtualizados.size());
			System.out.println("professores "+this.professores.size()+" " + " professores atualizados "+this.professoresAtualizados.size());
			if(this.professores.size() == this.professoresAtualizados.size()) {
			
				loopProfessor: for (Professor professor : this.professoresAtualizados) {
					/*
					 * Efetua as 2 verificações:
					 * Se o professor conhece a disciplina
					 * Se o professor possui disponibilidade no dia
					 * Caso seja verdadeiro atribui o professor na aula, 
					 * sair recebe true e para o loop dos professores
					 */
					if (professor.conheceDisciplina(aula.getDisciplina())
							&& professor.possuiDisponibilidadeNoDia(aula.getDiasSemana())) {
						
						DiaNaoDisponivel diaNaoDisponivel = new DiaNaoDisponivel(aula.getDiasSemana(),
								"lecionar disciplina "+aula.getDisciplina().getNome(),
								GrauMotivoEnum.TRABALHO
								);
						professor.getDisponibilidade().addDiasNaoDisponiveis(diaNaoDisponivel);
						aula.setProfessor(professor);
						addProfessorAtualizado(professor);
						sair = true;
						break loopProfessor;
					}
				}
			}else {
				loopProfessor: for (Professor professor : professores) {
					/*
					 * Efetua as 2 verificações:
					 * Se o professor conhece a disciplina
					 * Se o professor possui disponibilidade no dia
					 * Caso seja verdadeiro atribui o professor na aula, 
					 * sair recebe true e para o loop dos professores
					 */
					if (professor.conheceDisciplina(aula.getDisciplina())
							&& professor.possuiDisponibilidadeNoDia(aula.getDiasSemana())) {
						
						DiaNaoDisponivel diaNaoDisponivel = new DiaNaoDisponivel(aula.getDiasSemana(),
								"lecionar disciplina "+aula.getDisciplina().getNome(),
								GrauMotivoEnum.TRABALHO
								);
						professor.getDisponibilidade().addDiasNaoDisponiveis(diaNaoDisponivel);
						aula.setProfessor(professor);
						professoresAtualizados.add(professor);
//						addProfessorAtualizado(professor);
						sair = true;
						break loopProfessor;
					}
				}
			}
		}
		/*
		 * Retorna a aula
		 */
		return aula;
	}
	
	public boolean contemProfessor(Professor professor, List<Professor>professores) {
		boolean contemProfessor = false;
		for(Professor professorLista : professores) {
			if(professorLista.getNomeCompleto().equals(professor.getNomeCompleto())) {
				contemProfessor = true;
				break;
			}
		}	
		return contemProfessor;
	}
	
	public void addProfessorAtualizado(Professor professor) {
		int indiceASerRemovido = 0;
		boolean contemProfessor = contemProfessor(professor, professoresAtualizados);		
		if(contemProfessor) {
			for(Professor professor2 : professoresAtualizados) {
				if((professor.getNomeCompleto().equals(professor2.getNomeCompleto())) && (professor.getDisponibilidade().qtdaDiasDisponiveis() != professor2.getDisponibilidade().qtdaDiasDisponiveis())) {
					indiceASerRemovido = professoresAtualizados.indexOf(professor2);
					this.professoresAtualizados.add(professor);
				}
			}
			this.professoresAtualizados.remove(indiceASerRemovido);
		}
		else {
			this.professoresAtualizados.add(professor);
		}
	}
}