package org.barajas.ies;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.*;

/**
 * LectorXMLListinJAXBImpl: Recupera el estado del Listin desde un fichero XML.
 *
 * @author Yones El Tawil
 * @version 1.0.0
 */
public class LectorXMLListinJAXBImpl {

	private static final String RUTA_XML = "src/org/barajas/ies/listin.xml";

	/**
	 * Lee el listin desde un fichero XML.
	 *
	 * @param listin objeto listin base
	 * @return lista de contactos recuperada
	 * @throws ListinXMLException si ocurre un error de lectura
	 */
	public static List<Contacto> leerListinDeXML(Listin listin) throws ListinXMLException {
		File fichero = new File(RUTA_XML);

		if (!fichero.exists()) {
			return null;
		}

		try (Scanner sc = new Scanner(fichero)) {
			if (!sc.hasNextLine()) {
				return null;
			}

			JAXBContext context = JAXBContext.newInstance(Listin.class);
			listin = (Listin) context.createUnmarshaller().unmarshal(fichero);
			return listin.getContactos();

		} catch (JAXBException | java.io.FileNotFoundException e) {
			throw new ListinXMLException("Error al leer el listin desde XML", e);
		}
	}
}
