package org.barajas.ies.acceso;

import java.util.Scanner;

public class Fachada {

	private static final UtilidadAccesoFicheros funcionalidad = new UtilidadAccesoFicheros();

	public void escribir() {
		System.out.println("*** Introduzca el texto a escribir en el fichero y después pulse ENTER ***");
		// Ya veremos la clase Scanner más adelante
		Scanner sc = new Scanner(System.in);
		// La utilizamos para recoger el texto que el usuario quiere escribir en el
		// fichero
		String texto = sc.nextLine();
		sc.reset();
		// Utilizamos el método de "FileWriter" para escribir la línea completa
		funcionalidad.escribirLineaFileWriter(texto);

		System.out.println();
	}

	public void agregar() {
		System.out.println("*** Introduzca el texto a agregar al final del fichero y después pulse ENTER ***");
		// Ya veremos la clase Scanner más adelante
		Scanner sc = new Scanner(System.in);
		// La utilizamos para recoger el texto que el usuario quiere escribir en el
		// fichero
		String texto = sc.nextLine();
		sc.reset();
		// Utilizamos el método de "PrintWriter" para agregar la línea completa, además
		// de un salto de línea al final.
		funcionalidad.agregarLineaMasSaltoDeLineaPrintWriter(texto);

		System.out.println();
	}

	public void leer() {
		funcionalidad.leerFichero();
	}

	public void info() {
		funcionalidad.informacionFichero();
	}

}
