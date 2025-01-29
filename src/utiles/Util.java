package utiles;
import java.io.File;

public class Util {

    /**
     * Obtiene la ruta del directorio de un archivo sin incluir el nombre del archivo.
     *
     * @param rutaArchivo La ruta completa del archivo.
     * @return La ruta del directorio donde se encuentra el archivo, sin el nombre del archivo.
     */
    public static String obtenerRutaSinArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.getParent(); // Ruta sin archivo
    }

    /**
     * Muestra un mensaje indicando cómo utilizar el programa.
     */
    public static void mostrarUso(){
        System.out.println("Forma de uso:");
        System.out.println("Se debe ejecutar en el directorio del documento," +
                " si no se tendra que poner la ruta absoluta del los archivos.");
        System.out.println("  java -Dpath_keystore=/ruta/keystore.jks -Dpassword_keystore=contraseña " +
                "-jar /home/usuario/proyecto/miPrograma.jar [firmar/validar] NombreDocumento {FirmaDigital}");
    }

    /**
     * Muestra un mensaje de error cuando no se ha añadido el archivo de firma en la validación.
     */
    public static void faltaFirma(){
        System.out.println("Error, No se ha añadido el archivo firma");
        System.out.println("  java -Dpath_keystore=ruta FVfile validar NombreDocumento FirmaDigital");
    }

    /**
     * Muestra un mensaje de error cuando la acción proporcionada no es válida.
     *
     * @param accion La acción que no es válida.
     */
    public static void accionNoValida(String accion){
        System.out.println("Error, la acción " + accion + " no es valida");
        System.out.println("  Posibles acciones {firmar}  {validar}");
    }
}
