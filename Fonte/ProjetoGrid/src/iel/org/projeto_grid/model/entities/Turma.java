package iel.org.projeto_grid.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.iel.oitavo_periodo.projeto_integrador.entities.grade.GradeHoraria;
import org.iel.oitavo_periodo.projeto_integrador.enums.PeriodoEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum;
@NamedQueries({
	@NamedQuery(name = "Turma.listaPorCurso", query = ""
			+ "SELECT DISTINCT t FROM Turma t, Professor p, Disciplina d "
			+ "LEFT JOIN FETCH t.curso " 
//			+ "LEFT JOIN FETCH t.grade " 
//			+ "JOIN FETCH t.professores " 
//			+ "JOIN FETCH t.disciplinas " 
			+" where t.curso.id = :pCursoId "),
	
	@NamedQuery(name = "Turma.busca", query = ""
			+ "SELECT DISTINCT t FROM Turma t, Professor p, Disciplina d "
//			+ "LEFT JOIN FETCH t.curso " 
//			+ "LEFT JOIN FETCH t.grade " 
//			+ "LEFT JOIN FETCH t.professores " 
//			+ "LEFT JOIN FETCH t.disciplinas " 
			+" where t.id = :pId"),
 })

@Entity
@Table(name = "tab_turma")
@XmlRootElement
public class Turma implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 4, name = "ano", nullable = false, updatable = false)
	private String ano;

	@Enumerated(EnumType.STRING)
	private SemestreEnum semestre;

	@Enumerated(EnumType.ORDINAL)
	private PeriodoEnum periodo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@OneToOne(fetch = FetchType.EAGER)
	private GradeHoraria grade;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "tab_turma_professor", 
		joinColumns = {@JoinColumn(name = "id_turma", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "id_professor", referencedColumnName = "id") })
	private List<Professor> professores;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "tab_turma_disciplina", 
		joinColumns = {@JoinColumn(name = "id_turma", referencedColumnName = "id") },
		inverseJoinColumns = {@JoinColumn(name = "id_disciplina", referencedColumnName = "id") })
	private List<Disciplina> disciplinas;
	@Transient
	public int ramdom;
	
	public Turma() {}
	
	public Turma(List<Disciplina> disciplinasInformadas, List<Professor> professoresInformados, Curso cursoInformado,
			PeriodoEnum periodoInformado, SemestreEnum semestreInformado, String anoInformado) {
		
		this.professores = new ArrayList<Professor>(professoresInformados);
		this.disciplinas = new ArrayList<Disciplina>(disciplinasInformadas);
		
//		this.professores = professoresInformados.stream()
//				.map(p -> new Professor(p.getNomeCompleto(), p.getRegime(), p.getDataAdmissao(), p.getCargo(), p.getFormacao(), p.getTitulacao(), p.getDisciplinas()))
//				.collect(Collectors.toSet());
//		
//		this.disciplinas = disciplinasInformadas.stream()
//				.map(p -> new Disciplina(p.getNome(), p.getCargaHoraria(), p.getCargaHoraria()))
//				.collect(Collectors.toSet());
		
		
		this.curso = cursoInformado;
		this.periodo = periodoInformado;
		this.semestre = semestreInformado;
		this.ano = anoInformado;
	}

	public void addAllToDisciplinas(Set<Disciplina> disciplinasInformadas) {
		for(Disciplina disciplina : disciplinasInformadas)
			System.out.println(addDisciplinaToSet(disciplina));
	}
	
	public boolean addDisciplinaToSet(Disciplina disciplina) {
		return this.disciplinas.add(disciplina);
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Long getId() {
		return this.id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Turma)) {
			return false;
		}
		Turma other = (Turma) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public SemestreEnum getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreEnum semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Turma [ano=" + ano + ", semestre=" + semestre + ", periodo=" + periodo + ", curso=" + curso + ", grade="
				+ grade + ", professores=" + professores + ", disciplinas=" + disciplinas + "]";
	}
	
	public PeriodoEnum getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoEnum periodo) {
		this.periodo = periodo;
	}

	public GradeHoraria getGrade() {
		return grade;
	}

	public void setGrade(GradeHoraria grade) {
		this.grade = grade;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores.addAll(professores);
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas.addAll(disciplinas);
	}
}