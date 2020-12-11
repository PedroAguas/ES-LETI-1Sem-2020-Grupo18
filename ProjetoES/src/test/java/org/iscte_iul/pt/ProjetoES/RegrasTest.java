package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RegrasTest {

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
	void testLmRegrasmmA() {
		Regras regras = new Regras(dados, '<', '<', "and", "31", "22", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(7));
		assertEquals(false, lista.get(13));
		assertEquals("10", resultados[9]);
		assertEquals("18", resultados[13]);
		
	}
	
	@Test
	void testeLmRegrasMMA() {
		Regras regras = new Regras(dados, '>', '>', "and", "31", "22", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(false, lista.get(1));
		assertEquals(true, lista.get(280));
		assertEquals("14", resultados[0]);
		assertEquals("90", resultados[10]);
		assertEquals("281", resultados[44]);
		
	}

	@Test
	void testLmRegrasmMA() {
		Regras regras = new Regras(dados, '<', '>', "and", "100", "11", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(false, lista.get(14));
		assertEquals(true, lista.get(357));
		assertEquals("101", resultados[0]);
		assertEquals("378", resultados[10]);
		assertEquals(null, resultados[44]);
	}
		
	
	@Test
	void testLmRegrasMmA() {
		Regras regras = new Regras(dados, '>', '<', "and", "27", "105", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(6));
		assertEquals(true, lista.get(357));
		assertEquals(false, lista.get(123));
		assertEquals("221", resultados[71]);
		assertEquals("7", resultados[0]);
		assertEquals("150", resultados[44]);
	}
//		
//		Regras feRegrasmmA = new Regras(dados, '<', '<', "and", "31", "22", "FeatureEnvy");
//		feRegrasmmA.cria();

}
