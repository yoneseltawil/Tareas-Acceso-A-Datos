Este proyecto implementa un Listín Telefónico en Java con persistencia en XML usando JAXB. La aplicación se ejecuta por consola mediante un menú que permite añadir, eliminar, mostrar, guardar y recuperar contactos del listín.

El funcionamiento base se apoya en estas clases:

ArrancarListinTelefonico / ListinTelefonico: inician el programa y muestran el menú de opciones.

Listin: mantiene la colección de contactos y la lógica de gestión (altas/bajas/listado).

Contacto: representa cada contacto (nombre, teléfono, prefijo y tag). El campo tag se guarda en el XML como atributo de la etiqueta contacto.

FachadaListin: actúa como intermediaria entre el menú y la lógica, centralizando la interacción con el usuario.

Clase de guardado en XML: guarda el estado actual del listín en un fichero XML mediante JAXB.

Clase de recuperación desde XML: lee el XML y reconstruye el listín en memoria mediante JAXB.

Ampliación del proyecto

Como extensión del listín en XML, se añade:

Documentación Javadoc en las clases principales (mínimo clase y métodos públicos), incluyendo descripción, autor/es, versión, parámetros y retorno.

Pruebas unitarias con JUnit 5 para FachadaListin y las clases de guardado/recuperación XML, ubicadas en src/test/java, con clases Test... y una TestSuite que ejecuta todos los tests.

Gestión de excepciones en FachadaListin y en las clases XML, incorporando relanzamiento de excepciones, capturas, uso de finally (mínimo 3), unión de catch y al menos un try-with-resources (por ejemplo con Scanner) para asegurar el cierre de recursos.

La entrega incluye el proyecto exportado (según el enunciado), junto con el fichero XML generado que contenga al menos un contacto con el nombre y apellidos requeridos, además de los ficheros de test y la suite de pruebas.