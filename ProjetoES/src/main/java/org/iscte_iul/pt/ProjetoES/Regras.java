package org.iscte_iul.pt.ProjetoES;

import static org.junit.Assume.assumeNoException;

import java.util.ArrayList;
/**
 * Nesta classe é escolhido a base de um novo defeito podendo ela ser LongMethod ou FeatureEnvy
 * @author mdmpe
 *
 */
public class Regras {
	
	private char pOperador;
	private char sOperador;
	private String logico;
	private String pAtributo;
	private String sAtributo;
	private String codeSmell;
	private String[] resultados=new String[500];
	private String[][] dados;
	private ArrayList<Boolean> lista = new ArrayList<Boolean>();
/**
 * 
 * @param dados	dados do Excel do ExcelrReader matriz de String
 * @param pOperador	char primeiro operador 
 * @param sOperador	char segundo operador
 * @param logico	operador logico String
 * @param pAtributo	primeiro atributo String
 * @param sAtributo	segundo atributo String
 * @param codeSmell	nome do codeSmells a ser escolhido String
 */
	public Regras(String[][] dados, char pOperador, char sOperador, String logico, String pAtributo, String sAtributo, String codeSmell) {
		
		this.dados = dados;
		this.pOperador = pOperador;
		this.sOperador = sOperador;
		this.logico = logico;
		this.pAtributo = pAtributo;
		this.sAtributo = sAtributo;
		this.codeSmell = codeSmell;
		
	}
	
/**
 * 	quando o codeSmells é escolhido criasse um construtor ou da classe LongMethod ou FeatureEnvy
 * esse code construtor vai receber tudo do construtor desta classe exceto o nome
 * depois chama o método operar da nova classe
 * @throws Exception quando o input é inválido
 * 
 */
	public void cria() throws Exception  {
		if(codeSmell=="LongMethod") {
			LongMehtod lm = new LongMehtod(dados, pAtributo, sAtributo, pOperador, sOperador, logico);
			resultados =lm.operar();
			lista.addAll(lm.getLista());
			System.out.println(resultados[0] +"|||" + resultados[1] + "|||" + resultados[499]);
		}else if (codeSmell=="FeatureEnvy") {
			FeatureEnvy fe = new FeatureEnvy(dados, pAtributo, sAtributo, pOperador, sOperador, logico);
			resultados=fe.operar();
			lista.addAll(fe.getLista());
		}else {
			throw new Exception("Ponha um válido");
		}
		
	}
	
	public String[] getResultados() {
		return resultados;
	}
	
	public ArrayList<Boolean> getLista(){
		return lista;
	}
}
