Configuración del Entorno de Desarrollo


Herramientas Utilizadas:
Entorno de Desarrollo: Eclipse
Lenguaje de Programación: Java
Patrón de Diseño: POM (Page Object Model)
Automatización de Pruebas: Selenium WebDriver
Framework de Pruebas Unitarias: JUnit
Framework de Pruebas BDD (Behavior Driven Development): Cucumber



Instalación

1. Instalación de Java 8
Asegúrese de tener Java 8 instalado en su máquina. La ruta del JDK debe estar en la carpeta "Archivos de Programa" del disco local del equipo.

2. Descargar e Instalar Apache Maven
Descargue Apache Maven desde internet para gestionar las dependencias del proyecto.

3. Configuración de Variables de Entorno (Windows)
Busque "Editar las variables de entorno del sistema" en la barra de búsqueda y seleccione la opción.
En la pestaña "Propiedades del sistema", haga clic en "Opciones avanzadas" y luego en "Variables de entorno".
En la sección "Variables del sistema", haga clic en "Nueva" para agregar las siguientes variables:
Nombre: JAVA_HOME, Valor: Ruta donde se encuentra el JDK (ejemplo: "C:\Program Files\Java\jdk1.8.0_321").
Nombre: MAVEN_HOME, Valor: Ruta donde se encuentra Maven.
En la variable "Path", haga clic en "Nuevo" y agregue las siguientes rutas:
"%JAVA_HOME%\bin" para Java.
"%MAVEN_HOME%\bin" para Maven.
Asegúrese de hacer clic en "Aceptar" en todas las ventanas para guardar los cambios.

4. Validación de Variables de Entorno
Abra la consola del sistema y valide que las variables se hayan creado correctamente:

java -version   # Debería mostrar la versión de Java
mvn -version    # Debería mostrar la versión de Maven

Resultado esperado:

Java version "1.8.0_321"
Apache Maven 3.8.4

5. Configuración en Eclipse
Abra Eclipse y vaya a Windows > Preferences > Java > Installed JREs.
Haga clic en "Add", seleccione "Standard VM", y haga clic en "Next".
Haga clic en "Directory", seleccione la ruta del JDK, y haga clic en "Finish".
Marque la opción del JDK y finalmente haga clic en "Apply and Close".

6. Actualización del Proyecto en Eclipse
Posiciónese en la raíz del proyecto en Eclipse.
Haga clic derecho y vaya a Maven > Update Project.
Haga clic en "OK" y espere a que el proyecto se cargue al 100%.

7. Configuración del Proyecto Cucumber
Haga clic derecho nuevamente sobre la carpeta del proyecto en Eclipse.
Vaya a Configure > Convert to Cucumber Project.

8. Configuración del ChromeDriver
Verifique que en la ruta del proyecto src/test/resources > drivers, esté la última versión de ChromeDriver.
Descargue la versión del navegador compatible desde https://googlechromelabs.github.io/chrome-for-testing/.



Cómo Ejecutar las Pruebas:

Desplácese a la carpeta con la ruta: src/test/java > mainrunner > MainRunner.java.
En esta clase, se procesan todos los casos para ejecutarlos. Para iniciar una prueba, coloque el tag usado en el ".feature".
Guarde los cambios de la clase y haga clic derecho en la clase abierta.
Seleccione la opción "Run As" y luego "JUnit Test" para iniciar la ejecución de la prueba.


Con estos pasos, su entorno estará configurado para ejecutar pruebas con Cucumber y Selenium WebDriver en Eclipse.
