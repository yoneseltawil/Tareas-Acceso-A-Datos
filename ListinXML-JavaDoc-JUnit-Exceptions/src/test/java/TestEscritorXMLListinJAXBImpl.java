package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.barajas.ies.Contacto;
import org.barajas.ies.EscritorXMLListinJAXBImpl;
import org.barajas.ies.Listin;
import org.barajas.ies.ListinXMLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests de EscritorXMLListinJAXBImpl")
class TestEscritorXMLListinJAXBImpl {

	private static final String RUTA_XML = "src/org/barajas/ies/listin.xml";
	private Listin listin;

	@BeforeEach
	void setUp() throws ListinXMLException {
		listin = new Listin();
		listin.agregarContacto(new Contacto("Yones El Tawil", 123456789, "+34", "Don Juan"));
		listin.agregarContacto(new Contacto("Jose Luis Gonzalez", 111111111, "+34", "Gavilan"));
		EscritorXMLListinJAXBImpl.escribirListinEnXML(listin);

	}

	@Test
	@DisplayName("Escribe el listin en XML y crea el fichero")
	void testEscribirListinEnXML() throws ListinXMLException {
		boolean ok = EscritorXMLListinJAXBImpl.escribirListinEnXML(listin);
		assertTrue(ok);

		File f = new File(RUTA_XML);
		assertTrue(f.exists());
		assertTrue(f.length() > 0);
	}
}
