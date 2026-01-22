package org.barajas.ies;

import java.util.List;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa la Fachada del Listin
 * 
 * @author Yones El Tawil
 * @version 1.0.0
 */
@XmlRootElement(name = "listin")
@XmlAccessorType(XmlAccessType.FIELD)
public class FachadaListin {

	private Listin listin;
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * Constructor que inicializa el listin
	 */
	public FachadaListin() {
		listin = new Listin();
	}

	/**
	 * Imprime una linea separadora
	 */
	void linea() {
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Solicita un numero y lo valida
	 * 
	 * @return numero entero introducido por el usuario
	 */
	public int introducirNumero() {
		while (true) {
			String texto = sc.nextLine();
			try {
				return Integer.parseInt(texto);
			} catch (NumberFormatException e) {
				System.out.println("Entrada no valida, introduce un numero");
			}
		}
	}

	/**
	 * Devuelve el listin actual
	 * 
	 * @return listin actual
	 */
	public Listin getListin() {
		return listin;
	}

	/**
	 * Cambia el listin actual
	 * 
	 * @param listin nuevo listin
	 */
	public void setListin(Listin listin) {
		this.listin = listin;
	}

	/**
	 * Solicita los datos de un contacto y lo anade al listin
	 */
	public void agregarContacto() {

		linea();
		System.out.println("AGREGAR CONTACTO");
		linea();

		Contacto c = new Contacto();

		System.out.println("Introduzca el nombre:");
		c.setNombre(sc.nextLine());

		System.out.println("Introduzca el prefijo telefonico:");
		c.setPrefijo(sc.nextLine());

		System.out.println("Introduzca el numero de telefono:");
		c.setTlf(introducirNumero());

		System.out.println("Introduzca una etiqueta:");
		c.setTag(sc.nextLine());

		listin.agregarContacto(c);

		System.out.println("Contacto anadido correctamente");
		linea();
		System.out.println();
	}

	/**
	 * Elimina un contacto segun su numero de telefono
	 */
	public void eliminarContacto() {

		linea();
		System.out.println("ELIMINAR CONTACTO");
		linea();

		System.out.println("Introduzca el telefono del contacto a eliminar:");
		int tlf = introducirNumero();

		Contacto encontrado = null;

		for (Contacto c : listin.getContactos()) {
			if (c.getTlf() == tlf) {
				encontrado = c;
				break;
			}
		}

		if (encontrado != null) {
			listin.eliminarContacto(encontrado);
			System.out.println("Contacto eliminado");
		} else {
			System.out.println("No se ha encontrado ese numero");
		}

		linea();
		System.out.println();
	}

	/**
	 * Guarda el contenido actual del listin en un fichero XML
	 */
	public void guardarListin() {

		linea();
		System.out.println("GUARDAR LISTIN");
		linea();

		try {
			if (listin.getContactos().isEmpty()) {
				System.out.println("No hay contactos que guardar.");
			} else if (EscritorXMLListinJAXBImpl.escribirListinEnXML(listin)) {
				System.out.println("Listin guardado correctamente");
			} else {
				System.out.println("Error al guardar el listin");
			}
		} catch (ListinXMLException e) {
			System.out.println(e.getMessage());
		} finally {
			linea();
			System.out.println();
		}
	}

	/**
	 * Recupera el ultimo estado guardado del listin desde el fichero XML
	 */
	public void recuperarListin() {

		linea();
		System.out.println("RECUPERAR LISTIN");
		linea();

		try {
			List<Contacto> datos = LectorXMLListinJAXBImpl.leerListinDeXML(listin);

			if (datos != null && !datos.isEmpty()) {
				listin.setContactos(datos);
				System.out.println("Listin recuperado");
				mostrarListin();
			} else {
				System.out.println("No se encontro un listin valido");
			}
		} catch (ListinXMLException e) {
			System.out.println(e.getMessage());
		} finally {
			linea();
			System.out.println();
		}
	}

	/**
	 * Muestra el contenido del listin
	 */
	public void mostrarListin() {

		linea();
		System.out.println("LISTIN TELEFONICO");
		System.out.println();

		List<Contacto> contactos = listin.getContactos();

		if (contactos.isEmpty()) {
			System.out.println("El listin esta vacio");
		} else {
			for (Contacto c : contactos) {
				System.out.println(c);
			}
		}

		linea();
		System.out.println();
	}
}
