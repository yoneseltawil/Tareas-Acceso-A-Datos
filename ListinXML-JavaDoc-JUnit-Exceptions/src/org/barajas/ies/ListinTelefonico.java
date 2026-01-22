package org.barajas.ies;

import java.util.Scanner;

/**
 * Clase que representa un contacto del listin telefonico
 * 
 */
public class ListinTelefonico {

	// Objeto de la fachada que llama a las clases que implementan la funcionalidad
	// de la aplicación
	private FachadaListin fachada;

	private void finOpcion() {
		System.out.println("*** Pulse ENTER para volver al menú ... ***");
		// Ya veremos la clase Scanner más adelante
		Scanner sc = new Scanner(System.in);
		// La utilizamos para recoger la opción que haya introducido poniendo el número
		// correspondiente el usuario por teclado
		sc.nextLine();
		sc.reset();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	/**
	 * Método para mostrar el menu de opciones
	 */
	protected int menu() {
		int opcion;
		System.out.println("*** ########## Listín telefónico ########## ***");
		System.out.println("*** ---------------------------------------------- ***");
		System.out.println("1. Añadir contacto al Listín ");
		System.out.println("2. Eliminar contacto del Listín ");
		System.out.println("3. Guardar estado actual del Listín ");
		System.out.println("4. Recuperar último estado guardado del Listín ");
		System.out.println("5. Ver Listín telefónico ");
		System.out.println("0. Terminar programa");

		Scanner sc = new Scanner(System.in);
		// La utilizamos para recoger la opción que haya introducido poniendo el número
		// correspondiente el usuario por teclado
		opcion = sc.nextInt();
		sc.reset();
		return opcion;
	}

	protected void arrancarPrograma() {
		fachada = new FachadaListin();
		int opcion = 0;
		do {
			opcion = menu();

			switch (opcion) {
			case 1:
				fachada.agregarContacto();
				finOpcion();
				break;
			case 2:
				fachada.eliminarContacto();
				finOpcion();
				break;
			case 3:
				fachada.guardarListin();
				finOpcion();
				break;
			case 4:
				fachada.recuperarListin();
				finOpcion();
				break;
			case 5:
				fachada.mostrarListin();
				finOpcion();
				break;
			case 0: // No hace nada y saldrá del programa
				break;
			default:
				finOpcion();
			}
		} while (opcion != 0);

		System.out.println("*** ########## FIN Listín telefónico ########## ***");
		System.out.println("*** ------------- FIN DEL PROGRAMA ------------ ***");

	}
}
