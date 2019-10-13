package algoritmo.busca_tabu;

public class BuscaTabu {

	
}
class ListaTabu {
	
}

class ObjetoTabu{
	private int idadeObjetoBT;
	
	private ObjetoGradeCurricular objeto;

	public ObjetoTabu(int idadeObjetoBT, ObjetoGradeCurricular objeto) {
		super();
		this.idadeObjetoBT = idadeObjetoBT;
		this.objeto = objeto;
	}

	public int getIdadeObjetoBT() {
		return idadeObjetoBT;
	}

	public ObjetoGradeCurricular getObjeto() {
		return objeto;
	}

}

class ObjetoGradeCurricular{
	private int id;
	private int dia;
	private int professor;
	private int disciplina;
	private int curso;
		
	public ObjetoGradeCurricular(int id, int dia, int professor, int disciplina, int curso) {
		super();
		this.id = id;
		this.dia = dia;
		this.professor = professor;
		this.disciplina = disciplina;
		this.curso = curso;
	}
	
	public int getId() {
		return id;
	}
	public int getDia() {
		return dia;
	}
	public int getProfessor() {
		return professor;
	}
	public int getDisciplina() {
		return disciplina;
	}
	public int getCurso() {
		return curso;
	}
	
	
	
}