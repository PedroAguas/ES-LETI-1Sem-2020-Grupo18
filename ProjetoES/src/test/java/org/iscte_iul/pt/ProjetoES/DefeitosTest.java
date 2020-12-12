package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DefeitosTest {

	private static String[][] dados;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ExcelReader excel = new ExcelReader("Defeitos.xlsx");
		dados = excel.getDados();

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testDefPmd() {
		Defeitos def = new Defeitos(dados);
		def.defeitos();
		String[][] xx = def.getresultados();
		String[] header = def.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("140", xx[0][1]);
		assertEquals("18", xx[1][1]);
		assertEquals("262", xx[2][1]);
		assertEquals("0", xx[3][1]);	
	}

}
