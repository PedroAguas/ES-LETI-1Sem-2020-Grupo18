package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;
/**
 * Nesta classe é feita a criação de defeitos usando um LongMethod personalizado
 * @author mdmpe
 *
 */
public class LongMehtod {

	private String[][] dados;
	private String loc;
	private String cyclo;
	private char poperador;
	private char soperador;
	private String[] resultados = new String[500];
	private String logico;
	private int j = 0;
	private ArrayList<Boolean> lista = new ArrayList<Boolean>();
/**
 * 
 * @param dados	O Excel gerado no ExcelrReader
 * @param loc	Valor de input dados pelo utilizador
 * @param cyclo	Valor de input dados pelo utilizador
 * @param poperador	primeiro operador dado pelo utilizador
 * @param soperador	segundo operador dado pelo utilizador
 * @param logico operador logico das operações entre os outros operadores dado pelo utilizador
 */
	public LongMehtod(String[][] dados, String loc, String cyclo, char poperador, char soperador, String logico) {

		this.dados = dados;
		this.loc = loc;
		this.cyclo = cyclo;
		this.poperador = poperador;
		this.logico = logico;
		this.soperador = soperador;
	}
/**
 * Utiliza set de switch, o primeiro para lógicos, e os outros dois dentro de si e deles mesmo
 * Compara os dois atributos utilizando os operadores.
 * se a comparação for bem-sucedida adiciona o methodID a lista de resultados e adiciona TRUE a lista
 * quando a comparação não é bem-sucedida adiciona FALSE a lista
 * @return
 */
	public String[] operar() {
		switch (logico) {

		case "and":
			switch (poperador) {
			case '>':

				switch (soperador) {
				case '>':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}
					}
					break;
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
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
								&& Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}
					}
					break;
					
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))
								&& Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
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
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) > Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}

					}
					break;
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) > Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
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
							lista.add(true);
						} else {
							lista.add(false);
						}
					}
					break;
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Integer.parseInt(dados[i][4]) < Integer.parseInt(loc.trim()))
								|| Integer.parseInt(dados[i][5]) < Integer.parseInt(cyclo.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
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

	public ArrayList<Boolean> getLista() {
		System.out.println(lista.size());
		return lista;
	}

}
