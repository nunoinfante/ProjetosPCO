/**
 * PCO Fase 3
 * 
 * Grupo PCO 31
 * @author Luís Antunes 46590
 * @author Nuno Infante 55411
 */

public class BuracoNegro extends CorpoCeleste {
	
	/**
	 * Inicializa os atributos de um buraco negro, cujas instancias representam corpos celestes
	 * @param massa massa do corpo celeste
	 * @param pos posicao do corpo celeste
	 */
	public BuracoNegro(double massa, Ponto3D pos) {
		super(massa, pos);
	}
	
	/**
	 * Devolve a distancia minima deste buraco negro a outro corpo celeste para o corpo nao ser afetado pela forca de atracao
	 */
	public double distanciaMinimaSeguranca(CorpoCeleste c) {
		return Math.sqrt(c.massa * massa);
	}
}
