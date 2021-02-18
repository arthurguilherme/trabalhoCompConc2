import java.util.concurrent.RecursiveAction;

public class QuickSortForkJoinPool extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	private VetorIntegerAleatorio vetor;
	private int inicio, fim;

	// ordena o subarray do índice 'inicio' até 'fim'
	private QuickSortForkJoinPool(VetorIntegerAleatorio vetor, int inicio, int fim) {
		this.vetor = vetor;
		this.inicio = inicio;
		this.fim = fim;
	}

	// construtor chamado pelo metodo main, determina a dimensao do vetor
	public QuickSortForkJoinPool(VetorIntegerAleatorio vetor) {
		this(vetor, 0, vetor.getDimensao() - 1);
	}

	// executa o Quicksort paralelamente com Fork-Join
	@Override
	protected void compute() {
		if (fim > inicio) {
			int q = particao(vetor, inicio, fim); // obtém o pivô (join)
			// realiza as chamadas recursivas paralelamente (fork)
			invokeAll(new QuickSortForkJoinPool(vetor, inicio, q - 1), new QuickSortForkJoinPool(vetor, q + 1, fim));
		}
	}

	// Método de partição
	private int particao(VetorIntegerAleatorio vetor, int inicio, int fim) {
		// o pivo é o elemento inicial
		int pivo = vetor.getValorPosicaoVetor(inicio);

		// índice i irá percorrer o array da esquerda para a direita
		int esquerda = inicio + 1;

		// índice j irá percorrer o array da direita para a esquerda
		int direita = fim;

		// O loop irá parar quando os índices se ultrapassarem
		while (esquerda <= direita) {
			/*
			 * Este laço irá parar quando encontrar algum elemento à esquerda que é maior
			 * que o pivô, pois ele deveria estar na partição direita
			 */
			while (esquerda <= direita && vetor.getValorPosicaoVetor(esquerda) <= pivo) {
				esquerda = esquerda + 1;
			}
			/*
			 * Esse laço irá parar quando encontrar algum elemento à direira que é menor ou
			 * igual ao pivô, pois ele deveria estar na partição esquerda
			 */
			while (esquerda <= direita && vetor.getValorPosicaoVetor(direita) > pivo) {
				direita = direita - 1;
			}

			// se os índices não ultrapassarem, troca-os de posição
			if (esquerda < direita) {
				vetor.troca(esquerda, direita);
			}
		}

		// coloca o pivô na posição de ordenação
		vetor.troca(inicio, direita);
		return direita; // retorna a posição do pivô
	}
}