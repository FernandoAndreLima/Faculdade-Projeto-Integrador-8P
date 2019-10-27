package org.iel.oitavo_periodo.projeto_integrador.entities.grade;

import enums.Periodo;

public class PeriodoAno {
	private Periodo periodo;
	private String ano;

	public PeriodoAno(Periodo periodo, String ano) {
		super();
		this.periodo = periodo;
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "PeriodoAno [periodo=" + periodo + ", ano=" + ano + "]";
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}