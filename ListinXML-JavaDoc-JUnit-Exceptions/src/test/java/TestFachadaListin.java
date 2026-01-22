package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.barajas.ies.Contacto;
import org.barajas.ies.FachadaListin;
import org.barajas.ies.Listin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests de FachadaListin")
class TestFachadaListin {

	private FachadaListin fachada;

	@BeforeEach
	void setUp() {
		fachada = new FachadaListin();
	}

	@Test
	@DisplayName("El constructor crea un listin no nulo")
	void testConstructor() {
		assertNotNull(fachada);
		assertNotNull(fachada.getListin());
	}

	@Test
	@DisplayName("Se puede anadir un contacto al listin")
	void testAgregarContactoEnListin() {
		Listin listin = fachada.getListin();
		int antes = listin.getContactos().size();

		Contacto c = new Contacto("Yones El Tawil", 123456789, "+34", "Test");
		boolean ok = listin.agregarContacto(c);

		assertTrue(ok);
		assertEquals(antes + 1, listin.getContactos().size());
	}
}
