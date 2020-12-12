package org.iscte_iul.pt.ProjetoES;
/**
 * Classe que cria o codsmell isFeatureEnvy
 * data
 * @author mdmpe
 *
 */
public class isFeatureEnvy {

	private String[][] dados;
	private String atfd;
	private String laa;
	private String[] resultados;
/**
 * 
 * @param dados O Excel gerado no ExcelReader
 * @param atfd	Valor de input dados pelo utilizador
 * @param laa	Valor de input dados pelo utilizador
 */
	public isFeatureEnvy(String[][] dados, String atfd, String laa) {
		this.dados = dados;
		this.atfd = atfd;
		this.laa = laa;
		tratar();
	}
/**
 * Neste metodo é feita a analise de codeSmells pela regra do FeatureEnvy através de uma comparacao com o input de dados do Excel com metricas tais como ATFD ou LAA
 * Neste metodo os limites ATFD ou LAA dados pelo utilizador sao os limites pelos quais os dados devem passar para que possam passar para os resultados 
 * Se o ATFD ou o LAA forem menores que os inputs, o metodo tem um codeSmells
 * 
 * @return é devolvida uma lista de String com os resultados (i.e. se tem codeSmells retorna methodID 
 */
	public String[] tratar() {
		resultados = new String[422];
		System.out.println(resultados.length);
		int j = 0;
		for (int i = 1; i < dados.length; i++) {
			if ((Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim()))
					&& Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
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