package org.iscte_iul.pt.ProjetoES;

public class LongMehtod {

	private String[][] dados;
	private String loc;
	private String cyclo;
	private char poperador;
	private char soperador;
	private String[] resultados = new String[5000];
	private String logico;
	private int j=0;

	public LongMehtod(String[][] dados, String loc, String cyclo, char poperador, char soperador, String logico) {
		
		this.dados = dados;
		this.loc = loc;
		this.cyclo = cyclo;
		this.poperador = poperador;
		this.logico = logico;
		this.soperador = soperador;
	}

	public String[] operar() {
		switch (logico) {

		case "and":
			switch (poperador) {
			case '>':

				switch (soperador) {
				case '>':
					for (int i = 0; i < dados.length-1; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				case '<':
					for (int i = 0; i < dados.length-1; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				}
				break;

			case '<':
				switch (soperador) {
				case '>':
					for (int i = 0; i < dados.length-1; i++) {
						if ((Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				}
				break;
			}
			break;

		case "or":
			switch (poperador) {
			case '>':
				switch (soperador) {
				
				case '>':
					for (int i = 0; i < dados.length-1; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				}
				break;

			case '<':
				switch (soperador) {
				
				case '>':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
						}
					}
					break;
				}
				break;
			}
			break;
		}
		return resultados;
	}

}
