package org.iscte_iul.pt.ProjetoES;

public class isFeatureEnvy {

	private String[][] dados;
	private String atfd;
	private String laa;
	private String[] resultados;

	public isFeatureEnvy(String[][] dados, String atfd, String laa) {
		this.dados = dados;
		this.atfd = atfd;
		this.laa = laa;
		tratar();
	}

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