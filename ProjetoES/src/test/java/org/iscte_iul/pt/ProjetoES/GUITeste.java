package org.iscte_iul.pt.ProjetoES;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		String[] xx = {"das","asdad","1233","asdas",null};
		i.configurationFrame();
		String[] a=i.tamanhoVetorCerto(xx);
		String[] x= {"das","asdad","1233","asdas"};
		assertArrayEquals(x,a);
	}

}
