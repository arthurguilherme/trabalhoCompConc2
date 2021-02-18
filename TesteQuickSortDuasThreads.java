
/**
 * @author Arthur Guilherme Souza
 *
 */
public class TesteQuickSortDuasThreads {
	boolean ModoImpressaoOuArquivo;
	VetorIntegerAleatorio vetor;
	QuickSortDuasThreads teste;
	int primeiro, ultimo;
	int dimensao;

	/**
	 * @param modoImpressaoOuArquivo
	 * @param vetor
	 * @param teste
	 */
	public TesteQuickSortDuasThreads(boolean modoImpressaoOuArquivo, int dimensao, int primeiro, int ultimo) {
		ModoImpressaoOuArquivo = modoImpressaoOuArquivo;
		this.primeiro = primeiro;
		this.ultimo = ultimo;
		this.dimensao = dimensao;
	}

	public TesteQuickSortDuasThreads(boolean modoImpressaoOuArquivo, int dimensao) {
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

		// Se verdadeiro imprime o arquivo
		if (ModoImpressaoOuArquivo) {

			// imprime o vetor desordenado
			vetor.imprime();

			// realiza o primeiro particionamento para dividir o vetor em 2
			// de forma que cada Thread fique com "um lado" do vetor (esquerdo ou direito)
			teste = new QuickSortDuasThreads(vetor);
			teste.quickSort();

			// instancia as threads
			Thread threadE = new Thread(new TarefaQuickSortEsquerda(teste));
			Thread threadD = new Thread(new TarefaQuickSortDireita(teste));

			// Inicia a ordenacao
			threadD.start();
			threadE.start();

			try {
				threadE.join();
				threadD.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// imprime o vetor ordenado
			vetor.imprime();
		}
		// se falso salva o arquivo
		else {
			// salva arquivo com o vetor desordenado
			vetor.salvaArquivo("vetorDesordenadoDuasThreads.txt");

			// realiza o primeiro particionamento para dividir o vetor em 2
			// de forma que cada Thread fique com "um lado" do vetor (esquerdo ou direito)
			teste = new QuickSortDuasThreads(vetor);
			teste.quickSort();

			// instancia as threads
			Thread threadE = new Thread(new TarefaQuickSortEsquerda(teste));
			Thread threadD = new Thread(new TarefaQuickSortDireita(teste));

			// Inicia a ordenacao
			threadD.start();
			threadE.start();

			try {
				threadE.join();
				threadD.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// salva arquivo com o vetor ordenado
			vetor.salvaArquivo("vetorOrdenadoDuasThreads.txt");
		}
	}
}
