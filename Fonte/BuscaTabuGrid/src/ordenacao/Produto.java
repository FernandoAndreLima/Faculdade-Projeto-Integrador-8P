package ordenacao;

public class Produto {

	private long valor;
	private String nome;

	public Produto(String nome, long valor) {
		this.valor = valor;
		this.nome = nome;
	}

	public long getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}
}
