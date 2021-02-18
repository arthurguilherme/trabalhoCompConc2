

/**
 * @author Arthur Guilherme Souza
 *
 */

public class TarefaQuickSortDireita implements Runnable{
	
	QuickSortDuasThreads vetor;

	public TarefaQuickSortDireita(QuickSortDuasThreads vetor) {
		this.vetor = vetor;
	}

	@Override
	public void run() {

		// chama a particao da esquerda.
		vetor.quickSortD(vetor.getPivoInicial(), vetor.getDimensao() - 1);
	}
}
