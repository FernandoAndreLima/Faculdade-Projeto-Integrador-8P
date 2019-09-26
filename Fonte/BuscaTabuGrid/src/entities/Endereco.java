package entities;

import java.io.Serializable;

public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private String nomeRua;

	private String complemento;

	private String bairro;

	private String municipio;

	private String cep;

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