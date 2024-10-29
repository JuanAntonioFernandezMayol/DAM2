Explicación del código
Configuración de SAXParser:

El programa utiliza la clase SAXParserFactory para crear una instancia de SAXParser.

Manejo de eventos de SAX:
startElement: Se activa al comenzar un nuevo elemento. El programa verifica el nombre del elemento para identificar si es un titol, autor, any, o resum y cambia las variables correspondientes a true.

characters: Cuando se encuentra texto dentro de un elemento. Dependiendo de qué variable esté activa (titol, autor, etc.), imprime el contenido en la consola.

endElement: Se activa al cerrar un elemento. Si el elemento es llibre, imprime una línea de separación para mostrar que terminó con ese libro.

El programa está dentro de un bloque try-catch para capturar excepciones.

Informacion del ecosistema utilizado:

Windows 11.
Visual studio code.
Java Maven 17.

Para que el programa se ejecute con exito tiene que haber un archivo llamado llibres.xml y ejecutar el main.