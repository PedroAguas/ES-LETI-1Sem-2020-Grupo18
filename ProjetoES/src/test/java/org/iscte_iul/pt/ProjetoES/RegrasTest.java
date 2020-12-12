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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("15", xx[0][1]);
		assertEquals("143", xx[1][1]);
		assertEquals("36", xx[2][1]);
		assertEquals("226", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("0", xxx[0][1]);
		assertEquals("140", xxx[1][1]);
		assertEquals("39", xxx[2][1]);
		assertEquals("241", xxx[3][1]);
		

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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("95", xx[0][1]);
		assertEquals("63", xx[1][1]);
		assertEquals("262", xx[2][1]);
		assertEquals("0", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("95", xxx[0][1]);
		assertEquals("45", xxx[1][1]);
		assertEquals("280", xxx[2][1]);
		assertEquals("0", xxx[3][1]);
		

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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("5", xx[0][1]);
		assertEquals("153", xx[1][1]);
		assertEquals("256", xx[2][1]);
		assertEquals("6", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("4", xxx[0][1]);
		assertEquals("136", xxx[1][1]);
		assertEquals("273", xxx[2][1]);
		assertEquals("7", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("142", xx[0][1]);
		assertEquals("16", xx[1][1]);
		assertEquals("221", xx[2][1]);
		assertEquals("41", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("136", xxx[0][1]);
		assertEquals("4", xxx[1][1]);
		assertEquals("233", xxx[2][1]);
		assertEquals("47", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("56", xx[0][1]);
		assertEquals("102", xx[1][1]);
		assertEquals("0", xx[2][1]);
		assertEquals("262", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("38", xxx[0][1]);
		assertEquals("102", xxx[1][1]);
		assertEquals("0", xxx[2][1]);
		assertEquals("280", xxx[3][1]);

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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("77", xx[0][1]);
		assertEquals("81", xx[1][1]);
		assertEquals("259", xx[2][1]);
		assertEquals("3", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("77", xxx[0][1]);
		assertEquals("63", xxx[1][1]);
		assertEquals("277", xxx[2][1]);
		assertEquals("3", xxx[3][1]);

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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("16", xx[0][1]);
		assertEquals("142", xx[1][1]);
		assertEquals("23", xx[2][1]);
		assertEquals("239", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("0", xxx[0][1]);
		assertEquals("140", xxx[1][1]);
		assertEquals("25", xxx[2][1]);
		assertEquals("255", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("62", xx[0][1]);
		assertEquals("96", xx[1][1]);
		assertEquals("9", xx[2][1]);
		assertEquals("253", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("45", xxx[0][1]);
		assertEquals("95", xxx[1][1]);
		assertEquals("10", xxx[2][1]);
		assertEquals("270", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("47", xx[0][1]);
		assertEquals("111", xx[1][1]);
		assertEquals("136", xx[2][1]);
		assertEquals("126", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("39", xxx[0][1]);
		assertEquals("101", xxx[1][1]);
		assertEquals("146", xxx[2][1]);
		assertEquals("134", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("4", xx[0][1]);
		assertEquals("154", xx[1][1]);
		assertEquals("262", xx[2][1]);
		assertEquals("0", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("4", xxx[0][1]);
		assertEquals("136", xxx[1][1]);
		assertEquals("280", xxx[2][1]);
		assertEquals("0", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("100", xx[0][1]);
		assertEquals("58", xx[1][1]);
		assertEquals("132", xx[2][1]);
		assertEquals("130", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("90", xxx[0][1]);
		assertEquals("50", xxx[1][1]);
		assertEquals("140", xxx[2][1]);
		assertEquals("140", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("1", xx[0][1]);
		assertEquals("157", xx[1][1]);
		assertEquals("262", xx[2][1]);
		assertEquals("0", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("1", xxx[0][1]);
		assertEquals("139", xxx[1][1]);
		assertEquals("280", xxx[2][1]);
		assertEquals("0", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("153", xx[0][1]);
		assertEquals("5", xx[1][1]);
		assertEquals("0", xx[2][1]);
		assertEquals("262", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("135", xxx[0][1]);
		assertEquals("5", xxx[1][1]);
		assertEquals("0", xxx[2][1]);
		assertEquals("280", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("95", xx[0][1]);
		assertEquals("63", xx[1][1]);
		assertEquals("133", xx[2][1]);
		assertEquals("129", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("85", xxx[0][1]);
		assertEquals("55", xxx[1][1]);
		assertEquals("141", xxx[2][1]);
		assertEquals("139", xxx[3][1]);

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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("146", xx[0][1]);
		assertEquals("12", xx[1][1]);
		assertEquals("2", xx[2][1]);
		assertEquals("260", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("128", xxx[0][1]);
		assertEquals("12", xxx[1][1]);
		assertEquals("2", xxx[2][1]);
		assertEquals("278", xxx[3][1]);
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
		DefeitosPrPMD defpr = new DefeitosPrPMD(dados,lista);
		defpr.defeitos();
		String[][] xx = defpr.getresultados();
		String[] header = defpr.getheader();
		assertEquals("Defeitos", header[0]);
		assertEquals("Total", header[1]);
		assertEquals("56", xx[0][1]);
		assertEquals("102", xx[1][1]);
		assertEquals("135", xx[2][1]);
		assertEquals("127", xx[3][1]);
		DefeitosPrIPlasma defip = new DefeitosPrIPlasma(dados,lista);
		defip.defeitos();
		String[][] xxx = defip.getresultados();
		String[] headerr = defip.getheader();
		assertEquals("Defeitos", headerr[0]);
		assertEquals("Total", headerr[1]);
		assertEquals("48", xxx[0][1]);
		assertEquals("92", xxx[1][1]);
		assertEquals("145", xxx[2][1]);
		assertEquals("135", xxx[3][1]);
	}

}
