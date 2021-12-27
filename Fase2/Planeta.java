package proj2;

import java.util.List;

/**
* Os objetos desta classe representam planetas.
* @author Grupo 31
* @author Diana Infante, 54948
* @author Luis Antunes, 46590
* @author Nuno Infante, 55411
*/

public class Planeta {
	
	private String nome;
	private List<Propriedade> props;
	
	/**
	 * construtor que inicializa um novo Planeta cujo nome é nome, e cujas propriedades
	 * sao as contidas na lista props;
	 * @param nome String
	 * @param props List<Propriedade>
	 */
	Planeta(String nome, List<Propriedade> props) {
		this.nome = nome;
		this.props = props;
	}
	
	/**
	 * metodo que retorna o nome do planeta;
	 * @return this.nome
	 */
	String nome() {
		return this.nome;
	}

	/**
	 * metodo que retorna true se este planeta tem a propriedade p;
	 * @param p Propriedade
	 * @return true se a lista props tiver a Propriedade p; else false
	 */
	boolean temPropriedade(Propriedade p) {
		return props.contains(p);
	}
	
	
	/**
	 * metodo que retorna true se este planeta tem todas as propriedades contidas na lista props;
	 * @param props List<Propriedade>
	 * @return true se a lista this.props tem todas as propriedades da lista props
	 */
	boolean temTodas(List<Propriedade> props) {
		return this.props.containsAll(props);
	}
	
	/**
	 * metodo que devolve a representação textual deste planeta.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + ": ");
		for(int i = 0; i < props.size(); i++) {
			sb.append(props.get(i) + " ");
		}
		return sb.toString();
	}
}
