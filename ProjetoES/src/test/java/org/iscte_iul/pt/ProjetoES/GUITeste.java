package org.iscte_iul.pt.ProjetoES;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GUITeste {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		GUI i = new GUI();
		i.open();
	}

}
