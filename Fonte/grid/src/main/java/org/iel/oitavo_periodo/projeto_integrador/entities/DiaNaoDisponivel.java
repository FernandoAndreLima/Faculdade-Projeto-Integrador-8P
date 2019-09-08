package org.iel.oitavo_periodo.projeto_integrador.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.iel.oitavo_periodo.projeto_integrador.enums.DiasEnum;
import org.iel.oitavo_periodo.projeto_integrador.enums.GrauMotivoEnum;
@Entity
@Table(name = "tab-dia-nao-disponivel")
@XmlRootElement
public class DiaNaoDisponivel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private DiasEnum dia;

	@Column(length = 150, name = "motivo", nullable = false)
	private String motivo;

	@Enumerated(EnumType.STRING)
	private GrauMotivoEnum grauMotivo;

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
		if (!(obj instanceof DiaNaoDisponivel)) {
			return false;
		}
		DiaNaoDisponivel other = (DiaNaoDisponivel) obj;
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

	public DiasEnum getDia() {
		return dia;
	}

	public void setDia(DiasEnum dia) {
		this.dia = dia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public GrauMotivoEnum getGrauMotivo() {
		return grauMotivo;
	}

	public void setGrauMotivo(GrauMotivoEnum grauMotivo) {
		this.grauMotivo = grauMotivo;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (dia != null)
			result += ", dia: " + dia;
		if (motivo != null && !motivo.trim().isEmpty())
			result += ", motivo: " + motivo;
		if (grauMotivo != null)
			result += ", grauMotivo: " + grauMotivo;
		return result;
	}
}