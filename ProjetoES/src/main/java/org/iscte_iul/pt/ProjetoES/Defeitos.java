package org.iscte_iul.pt.ProjetoES;
/**
 * Nesta classe utilizamos os dados do excel para criar os defeitos
 * @author mdmpe
 *
 */
public class Defeitos {
	private String[][] dados;
	// private String[][] resultados;
	private String[] header = { "Defeitos", "Total" };
	private int DCI = 0;
	private int DII = 0;
	private int ADCI = 0;
	private int ADII = 0;
	private String[][] resultados = { { "DCI", Integer.toString(DCI) }, 
									  { "DII", Integer.toString(DII) },
									  { "ADCI", Integer.toString(ADCI) }, 
									  { "ADII", Integer.toString(ADII) } };
/**
 *    
 * @param dados do excel
 */
	
	public Defeitos(String[][] dados) {
		this.dados = dados;
	}

/**
 * Neste metodo utilizando os dados e PMD
 * Se ambos forem true, passa a existir um DCI
 * Se os dados forem false e o PMD true, existe um DII
 * Se ambos forem false, cria-se um ADII
 * Se nenhum deste acontecer, passa a existir mais um ADDII
 * 
 */	
	public void defeitos() {
		for (int i = 0; i < dados.length; i++) {
			if (Boolean.parseBoolean(dados[i][8]) == true && Boolean.parseBoolean(dados[i][10]) == true) {
				DCI++;
			} else if (Boolean.parseBoolean(dados[i][8]) == false && Boolean.parseBoolean(dados[i][10]) == true) {
				DII++;
			} else if (Boolean.parseBoolean(dados[i][8]) == false && Boolean.parseBoolean(dados[i][10]) == false) {
				ADCI++;
			} else {
				ADII++;
			}
		}
		resultados[0][1] = Integer.toString(DCI);
		resultados[1][1] = Integer.toString(DII);
		resultados[2][1] = Integer.toString(ADCI);
		resultados[3][1] = Integer.toString(ADII);
	}

	public String[][] getresultados() {
		return resultados;
	}

	public String[] getheader() {
		return header;
	}

}
