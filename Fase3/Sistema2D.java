import java.util.ArrayList;
import java.util.List;

/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public class Sistema2D extends AbstractSistemaSolar {
	
	private CorpoCeleste[][] m;
	private Direcionador d;
	
	/**
	 * Inicializa os atributos de um sistema 2D, cujas instancias representam sistemas solares
	 * @param nome nome do sistema solar
	 * @param m matriz de corpos celestes
	 * @param d define a ordem se como a matriz e percorrida
	 */
	public Sistema2D(String nome, CorpoCeleste[][] m, Direcionador d) {
		super(nome);
		this.m = m;
		this.d = d;
	}
	
	/**
	 * Devolve o numero de elementos da matriz
	 */
	public int quantosElementos() {
		return m.length * m[0].length;
	}
	
	/**
	 * Devolve o corpo celeste da matriz do sistema solar correspondente ao numero de ordem n
	 * @param n numero de ordem
	 */
	public CorpoCeleste getElemento(int n) {
		d.defineUniverso(m);
		return d.nEsimoElemento(n);
	}
	
	/**
	 * Devolve uma lista com todos os buracos negros da matriz m
	 */
	private List<BuracoNegro> buracosNegrosMatriz() {
		List<BuracoNegro> res = new ArrayList<BuracoNegro>();
		for(CorpoCeleste[] i : m) {
			for(CorpoCeleste j : i) {
				if(j instanceof BuracoNegro) {
					res.add((BuracoNegro) j);
				}
			}
		}
		return res;
	}
	
	/**
	 * Devolve o buraco negro que se encontra mais perto do corpo celeste c
	 * @param c corpo celeste em questao
	 */
	public BuracoNegro buracoNegroMaisPerto(CorpoCeleste c) {
		List<BuracoNegro> buracosNegros = buracosNegrosMatriz();
		BuracoNegro bn = buracosNegros.get(0);
		double minDistancia = bn.distancia(c);
		for(BuracoNegro i : buracosNegros) {
			if(i.distancia(c) < minDistancia) {
				bn = i;
				minDistancia = i.distancia(c);
			}
		}
		return bn;
	}
	
	/**
	 * Verifica se é possivel visitar os corpos celestes, que correspondem a numeros inteiros
	 * @param aVisitar lista de nuemros inteiros
	 * @return true se os valores da lista forem maiores que zero e menores que quantosElementos() e se os corpos celestes nao sao nem buracos negros nem null; false caso contrario
	 */
	public boolean podeVisitar(List<Integer> aVisitar) {
		if(super.podeVisitar(aVisitar)) {
			for(int i : aVisitar) {
				if(getElemento(i) == null || getElemento(i) instanceof BuracoNegro) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Representacao textual do sistema 2D
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + super.toString()  + "\n");
		sb.append("Direcionador: " + d.getClass().getName());
		for(CorpoCeleste[] i : m) {
			sb.append("\n");
			for(CorpoCeleste j : i) {
				if(j == null) {
					sb.append(j + " ");
				} else if (j instanceof BuracoNegro) {
					sb.append("B"+j.pos + " ");
				} else {
					sb.append(j.pos + " ");
				}
			}
		}
		sb.append("\n");
		return sb.toString();
	}
}
