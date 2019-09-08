package org.iel.oitavo_periodo.projeto_integrador.entities;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import org.iel.oitavo_periodo.projeto_integrador.entities.Endereco;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "tab-instituicao")
@XmlRootElement
public class Instituicao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 15, name = "cnpj", nullable = false)
	private String cnpj;

	@OneToMany
	private Set<Endereco> endereco = new HashSet<Endereco>();

	@Column(length = 200, name = "razao_social", nullable = false)
	private String razaoSocial;

	@Column(length = 200, name = "nome_fantasia", nullable = false)
	private String nomeFantasia;

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
		if (!(obj instanceof Instituicao)) {
			return false;
		}
		Instituicao other = (Instituicao) obj;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Set<Endereco> getEndereco() {
		return this.endereco;
	}

	public void setEndereco(final Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (cnpj != null && !cnpj.trim().isEmpty())
			result += ", cnpj: " + cnpj;
		if (endereco != null)
			result += ", endereco: " + endereco;
		if (razaoSocial != null && !razaoSocial.trim().isEmpty())
			result += ", razaoSocial: " + razaoSocial;
		if (nomeFantasia != null && !nomeFantasia.trim().isEmpty())
			result += ", nomeFantasia: " + nomeFantasia;
		return result;
	}
}