# Sistema de Control de Acceso en Java

Este proyecto es un programa desarrollado en Java que implementa un sistema de control de acceso basado en roles. Cada usuario tiene permisos específicos según su rol (Administrador, Usuario o Invitado). El programa permite crear usuarios, seleccionar roles y realizar acciones verificando las políticas de seguridad predefinidas.

---

## Características

- **Creación de usuarios**: Se pueden crear múltiples usuarios con roles asignados.
- **Roles soportados**:
  - Administrador: Acceso completo.
  - Usuario: Acceso limitado a ciertas acciones.
  - Invitado: Acceso básico.
- **Control de acceso**: Valida si un rol tiene permisos para realizar acciones específicas.
- **Gestión dinámica**: Uso de estructuras de datos como `HashMap` para almacenar usuarios y sus permisos.

---

## Requisitos

- **Java**: Versión 8 o superior.
- **IntelliJ IDEA** (opcional): Para compilar y ejecutar el proyecto.

---

## Ejemplo de Uso

Al iniciar el programa, se presentará un menú con las siguientes opciones:

1. Crear usuarios.
2. Seleccionar un usuario y realizar acciones.
3. Salir del programa.

### Flujo básico:
1. Selecciona la opción **Crear Usuarios**.
2. Ingresa el número de usuarios, sus nombres y roles.
3. Selecciona un usuario de la lista disponible.
4. Realiza acciones según los permisos del rol asignado.

---

## Estructura del Proyecto

```
src/
├── Principal.java          # Clase principal
├── Usuario.java       # Representa los usuarios del sistema
├── ControlDeAcceso.java # Implementa las políticas de seguridad
```

---

## Contribuciones
Las contribuciones son bienvenidas. Por favor, realiza un fork del repositorio y abre un pull request con tus mejoras o sugerencias.
