package org.iscte_iul.pt.ProjetoES;

public class FeatureEnvy {

	private String atfd;
	private String laa;
	private char poperador;
	private char soperador;
	private String[] resultados;
	
	public FeatureEnvy(String atfd, String laa, char poperador,char soperador) {
		this.atfd=atfd;
		this.laa=laa;
		this.poperador=poperador;
		this.soperador=soperador;
		
	}
	
	public String[] operar(String[][] dados) {
		
		int j = 0;
		for (int i = 1; i < dados.length; i++) {
			
			
			switch (poperador | soperador) {
			
			case '>' |'>':
				if ((i != 0 && Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim())) && i != 0
				&& Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
				
					resultados[j] = dados[i][0];
					j++;
				}
			case '<' |'<':
				if ((i != 0 && Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim())) && i != 0
				&& Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
				
					resultados[j] = dados[i][0];
					j++;
				}	
				
			
			
			}
			
			
		}
		return resultados;
	}
	
	
}
