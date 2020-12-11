package org.iscte_iul.pt.ProjetoES;

import java.util.ArrayList;

public class Regras {
	
	private String nome;
	private char pOperador;
	private char sOperador;
	private String logico;
	private String pAtributo;
	private String sAtributo;
	private String codeSmell;
	private String[] resultados=new String[500];
	private String[][] dados;
	private ArrayList<Boolean> lista = new ArrayList<Boolean>();
	
	public Regras(String[][] dados, String nome, char pOperador, char sOperador, String logico, String pAtributo, String sAtributo, String codeSmell) {
		
		this.dados = dados;
		this.nome = nome;
		this.pOperador = pOperador;
		this.sOperador = sOperador;
		this.logico = logico;
		this.pAtributo = pAtributo;
		this.sAtributo = sAtributo;
		this.codeSmell = codeSmell;
		
	}
	
	public void cria() {
		if(codeSmell=="LongMethod") {
			LongMehtod lm = new LongMehtod(dados, pAtributo, sAtributo, pOperador,sOperador, logico);
			resultados =lm.operar();
			lista.addAll(lm.getLista());
			System.out.println(resultados[0] +"|||" + resultados[1] + "|||" + resultados[499]);
		}else if (codeSmell=="FeatureEnvy") {
			FeatureEnvy fe = new FeatureEnvy(dados, pAtributo, sAtributo, pOperador, sOperador, logico);
			resultados=fe.operar();
			lista.addAll(fe.getLista());
		}
		
	}
	
	public String[] getResultados() {
		return resultados;
	}
	
	public ArrayList<Boolean> getLista(){
		return lista;
	}
}
