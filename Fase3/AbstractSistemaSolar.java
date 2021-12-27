import java.util.List;

/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public abstract class AbstractSistemaSolar implements SistemaSolar {
	
	private String nome;
	
	/**
	 * Inicializa o atributo de um sistema solar
	 * @param nome nome do sistema solar
	 */
	public AbstractSistemaSolar(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Devolve o nome do sistema solar
	 */
	public String nome() {
		return nome;
	}
	
	/**
	 * Verifica se e possivel visitar os corpos celestes, que corresponde a numeros inteiros
	 * @param aVisitar lista de numeros inteiros
	 * @return true se os valores da lista forem maiores que zero e menores que quantosElementos(); false caso contrario
	 */
	public boolean podeVisitar(List<Integer> aVisitar) {
		for(int i : aVisitar) {
			if(i <= 0 || i > quantosElementos()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Representacao textual do nome do sistema solar
	 */
	public String toString() {
		return nome;
	}
}
