package org.iel.oitavo_periodo.projeto_integrador.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tab_endereco")
@XmlRootElement

public class Endereco implements Serializable {

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

	@Column(length = 50, name = "nome_rua", nullable = false)
	private String nomeRua;

	@Column(length = 50, name = "complemento", nullable = false)
	private String complemento;

	@Column(length = 50, name = "bairro", nullable = false)
	private String bairro;

	@Column(length = 50, name = "municipio", nullable = false)
	private String municipio;

	@Column(length = 50, name = "cep", nullable = false)
	private String cep;

	public Endereco() {}
	
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
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
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

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (nomeRua != null && !nomeRua.trim().isEmpty())
			result += ", nomeRua: " + nomeRua;
		if (complemento != null && !complemento.trim().isEmpty())
			result += ", complemento: " + complemento;
		if (bairro != null && !bairro.trim().isEmpty())
			result += ", bairro: " + bairro;
		if (municipio != null && !municipio.trim().isEmpty())
			result += ", municipio: " + municipio;
		if (cep != null && !cep.trim().isEmpty())
			result += ", cep: " + cep;
		return result;
	}
}