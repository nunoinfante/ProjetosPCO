/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public interface Direcionador {
	
	/**
	 * Define o universo sobre o qual este direcionador vai
	 * trabalhar
	 * @param m A matriz que representa o universo de corpos
	 *          celestes
	 * @requires m != null && m e' matriz
	 */
	void defineUniverso(CorpoCeleste[][] m);
	
	/**
	 * O elemento numa dada posicao da matriz universo
	 * @param n O numero de ordem do elemento requerido
	 * @return O elemento na n-esima posicao da matriz universo
	 * @requires n >= 1
	 */
	CorpoCeleste nEsimoElemento(int n);
}
