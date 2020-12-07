package org.iscte_iul.pt.ProjetoES;





//coluna 5 e 6
public class isLongMethod {
	
	private String[][] dados;
	private String loc;
	private String cyclo;
	private Boolean[] resultados = new Boolean[500];
	
	
	public isLongMethod(String[][] dados, String loc, String cyclo) {
		this.dados=dados;
		this.loc=loc;
		this.cyclo=cyclo;
		tratar();
	}
	
	
	public  Boolean[] tratar() {
		for(int i=0;i<dados.length;i++) {
			for(int j=0;j<dados[i].length;j++) {
				if((i!=0 && Integer.parseInt(dados[i][4])>Integer.parseInt(loc.trim()))||i!=0 && Integer.parseInt(dados[i][5])>Integer.parseInt(cyclo.trim())) {
					resultados[i]=true;
				}else {
					resultados[i]=false;
				}
			}
		}
		return resultados;
	}
	
	
	
	
	
}
