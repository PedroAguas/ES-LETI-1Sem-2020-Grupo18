package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class isLongMethodTest {

	private static String[][] dados;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ExcelReader excel = new ExcelReader("Defeitos.xlsx");
		dados = excel.getDados();

	}

	@Test
	void test() {

		isLongMethod lm = new isLongMethod(dados, "20", "30");
		lm.tratar();
		String[] resultados = lm.getdados();
		assertEquals("14", resultados[0]);
		assertEquals("15", resultados[1]);

	}

}
