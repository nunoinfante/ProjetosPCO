import java.util.List;

/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public interface SistemaSolar {
	
	/**
	 * Devolve o nome do sistema solar
	 */
	String nome();
	
	/**
	 * Verifica se e possivel visitar os corpos celestes, que corresponde a numeros inteiros
	 * @param aVisitar lista de numeros inteiros
	 * @return true se os valores da lista forem maiores que zero e menores que quantosElementos(); false caso contrario
	 */
	boolean podeVisitar(List<Integer> aVisitar);
	
	/**
	 * Devolve o numero de elementos da matriz
	 */
	int quantosElementos();
	
	/**
	 * Devolve o corpo celeste da matriz do sistema solar correspondente ao numero de ordem n
	 * @param n numero de ordem
	 */
	CorpoCeleste getElemento(int n);
	
	/**
	 * Devolve o buraco negro que se encontra mais perto do corpo celeste c
	 * @param c corpo celeste em questao
	 */
	BuracoNegro buracoNegroMaisPerto(CorpoCeleste c);
}
