package ordenacao;

public class MainProduto {

	public static void main(String[] args) {
		Produto produtos[] = { 
				new Produto("Lamborghini", 1000000), 
				new Produto("Jipe", 46000),
				new Produto("Brasilia", 16000),
				new Produto("Smart", 46000), 
				new Produto("Fusca", 17000) };
		int[] maisBaratomaisCaro = verificaOMaisBaratoECaro(produtos, 0,4);

		System.out.println(maisBaratomaisCaro[0]);
		System.out.println("O produto mais barato é: " + produtos[maisBaratomaisCaro[0]].getNome() +
				" com o valor de R$"+ produtos[maisBaratomaisCaro[0]].getValor());
		
		System.out.println(maisBaratomaisCaro[1]);
		System.out.println("O produto mais caro é: " + produtos[maisBaratomaisCaro[1]].getNome() +
				" com o valor de R$"+ produtos[maisBaratomaisCaro[1]].getValor());
	}

	public static int [] verificaOMaisBaratoECaro(Produto produtos[], int inicio, int termino) {

		int maisBarato = 0;
		int maisCaro = 0;
		int[] retorno = new int[2];
		
		for (int atual = inicio; atual <= termino; atual++) {
			if (produtos[atual].getValor() < produtos[maisBarato].getValor()) {
				maisBarato = atual; retorno[0] = maisBarato;
			}
			else if(produtos[atual].getValor() > produtos[maisCaro].getValor()) {
				maisCaro = atual; retorno[1] = maisCaro;
			}
		}
		return retorno;
	}
	
	public static int carroMaisBarato(Produto produtos[], int inicio, int termino) {
		int maisBarato = 0;
		
		for (int atual = inicio; atual <= termino; atual++) {
			if (produtos[atual].getValor() < produtos[maisBarato].getValor()) 
				maisBarato = atual; 

		}
		return maisBarato;
	}
	
	public static int carroMaisCaro(Produto produtos[], int inicio, int termino) {
		int maisCaro = 0;
		
		for (int atual = inicio; atual <= termino; atual++) {
			if (produtos[atual].getValor() > produtos[maisCaro].getValor()) 
				maisCaro = atual; 

		}
		return maisCaro;
	}
}

class Produto {

	private int valor;
	private String nome;

	public Produto(String nome, int valor) {
		super();
		this.valor = valor;
		this.nome = nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}