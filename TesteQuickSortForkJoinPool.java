import java.util.concurrent.ForkJoinPool;

/**
 * @author Arthur Guilherme Souza
 *
 */

public class TesteQuickSortForkJoinPool {
	boolean ModoImpressaoOuArquivo;
	VetorIntegerAleatorio vetor;
	QuickSortForkJoinPool teste;
	int primeiro, ultimo;
	int dimensao;
	
	// cria um pool de threads Fork/Join
	ForkJoinPool pool = new ForkJoinPool();

	/**
	 * @param modoImpressaoOuArquivo
	 * @param vetor
	 * @param teste
	 */
	public TesteQuickSortForkJoinPool(boolean modoImpressaoOuArquivo, int dimensao, int primeiro, int ultimo) {
		ModoImpressaoOuArquivo = modoImpressaoOuArquivo;
		this.primeiro = primeiro;
		this.ultimo = ultimo;
		this.dimensao = dimensao;
	}

	public TesteQuickSortForkJoinPool(boolean modoImpressaoOuArquivo, int dimensao) {
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

			// realiza a ordenacao concorrente
			teste = new QuickSortForkJoinPool(vetor);
			pool.invoke(teste);
			// imprime o vetor desordenado
			vetor.imprime();
		}
		// se falso salva o arquivo
		else {
			// salva arquivo com o vetor desordenado
			vetor.salvaArquivo("vetorDesordenadoPoolDeThreads.txt");

			// realiza a ordenacao sequencial
			teste = new QuickSortForkJoinPool(vetor);
			pool.invoke(teste);

			// salva arquivo com o vetor ordenado
			vetor.salvaArquivo("vetorOrdenadoPoolDeThreads.txt");
		}
	}
}
