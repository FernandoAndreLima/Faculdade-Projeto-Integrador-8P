package iel.org.projeto_grid.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.NotNull;

import iel.org.projeto_grid.model.enums.DiasEnum;
import iel.org.projeto_grid.model.enums.Periodo;

/**
 * Objeto Grade Horária por periodo/turma
 * 
 * @author anderson
 *
 */
@Entity
@Table(name = "tab_grade_horaria")
@XmlRootElement
public class GradeHoraria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Periodo periodo;
	
	@NotNull
//	@NotBlank
	@Column(length = 4)
	private String ano;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Aula aulaSegunda;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Aula aulaTerca;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Aula aulaQuarta;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Aula aulaQuinta;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Aula aulaSexta;

	@Transient
	private List<Professor> professores = new ArrayList<Professor>();

	@Transient
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	@Transient
	private List<Disciplina> listaTabu = new ArrayList<Disciplina>();
	
	@Transient
	private List<Professor> professoresAtualizados = new ArrayList<Professor>();

	public GradeHoraria(Periodo periodoAnoInformado, String anoInformado, List<Professor> professoresInformados,
			List<Disciplina> disciplinasInformadas) {

		this.periodo = periodoAnoInformado;
		this.ano = anoInformado;
		this.professores.addAll(professoresInformados);
		this.disciplinas.addAll(disciplinasInformadas);

		this.aulaSegunda = new Aula(buscaDisciplina(), DiasEnum.SEGUNDA_FEIRA);
		this.aulaTerca = new Aula(buscaDisciplina(), DiasEnum.TERCA_FEIRA);
		this.aulaQuarta = new Aula(buscaDisciplina(), DiasEnum.QUARTA_FEIRA);
		this.aulaQuinta = new Aula(buscaDisciplina(), DiasEnum.QUINTA_FEIRA);
		this.aulaSexta = new Aula(buscaDisciplina(), DiasEnum.SEXTA_FEIRA);

	}
	
	public boolean verificaSeProfessorJaLecionaNaGrade(Professor professor) {
		boolean jaLeciona = false;
		
		if(getAulaSegunda().getProfessor() != null) {
			if((getAulaSegunda().getProfessor().contemProfessor())
					&& (getAulaSegunda().getProfessor().getNomeCompleto().equals(professor.getNomeCompleto())))
				jaLeciona = true;
		}
		
		if(getAulaTerca().getProfessor() != null) {
			if(getAulaTerca().getProfessor().contemProfessor()
					&& (getAulaTerca().getProfessor().getNomeCompleto().equals(professor.getNomeCompleto())))
				jaLeciona = true;
		}
		
		if(getAulaQuarta().getProfessor() != null) {
			if((getAulaQuarta().getProfessor().contemProfessor())
					&& (getAulaQuarta().getProfessor().getNomeCompleto().equals(professor.getNomeCompleto())))
				jaLeciona = true;
		}
		
		if(getAulaQuinta().getProfessor() != null) {
			if((getAulaQuinta().getProfessor().contemProfessor())
					&& (getAulaQuinta().getProfessor().getNomeCompleto().equals(professor.getNomeCompleto())))
				jaLeciona = true;
		}
		
		if(getAulaSexta().getProfessor() != null) {
			if((getAulaSexta().getProfessor().contemProfessor())
					&& (getAulaSexta().getProfessor().getNomeCompleto().equals(professor.getNomeCompleto())))
				jaLeciona = true;
		}
		return jaLeciona;
	}
	
	public void addProfessorAtualizado(Professor professor) {
		int indiceASerRemovido = 0;
		for(Professor professor2 : professoresAtualizados) {
			if((professor.getNomeCompleto().equals(professor2.getNomeCompleto())) && (professor.getDisponibilidade().qtdaDiasDisponiveis() != professor2.getDisponibilidade().qtdaDiasDisponiveis())) {
				indiceASerRemovido = professoresAtualizados.indexOf(professor2);
				professoresAtualizados.add(professor);
			}
		}
		professoresAtualizados.remove(indiceASerRemovido);

	}
	
	
	public GradeHoraria() {}

	private Disciplina buscaDisciplina() {
		Disciplina retorno = new Disciplina();
		boolean sair = false;
		while (!sair) {
			loopDisciplina: for (Disciplina disciplinaAtual : disciplinas) {
				if (!listaTabu.contains(disciplinaAtual)) {
					retorno = disciplinaAtual;
					listaTabu.add(disciplinaAtual);
					sair = true;
					break loopDisciplina;
				}
			}
		}
		return retorno;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodoAno) {
		this.periodo = periodoAno;
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

	public List<Disciplina> getListaTabu() {
		return listaTabu;
	}

	public void setListaTabu(List<Disciplina> listaTabu) {
		this.listaTabu = listaTabu;
	}



	public Aula getAulaSegunda() {
		return aulaSegunda;
	}

	public void setAulaSegunda(Aula aulaSegunda) {
		this.aulaSegunda = aulaSegunda;
	}

	public Aula getAulaTerca() {
		return aulaTerca;
	}

	public void setAulaTerca(Aula aulaTerca) {
		this.aulaTerca = aulaTerca;
	}

	public Aula getAulaQuarta() {
		return aulaQuarta;
	}

	public void setAulaQuarta(Aula aulaQuarta) {
		this.aulaQuarta = aulaQuarta;
	}

	public Aula getAulaQuinta() {
		return aulaQuinta;
	}

	public void setAulaQuinta(Aula aulaQuinta) {
		this.aulaQuinta = aulaQuinta;
	}

	public Aula getAulaSexta() {
		return aulaSexta;
	}

	public void setAulaSexta(Aula aulaSexta) {
		this.aulaSexta = aulaSexta;
	}

	@Override
	public String toString() {
		return "GradeHoraria [periodoAno=" + periodo + ", \naulaSegunda=" + aulaSegunda + ", \naulaTerca=" + aulaTerca
				+ ", \naulaQuarta=" + aulaQuarta + ", \naulaQuinta=" + aulaQuinta + ", \naulaSexta=" + aulaSexta + "]";
	}

	public boolean verificaSeTodasAsAulasEstaoPreenchidas() {
		boolean estaoPreenchidas = true;
		
		if(!getAulaSegunda().isAulaCompleta())
			estaoPreenchidas = false;
		
		if(!getAulaTerca().isAulaCompleta())
			estaoPreenchidas = false;
		
		if(!getAulaQuarta().isAulaCompleta())
			estaoPreenchidas = false;
		
		if(!getAulaQuinta().isAulaCompleta())
			estaoPreenchidas = false;
		
		if(!getAulaSexta().isAulaCompleta())
			estaoPreenchidas = false;
			
		return estaoPreenchidas;
	}
	
}
