package org.barajas.ies;

/**
 * Excepcion propia para errores relacionados con el listin en XML
 * 
 * @author Yones El Tawil
 * @version 1.0.0
 */
public class ListinXMLException extends Exception {

	private static final long serialVersionUID = 3000L;

	/**
	 * Constructor con mensaje
	 * 
	 * @param mensaje descripcion del error
	 */
	public ListinXMLException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Constructor con mensaje y excepcion original
	 * 
	 * @param mensaje descripcion del error
	 * @param causa   excepcion original
	 */
	public ListinXMLException(String mensaje, Exception causa) {
		super(mensaje, causa);
	}
}
