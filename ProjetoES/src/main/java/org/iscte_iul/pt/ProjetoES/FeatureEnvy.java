package org.iscte_iul.pt.ProjetoES;

public class FeatureEnvy {

	private String atfd;
	private String laa;
	private char poperador;
	private char soperador;
	private String[] resultados;
	private String logico;
	
	public FeatureEnvy(String atfd, String laa, char poperador,char soperador, String logico) {
		this.atfd=atfd;
		this.laa=laa;
		this.poperador=poperador;
		this.soperador=soperador;
		this.logico=logico;
		
	}
	
	public String[] operar(String[][] dados) {
		
		int j = 0;
		for (int i = 1; i < dados.length; i++) {
			
			switch (logico) {
			
			case "and":
			
				switch (poperador) {
					
							case '>':
								switch(soperador) {
									case '<':
										if ((i != 0 && Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim())) && i != 0
										&& Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
										
											resultados[j] = dados[i][0];
											j++;
										}
									case '>':
										if ((i != 0 && Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim())) && i != 0
										&& Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
										
											resultados[j] = dados[i][0];
											j++;
										}
										
								}	
							case '<':
								switch(soperador) {
								case '<':
									if ((i != 0 && Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim())) && i != 0
									&& Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
									
										resultados[j] = dados[i][0];
										j++;
									}
								case '>':
									if ((i != 0 && Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim())) && i != 0
									&& Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
									
										resultados[j] = dados[i][0];
										j++;
									}
									
							}	
								
								
								
								
				}
				
				
			case "or":
				switch (poperador) {
				
				case '>':
					switch(soperador) {
						case '<':
							if ((i != 0 && Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim())) && i != 0
							|| Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
							
								resultados[j] = dados[i][0];
								j++;
							}
						case '>':
							if ((i != 0 && Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim())) && i != 0
							|| Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
							
								resultados[j] = dados[i][0];
								j++;
							}
							
					}	
				case '<':
					switch(soperador) {
					case '<':
						if ((i != 0 && Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim())) && i != 0
						|| Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
						
							resultados[j] = dados[i][0];
							j++;
						}
					case '>':
						if ((i != 0 && Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim())) && i != 0
						|| Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
						
							resultados[j] = dados[i][0];
							j++;
						}
						
				}	
					
					
					
					
	}
			}
			
			
			
			
			
		}	
			
		
				
			
		
			
		return resultados;
	
	}	
	
}
