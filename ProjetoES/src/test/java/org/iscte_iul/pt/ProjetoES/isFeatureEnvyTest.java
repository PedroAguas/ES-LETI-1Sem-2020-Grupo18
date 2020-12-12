package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class isFeatureEnvyTest {


	private static String[][] dados;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ExcelReader excel = new ExcelReader("Defeitos.xlsx");
		dados = excel.getDados();

	}

	@Test
	void test() {

		isFeatureEnvy fe = new isFeatureEnvy(dados, "10", "0.3");
		fe.tratar();
		String[] resultados = fe.getdados();
		assertEquals("15", resultados[0]);
		assertEquals("128", resultados[10]);

	}

}
