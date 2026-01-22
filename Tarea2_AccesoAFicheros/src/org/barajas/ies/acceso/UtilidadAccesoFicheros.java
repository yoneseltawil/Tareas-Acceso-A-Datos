package org.barajas.ies.acceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UtilidadAccesoFicheros {

	// los comentarios que siguen esta estructura "/____..." o "//a"	son meramente para guiarme 
	// y asi saber que extractos de codigo he añadido y ubicar con que estructura va cada uno
	
	/**
	 * Método que utiliza un "FileWriter" para escribir la línea completa, pasada
	 * como parámetro "String", en el fichero "src/main/resources/ficheroTexto.txt"
	 * 
	 * @param texto - línea completa a escribir en el fichero
	 */
	protected void escribirLineaFileWriter(String texto) {
		File ficheroTexto = UtilidadFicheros.getFicheroTexto();

		try {
			// Creamos un objeto de la clase "FileWriter"
			//asegurándonos que NO se agregue texto, si existe sino que se sobreescribe
// _____________________________________________________________________________________________
			FileWriter escritor = new FileWriter(ficheroTexto, false); //a
// _____________________________________________________________________________________________
			// Utilizamos el método del "FileWriter" que escribirá nuestro "String"
// _____________________________________________________________________________________________
			escritor.write(texto); //a

			// Utilizamos el método del "FileWriter" que escribirá el caracter nueva línea
			// "\n"
			escritor.write("\n"); //a
			// Y vaciamos el flujo de datos
			escritor.flush(); //a
			// finalizamos la escritura Cerrando el "FileWriter"
			escritor.close(); //a
// _____________________________________________________________________________________________
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Método que utiliza un "PrintWriter" para agregar la línea completa, pasada
	 * como parámetro "String", además de un salto de línea final en el fichero
	 * "src/main/resources/ficheroTexto.txt"
	 * 
	 * @param texto - línea completa a escribir en el fichero
	 */
	protected void agregarLineaMasSaltoDeLineaPrintWriter(String texto) {
		File ficheroTexto = UtilidadFicheros.getFicheroTexto();

		try {
			// Creamos un objeto de la clase "FileWriter"
			//asegurándonos que se agregue texto

// _____________________________________________________________________________________________
			FileWriter escritorFichero = new FileWriter(ficheroTexto, true); //a

			// Creamos un objeto de la clase "PrintWriter" que utilizará el "FileWriter"
			//anterior
			PrintWriter escritor = new PrintWriter(escritorFichero); //a
// _____________________________________________________________________________________________
			// Utilizamos el método del "PrintWriter" que escribirá nuestro "String" y
			// después agrege un salto de línea
// _____________________________________________________________________________________________
			escritor.println(texto); //a

			// Y vaciamos el flujo de datos
			escritor.flush(); //a

			// finalizamos la escritura Cerrando el "PrintWriter"
			escritor.close(); //a
// _____________________________________________________________________________________________
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Método para mostrar el contenido del fichero
	 * "src/main/resources/ficheroTexto.txt" en su codificación de caracteres, o en
	 * "UTF-16" ó "ISO-8859-1"
	 * 
	 */
	protected void leerFichero() {

		System.out.println();
		System.out.println("*** ########## Seleccionar como leer el fichero ########## ***");
		System.out.println("*** ---------------------------------------------- ***");
		System.out.println("1. Leer el fichero con su codificación de caracteres ");
		System.out.println("2. Leer el fichero utilizando la codificicación UTF-16 ");
		System.out.println("3. Leer el fichero utilizando la codificicación ISO-8859-1 ");

		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		sc.reset();

		System.out.println();
		System.out.println("*** Contenido del fichero: ***");
		System.out.println();

		switch (opcion) {
		case 1:
			System.out.println(lecturaFichero(null));
			break;
		case 2:
			System.out.println(lecturaFichero(StandardCharsets.UTF_16));
			break;
		case 3:
			System.out.println(lecturaFichero(StandardCharsets.ISO_8859_1));
			break;
		default:
			System.out.println("Opción incorrecta.");
			System.out.println("Fin de la lectura ");
		}
		System.out.println();

	}

	/**
	 * Método que filtrará en que juego de caracteres mostrar el contenido del
	 * fichero "src/main/resources/ficheroTexto.txt"
	 * 
	 * @param encoding - a utilizar para leer el contenido del fichero
	 * 
	 * @return String - con el contenido del fichero
	 */
	private String lecturaFichero(Charset encoding) {

		// Si el enconding es null ...
		if (encoding == null) {
			// Leeremos línea a línea el fichero utilizando un BufferedReader
			return lecturaFicheroBufferedReader();
		} else {
			// Leeremos línea a línea el fichero utilizando un Scanner indicando el
			// "Charset" que debe usar.
			return lecturaFicheroScanner(encoding);
		}

	}

	/**
	 * Método que utilizará un "BufferedReader" para leer el fichero
	 * "src/main/resources/ficheroTexto.txt" línea a línea
	 * 
	 * @return String - con el contenido del fichero
	 */
	private String lecturaFicheroBufferedReader() {
		File ficheroTexto = UtilidadFicheros.getFicheroTexto();

		// Creamos un "StringBuilder" (VER:
		// https://docs.oracle.com/javase/6/docs/api/java/lang/StringBuilder.html)
		// para ir guardando los caracteres leídos
		StringBuilder lectura = new StringBuilder();

		try {

			// Creamos un objeto de la clase "FileReader"
// _____________________________________________________________________________________________		
			FileReader lectorFichero = new FileReader(ficheroTexto); //a

			// Porque al constructor del "BufferedReader" hay que pasarle como parámetro un
			// objeto "Reader"
			// o en este caso un objeto de una "subclase" de "Reader"

			BufferedReader lector = new BufferedReader(lectorFichero); //a
			// Mientras el flujo de caracteres almacenado en búfer está listo, no estando
			// este vacío

			while (lector.ready()) { //a
				//añadimos la nueva línea de texto devuelta por el "BufferedReader" al
				// "StringBuilder"
				lectura.append(lector.readLine()).append("\n"); //a
				
// _____________________________________________________________________________________________
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectura.toString();
	}

	/**
	 * Método que utilizará un "Scanner" para leer el fichero
	 * "src/main/resources/ficheroTexto.txt" línea a línea
	 * 
	 * @return String - con el contenido del fichero
	 * @throws IOException
	 */
	private String lecturaFicheroScanner(Charset encoding) {
		File ficheroTexto = UtilidadFicheros.getFicheroTexto();

		// Creamos un "StringBuilder" (VER:
		// https://docs.oracle.com/javase/6/docs/api/java/lang/StringBuilder.html)
		// para ir guardando los caracteres leídos
		StringBuilder lectura = new StringBuilder();

		try {
			// Creamos un objeto "Scanner" para leer el "ficheroTexto" pasando el "encoding"
			// del parámetro de entrada
			Scanner lector = new Scanner(ficheroTexto, encoding);

			// Mientras haya otra línea en la entrada de este escáner

			while (lector.hasNextLine()) { //a
				//añadimos la nueva línea de texto devuelta por el "Scanner" al "StringBuilder"
				lectura.append(lector.nextLine()).append("\n"); //a
// _____________________________________________________________________________________________
			}

			lector.reset();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lectura.toString();
	}

	/**
	 * Muestra metainformación del fichero
	 */
	protected void informacionFichero() {
		System.out.println();
		System.out.println("*** ########## INFORMACIÓN DEL FICHERO ########## ***");
		System.out.println("*** ---------------------------------------------- ***");
		System.out.println("Juego de caracteres del fichero: " + fileEncoding());
		System.out.println("Número de caracteres del fichero: " + numeroCaracteres());
		System.out.println("Número de palabras del fichero: " + numeroDePalabras());
		System.out.println("Número de líneas del fichero: " + numeroDeLineas());
		System.out.println("Tamaño del fichero en bytes: " + tamBytesFichero());
		System.out.println();
	}

	/**
	 * Método que utilizando un "FileInputStream" leerá el fichero
	 * "src/main/resources/ficheroTexto.txt" byte a byte devolviendo el número total
	 * de bytes leídos del fichero en un "String"
	 * 
	 * @return String - que indica el número de bytes leídos
	 */
	private String tamBytesFichero() {
		int contadorBytes = 0;

		File fichero = UtilidadFicheros.getFicheroTexto();
		try {
// _____________________________________________________________________________________________
			FileInputStream lector = new FileInputStream(fichero); //a
			// Mientras haya disponibles bytes a leer en el fichero...
			while (lector.available() > 0) { //a
				// Leemos un byte del fichero
				
				lector.read(); //a
								// contamos que hemos leido un nuevo byte aumentando el "contadorBytes"
				contadorBytes++; //a
// _____________________________________________________________________________________________
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return String.valueOf(contadorBytes);
	}

	/**
	 * Método que utilizando un "Scanner" leerá el fichero
	 * "src/main/resources/ficheroTexto.txt" línea a línea devolviendo el número
	 * total de líneas leídas del fichero en un "String"
	 * 
	 * @return String - que indica el número de líneas leídas
	 */
	private String numeroDeLineas() {
		int contadorLineas = 0;

		File fichero = UtilidadFicheros.getFicheroTexto();
		try {
			Scanner lector = new Scanner(fichero);

			// Mientras haya disponibles nuevas líneas a leer en el fichero...
// _____________________________________________________________________________________________
			while (lector.hasNextLine()) { //a
				// Leemos la siguiente línea del fichero
				lector.nextLine(); //a
									// contamos que hemos leido una nueva línea aumentando el "contadorLineas"
				contadorLineas++; //a
// _____________________________________________________________________________________________
			}

			lector.reset();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return String.valueOf(contadorLineas);
	}

	/**
	 * Método que utilizando un "Scanner" leerá el fichero
	 * "src/main/resources/ficheroTexto.txt" palabra a palabra devolviendo el número
	 * total de palabras leídas del fichero en un "String"
	 * 
	 * @return String - que indica el número de palabras leídas
	 */
	private String numeroDePalabras() {
		int contadorPalabras = 0;

		File fichero = UtilidadFicheros.getFicheroTexto();
		try {
			Scanner lector = new Scanner(fichero);

			// Mientras haya disponibles nuevas palabras a leer en el fichero...
			// NOTA: Ver en los apuntes cuál es el delimitador por defecto de los tokens en
			// un "Scanner"
// _____________________________________________________________________________________________
			while (lector.hasNext()) { //a
				// Leemos la siguiente palabra del fichero

				lector.next(); //a
								// contamos que hemos leido una nueva palabra aumentando el "contadorPalabras"
				contadorPalabras++; //a
// _____________________________________________________________________________________________
			}

			lector.reset();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return String.valueOf(contadorPalabras);
	}

	/**
	 * Método que utilizando un "FileReader" leerá el fichero
	 * "src/main/resources/ficheroTexto.txt" carácter a carácter devolviendo el
	 * número total de caracteres leídos del fichero en un "String"
	 * 
	 * @return String - que indica el número de caracteres leídos
	 */
	private String numeroCaracteres() {
		int contadorCaracteres = 0;

		File fichero = UtilidadFicheros.getFicheroTexto();
		try {
// _____________________________________________________________________________________________
			FileReader lector = new FileReader(fichero); //a
			
			// Mientras haya disponibles caracteres a leer en el fichero ...
			// NOTA: Es decir, el flujo está listo si hay bytes disponibles para leer
			while (lector.ready()) { //a
				// Leemos la siguiente carácter del fichero
				
				lector.read(); //a
								// contamos que hemos leido un nuevo carácter aumentando el "contadorCaracteres"
				contadorCaracteres++; //a
// _____________________________________________________________________________________________				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return String.valueOf(contadorCaracteres);
	}

	/**
	 * Método que mostrará el juego de caracteres utilizado para escribir el
	 * contenido del fichero.
	 * 
	 * @return String - que indica el juego de caracteres del fichero
	 */

	private String fileEncoding() {
		String encoding = null;

		File fichero = UtilidadFicheros.getFicheroTexto();

		try {
			// comentar duda
			// FileReader lector=null;
			FileReader lector = new FileReader(fichero);
			// llamamos al método que devuelve el "encoding" del "fichero"

			encoding = lector.getEncoding(); //a
// _____________________________________________________________________________________________
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encoding;
	}

}