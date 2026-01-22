package org.barajas.ies;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Contacto: Representa un contacto del listin telefónico. Contiene nombre,
 * teléfono, prefijo y una etiqueta identificativa.
 *
 * @author Yones El Tawil
 * @version 1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Contacto {

	@XmlElement(name = "nombre")
	private String nombre;

	@XmlElement(name = "tlf")
	private int tlf;

	@XmlElement(name = "prefijo")
	private String prefijo;

	@XmlAttribute(name = "tag")
	private String tag;

	/**
	 * Constructor sin argumentos requerido por JAXB.
	 */
	public Contacto() {
	}

	/**
	 * Constructor con todos los atributos del contacto
	 *
	 * @param nombre  nombre del contacto
	 * @param tlf     numero de teléfono
	 * @param prefijo prefijo telefónico
	 * @param tag     etiqueta identificativa
	 */
	public Contacto(String nombre, int tlf, String prefijo, String tag) {
		this.nombre = nombre;
		this.tlf = tlf;
		this.prefijo = prefijo;
		this.tag = tag;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Devuelve una representación textual del contacto
	 *
	 * @return cadena con los datos del contacto
	 */
	@Override
	public String toString() {
		return "\nNombre  : " + nombre + "\nTelefono: (" + prefijo + ") " + tlf + "\nTag     : " + tag + "\n";
	}
}
