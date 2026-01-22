package test.java;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestFachadaListin.class, TestEscritorXMLListinJAXBImpl.class, TestLectorXMLListinJAXBImpl.class })
public class TestSuiteListin {
}
