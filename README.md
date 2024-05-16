Editor de Laberintos Falken
Este programa te permite crear y editar archivos de laberintos. Proporciona una interfaz gráfica de usuario (GUI) para crear laberintos, así como la capacidad de guardar y cargar laberintos en varios formatos (XML, JSON y binario).

Características:

Crea nuevos laberintos de cualquier tamaño
Edita el laberinto colocando bloques
Guarda laberintos en archivos
Carga laberintos desde archivos
Establece el límite de tiempo para el laberinto
Establece el sonido de fondo para el laberinto
Requerimientos:

Java Runtime Environment (JRE) 1.8 o posterior
Ejecutando el programa:

Descarga el código fuente del programa.
Compila el código fuente usando un compilador de Java.
Ejecuta el programa ejecutando el archivo de clase compilado.
Usando el programa:

La ventana principal del programa consta de una barra de menú, un menú de bloques y un lienzo de laberinto.
La barra de menú contiene opciones para crear nuevos laberintos, guardar y cargar laberintos, establecer el límite de tiempo y el sonido del laberinto, y salir del programa.
El menú de bloques muestra los diferentes tipos de bloques que se pueden colocar en el laberinto.
El lienzo del laberinto es donde puedes crear y editar el laberinto. Puedes colocar bloques en el laberinto haciendo clic en el lienzo y seleccionando un bloque del menú de bloques.
Guardando y cargando laberintos:

Puedes guardar laberintos en archivos en formato XML, JSON o binario.
Puedes cargar laberintos desde archivos en formato XML, JSON o binario.
Estableciendo el límite de tiempo y el sonido para el laberinto:

Puedes establecer el límite de tiempo para el laberinto en segundos.
Puedes establecer el sonido de fondo para el laberinto especificando la ruta a un archivo de sonido.
Compilando el programa:

El programa se puede compilar utilizando un compilador Java como javac. El siguiente comando se puede utilizar para compilar el programa:

javac -cp .: javax.xml.bind-api.jar Principal.java Size.java Block.java IBlockListener.java Maze.java BlocksPanel.java DialogSize.java DialogTime.java MenuBar.java MenuItem.java Alert.java
Este comando asume que el código fuente del programa se encuentra en el directorio actual y que el archivo javax.xml.bind-api.jar se encuentra en el mismo directorio. 
El archivo javax.xml.bind-api.jar es necesario para la funcionalidad JAXB (Java Architecture for XML Binding) utilizada por el programa.

