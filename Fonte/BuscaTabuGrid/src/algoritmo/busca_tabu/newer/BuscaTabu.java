package algoritmo.busca_tabu.newer;

import java.util.HashSet;
import java.util.Set;

import entities.Disciplina;
import entities.GradeAulaDia;
import entities.Professor;

public class BuscaTabu {

	private Set<ProfessorBT> professores = new HashSet<ProfessorBT>();
	private Set<GradeBT> disciplinas = new HashSet<GradeBT>();

	public GradeAulaDia buscarGrade() {
		return null;
	}

}

class GradeBT {
	private Integer[][] idDisciplinas = new Integer[32][1];

	public GradeBT(Set<Disciplina>disciplinas) {
		int cont = disciplinas.size();
		for (Disciplina disciplina : disciplinas) {
			idDisciplinas[cont][0]=disciplina.getId().intValue();
		}
	}

	public Integer[][] getIdDisciplinas() {
		return idDisciplinas;
	}

	public void setIdDisciplinas(Integer[][] idDisciplinas) {
		this.idDisciplinas = idDisciplinas;
	}

	
	
}

class ProfessorBT {

	private int idProfessor;
	private int[] diasDisponiveis = new int[5];
	private int[] disciplinas = new int[32];
	private PesoDiasIndisponivel indisponibilidade;

	public ProfessorBT(Professor professor) {
		super();
		this.idProfessor = professor.getId().intValue();

	}

}

class PesoDiasIndisponivel {
	private int dia;
	private int peso;

	public PesoDiasIndisponivel(int dia, int peso) {
		super();
		this.dia = dia;
		this.peso = peso;
	}

	public int getDia() {
		return dia;
	}

	public int getPeso() {
		return peso;
	}
}