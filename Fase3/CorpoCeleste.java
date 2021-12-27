/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public class CorpoCeleste {

	protected double massa;
	protected Ponto3D pos;
	
	/**
	 * Inicializa os atributos de um corpo celeste
	 * @param massa massa do corpo celeste
	 * @param pos posicao do corpo celeste
	 */
	public CorpoCeleste(double massa, Ponto3D pos) {
		this.massa = massa;
		this.pos = pos;
	}

	/**
	 * Devolve a massa do corpo celeste
	 */
	public double massa() {
		return massa;
	}
	
	/**
	 * Devolve a posicao do corpo celeste
	 */
	public Ponto3D posicao() {
		return pos;
	}
	
	/**
	 * Devolve a distancia do corpo celeste atual a outro corpo celeste c
	 */
	public double distancia(CorpoCeleste c) {
		return pos.distancia(c.pos);
	}
	
	/**
	 * Verifica se o objeto other for igual ao corpo celeste atual
	 * @param other objeto a comparar
	 * @return true se as massas (com uma aproximacao de 0.0001) e posicoes forem iguais; false caso contrario 
	 */
	public boolean equals(Object other) {
		if(other instanceof CorpoCeleste) {
			if((double) Math.round(massa * 10000) / 10000 == (double) Math.round(((CorpoCeleste) other).massa() * 10000) / 10000 && pos == ((CorpoCeleste) other).posicao()) {
				return true;
			}
		}
		return false;
	}
}
