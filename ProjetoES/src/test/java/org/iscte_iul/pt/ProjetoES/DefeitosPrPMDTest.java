package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DefeitosPrPMDTest {
	private static String[][] dadosI;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ExcelReader excel = new ExcelReader("Defeitos.xlsx");
		dadosI = excel.getDados();
		
		

	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testeDefPR() {
		Regras regras = new Regras(dadosI, '>', '>', "and", "31", "0.2", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		DefeitosPrPMD defpr = new DefeitosPrPMD(dadosI,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("4", xx[0][1]);
		assertEquals("154", xx[1][1]);
		assertEquals("262", xx[2][1]);
		assertEquals("0", xx[3][1]);
		//defpr.defeitos();
		
	}

}
