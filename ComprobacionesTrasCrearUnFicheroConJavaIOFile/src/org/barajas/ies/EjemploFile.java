package org.barajas.ies;

import java.io.File;
import java.io.IOException;

public class EjemploFile {

	/**
	 * Método para crear un fichero
	 */
	protected boolean crearFichero(String nombre) {
		boolean creado = false;

		File fichero = new File(nombre);
		try {
			if (fichero.createNewFile()) {
				// no lo pide System.out.println("Creado el fichero " + fichero);
				creado = true;
			} else {
				System.out.println("No se ha creado el fichero");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return creado;
	}

	/**
	 * Método para crear un directorio
	 */
	protected boolean crearDirectorio(String nombre) {
		boolean creado = false;

		File directorio = new File(nombre);
		if (directorio.mkdir()) {
			// no lo tiene que mostrar System.out.println("Creado el directorio " +
			// directorio);
			creado = true;
		} else {
			System.out.println("No se ha creado el directorio");
		}

		return creado;
	}

	protected boolean crearArbolDirectorios(String nombre) {
		boolean creado = false;

		File directorio = new File(nombre);
		if (directorio.mkdirs()) {
			// no lo pide System.out.println("Creado el directorio " + directorio);
			creado = true;
		} else {
			System.out.println("No se ha creado el directorio");
		}

		return creado;
	}

	protected boolean asignarPermisos(File fichero, boolean lectura, boolean escritura, boolean ejecucion) {
		boolean asignados = false;

		// asignamos el permiso indicado de lectura
		fichero.setReadable(lectura);
		// asignamos el permiso indicado de escritura
		fichero.setWritable(escritura);
		// asignamos el permiso indicado de ejecucion
		fichero.setExecutable(ejecucion);

		asignados = true;

		return asignados;
		
		//el archivo en otro SO si que se asignaria, windows caca no hace caso
	}

//	protected void permisosDefault(File fichero) {
//		fichero.setReadable(false);
//		// asignamos el permiso indicado de escritura
//		fichero.setWritable(false);
//		// asignamos el permiso indicado de ejecucion
//		fichero.setExecutable(false);
//	}

	protected void mostrarPermisos(File fichero) {
		if (fichero == null)
			return;
		// clases de CanRead= Puede leer CanWrite= Puede Escribir canExecute= Puede
		// Ejecutar
		if (fichero.canRead()) {
			System.out.println("Se puede leer");
		} else {
			System.out.println("No se puede leer");
		}
		if (fichero.canWrite()) {
			System.out.println("Se puede escribir");
		} else {
			System.out.println("No se puede escribir");
		}
		if (fichero.canExecute()) {
			System.out.println("Se puede ejecutar");
		} else {
			System.out.println("No se puede ejecutar");
		}
	}
}
