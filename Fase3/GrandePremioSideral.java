import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public class GrandePremioSideral {
	
	private SistemaSolar ss;
	private List<Viajante> jogs;
	private int premioBase;
	private static final int PONTOS_BURACO_NEGRO = Integer.MAX_VALUE;
	private static final int TAXA_RISCO = 5;
	private Map<String, Viajante> viajantes;
	
	/**
	 * Inicializa os atributos de um Grande Premio Sideral
	 * @param ss sistema solar
	 * @param jogs viajantes
	 * @param premioBase premio base
	 */
	public GrandePremioSideral(SistemaSolar ss, List<Viajante> jogs, int premioBase) {
		this.ss = ss;
		this.jogs = jogs;
		this.premioBase = premioBase;
		viajantes = new HashMap<String, Viajante>();
		for(Viajante v : jogs) {
			viajantes.put(v.nome(), v);
		}
	}
	
	/**
	 * Devolve o valor do premio base
	 */
	public int premioBase() {
		return premioBase;
	}
	
	/**
	 * Dada uma jogada de cada viajante, é dada uma pontuacao (podendo ser negativa), que depende do corpo celeste que o viajante pretende visitar
	 * @param jogadas lista de Pares com o nome do viajante e um numero inteiro que representa o corpo celeste que pretende visitar
	 */
	public void fazJogada(List<Par<String, Integer>> jogadas) {
		for(Par<String, Integer> i : jogadas) {
			Viajante v = viajantes.get(i.primeiro());
			CorpoCeleste c = ss.getElemento(i.segundo());
			if(c == null) {
				v.registaPontos(-v.pontuacao()/2);
			} else {
				if(v.podeViajar(c.posicao()) && !(c.equals(v.posicaoGlobal()))) {
					v.mudaPosicaoGlobal(c.posicao());
					if(c instanceof BuracoNegro) {
						v.registaPontos(-PONTOS_BURACO_NEGRO);
					} else {
						if(c.distancia(ss.buracoNegroMaisPerto(c)) < ss.buracoNegroMaisPerto(c).distanciaMinimaSeguranca(c)) {
							v.registaPontos(premioBase * TAXA_RISCO);
						} else {
							v.registaPontos(premioBase);
						}
					}
				} else {
					v.registaPontos(-v.pontuacao()/5);
				}
			}
		}
	}
	
	/**
	 * Organiza o lista jogs por pontuacao. Compara o index atual com o proximo; se o atual for menor que o proximo troca
	 */
	private void organizarPorPontuacao(){
		for(int i = 0; i < jogs.size(); i++) {
			for(int j = i + 1; j < jogs.size(); j++) {
				Viajante temp = null;
				if(jogs.get(i).pontuacao() < jogs.get(j).pontuacao()) {
					temp = jogs.get(i);
					jogs.set(i, jogs.get(j));
					jogs.set(j, temp);
				}
			}
		}
	}
	
	
	/**
	 * Devolve uma lista com os vencedores. Caso haja um empate vai haver mais que um vencedor
	 */
	public List<String> vencedores(){
		int counter = 0;
		organizarPorPontuacao();
		List<String> res = new ArrayList<String>();
		for(int i = 0; i < jogs.size(); i++) {
			if(jogs.get(0).pontuacao() == jogs.get(i).pontuacao()) {
				counter++;
			}
		}
		for(int i = 0; i < counter; i++) {
			res.add(jogs.get(i).nome());
		}
		return res;
	}
	
	/**
	 * Representacao textual do grande premio sideral com o sistema solar e os viajantes
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("============ GRANDE PREMIO ============ \n");
		sb.append("Premio base: " + premioBase + "\n");
		sb.append("Sistema solar: \n" + ss.toString());
		sb.append("Viajantes: \n");
		for(Viajante v : jogs) {
			sb.append(v.toString());
		}
		return sb.toString();
	}
}