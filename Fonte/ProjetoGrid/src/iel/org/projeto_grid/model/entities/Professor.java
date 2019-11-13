package iel.org.projeto_grid.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import iel.org.projeto_grid.model.enums.CargoEnum;
import iel.org.projeto_grid.model.enums.DiasEnum;
import iel.org.projeto_grid.model.enums.FormacaoEnum;
import iel.org.projeto_grid.model.enums.RegimeEnum;
import iel.org.projeto_grid.model.enums.TitulacaoEnum;

@NamedQueries({
		@NamedQuery(name = "Professor.listarTodos", query = "SELECT DISTINCT p FROM Professor p "
				+ "LEFT JOIN FETCH p.disciplinas " + "LEFT JOIN FETCH p.disponibilidade"),

		@NamedQuery(name = "Professor.busca", query = "SELECT DISTINCT p FROM Professor p "
				+ "LEFT JOIN FETCH p.disciplinas " + "LEFT JOIN FETCH p.disponibilidade " + "where p.id = :pId"),
		
		@NamedQuery(name = "Professor.listaTodosPorTurma", query = "SELECT DISTINCT p FROM Professor p "
				+ "LEFT JOIN FETCH p.disponibilidade " + "LEFT JOIN FETCH p.turmas "),

		@NamedQuery(name = "Professor.disciplina", query = "SELECT DISTINCT p FROM Professor p "
				+ "LEFT JOIN FETCH p.disciplinas " + "LEFT JOIN FETCH p.disponibilidade " + "where p.id = :pId") })

@Entity
@Table(name = "tab_professor")
@XmlRootElement
public class Professor implements Serializable {

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

	@Column(length = 200, name = "nome_completo", nullable = false)
	private String nomeCompleto;

	@Enumerated(EnumType.STRING)
	private RegimeEnum regime;

	@Column(name = "data_admissao")
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Enumerated(EnumType.STRING)
	private CargoEnum cargo;

	@Enumerated(EnumType.STRING)
	private FormacaoEnum formacao;

	@Enumerated(EnumType.STRING)
	private TitulacaoEnum titulacao;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "tab_professor_disciplina", 
		joinColumns = {@JoinColumn(name = "id_professor", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "id_disciplina", referencedColumnName = "id") })
	private List<Disciplina> disciplinas = new ArrayList<>();

	@OneToOne(mappedBy = "professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private DisponibilidadeProfessor disponibilidade;
	
	@ManyToMany(mappedBy = "professores")
	private List<Turma> turmas = new ArrayList<Turma>();

	@Transient
	public int ramdom;
	
	public DisponibilidadeProfessor getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadeProfessor disponibilidadesRecebidas) {
		this.disponibilidade = disponibilidadesRecebidas;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public boolean conheceDisciplina(Disciplina disciplina) {
		return disciplinas.contains(disciplina);
	}

	public boolean contemProfessor() {
		return (id != null) && (nomeCompleto != null && !nomeCompleto.trim().isEmpty()) && (regime != null)
				&& (cargo != null) && (dataAdmissao != null) && (formacao != null) ? true : false;
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public Professor() {

	}

	public Professor(String nomeCompletoRecevido, RegimeEnum regimeRecevido, Date dataAdmissaoRecevido,
			CargoEnum cargoRecevido, FormacaoEnum formacaoRecevido, TitulacaoEnum tituloRecevido) {

		this.nomeCompleto = nomeCompletoRecevido;
		this.regime = regimeRecevido;
		this.dataAdmissao = dataAdmissaoRecevido;
		this.cargo = cargoRecevido;
		this.formacao = formacaoRecevido;
		this.titulacao = tituloRecevido;

	}
	
	public Professor(String nomeCompletoRecevido, RegimeEnum regimeRecevido, Date dataAdmissaoRecevido,
			CargoEnum cargoRecevido, FormacaoEnum formacaoRecevido, TitulacaoEnum tituloRecevido, List<Disciplina> disciplinasRecebidas) {

		this.nomeCompleto = nomeCompletoRecevido;
		this.regime = regimeRecevido;
		this.dataAdmissao = dataAdmissaoRecevido;
		this.cargo = cargoRecevido;
		this.formacao = formacaoRecevido;
		this.titulacao = tituloRecevido;
		
		this.disciplinas.addAll(disciplinasRecebidas);

	}

	public Long getId() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Professor)) {
			return false;
		}
		Professor other = (Professor) obj;
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

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public RegimeEnum getRegime() {
		return regime;
	}

	public void setRegime(RegimeEnum regime) {
		this.regime = regime;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}

	public FormacaoEnum getFormacao() {
		return formacao;
	}

	public void setFormacao(FormacaoEnum formacao) {
		this.formacao = formacao;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", version=" + version + ", nomeCompleto=" + nomeCompleto + ", regime=" + regime
				+ ", dataAdmissao=" + dataAdmissao + ", cargo=" + cargo + ", formacao=" + formacao + ", disciplinas="
				+ disciplinas + "]";
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas.addAll(disciplinas);
	}

	// liberando geral
	public boolean possuiDisponibilidadeNoDia(DiasEnum dia) {
		// TODO Auto-generated method stub
		return true;
	}

	public TitulacaoEnum getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(TitulacaoEnum titulacao) {
		this.titulacao = titulacao;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

}