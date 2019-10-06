package entities;

import enums.DiasEnum;

public class GradeAulaDia {

	private long id;
	private DiasEnum dia;
	private Professor professor;
	private Disciplina disciplina;

	public boolean isPreenchido() {
		return (dia.ordinal() > 0) 
				&& professor.contemProfessor() 
				&& disciplina.contemDisciplina() 
				? true : false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DiasEnum getDia() {
		return dia;
	}

	public void setDia(DiasEnum dia) {
		this.dia = dia;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
