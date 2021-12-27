/**
 * PCO Fase 1
 * 
 * Grupo PCO 31
 * @author Diana Andrade 54948
 * @author Lu�s Antunes 46590
 * @author Nuno Infante 55411
 */
public class MetodosVerificacao {
	
	/**
	 * Reverte o array de Strings
	 * @param a array de Strings
	 * @return array de Strings revertido
	 */
	private static String[] reverseString(String[] a) {
		String[] b = new String[a.length];
		int j = a.length;
		
		for (int i = 0; i < a.length; i++) {
			b[i] = a[j - 1];
			j -= 1;
		}
		return b;
	}
	
	/**
	 * Um dado trajeto, num dado sentido, satisfaz uma dada propriedade?
	 * @param trajeto O trajeto em quest�o
	 * @param propriedade A propriedade a ser verificada
	 * @param sentido O sentido a considerar no trajeto para a verifica��o
	 * @requires trajeto != null && propriedade != null && sentido in {"REGULAR","INVERSO"}
	 * @return true se o trajeto se verificar, false caso contr�rio
	 */
	static boolean verificaPropriedade(String[] trajeto, String propriedade, String sentido) {
		int n = 0;
		int nrPlanetas = trajeto.length;
		
		if (sentido == "INVERSO"){
			trajeto = reverseString(trajeto);
		}
		
		String[] partes = propriedade.split("[:;]");		
		
		
		for (int i = 0; i < partes.length; i += 2) {
			n += Integer.valueOf(partes[i]);
			
			if (n >= nrPlanetas) {
				n %= nrPlanetas;
			}
			
			String[] arr = partes[i+1].split(",");
			
			for (int j = 0; j < arr.length; j++) {
				if (!trajeto[Integer.valueOf(n)].contains(arr[j])){
					return false;
				}		
			}
		}
		
		return true;
	}
}
