package org.iscte_iul.pt.ProjetoES;

/**
 * IsLongMehtod Classe cria um codeSmell do mesmo nome
 * 
 * data
 * @author mdmpe
 *
 */
public class isLongMethod {

	private String[][] dados;
	private String loc;
	private String cyclo;
	private String[] resultados;
/**
 * 
 * @param dados O Excel gerado no ExcelrReader
 * @param loc Valor de input dados pelo utilizador
 * @param cyclo Valor de input dados pelo utilizador
 */
	public isLongMethod(String[][] dados, String loc, String cyclo) {
		this.dados = dados;
		this.loc = loc;
		this.cyclo = cyclo;
		tratar();
	}
/**
 * Neste método é feita a análise de codeSmells pela regra do LongMethod
 * através de uma comparação com o input de dados do Excel com métricas tais como LOC ou CYCLO
 * Os limites LOC ou CYCLO dados pelo utilizado quer vem na forma de String e que quando usando o parseInt
 * Se o LOC ou o CYCLO forem menor que o input, o método tem um codeSmells
 * 
 * @return vector de strings
 */
	public String[] tratar() {
		resultados = new String[422];
		System.out.println(resultados.length);
		int j = 0;
		for (int i = 0; i < dados.length; i++) {
			if (( Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim())) 
					&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
				resultados[j] = dados[i][0];
				j++;
			}
		}
		return resultados;
	}
	

	public String[] getdados() {
		return resultados;
	}

}
