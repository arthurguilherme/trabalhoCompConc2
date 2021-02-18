/**
 * @author Arthur Guilherme Souza
 *
 */

public class QuickSortSequencial {

	private VetorIntegerAleatorio vetor;
	private int inicio, fim;

	// construtor, determina a dimensao do vetor
	// define posicao final do vetor igual ao tamanho do vetor
	public QuickSortSequencial(VetorIntegerAleatorio vetor) {
		this.vetor = vetor;
		this.fim = vetor.getDimensao() - 1;
	}

	// realiza o quick sort chamando o metodo de divisao
	private void quickSort(int inicio, int fim) {
		if (fim > inicio) {
			// ordena e realiza a particao.
			int pivo = this.particiona(inicio, fim);

			// chama a particao da esquerda.
			this.quickSort(inicio, pivo - 1);

			// chama a particao da direita.
			this.quickSort(pivo + 1, fim);
		}
	}

	// quickSort para a chamada inicial
	public void quickSort() {
		quickSort(this.inicio, this.fim);
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
