package org.iscte_iul.pt.ProjetoES;



public class isFeatureEnvy {
	//outro coluna 7 8


	private String[][] dados;
	private String atfd;
	private String laa;
	private Boolean [] resultados =new Boolean[500];
	
	public isFeatureEnvy(String[][] dados, String atfd, String laa) {
		this.dados=dados;
		this.atfd=atfd;
		this.laa=laa;
		tratar();
	}
	public  Boolean[] tratar() {
		for(int i=0;i<dados.length;i++) {
			for(int j=0;j<dados[i].length;j++) {
				if((i!=0 && Integer.parseInt(dados[i][6])>Integer.parseInt(atfd.trim()))||i!=0 && Long.parseLong(dados[i][7])<Long.parseLong(laa.trim())) {
					resultados[i]=true;
				}else {
					resultados[i]=false;
				}
			}
		}
		return resultados;
	}
}
