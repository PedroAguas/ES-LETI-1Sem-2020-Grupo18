package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;

public class FeatureEnvy {

	private String[][] dados;
	private String atfd;
	private String laa;
	private char poperador;
	private char soperador;
	private String[] resultados = new String[500];
	private String logico;
	private int j = 0;
	private ArrayList<Boolean> lista = new ArrayList<Boolean>();

	public FeatureEnvy(String[][] dados, String atfd, String laa, char poperador, char soperador, String logico) {

		this.atfd = atfd;
		this.laa = laa;
		this.poperador = poperador;
		this.soperador = soperador;
		this.logico = logico;
		this.dados = dados;

	}

	public String[] operar() {
		switch (logico) {

		case "and":
			switch (poperador) {
			case '>':
				switch (soperador) {
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim()))
								&& Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}
					}
					break;
				case '>':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim()))
								&& Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
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
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim()))
								&& Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}
					}
					break;
					
				case '>':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim()))
								&& Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
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
				
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim()))
								|| Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}

					}
					break;
				case '>':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) > Double.parseDouble(atfd.trim()))
								|| Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
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
				case '<':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim()))
								|| Double.parseDouble(dados[i][7]) < Double.parseDouble(laa.trim())) {
							resultados[j] = dados[i][0];
							j++;
							lista.add(true);
						} else {
							lista.add(false);
						}
					}
					break;
				case '>':
					for (int i = 0; i < dados.length; i++) {
						if ((Double.parseDouble(dados[i][6]) < Double.parseDouble(atfd.trim()))
								|| Double.parseDouble(dados[i][7]) > Double.parseDouble(laa.trim())) {
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
