Explicacion del codigo.
Clase Llibre
Esta clase representa un libro individual. Cada atributo de la clase mapea un campo correspondiente en el XML (titol, autor, any, y resum).
Atributos: Cada atributo (titol, autor, any, resum) almacena los datos de un libro.
Getters y Setters: Son necesarios para que JAXB pueda leer y escribir los valores de los campos del XML.

2. Clase Llibres
Esta clase mapea el elemento raíz <llibres> que contiene una lista de libros. En lugar de manejar solo un libro, manejamos una lista de ellos.

3.Main
Esta clase la entrada del programa y se encarga de leer el archivo XML, convertirlo a objetos Java utilizando JAXB, y enseña la información de cada libro.

El programa está dentro de un bloque try-catch para capturar excepciones.

Informacion del ecosistema utilizado:

Windows 11.
Visual studio code.
Java Maven 17.

Para que el programa se ejecute con exito tiene que haber un archivo llamado llibres.xml - Llibre.java y Llibres.java para ejecutar el main y que todo funcione correctamente.