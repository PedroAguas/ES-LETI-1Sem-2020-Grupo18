package org.iscte_iul.pt.ProjetoES;

public class LongMehtod {
	
	private String loc;
	private String cyclo;
	private char operador;
	private String[] resultados;
	
	public LongMehtod(String loc, String cyclo, char operador) {
		
		this.loc=loc;
		this.cyclo=cyclo;
		this.operador=operador;
	}
	
	
	
	public String[] operar(String[][] dados) {
		
		int j = 0;
		for (int i = 1; i < dados.length; i++) {
		
			switch (operador) {
				
			case '>' : 
				if ((i != 0 && Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))&& i != 0
						&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())){
					resultados[j] = dados[i][0];
					j++;
			}
			
			case '<' :
				if ((i != 0 && Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))&& i != 0
						&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())){
					resultados[j] = dados[i][0];
					j++;
			
			}
				
		}
		
	}
		return resultados;
	}	
}
