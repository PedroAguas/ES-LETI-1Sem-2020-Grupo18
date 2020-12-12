package org.iscte_iul.pt.ProjetoES;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({Defeitos_IplasmaTest.class, DefeitosTest.class, RegrasTest.class, ExcelReader.class, isFeatureEnvyTest.class, isLongMethodTest.class, GUITeste.class})
public class AllTests {

}
