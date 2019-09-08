package org.iel.oitavo_periodo.projeto_integrador.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.iel.oitavo_periodo.projeto_integrador.enums.CargoEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.FormacaoEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.RegimeEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.TitulacaoEnum;

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

	@ManyToMany
	@JoinTable(name = "professor_disciplina", joinColumns = @JoinColumn(name = "id_professor"), inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
	private Set<Disciplina> disciplinas = new HashSet<>();

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
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

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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

	public TitulacaoEnum getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(TitulacaoEnum titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (nomeCompleto != null && !nomeCompleto.trim().isEmpty())
			result += ", nomeCompleto: " + nomeCompleto;
		if (regime != null)
			result += ", regime: " + regime;
		if (dataAdmissao != null)
			result += ", dataAdmissao: " + dataAdmissao;
		if (cargo != null)
			result += ", cargo: " + cargo;
		if (formacao != null)
			result += ", formacao: " + formacao;
		if (titulacao != null)
			result += ", titulacao: " + titulacao;
		return result;
	}
}