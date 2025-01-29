Proyecto: Firma Digital en Java

Descripción del Proyecto

Este proyecto es una aplicación en Java que permite la firma y validación de documentos digitales utilizando criptografía asimétrica. La aplicación aprovecha la infraestructura de una KeyStore para almacenar y gestionar las claves pública y privada necesarias para estos procesos.

Características Principales

Firma de documentos: el programa genera una firma digital para un archivo de entrada utilizando una clave privada.

Validación de documentos: permite verificar la integridad de un documento y su firma digital correspondiente mediante la clave pública.

Uso de algoritmos seguros como SHA256withRSA.

Acceso seguro a las claves desde una KeyStore configurada mediante las propiedades del sistema.

Manejo de errores detallado para el uso incorrecto de los comandos o la falta de archivos.

Estructura del Proyecto

Clase ClaveManager: se encarga de gestionar el acceso a la KeyStore para obtener las claves privada y pública necesarias.

Clase FirmaDigital: contiene la lógica para firmar y validar documentos.

Clase FVfile: punto de entrada principal del programa que interpreta los argumentos proporcionados por el usuario.

Clase Util: incluye funciones auxiliares para mostrar mensajes de error y guía de uso.

Flujo de Operación

El usuario puede ejecutar el programa desde la línea de comandos proporcionando las siguientes opciones:

Firmar un Documento

java -Dpath_keystore=ruta_keystore -Dpassword_keystore=contraseña FVfile firmar nombreDocumento

Esto genera un archivo de firma con el prefijo firma_.

Validar un Documento

java -Dpath_keystore=ruta_keystore -Dpassword_keystore=contraseña FVfile validar nombreDocumento firmaDigital

Esto verifica la validez del documento y muestra el resultado.

Bibliotecas Usadas

java.io.*: para operaciones de entrada/salida de archivos.

java.security.*: para operaciones criptográficas, manejo de claves y firmas.

java.security.cert.Certificate: para acceder a los certificados almacenados en la KeyStore.

Dependencias

Este proyecto no utiliza librerías externas, pero requiere la configuración de las siguientes propiedades del sistema al ejecutarse:

-Dpath_keystore: ruta al archivo de KeyStore.

-Dpassword_keystore: contraseña para acceder al KeyStore.

Asegúrate de tener configurada una KeyStore con el alias clavesP que contenga un par de claves (pública y privada) para el correcto funcionamiento del programa.
