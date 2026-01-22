Este proyecto consiste en un programa Java de acceso a ficheros de texto, que permite crear, escribir, añadir, leer y obtener información de un fichero utilizando distintas clases de la API java.io y java.util.

El programa trabaja con el fichero
src/main/resources/ficheroTexto.txt, asegurándose de que la ruta y el fichero existen antes de realizar cualquier operación. A través de un menú interactivo por consola, el usuario puede:

escribir texto en el fichero,

añadir texto al final,

leer su contenido usando distintas codificaciones de caracteres,

y mostrar información del fichero como número de líneas, palabras, caracteres, bytes y juego de caracteres utilizado.

La aplicación está estructurada en varias clases:

una clase principal que inicia el programa,

una clase Fachada que gestiona la interacción con el usuario,

una clase de utilidad de acceso a ficheros, que implementa la lectura y escritura,

y una clase de utilidad de ficheros, encargada de crear y devolver el fichero de trabajo.