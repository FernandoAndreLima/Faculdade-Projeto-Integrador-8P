package algoritmo.busca_tabu.old;

import java.util.HashSet;
import java.util.Set;

public class BuscaTabu {

	public ListaTabu lista = new ListaTabu();
	
}

class ListaTabu {
	private Set<ObjetoTabu> lista = new HashSet<>();

	public ListaTabu() {
		if (lista.isEmpty())
			this.lista = new HashSet<>();
	}

	public void adicionaItem(ObjetoTabu objeto) {
		this.lista.add(objeto);
	}

	public ObjetoTabu buscaObjeto(int idItem) {
		int cont = 0;
		for (ObjetoTabu objetoTabu : lista) {
			if (cont == idItem) {
				return objetoTabu;
			} else {
				cont++;
			}
		}
		return null;
	}

	public boolean contemObjeto(int idItem) {
		int cont = 0;
		for (ObjetoTabu objetoTabu : lista) {
			if (cont == idItem) {
				return true;
			} else {
				cont++;
			}
		}
		return false;
	}
	
	public boolean removeItem(int idItem) {
		if(contemObjeto(idItem))
			lista.remove(buscaObjeto(idItem));
		
		return !contemObjeto(idItem)? true : false;
	}
}

class ObjetoTabu {

	private int id;

	private int idadeObjetoBT;

	private ObjetoGradeCurricular objeto;

	private int[] gradeCurricularBinaria;

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

	public int[] getGradeCurricularBinaria() {
		return gradeCurricularBinaria;
	}

}

class ObjetoGradeCurricular {
	
	private int[] 
	
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
		this.gradeCurricularBinaria = converteObjetoGradeEmObjetoBinario(objeto);
	}
	
	/*
	 * estou pensando em utilizar objetos mesmo
	 */
	private int[] converteObjetoGradeEmObjetoBinario(ObjetoGradeCurricular objeto) {
		
		int[] array = {
				objeto.getId(),
				objeto.getDia(),
				objeto.getDisciplina(),
				objeto.getProfessor(),
				objeto.getCurso()
		};
		
		return array;
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