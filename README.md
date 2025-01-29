# Firma Digital

## Descripción
- El objetivo de este proyecto es desarrollar un programa capaz de firmar y validar documentos aplicando los conocimientos obtenidos sobre `Firma Digital`. Para ello, es necesario entender cómo funciona la firma digital y qué elementos son necesarios para su implementación.

## Elementos Necesarios
  - Para implementar la firma digital, se requieren los siguientes componentes:
      - Un par de claves: Una clave privada y una clave pública.
      - Un documento: El archivo que se desea firmar.
      - Algoritmo de firma: En este caso, se utiliza SHA256 con RSA para generar y verificar la firma.

---

## Funcionamiento

### Firmar
- Para firmar un documento tenemos que:
   1. Se genera un hash del documento utilizando el algoritmo SHA256.
   1. Este hash se encripta con la clave privada, lo que produce la Firma Digital.
   1. La firma digital se guarda en un archivo independiente para su posterior uso.

### Valdiar
- Para validar un documento tenemos que:
    1. Para verificar la autenticidad del documento, se desencripta la firma digital utilizando la clave pública.
    2. Se genera nuevamente el hash del documento original.
    3. Si el hash desencriptado y el hash generado coinciden, se puede afirmar que:
        - El documento no ha sido modificado.
        - El documento fue firmado por el propietario de la clave privada.

### Como funciona la firma digital
  - La firma digital es un mecanismo criptográfico que nos permite garantizar la autenticidad e integridad de un documento digital. Funciona parecido a una forma firma normal pero nos ofrece mayor segurridad, ya que permite

    - Autenticidad: Verificar la identidad del remitente del documento.
    - Integridad: Comprobar que el documento no ha sido alterado desde que fue firmado.
    - No repudio: Asegurar que el remitente no pueda negar haber firmado el documento.

---

## Como usarlo

### Preparación
  - Para poder usar este programa deberemos crear un keystore donde guardar los pares de claves
```
keytool -genkeypair -alias clavesP -keyalg RSA -keysize 3072 -keystore miKeystore.jks -validity 365
```
Con esto la primera vez crearemos el keystore y añadiremos nuestro primer par de claves bajo el apodo de "clavesP"

  - Si queremos añadir más pares de claves
```
keytool -genkeypair -alias clavesH -keyalg RSA -keysize 3072 -keystore miKeystore.jks -validity 365
```
Y con esto añadiremos otro par de claves con el alias "clavesH"

### Ejecución del programa
- Ya con el keystore creado procedemos a ejecutar el comando con el cual llevaremos acabo la firma o la validación.
  - Firma
   ```
    java -Dpath_keystore=/ruta/keystore.jks -Dpassword_keystore=contraseña -jar /ruta/miPrograma.jar firmar /ruta/NombreDocumento 
   ```

  - Validar
   ```
    java -Dpath_keystore=/ruta/keystore.jks -Dpassword_keystore=contraseña -jar /ruta/miPrograma.jar validar /ruta/NombreDocumento /ruta/firma.sig
   ```
  
   >[!IMPORTANT]
   >
   > Falta por implementar la solicitud del alias de las claves para saber con que clave se quiere firmar o validar.

---

## Librerias dependencias y otras utilidades
Para la realizacion del proyecto se ha llebado acabo el uso de:
  - java.io.File -> Para trabajar con ficheros
  - java.security.*
    - KeyStore -> Para manejar el almacén de claves (KeyStore).
    - PrivateKey -> Para representar claves privadas.
    - PublicKey-> Para representar claves públicas.
    - Signature -> Para firmar y validar documentos.
    - Certificate -> Para manejar certificados de clave pública.
  - java.security.cert.Certificate -> Para acceder al certificado del Keystore

---

## Estructura del Proyecto

```
firma-digital/
├── src/
    ├── utiles
    |   ├── Util.java //Funciones extra
    ├── ClaveManager.java //Manejo del acceso a las claves
    ├── FVfile.java  //Administración de argumentos recibidos y opción seleccionada
    └── FirmaDigital.java //Funciones de firmar y validar       

```

---
