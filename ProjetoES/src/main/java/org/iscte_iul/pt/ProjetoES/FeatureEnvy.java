package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;

/**
 * Nesta classe é feita a criacao de defeitos usando um LongMethod personalizado
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
	 *Usa switchs para representar todos os casos possiveis para a criacao do codeSmell personalizado
	 *Primeiro tem o switch maior para a ligação logica: and ou or
	 *Depois tem as combinacoes de maiores e maiores
	 *Dentro deles tem um extract de um metodo que contem um for para percorrer os dados e um if para satisfazer as condicoes
	 * 
	 * @return Os metodos IDs que satisfazem as condicoes
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
	/**
	 * metodo refratado usado no operar
	 */
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
	/**
	 * metodo refratado usado no operar
	 */
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
	/**
	 * metodo refratado usado no operar
	 */
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
	/**
	 * metodo refratado usado no operar
	 */
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
