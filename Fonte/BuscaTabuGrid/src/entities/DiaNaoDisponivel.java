package entities;

import java.io.Serializable;

import enums.DiasEnum;
import enums.GrauMotivoEnum;

public class DiaNaoDisponivel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private DiasEnum dia;

	private String motivo;

	private GrauMotivoEnum grauMotivo;

	private DisponibilidadeProfessor disponibilidade;

	public DisponibilidadeProfessor getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadeProfessor disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

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