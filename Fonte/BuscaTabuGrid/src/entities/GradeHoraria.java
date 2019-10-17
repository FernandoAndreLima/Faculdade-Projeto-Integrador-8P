package entities;

import java.util.HashSet;
import java.util.Set;

import enums.DiasEnum;
import enums.Periodo;

public class GradeHoraria {
	PeriodoAno periodoAno;
		
	Set<ProfessorDiciplinaDia> professorDiciplinaDia = new HashSet<ProfessorDiciplinaDia>();	
	
	public PeriodoAno getPeriodoAno() {
		return periodoAno;
	}
	public void setPeriodoAno(PeriodoAno periodoAno) {
		this.periodoAno = periodoAno;
	}
}

class ProfessorDiciplinaDia{
	Professor professor;
	Disciplina disciplina;
	DiasEnum diasSemana;
}

class PeriodoAno{
	Periodo periodo;
	String ano;
	
	@Override
	public String toString() {
		return "PeriodoAno [periodo=" + periodo + ", ano=" + ano + "]";
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
}