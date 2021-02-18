
/**
 * @author Arthur Guilherme Souza
 *
 */

public class QuickSortDuasThreads {

	private VetorIntegerAleatorio vetor;
	private int pivoInicial;

	// construtor, determina a dimensao do vetor
	public QuickSortDuasThreads(VetorIntegerAleatorio vetor) {
		this.vetor = vetor;
	}

	// retorna o pivo inicial para quickSortE e quickSortD
	public int getPivoInicial() {
		return pivoInicial;
	}
	
	// retorna o tamanho do vetor para o quickSortD
	public int getDimensao() {
		return vetor.getDimensao();
	}


	// realiza primeira particao e determina a posicao inicial do pivo
	// para quickSortE e quickSortD
	public void quickSort() {
		this.pivoInicial = this.particiona(0, this.vetor.getDimensao() - 1);
	}

	// realiza o quick sort da thread esquerda, chamando o metodo de divisao
	public void quickSortE(int inicio, int fim) {
		if (fim > inicio) {

			// ordena e realiza a particao.
			int pivo = this.particiona(inicio, fim);

			// chama a particao da esquerda.
			this.quickSortE(inicio, pivo - 1);

			// chama a particao da direita.
			this.quickSortE(pivo + 1, fim);
		}
	}

	// realiza o quick sort da thread direita, chamando o metodo de divisao
	public void quickSortD(int inicio, int fim) {
		if (fim > inicio) {

			// ordena e realiza a particao.
			int pivo = this.particiona(inicio, fim);

			// chama a particao da esquerda.
			this.quickSortD(inicio, pivo - 1);

			// chama a particao da direita.
			this.quickSortD(pivo + 1, fim);
		}
	}

	// Esquema de particao de Hoare
	private int particiona(int inicio, int fim) {

		// seleciona o pivo como o elemento inicial
		int pivo = this.vetor.getValorPosicaoVetor(inicio);

		// índice "esquerda" irá percorrer o array da esquerda para a direita
		int esquerda = inicio + 1;

		// índice "direita" irá percorrer o array da direita para a esquerda
		int direita = fim;

		// particiona e "ordena"
		while (esquerda <= direita) {

			while (esquerda <= direita && this.vetor.getValorPosicaoVetor(esquerda) <= pivo) {
				esquerda = esquerda + 1;
			}

			while (esquerda <= direita && this.vetor.getValorPosicaoVetor(direita) > pivo) {
				direita = direita - 1;
			}

			if (esquerda < direita) {
				// troca o valor da posicao esquerda com o da direita
				this.vetor.troca(esquerda, direita);
			}
		}

		// coloca o pivo na posicao correta do vetor ordenado
		this.vetor.troca(inicio, direita);

		// retorna a nova posicao do pivo
		return direita;
	}
}
