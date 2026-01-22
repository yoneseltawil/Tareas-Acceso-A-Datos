package org.barajas.ies.acceso;

import java.io.File;
import java.io.IOException;

public class UtilidadFicheros {

	// los comentarios que siguen esta estructura "/____..." o "//a"	son meramente para guiarme 
	// y asi saber que extractos de codigo he añadido y ubicar con que estructura va cada uno
	
	// Ruta del directorio dónde tendremos el fichero en el cuál escribiremos
		// caracteres.
		private static final String ruta = "src" + File.separator + "main" + File.separator + "resources";

		// Nombre del fichero de texto.
		private static final String nombreFichero = "ficheroTexto.txt";

		/**
		 * Método que devolverá el objeto que representa el fichero de texto
		 * "src/main/resources/ficheroTexto.txt"
		 * 
		 * Asegurándose que este existe, y de no ser así, creándolo, junto con su ruta
		 * 
		 * @return File a "src/main/resources/ficheroTexto.txt" 
		 * @throws IOException 
		 */
		public static File getFicheroTexto(){
// _____________________________________________________________________________________________
		    File fichero = new File(ruta + File.separator + nombreFichero); //a
	        File rutaDelFichero = new File(ruta); //a
// _____________________________________________________________________________________________	        
	        // Si NO existe la ruta ...
// _____________________________________________________________________________________________
	        if (!rutaDelFichero.exists()) {  //a
	            // Creamos la ruta completa
	            rutaDelFichero.mkdirs(); //a
// _____________________________________________________________________________________________
	        }
	    
	        // Si NO existe el fichero ...
// _____________________________________________________________________________________________
	        if (!fichero.exists()) { //a
// _____________________________________________________________________________________________
	            try {
	        	    // Creamos el fichero vacío
// _____________________________________________________________________________________________
			        fichero.createNewFile(); //a
// _____________________________________________________________________________________________
	            } catch (IOException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    }
	        }
	    
		    return fichero;
		}

	}