import static utiles.Util.*;

/**
 * Clase principal que maneja las operaciones de firma y validación de documentos.
 *
 * @author Guillermo Hurtado
 * @version 1.0
 */
public class FVfile {
    /**
     * Método principal que maneja las operaciones de firma o validación de documentos.
     *
     * @param args Los argumentos que determinan la acción a realizar ('firmar' o 'validar').
     *             Opción firmar/validar obligatorio
     *             Nombre_documento obligatorio
     *             Fichero_firma Solo si se elige la opción validar
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            mostrarUso();  // Error de uso del comando
            return;
        }

        String accion = args[0];
        String nombreDocumento = args[1];

        try {
            switch (accion) {
                case "firmar":
                    FirmaDigital.firmarDocumento(nombreDocumento);  // Firma el documento
                    break;

                case "validar":
                    if (args.length < 3) {
                        faltaFirma();  // No se ha añadido la firma
                        return;
                    }
                    String nombreFirma = args[2];
                    FirmaDigital.validarDocumento(nombreDocumento, nombreFirma);  // Valida el documento
                    break;

                default:
                    accionNoValida(accion);  // Acción no existente
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
