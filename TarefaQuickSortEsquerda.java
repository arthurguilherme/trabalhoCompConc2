

/**
 * @author Arthur Guilherme Souza
 *
 */

public class TarefaQuickSortEsquerda implements Runnable {

	QuickSortDuasThreads vetor;

	public TarefaQuickSortEsquerda(QuickSortDuasThreads vetor) {
		this.vetor = vetor;
	}

	@Override
	public void run() {

		// chama a particao da esquerda.
		vetor.quickSortE(0, vetor.getPivoInicial());
	}

}
