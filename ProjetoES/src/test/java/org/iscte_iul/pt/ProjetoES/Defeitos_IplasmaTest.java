package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Defeitos_IplasmaTest {

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
	void testDefIplasma() {
		Defeitos_Iplasma defI = new Defeitos_Iplasma(dadosI);
		defI.defeitos();
		String[][] xx = defI.getresultados();
		String[] header = defI.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("140", xx[0][1]);
		assertEquals("0", xx[1][1]);
		assertEquals("280", xx[2][1]);
		assertEquals("0", xx[3][1]);
	}

}
