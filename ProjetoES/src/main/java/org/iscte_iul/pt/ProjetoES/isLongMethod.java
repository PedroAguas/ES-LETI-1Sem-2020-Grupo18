package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;
import java.util.Iterator;


//coluna 5 e 6
public class isLongMethod {
	
	private String[][] dados;
	private String loc;
	private String cyclo;
	private ArrayList<Integer> resultados = new ArrayList<>();
	
	
	public isLongMethod(String[][] dados, String loc, String cyclo) {
		this.dados=dados;
		this.loc=loc;
		this.cyclo=cyclo;
		tratar();
	}
	
	
	public  ArrayList<Integer> tratar() {
		for(int i=0;i<dados.length;i++) {
			for(int j=0;j<dados[i].length;j++) {
				if((i!=0 && Integer.parseInt(dados[i][4])>Integer.parseInt(loc))||i!=0 && Integer.parseInt(dados[i][5])>Integer.parseInt(cyclo)) {
					resultados.add(1);
				}else {
					resultados.add(0);
				}
			}
		}
		return resultados;
	}
	
	
	
	
	
}
