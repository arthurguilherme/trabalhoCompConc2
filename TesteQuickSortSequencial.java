
public class TesteQuickSortSequencial {

	boolean ModoImpressaoOuArquivo;
	VetorIntegerAleatorio vetor;
	QuickSortSequencial teste;
	int primeiro, ultimo;
	int dimensao;

	/**
	 * @param modoImpressaoOuArquivo
	 * @param vetor
	 * @param teste
	 */
	public TesteQuickSortSequencial(boolean modoImpressaoOuArquivo, int dimensao, int primeiro, int ultimo) {
		ModoImpressaoOuArquivo = modoImpressaoOuArquivo;
		this.primeiro = primeiro;
		this.ultimo = ultimo;
		this.dimensao = dimensao;
	}

	public TesteQuickSortSequencial(boolean modoImpressaoOuArquivo, int dimensao) {
		ModoImpressaoOuArquivo = modoImpressaoOuArquivo;
		this.primeiro = 0;
		this.ultimo = dimensao;
		this.dimensao = dimensao;
	}

	public void teste() {
		// instancia o vetor
		vetor = new VetorIntegerAleatorio(dimensao);

		// popula o vetor
		vetor.geraVetorAleatorio(primeiro, ultimo);

		// Se true Imprime o arquivo
		if (ModoImpressaoOuArquivo) {

			// imprime o vetor desordenado
			vetor.imprime();

			// realiza a ordenacao sequencial
			teste = new QuickSortSequencial(vetor);
			teste.quickSort();

			// imprime o vetor desordenado
			vetor.imprime();
		}
		// se falso salva o arquivo
		else {
			// salva arquivo com o vetor desordenado
			vetor.salvaArquivo("vetorDesordenadoSequencial.txt");

			// realiza a ordenacao sequencial
			teste = new QuickSortSequencial(vetor);
			teste.quickSort();

			// salva arquivo com o vetor ordenado
			vetor.salvaArquivo("vetorOrdenadoSequencial.txt");
		}
	}

}
