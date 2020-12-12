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

	// teste do LongMethod AND
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

	// teste do LongMethod OR
	@Test
	void testLmRegrasmmO() {
		Regras regras = new Regras(dados, '<', '<', "or", "31", "22", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(12));
		assertEquals(true, lista.get(29));
		assertEquals("10", resultados[9]);
		assertEquals("16", resultados[13]);

	}

	@Test
	void testeLmRegrasMMO() {
		Regras regras = new Regras(dados, '>', '>', "or", "150", "200", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(false, lista.get(1));
		assertEquals(true, lista.get(279)); // 280
		assertEquals(true, lista.get(300)); // 301
		assertEquals("15", resultados[1]);
		assertEquals("114", resultados[10]);
		assertEquals("251", resultados[37]);

	}

	@Test
	void testLmRegrasmMO() {
		Regras regras = new Regras(dados, '<', '>', "or", "40", "366", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(false, lista.get(12));
		assertEquals(false, lista.get(353));
		assertEquals(true, lista.get(354));
		assertEquals("1", resultados[0]);
		assertEquals("11", resultados[10]);
		assertEquals("405", resultados[244]);
	}

	@Test
	void testLmRegrasMmO() {
		Regras regras = new Regras(dados, '>', '<', "or", "200", "10", "LongMethod");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(1));
		assertEquals(false, lista.get(61));
		assertEquals(true, lista.get(4));
		assertEquals("1", resultados[0]);
		assertEquals("90", resultados[79]);
		assertEquals("37", resultados[33]);
	}

	// FEFEFEFE

	@Test
	void testFeRegrasmmA() {
		Regras regras = new Regras(dados, '<', '<', "and", "31", "0.2", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(false, lista.get(1));
		assertEquals(true, lista.get(4));
		assertEquals("3", resultados[0]);
		assertEquals("23", resultados[15]);
	}

	@Test
	void testeFeRegrasMMA() {
		Regras regras = new Regras(dados, '>', '>', "and", "31", "0.2", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(13));
		assertEquals(true, lista.get(391));
		assertEquals(false, lista.get(2));
		assertEquals("14", resultados[0]);
		assertEquals("329", resultados[1]);
	}

	@Test
	void testFeRegrasmMA() {
		Regras regras = new Regras(dados, '<', '>', "and", "100", "0.2", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(0));
		assertEquals(false, lista.get(5));
		assertEquals("7", resultados[2]);
		assertEquals("21", resultados[5]);
	}

	@Test
	void testFeRegrasMmA() {
		Regras regras = new Regras(dados, '>', '<', "and", "71", "0.3", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(14));
		assertEquals(false, lista.get(4));
		assertEquals("15", resultados[0]);
		assertEquals(null, resultados[1]);
	}

	// ORRORORO

	@Test
	void testFeRegrasmmO() {
		Regras regras = new Regras(dados, '<', '<', "or", "27", "0.18", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(20));
		assertEquals(false, lista.get(13));
		assertEquals("6", resultados[5]);
		assertEquals("81", resultados[79]);
	}

	@Test
	void testeFeRegrasMMO() {
		Regras regras = new Regras(dados, '>', '>', "or", "50", "0.25", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(1));
		assertEquals(false, lista.get(5));
		assertEquals("7", resultados[2]);
		assertEquals("26", resultados[7]);

	}

	@Test
	void testFeRegrasmMO() {
		Regras regras = new Regras(dados, '<', '>', "or", "30", "0.3", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(true, lista.get(20));
		assertEquals(false, lista.get(13));
		assertEquals("6", resultados[5]);
		assertEquals("16", resultados[13]);
	}

	@Test
	void testFeRegrasMmO() {
		Regras regras = new Regras(dados, '>', '<', "or", "100", "0.2", "FeatureEnvy");
		regras.cria();
		ArrayList<Boolean> lista = regras.getLista();
		String[] resultados = regras.getResultados();
		assertEquals(false, lista.get(1));
		assertEquals(true, lista.get(4));
		assertEquals("3", resultados[0]);
		assertEquals("24", resultados[17]);
	}

}
