package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FeatureEnvy {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("ola motherfuckers");
		System.out.println("teste 3");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("teste 2");

	}

	@Test
	void test() {
		System.out.println("teste 1");
		FeatureEnvy ew = new FeatureEnvy();
		assertEquals("123", "123");
		fail("Not yet implemented");
	}

}
