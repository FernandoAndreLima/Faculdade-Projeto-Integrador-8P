package org.iel.oitavo_periodo.projeto_integrador.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

//@NamedQueries({
//	@NamedQuery(name = "Disciplina.listarTodos", query = "SELECT DISTINCT d FROM Disciplina d "
//			+ "LEFT JOIN FETCH d.professores "),
//
//	@NamedQuery(name = "Disciplina.busca", query = "SELECT DISTINCT d FROM Disciplina d "
//			+ "LEFT JOIN FETCH d.professores " + "where d.id = :pId"),
//
//	@NamedQuery(name = "Disciplina.listaPorPeriodo", query = "SELECT DISTINCT d FROM Disciplina d "
//			+ "LEFT JOIN FETCH d.professores " + "where d.id = :pId") })
//

@Entity
@Table(name = "tab_disciplina")
@XmlRootElement
public class Disciplina implements Serializable {

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

	@Column(length = 200, name = "nome", nullable = false)
	private String nome;

	@Column(length = 200, name = "descricao", nullable = false)
	private String descricao;

	@Column(length = 6, name = "cargaHoraria", nullable = false)
	private String cargaHoraria;

	@ManyToMany(mappedBy = "disciplinas")
	private Set<Professor> professores = new HashSet<Professor>();
	
	@ManyToMany(mappedBy = "disciplinas")
	private Set<Turma>turmas = new HashSet<Turma>();

	@Transient
	public int ramdom;
	
	public Disciplina(String nomeRecebido, String tempoDuracaoRecebida, String descricaoRecebida) {
		this.nome = nomeRecebido;
		this.cargaHoraria = tempoDuracaoRecebida;
		this.descricao = descricaoRecebida;
	}

	public boolean contemDisciplina() {
		return (id != null) && (nome != null && !nome.trim().isEmpty())
				&& (descricao != null && !descricao.trim().isEmpty())
				&& (cargaHoraria != null && !cargaHoraria.trim().isEmpty()) ? true : false;
	}

	public Disciplina() {
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Disciplina)) {
			return false;
		}
		Disciplina other = (Disciplina) obj;
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

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		if (descricao != null && !descricao.trim().isEmpty())
			result += ", descricao: " + descricao;
		if (cargaHoraria != null && !cargaHoraria.trim().isEmpty())
			result += ", cargaHoraria: " + cargaHoraria;
		return result;
	}

}