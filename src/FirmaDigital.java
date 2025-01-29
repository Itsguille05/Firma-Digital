import java.io.*;
import java.security.*;
import utiles.Util;
/**
 * Clase encargada de firmar y validar documentos digitales.
 */
public class FirmaDigital {
    /**
     * Firma un documento con la clave privada obtenida del KeyStore.
     *
     * @param nombreDocumento El nombre del documento a firmar.
     * @throws Exception Si ocurre algún error durante el proceso de firma.
     */
    public static void firmarDocumento(String nombreDocumento) throws Exception {
        PrivateKey privateKey = ClaveManager.obtenerClavePrivada();  // Pedimos la clave privada
        Signature firma = Signature.getInstance("SHA256withRSA");  // Creamos la firma
        firma.initSign(privateKey);

        byte[] contenido = leerArchivo(nombreDocumento);
        firma.update(contenido);  // Firmamos

        byte[] firmaDigital = firma.sign();

        // Obtener la ruta sin el nombre del archivo y guardar la firma en la misma carpeta
        String rutaDocumento = nombreDocumento;
        String rutaSinArchivo = Util.obtenerRutaSinArchivo(rutaDocumento);
        String nombreFirma = rutaSinArchivo + "/firma_" + nombreDocumento + ".sig";  // Guarda la firma en la misma carpeta

        try (FileOutputStream fos = new FileOutputStream(nombreFirma)) {
            fos.write(firmaDigital);
        }
        System.out.println("Documento firmado. Firma guardada en: " + nombreFirma);
    }

    /**
     * Valida un documento comparando su firma con la firma digital proporcionada.
     *
     * @param nombreDocumento El nombre del documento a validar.
     * @param nombreFirma El nombre del archivo que contiene la firma digital.
     * @throws Exception Si ocurre algún error durante la validación.
     */
    public static void validarDocumento(String nombreDocumento, String nombreFirma) throws Exception {
        PublicKey publicKey = ClaveManager.obtenerClavePublica();  // Obtenemos la clave pública
        Signature firma = Signature.getInstance("SHA256withRSA");
        firma.initVerify(publicKey);

        byte[] contenido = leerArchivo(nombreDocumento);
        firma.update(contenido);

        byte[] firmaDigital = leerArchivo(nombreFirma);

        boolean esValida = firma.verify(firmaDigital);
        if (esValida) {
            System.out.println("Firma válida. El documento no ha sido modificado.");
        } else {
            System.out.println("Firma inválida o documento modificado.");
        }
    }

    /**
     * Lee el contenido de un archivo en formato de byte array.
     *
     * @param nombreArchivo El nombre del archivo a leer.
     * @return Un array de bytes con el contenido del archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    private static byte[] leerArchivo(String nombreArchivo) throws IOException {
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        }
    }
}

