package org.barajas.ies;

import java.io.File;

public class FachadaComprobaciones {

	private final EjemploFile ejemplo;

	public FachadaComprobaciones() {
		this.ejemplo = new EjemploFile();
	}

	public void ejecutarActividad() {
		// con estas lineas hacemos una escalera, si puede la ruta = True, se baja un
		// escalon; si puede crear u directorio baja otro;
		// si puede crear el fichero baja el ultimo escalon
		if (ejemplo.crearArbolDirectorios("src/main/resources")) {
			if (ejemplo.crearDirectorio("src/main/resources/crearFicheros")) {
				ejemplo.crearFichero("src/main/resources/crearFicheros/fichero.txt");
			}
		}
		// se crea el directorio primero y luego especificamos que hay un fichero1 en la
		// ruta de dir1
		String dir1 = "src/main/resources/crearFicheros/nuevoDirectorio1";
		String fichero1 = dir1 + "/fichero1.txt";

		// comprobamos que existe las rutas
		if (ejemplo.crearArbolDirectorios(dir1)) {
			if (ejemplo.crearFichero(fichero1)) {
				System.out.println("Creado el fichero 1 " + fichero1);
				// inicializamos el archivo f1 en la ruta de fichero1
				// se asignamos los permisos de lectura y escritura en True, el permiso de
				// ejecutable en False
				File f1 = new File(fichero1);
				ejemplo.asignarPermisos(f1, true, true, false);
				ejemplo.mostrarPermisos(f1);
			}
		}
		// creamos la ruta para fichero2
		String dir2 = "src/main/resources/crearFicheros/nuevoDirectorio2";
		String fichero2 = dir2 + "/fichero2.txt";

		// comprobamos que existe las rutas
		if (ejemplo.crearArbolDirectorios(dir2)) {
			if (ejemplo.crearFichero(fichero2)) {
				System.out.println("Creado el fichero 2 " + fichero2);
				File f2 = new File(fichero2);
				// le asignamos a fichero 2 los permisos de lecura y ejecutable en True, el de
				// escritura en false
				ejemplo.asignarPermisos(f2, true, false, true);
				ejemplo.mostrarPermisos(f2);
			}
		}
	}
}
