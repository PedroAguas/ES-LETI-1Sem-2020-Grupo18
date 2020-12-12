package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;

/**
 * Nesta classe é feita a criação de defeitos usando um LongMethod personalizado
 * 
 * @author mdmpe
 *
 */
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

	/**
	 * 
	 * @param dados     O Excel gerado no ExcelrReader
	 * @param atfd      Valor de input dados pelo utilizador
	 * @param laa       Valor de input dados pelo utilizador
	 * @param poperador primeiro operador dado pelo utilizador
	 * @param soperador segundo operador dado pelo utilizador
	 * @param logico    operador logico das operações entre os outros operadores
	 *                  dado pelo utilizador
	 */
	public FeatureEnvy(String[][] dados, String atfd, String laa, char poperador, char soperador, String logico) {

		this.atfd = atfd;
		this.laa = laa;
		this.poperador = poperador;
		this.soperador = soperador;
		this.logico = logico;
		this.dados = dados;

	}

	/**
	 * Utiliza set de switch, o primeiro para lógicos, e os outros dois dentro de si
	 * e deles mesmo Compara os dois atributos utilizando os operadores. se a
	 * comparação for bem-sucedida adiciona o methodID a lista de resultados e
	 * adiciona TRUE a lista quando a comparação não é bem-sucedida adiciona false a
	 * lista
	 * 
	 * @return
	 */
	public String[] operar() {
		switch (logico) {

		case "and":
			switch (poperador) {
			case '>':
				featureEnvyAndMaior();
				break;

			case '<':
				featureEnvyAndMenor();
				break;
			}
			break;

		case "or":
			switch (poperador) {
			case '>':
				featureEnvyOrMaior();
				break;
			case '<':
				featureEnvyOrMenor();
				break;
			}
			break;
		}
		return resultados;
	}

	public void featureEnvyOrMenor() {
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
	}

	public void featureEnvyOrMaior() {
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
	}

	public void featureEnvyAndMenor() {
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
	}

	public void featureEnvyAndMaior() {
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
	}

	public ArrayList<Boolean> getLista() {
		System.out.println(lista.size());
		return lista;
	}

}
