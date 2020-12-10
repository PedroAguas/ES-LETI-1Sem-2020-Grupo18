package org.iscte_iul.pt.ProjetoES;

public class Regras {
	
	private String nome;
	private char pOperador;
	private char sOperador;
	private char mainOperador;
	private String pAtributo;
	private String sAtributo;
	private String codeSmell;
	private String[] resultados;
	
	public Regras(String nome, char pOperador, char sOperador, char mainOperador, String pAtributo, String sAtributo, String codeSmell) {
		super();
		this.nome = nome;
		this.pOperador = pOperador;
		this.sOperador = sOperador;
		this.mainOperador = mainOperador;
		this.pAtributo = pAtributo;
		this.sAtributo = sAtributo;
		this.codeSmell = codeSmell;
	}
	
	public void cria(String[][] dados) {
		if(codeSmell=="LongMethod") {
			LongMehtod lm = new LongMehtod(pAtributo,sAtributo,pOperador);
			resultados =lm.operar(dados);
		}else if (codeSmell=="FeatureEnvy") {
			FeatureEnvy fe = new FeatureEnvy(pAtributo,sAtributo, pOperador, sOperador);
			resultados=fe.operar(dados);
		}
		
	}
	
}
