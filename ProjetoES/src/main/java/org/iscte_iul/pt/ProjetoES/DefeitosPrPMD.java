package org.iscte_iul.pt.ProjetoES;
import java.util.ArrayList;

public class DefeitosPrPMD {
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
        private ArrayList<Boolean> verdades = new ArrayList<Boolean>();
        
        public DefeitosPrPMD(String[][] dados, ArrayList<Boolean> verdades) {
            this.dados = dados;
            this.verdades=verdades;
        }

        public void defeitos() {
        	//System.out.println(verdades.size()+" primeiro: " + verdades.get(verdades.size()) + " ajdsbuas "+ dados.length+ " primeiro: " + dados[dados.length-2][10]);
            for (int i = 0; i < dados.length; i++) {
                if (verdades.get(i) == true && Boolean.parseBoolean(dados[i][10]) == true) {
                    DCI++;
                } else if ((verdades.get(i) == false) && Boolean.parseBoolean(dados[i][10]) == true) {
                    DII++;
                } else if (verdades.get(i) == false && Boolean.parseBoolean(dados[i][10]) == false) {
                    ADCI++;
                } else {
                    ADII++;
                }
            }
            resultados[0][1] = Integer.toString(DCI);
            resultados[1][1] = Integer.toString(DII);
            resultados[2][1] = Integer.toString(ADCI);
            resultados[3][1] = Integer.toString(ADII);

            System.out.println("DCI " + DCI+ " DII " + DII+ " DCI " + ADCI+ " ADII " + ADII);
            

        }

        public String[][] getresultados() {
            return resultados;
        }

        public String[] getheader() {
            return header;
        }


}

