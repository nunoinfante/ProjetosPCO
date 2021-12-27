package proj2;

import java.util.ArrayList;
import java.util.List;

/**
* Os objectos desta classe representam sistemas solares formados por planetas
* @author Grupo 31
* @author Diana Infante, 54948
* @author Luis Antunes, 46590
* @author Nuno Infante, 55411
*/

public class SistemaSolar {
	
	private String nome;
	private Planeta[][] planetas;
	
	/**
	* construtor que inicializa um sistema solar cujo nome é nome e contém uma matriz de planetas igual a planetas;
	* @param nome String
	* @param planetas Planeta[][]
	*/
	SistemaSolar(String nome, Planeta[][] planetas) {
		this.nome = nome;
		this.planetas = planetas;
	}
	
	/** 
	 * metodo que retorna true se o	array bi-dimensional arrayBi é uma matriz e não contém elementos a null
	 * @param arrayBi Planeta[][]
	 * @return true if arrayBi matriz and != null
	 */
	static boolean universoValido(Planeta[][] arrayBi) {
		int length = arrayBi[0].length;
		for (Planeta[] i : arrayBi) {
			if (i.length == length) {
				for (Planeta p : i) {
					if (p == null) {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Devolve o nome do Sistema Solar
	 * @return nome
	 */
	String nome() {
		return this.nome;
	}
	
	/**
	 * metodo que devolve true se este sistema solar contém	um planeta cujo	nome é nome
	 * @param nome String
	 * @return true for Planeta[] i: planetas and for planeta p : i if p.nome = nome; else false
	 */
	boolean temPlaneta(String nome) {
		for (Planeta[] i : planetas) {
			for (Planeta p : i) {
				if (p.nome() == nome) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * metodo que que devolve uma lista contendo os nomes de todos os planetas deste sistema solar que têm	
	 * todas as propriedades referidas na lista props;
	 * @param props List<Propriedade>.
	 * @return string list res contains props;
	 */
	List<String> comPropriedades(List<Propriedade> props){
		List<String> res = new ArrayList<String>();
		for (Planeta[] i : planetas) {
			for (Planeta p : i) {
				if(p.temTodas(props)) {
					res.add(p.nome());
				}
			}
		}
		return res;
	}
	
	/**
	 * metodo que devolve um vetor em que o	i-ésimo	elemento representa	o número de	planetas deste sistema solar que 
	 * tem a i-ésima propriedade do	vetor Propriedade.values()
	 * @return int[] res
	 */
	int[] quantosPorPropriedade() {
		List<Integer> res = new ArrayList<Integer>();
		int counter = 0;
		for (Propriedade prop : Propriedade.values()) {
			for (Planeta[] j : planetas) {
				for (Planeta p : j) {
					if (p.temPropriedade(prop)) {
						counter++;
					}
				}
			}
			res.add(counter);
			counter = 0;
		}
		return intListToIntArray(res);
	}
	
	/**
	 * metodo que copia os elementos de lista para um int[] res 
	 * @param lista List<Integer>;
	 * @return res int[]
	 */
	private int[] intListToIntArray(List<Integer> lista){
		  int[] res = new int[lista.size()];
		  for(int i = 0; i < res.length; i++)
		    res[i] = lista.get(i);
		  return res;
		}
	
	/**
	 * metodo de auxilio do metodo nEsimoTem, que reorganiza o array bi-dimensional Planetas para uma lista res, revertendo os elementos dos arrays impares
	 * @return res List<Planeta>;
	 */
	private List<Planeta> nEsimoTemAuxiliar() {
		List<Planeta> res = new ArrayList<Planeta>();
		for (int i = 0; i < planetas.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < planetas[i].length; j++) {
					res.add(planetas[i][j]);
				}
			} else {
				for (int j = planetas[i].length-1; j >= 0; j--) {
					res.add(planetas[i][j]);
				}
			}
		}
		return res;
	}
	
	/**
	 * metodo que retorna true se o n-ésimo planeta	deste sistema solar tem todas as propriedades referidas
	 * na lista props; 
	 * @param n int
	 * @param props List<Propriedade>;
	 * @return true if planeta n tens as propriedades de props; else false
	 */
	boolean nEsimoTem(int n, List<Propriedade> props) {
		List<Planeta> res = nEsimoTemAuxiliar();
		n %= res.size();
		if (res.get(n).temTodas(props)) {
			return true;
		}
		return false;
	}
	
	/**
	 * meotdo que devolve a	propriedade	que aparece	mais vezes nos planetas	deste sistema solar;
	 * @return p Propriedade
	 */
	Propriedade maisFrequente() {
		int max = 0;
		int[] arr = quantosPorPropriedade();
		Propriedade p = null;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				p = Propriedade.values()[i];
			}
		}
		return p;
	}
	
	
	/**
	 * metodo que devolve a representação textual de um sistema solar;
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		sb.append(nome);
		for (Planeta[] j : planetas) {
			for (Planeta p : j) {
				if (counter % planetas[0].length == 0) {
					sb.append("\n");
				}
				counter++;
				sb.append(p);
			}
		}
		return sb.toString();
	}
}

