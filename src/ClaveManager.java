import java.io.FileInputStream;
import java.security.*;
import java.security.cert.Certificate;

/**
 * Clase encargada de manejar la carga del KeyStore y la obtención de claves privadas y públicas.
 */
public class ClaveManager {
    private static final String KEYSTORE_TYPE = "JKS";  // Tipo de KeyStore (Java KeyStore)
    private static final String ALIAS = "clavesP";      // Alias de la clave en el KeyStore
    private static final char[] password = obtenerPass();  // Contraseña del KeyStore

    /**
     * Obtiene la clave privada del KeyStore para la firma.
     *
     * @return La clave privada del KeyStore.
     * @throws Exception Si hay algún error al cargar o acceder al KeyStore.
     */
    public static PrivateKey obtenerClavePrivada() throws Exception {
        String keystorePath = obtenerRutaKeyStore();
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);

        try (FileInputStream fis = new FileInputStream(keystorePath)) {
            keyStore.load(fis, password);
        }

        return (PrivateKey) keyStore.getKey(ALIAS, password);
    }

    /**
     * Obtiene la clave pública del KeyStore.
     *
     * @return La clave pública del KeyStore.
     * @throws Exception Si hay algún error al cargar o acceder al KeyStore.
     */
    public static PublicKey obtenerClavePublica() throws Exception {
        String keystorePath = obtenerRutaKeyStore();
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);

        try (FileInputStream fis = new FileInputStream(keystorePath)) {
            keyStore.load(fis, password);
        }

        Certificate cert = keyStore.getCertificate(ALIAS);
        return cert.getPublicKey();
    }

    /**
     * Obtiene la ruta del KeyStore desde la propiedad del sistema 'path_keystore'.
     *
     * @return La ruta del KeyStore.
     * @throws RuntimeException Si la propiedad 'path_keystore' no está definida.
     */
    private static String obtenerRutaKeyStore() {
        String keystorePath = System.getProperty("path_keystore");
        if (keystorePath == null || keystorePath.isBlank()) {
            throw new RuntimeException("La propiedad path_keystore no está definida. Usa -Dpath_keystore=ruta.");
        }
        return keystorePath;
    }

    /**
     * Obtiene la contraseña del KeyStore desde la propiedad del sistema 'password_keystore'.
     *
     * @return La contraseña del KeyStore.
     * @throws RuntimeException Si la propiedad 'password_keystore' no está definida.
     */
    private static char[] obtenerPass() {
        String keystorepass = System.getProperty("password_keystore");
        if (keystorepass == null || keystorepass.isBlank()) {
            throw new RuntimeException("La propiedad password_keystore no está definida. Usa -Dpassword_keystore=contraseña.");
        }
        return keystorepass.toCharArray();
    }
}

