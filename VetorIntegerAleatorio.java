import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 */

/**
 * @author Arthur Guilherme Souza
 *
 */

public class VetorIntegerAleatorio {

	int dimensao;
	Integer[] vetor;

	// construtor
	public VetorIntegerAleatorio(int dimensao) {
		this.dimensao = dimensao;
		vetor = new Integer[dimensao];
	}

	// retorna o vetor
	public Integer[] getVetor() {
		return vetor;
	}

	// altera o vetor
	public void setVetor(Integer[] vetor) {
		this.vetor = vetor;
	}
	
	// retorna o valor de uma posicao do vetor
	public Integer getValorPosicaoVetor(int posicao) {
		return this.vetor[posicao];
	}

	// altera o valor de uma posicao do vetor
	public void setValorPosicaoVetor(Integer valor, int posicao) {
		this.vetor[posicao] = valor;
	}

	// retorna a dimensao/tamanho do vetor
	public int getDimensao() {
		return dimensao;
	}
	
	// troca valores do vetor
	public void troca(int x, int y) {
		int temp = this.vetor[x];
		this.vetor[x] = this.vetor[y];
		this.vetor[y] = temp;
	}

	// popula o vetor com valores inteiros qu podem assumir valores
	// de "primeiro" ate "ultimo"
	public Integer[] geraVetorAleatorio(int primeiro, int ultimo) {
		for (int i = primeiro; i < ultimo; i++) {
			this.vetor[i] = ThreadLocalRandom.current().nextInt(primeiro, ultimo);
			;
		}
		return this.vetor;
	}

	// imprime o vetor
	public void imprime() {
		System.out.print("[ ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("]");
	}

	// cria um arquivo com o vetor atual
	public void salvaArquivo(String nomeArquivo) {
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(nomeArquivo);
			PrintWriter salvarArquivo = new PrintWriter(arquivo);
			salvarArquivo.printf("[ ");
			for (int i = 0; i < vetor.length; i++) {
				salvarArquivo.printf(vetor[i] + " ");
			}
			salvarArquivo.printf("]");
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
