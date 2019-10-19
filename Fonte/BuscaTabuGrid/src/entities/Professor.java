package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import enums.CargoEnum;
import enums.DiasEnum;
import enums.FormacaoEnum;
import enums.RegimeEnum;

public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private String nomeCompleto;

	private RegimeEnum regime;

	private Date dataAdmissao;

	private CargoEnum cargo;

	private FormacaoEnum formacao;

	private Set<Disciplina> disciplinas = new HashSet<>();

	private DisponibilidadeProfessor disponibilidade;

	public DisponibilidadeProfessor getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadeProfessor disponibilidade) {
		this.disponibilidade = disponibilidade;
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

	public Professor(Long id, int version, String nomeCompleto, RegimeEnum regime, Date dataAdmissao, CargoEnum cargo,
			FormacaoEnum formacao) {
		super();
		this.id = id;
		this.version = version;
		this.nomeCompleto = nomeCompleto;
		this.regime = regime;
		this.dataAdmissao = dataAdmissao;
		this.cargo = cargo;
		this.formacao = formacao;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
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

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas.addAll(disciplinas);
	}

	// liberando geral
	public boolean possuiDisponibilidadeNoDia(DiasEnum dia) {
		// TODO Auto-generated method stub
		return true;
	}
}