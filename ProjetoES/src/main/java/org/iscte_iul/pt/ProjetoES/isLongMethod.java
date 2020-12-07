package org.iscte_iul.pt.ProjetoES;

//coluna 5 e 6
public class isLongMethod {

	private String[][] dados;
	private String loc;
	private String cyclo;
	private String[] resultados;

	public isLongMethod(String[][] dados, String loc, String cyclo) {
		this.dados = dados;
		this.loc = loc;
		this.cyclo = cyclo;
		tratar();
	}

	public String[] tratar() {
		resultados = new String[422];
		System.out.println(resultados.length);
		int j = 0;
		for (int i = 1; i < dados.length; i++) {
			if ((i != 0 && Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim())) && i != 0
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
