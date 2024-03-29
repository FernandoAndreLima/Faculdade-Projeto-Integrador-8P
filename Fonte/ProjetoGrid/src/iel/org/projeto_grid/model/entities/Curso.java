package iel.org.projeto_grid.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tab_curso")
@XmlRootElement
public class Curso implements Serializable {

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

	@Column(length = 6, name = "tempo_duracao", nullable = false)
	private String tempoDuracao;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tab_curso_diciplina", joinColumns = {
			@JoinColumn(name = "id_curso", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_disciplina", referencedColumnName = "id") })
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Turma> turmas = new ArrayList<Turma>();

	@Transient
	private List<Professor> professores = new ArrayList<Professor>();

	public Curso() {
	}

	public Curso(String nomeRecebido, String descricaoRecebido, String tempoDusracaoRecebido) {
		this.nome = nomeRecebido;
		this.descricao = descricaoRecebido;
		this.tempoDuracao = tempoDusracaoRecebido;

//		System.out.println("Curso "+nomeRecebido+" foi criado com sucesso");
	}

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
		if (!(obj instanceof Curso)) {
			return false;
		}
		Curso other = (Curso) obj;
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

	public String getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(String tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
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
		if (tempoDuracao != null && !tempoDuracao.trim().isEmpty())
			result += ", tempoDuracao: " + tempoDuracao;
		return result;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores.addAll(professores);
	}
}