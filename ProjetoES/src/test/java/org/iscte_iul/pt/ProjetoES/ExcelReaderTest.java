package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ExcelReaderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws InvalidFormatException, IOException {
		ExcelReader excel = new ExcelReader("Defeitos.xlsx");
		String[][] xx = excel.getDados();
		String[] header = excel.getHeader();
		assertEquals("FALSE", xx[12][8]);
		assertEquals("iPlasma", header[9]);
		
	}

}
