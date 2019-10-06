package ordenacao;

public class MainProduto {

	public static void main(String[] args) {
		Produto produtos[] = { new Produto("Lamborghini", 1000000), new Produto("Jipe", 46000),
				new Produto("Brasilia", 16000), new Produto("Smart", 46000), new Produto("Fusca", 17000) };
		int maisCaro = carroMaisCaro(produtos, 0, 4);
		int maisBararo = carroMaisBarato(produtos, 0, 4);

		System.out.println(maisBararo);
		System.out.println("O produto mais barato é: " + produtos[maisBararo].getNome() + " com o valor de R$"
				+ produtos[maisBararo].getValor());

		System.out.println(maisCaro);
		System.out.println("O produto mais caro é: " + produtos[maisCaro].getNome() + " com o valor de R$"
				+ produtos[maisCaro].getValor());
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