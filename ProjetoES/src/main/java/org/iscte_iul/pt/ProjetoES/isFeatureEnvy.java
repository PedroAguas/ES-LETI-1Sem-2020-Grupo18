package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;

public class isFeatureEnvy {
	//outro coluna 7 8


	private String[][] dados;
	private String atfd;
	private String laa;
	private ArrayList<Boolean> resultados = new ArrayList<>();
	
	public isFeatureEnvy(String[][] dados, String atfd, String laa) {
		this.dados=dados;
		this.atfd=atfd;
		this.laa=laa;
		tratar();
	}
	public  ArrayList<Boolean> tratar() {
		for(int i=0;i<dados.length;i++) {
			for(int j=0;j<dados[i].length;j++) {
				if((i!=0 && Integer.parseInt(dados[i][6])>Integer.parseInt(atfd))||i!=0 && Integer.parseInt(dados[i][7])<Integer.parseInt(laa)) {
					resultados.add(true);
				}else {
					resultados.add(false);
				}
			}
		}
		return resultados;
	}
}
