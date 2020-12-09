package org.iscte_iul.pt.ProjetoES;

public class Regras {
	
	private String nome;
	private char pOperador;
	private char sOperador;
	private String logico;
	private String pAtributo;
	private String sAtributo;
	private String codeSmell;
	private String[] resultados;
	
	public Regras(String nome, char pOperador, char sOperador, String logico, String pAtributo, String sAtributo, String codeSmell) {
		super();
		this.nome = nome;
		this.pOperador = pOperador;
		this.sOperador = sOperador;
		this.logico = logico;
		this.pAtributo = pAtributo;
		this.sAtributo = sAtributo;
		this.codeSmell = codeSmell;
		this.resultados=new String[500];
	}
	
	public void cria(String[][] dados) {
		if(codeSmell=="LongMethod") {
			LongMehtod lm = new LongMehtod(pAtributo, sAtributo, pOperador,sOperador, logico);
			resultados =lm.operar(dados);
		}else if (codeSmell=="FeatureEnvy") {
			FeatureEnvy fe = new FeatureEnvy(pAtributo, sAtributo, pOperador,sOperador, logico);
			resultados=fe.operar(dados);
		}
		
	}
	public String[] getResultados() {
		return resultados;
	}
}
