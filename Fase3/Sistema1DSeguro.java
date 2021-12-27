import java.util.ArrayList;
import java.util.List;

/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public class Sistema1DSeguro extends AbstractSistemaSolar{
	
	private CorpoCeleste[][] m;
	
	/**
	 * Inicializa os atributos de um sistema
	 * @param nome nome do sistema solar
	 * @param m matriz de corpos celestes
	 */
	public Sistema1DSeguro(String nome, CorpoCeleste[][] m) {
		super(nome);
		this.m = m;
	}
	
	/**
	 * Devolve o numero de corpos celestes sem buracos negros e sem espacos null
	 */
	public int quantosElementos() {
		CorpoCeleste[] res = apenasCorposCelestes();
		return res.length;
	}
	
	/**
	 * Devolve um array com os corpos celestes da matriz m sem buracos negros e sem espacos null
	 */
	private CorpoCeleste[] apenasCorposCelestes(){
		List<CorpoCeleste> res = new ArrayList<CorpoCeleste>();
		for(CorpoCeleste[] i : m) {
			for(CorpoCeleste c : i) {
				if(c instanceof CorpoCeleste && !(c instanceof BuracoNegro)) {
					res.add(c);
				}
			}
		}
		CorpoCeleste[] cc = new CorpoCeleste[res.size()];
		res.toArray(cc);
		return cc;
	}
	
	/**
	 * Devolve o corpo celeste do sistema solar correspondente ao numero de ordem n
	 */
	public CorpoCeleste getElemento(int n) {
		CorpoCeleste[] res = apenasCorposCelestes();
		return res[n-1];
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
	 * Representacao textual do sistema 1D Seguro
	 */
	public String toString() {
		CorpoCeleste[] res = apenasCorposCelestes();
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + super.toString() + "\n");
		sb.append("Planetas:");
		for(int i = 0; i < res.length; i++) {
			if(i % 5 == 0) {
				sb.append("\n");
			}
			sb.append(res[i].posicao());
		}
		return sb.toString();
	}
}
