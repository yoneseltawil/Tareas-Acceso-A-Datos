package org.barajas.ies.acceso;

import java.util.Scanner;

public class AccesoFicheros {
	
	        // Objeto de la fachada que llama a las clases que implementan la lectura y escritura en ficheros de texto
		private Fachada fachada;
		
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
			System.out.println("*** ########## INSCRIPCION DEL CONCURSO ########## ***");
			System.out.println("*** ---------------------------------------------- ***");
			System.out.println("1. Escribir texto en el fichero \"src/main/resources/ficheroTexto.txt\" ");
			System.out.println("2. Añadir texto al final del fichero \"src/main/resources/ficheroTexto.txt\" ");
			System.out.println("3. Leer el fichero \"src/main/resources/ficheroTexto.txt\" ");
			System.out.println("4. Obtener información del fichero \"src/main/resources/ficheroTexto.txt\"");
			System.out.println("0. Terminar programa");
			
			Scanner sc = new Scanner(System.in);
			// La utilizamos para recoger la opción que haya introducido poniendo el número
			// correspondiente el usuario por teclado
			opcion = sc.nextInt();
			sc.reset();
			return opcion;
		}

		protected void arrancarPrograma() {
			fachada = new Fachada();
			int opcion = 0;
			//esto lo pongo por si acaso jajaja
			System.out.println("Recuerda que el programa busca en la carpeta del proyecto src/main/resources/ficheroTexto.txt");
			System.out.println("Si no la encuentra la crea junto al txt vacio Recuerda sustituirlo por el mio escrito!!");
			do {
				opcion = menu();

				switch (opcion) {
				case 1: 
					fachada.escribir();
					finOpcion();
					break;
				case 2: 
					fachada.agregar();
					finOpcion();
					break;
				case 3: 
					fachada.leer();
					finOpcion();
					break;
				case 4:
					fachada.info();
					finOpcion();
					break;
				case 0: // No hace nada y saldrá del programa
					break;
				default:
					finOpcion();
				}
			} while (opcion != 0);

			System.out.println("*** ########## FIN INSCRIPCION DEL CONCURSO ########## ***");
			System.out.println("*** ----------------- FIN DEL PROGRAMA --------------- ***");

		}

}
