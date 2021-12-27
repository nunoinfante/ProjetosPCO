/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public class LagartaHorizontal implements Direcionador {

	private CorpoCeleste [][] m;
	
	/**
	 * Define o universo sobre o qual este direcionador vai
	 * trabalhar
	 * @param m A matriz que representa o universo de corpos
	 *          celestes
	 * @requires m != null && m e' matriz
	 */
	public void defineUniverso(CorpoCeleste[][] m) {
		this.m = m;
	}
	
	/**
	 * O elemento numa dada posicao da matriz universo
	 * @param n O numero de ordem do elemento requerido
	 * @return O elemento na n-esima posicao da matriz universo
	 * @requires n >= 1
	 */
	public CorpoCeleste nEsimoElemento(int n) {
		int width = m[0].length;
		int index = (n - 1) % (width * m.length);
		int row = index / width;
		int col = row % 2 == 0 ? index % width : width-1-(index % width);
		return m[row][col];
	}
}
