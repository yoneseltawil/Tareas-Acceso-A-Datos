package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.barajas.ies.Contacto;
import org.barajas.ies.EscritorXMLListinJAXBImpl;
import org.barajas.ies.LectorXMLListinJAXBImpl;
import org.barajas.ies.Listin;
import org.barajas.ies.ListinXMLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests de LectorXMLListinJAXBImpl")
class TestLectorXMLListinJAXBImpl {

	private Listin listin;

	@BeforeEach
	void setUp() throws ListinXMLException {
		listin = new Listin();

		listin.agregarContacto(
				new Contacto("Yones El Tawil", 123456789, "+34", "Don Juan"));
		listin.agregarContacto(
				new Contacto("Jose Luis Gonzalez", 111111111, "+34", "Gavilan"));

		EscritorXMLListinJAXBImpl.escribirListinEnXML(listin);
	}

	@Test
	@DisplayName("Lee el XML y recupera dos contactos")
	void testLeerListinDeXML() throws ListinXMLException {

		List<Contacto> datos = LectorXMLListinJAXBImpl.leerListinDeXML(listin);

		assertNotNull(datos);
		assertEquals(2, datos.size());
	}
}
