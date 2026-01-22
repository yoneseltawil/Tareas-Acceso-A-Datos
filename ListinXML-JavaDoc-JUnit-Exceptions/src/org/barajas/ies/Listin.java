package org.barajas.ies;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

/**
 * Listin: Gestiona una colección de contactos telefónicos.
 *
 * @author Yones El Tawil
 * @version 1.0.0
 */
@XmlRootElement(name = "listin")
@XmlAccessorType(XmlAccessType.FIELD)
public class Listin {

	@XmlElementWrapper(name = "contactos")
	@XmlElement(name = "contacto")
	private List<Contacto> contactos = new ArrayList<>();

	@XmlTransient
	private static int totalContactos = 0;

	/**
	 * Añade un contacto al listin.
	 *
	 * @param contacto contacto a añadir
	 * @return true si se añade correctamente
	 */
	public boolean agregarContacto(Contacto contacto) {
		boolean añadido = contactos.add(contacto);
		if (añadido) {
			totalContactos++;
		}
		return añadido;
	}

	/**
	 * Elimina un contacto del listin.
	 *
	 * @param contacto contacto a eliminar
	 * @return true si se elimina correctamente
	 */
	public boolean eliminarContacto(Contacto contacto) {
		boolean eliminado = contactos.remove(contacto);
		if (eliminado) {
			totalContactos--;
		}
		return eliminado;
	}

	/**
	 * Devuelve la lista de contactos.
	 *
	 * @return lista de contactos
	 */
	public List<Contacto> getContactos() {
		return contactos;
	}

	/**
	 * Sustituye la lista de contactos.
	 *
	 * @param contactos nueva lista
	 */
	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	/**
	 * Devuelve el numero total de contactos.
	 *
	 * @return total de contactos
	 */
	public static int getTotalContactos() {
		return totalContactos;
	}
}
