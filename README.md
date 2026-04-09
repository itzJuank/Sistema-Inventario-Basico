# Sistema Inventario Basico

Proyecto de inventario en Java con arquitectura por capas, persistencia en archivo de texto y una interfaz de consola sencilla para gestionar productos.

## Descripcion

Este proyecto fue construido como una base academica y practica para entender como organizar una aplicacion Java en capas.

Permite:

- Registrar productos
- Listar productos
- Buscar productos por ID
- Actualizar productos
- Eliminar productos

La informacion se guarda en el archivo `datos/productos.txt`, por lo que no necesita base de datos para funcionar.

## Arquitectura del proyecto

La aplicacion esta organizada en cuatro capas principales:

- `entidades`: define los objetos del dominio, en este caso `Producto`
- `dao`: maneja el acceso y persistencia de datos en archivo `.txt`
- `servicio`: aplica validaciones y coordina la logica entre presentacion y acceso a datos
- `presentacion`: contiene la interfaz de usuario por consola y la clase principal de arranque

## Estructura

```text
Sistema-Inventario-Basico/
├── datos/
│   └── productos.txt
├── docs/
├── src/
│   └── com/
│       └── inventario/
│           ├── entidades/
│           │   └── Producto.java
│           ├── dao/
│           │   ├── IProductoDAO.java
│           │   └── ProductoDAOArchivo.java
│           ├── servicio/
│           │   ├── IProductoServicio.java
│           │   └── ProductoServicio.java
│           └── presentacion/
│               ├── Main.java
│               └── Menu.java
├── CHANGELOG.md
├── README.md
└── prompts.txt
```

## Tecnologias usadas

- Java
- Programacion orientada a objetos
- Arquitectura por capas
- Persistencia en archivos `.txt`
- Git y GitHub

## Versiones publicadas

- `v1.0`: estructura inicial del proyecto
- `v1.1`: CRUD funcional completo
- `v1.2`: mejoras, validaciones y documentacion

## Funcionamiento

Cada producto se guarda en una linea del archivo `datos/productos.txt` con este formato:

```text
id|nombre|cantidad|precio
```

Ejemplo:

```text
1|Laptop|5|1200.00
2|Mouse|12|25.50
```

## Validaciones implementadas

En la capa de servicio se aplican estas validaciones al registrar productos:

- El nombre no puede ser nulo ni vacio
- La cantidad no puede ser negativa
- El precio debe ser mayor que cero
- El ID no puede repetirse

Si alguna validacion falla, se muestra un mensaje claro al usuario.

## Como ejecutar el proyecto

### Opcion 1: Desde NetBeans

1. Abre NetBeans.
2. Selecciona `Open Project`.
3. Elige la carpeta `Sistema-Inventario-Basico`.
4. Ejecuta la clase principal `com.inventario.presentacion.Main`.

### Opcion 2: Desde terminal

Compilar:

```bash
javac $(find src -name "*.java")
```

Ejecutar:

```bash
java -cp src com.inventario.presentacion.Main
```

## Clases principales

- `Producto`: representa la entidad del inventario
- `IProductoDAO`: contrato para operaciones de persistencia
- `ProductoDAOArchivo`: implementacion DAO sobre archivo de texto
- `IProductoServicio`: contrato de la capa de servicio
- `ProductoServicio`: valida y delega operaciones al DAO
- `Menu`: interfaz por consola para interactuar con el sistema
- `Main`: punto de entrada de la aplicacion

## Caracteristicas destacadas

- Proyecto simple y facil de entender
- Separacion clara de responsabilidades
- Sin dependencia de base de datos
- Facil de ampliar con nuevas interfaces o funcionalidades
- Base util para practicas de Java, POO y CRUD

## Mejoras futuras

- Agregar interfaz grafica completa
- Incorporar busquedas por nombre
- Añadir ordenamiento y filtros
- Crear pruebas unitarias
- Mejorar el formato visual de salida

## Autor

Proyecto desarrollado como sistema de inventario basico en Java para aprendizaje, practica de arquitectura por capas y uso de persistencia local.
