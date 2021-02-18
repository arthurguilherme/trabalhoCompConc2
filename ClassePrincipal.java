/**
 * @author Arthur Guilherme Souza
 *
 */

public class ClassePrincipal {

	public static void main(String[] args) {

		// define constantes para as dimensoes dos vetores
		final int N1 = 10;
		final int N2 = 20000000;

		// variaveis para calculo do tempo
		double inicio, fim;

//
		// Teste do QuickSort Sequencial
//

		// inicia a contagem do tempo para imprimir o vetor desordenado, ordenar,
		// e imprimir o vetor ordenado
		inicio = System.currentTimeMillis();

		// realiza a ordenacao com o QuickSort sequencial
		TesteQuickSortSequencial tqss1 = new TesteQuickSortSequencial(true, N1);
		tqss1.teste();

		// encerra e imprime a contagem do tempo
		fim = System.currentTimeMillis();
		System.out.println("tempo sequencial para dimensao " + N1 + ": " + (fim - inicio) + "ms");

		// inicia a contagem do tempo para criar arquivo desordenado, ordenar,
		// e criar arquivo ordenado
		inicio = System.currentTimeMillis();

		// realiza a ordenacao com o QuickSort sequencial
		TesteQuickSortSequencial tqss2 = new TesteQuickSortSequencial(false, N2);
		tqss2.teste();

		// encerra e imprime a contagem do tempo
		fim = System.currentTimeMillis();
		System.out.println("tempo sequencial para dimensao " + N2 + ": " + (fim - inicio) + "ms");

//
		// Teste do QuickSort Concorrente usando duas de Threads
//

		// inicia a contagem do tempo para imprimir o vetor desordenado, ordenar,
		// e imprimir o vetor ordenado
		inicio = System.currentTimeMillis();

		// realiza a ordenacao com o QuickSort Concorrente usando duas Threads
		TesteQuickSortDuasThreads tqsdt1 = new TesteQuickSortDuasThreads(true, N1);
		tqsdt1.teste();

		// encerra e imprime a contagem do tempo
		fim = System.currentTimeMillis();
		System.out.println("tempo concorrete usando 2 threads para dimensao " + N1 + ": " + (fim - inicio) + "ms");

		// inicia a contagem do tempo para criar arquivo desordenado, ordenar,
		// e criar arquivo ordenado
		inicio = System.currentTimeMillis();

		// realiza a ordenacao com o QuickSort Concorrente usando duas Threads
		TesteQuickSortDuasThreads tqsdt2 = new TesteQuickSortDuasThreads(false, N2);
		tqsdt2.teste();

		// encerra e imprime a contagem do tempo
		fim = System.currentTimeMillis();
		System.out.println("tempo concorrente usando 2 threads para dimensao " + N2 + ": " + (fim - inicio) + "ms");

//
		// Teste do QuickSort Concorrente usando um Pool de Threads
//

		// inicia a contagem do tempo para imprimir o vetor desordenado, ordenar,
		// e imprimir o vetor ordenado
		inicio = System.currentTimeMillis();

		// realiza a ordenacao com o QuickSort Concorrente usando um Pool de Threads
		TesteQuickSortForkJoinPool tqsfjp1 = new TesteQuickSortForkJoinPool(true, N1);
		tqsfjp1.teste();

		// encerra e imprime a contagem do tempo
		fim = System.currentTimeMillis();
		System.out.println("tempo concorrete usando Pool de threads para dimensao " + N1 + ": " + (fim - inicio) + "ms");

		// inicia a contagem do tempo para criar arquivo desordenado, ordenar,
		// e criar arquivo ordenado
		inicio = System.currentTimeMillis();

		// realiza a ordenacao com o QuickSort Concorrente usando um Pool de Threads
		TesteQuickSortForkJoinPool tqsfjp2 = new TesteQuickSortForkJoinPool(false, N2);
		tqsfjp2.teste();

		// encerra e imprime a contagem do tempo
		fim = System.currentTimeMillis();
		System.out.println("tempo concorrente usando Pool de threads para dimensao " + N2 + ": " + (fim - inicio) + "ms");

	}
}
