package org.iscte_iul.pt.ProjetoES;

public class LongMehtod {
	
	private String loc;
	private String cyclo;
	private char poperador;
	private char soperador;
	private String[] resultados;
	private String logico;
	
	public LongMehtod(String loc, String cyclo, char poperador,char soperador, String logico) {
		
		this.loc=loc;
		this.cyclo=cyclo;
		this.poperador=poperador;
		this.logico=logico;
		this.soperador=soperador;
	}
	
	
	
	public String[] operar(String[][] dados) {
		
		int j = 0;
		for (int i = 1; i < dados.length; i++) {
		
			switch (logico) {
				
						
						case "and" :
							switch(poperador) {
										case '>' :
											
											switch(soperador) {
											 case '>':
													if ((i != 0 && Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))&& i != 0
															&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())){
														resultados[j] = dados[i][0];
														j++;
													}
											 case '<':		
												 if ((i != 0 && Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))&& i != 0
													&& Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())){
												resultados[j] = dados[i][0];
												j++;
											}
											}		
										
										case '<' :
											switch(soperador) {
											 case '>':
													if ((i != 0 && Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))&& i != 0
															&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())){
														resultados[j] = dados[i][0];
														j++;
													}
											 case '<':		
												 if ((i != 0 && Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))&& i != 0
													&& Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())){
												resultados[j] = dados[i][0];
												j++;
											}
										}	
					}
						case "or" :
							switch(poperador) {
							case '>' :
								
								switch(soperador) {
								 case '>':
										if ((i != 0 && Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))&& i != 0
												||Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())){
											resultados[j] = dados[i][0];
											j++;
										}
								 case '<':		
									 if ((i != 0 && Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))&& i != 0
										|| Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())){
									resultados[j] = dados[i][0];
									j++;
								}
								}		
							
							case '<' :
								switch(soperador) {
								 case '>':
										if ((i != 0 && Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))&& i != 0
												|| Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())){
											resultados[j] = dados[i][0];
											j++;
										}
								 case '<':		
									 if ((i != 0 && Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))&& i != 0
										|| Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())){
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
