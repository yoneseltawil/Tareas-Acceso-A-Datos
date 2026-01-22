package org.barajas.ies;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.*;

/**
 * EscritorXMLListinJAXBImpl: Guarda el estado del Listín en un fichero XML
 *
 * @author Yones El Tawil
 * @version 1.0.0
 */
public class EscritorXMLListinJAXBImpl {

	private static final String RUTA_XML = "src/org/barajas/ies/listin.xml";

	/**
	 * Escribe el listin en un fichero XML.
	 *
	 * @param listin listin a guardar
	 * @return true si se guarda correctamente
	 * @throws ListinXMLException si ocurre un error de escritura
	 */
	public static boolean escribirListinEnXML(Listin listin) throws ListinXMLException {
		FileOutputStream fos = null;
		boolean correcto = false;

		try {
			JAXBContext context = JAXBContext.newInstance(Listin.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			fos = new FileOutputStream(new File(RUTA_XML));
			marshaller.marshal(listin, fos);
			correcto = true;

		} catch (JAXBException | IOException e) {
			throw new ListinXMLException("Error al escribir el listin en XML", e);

		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return correcto;
	}
}
