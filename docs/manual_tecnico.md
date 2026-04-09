# Manual Tecnico

## 1. Objetivo del sistema

El proyecto `Sistema-Inventario-Basico` es una aplicacion Java orientada al aprendizaje de arquitectura por capas.

Su objetivo es administrar productos mediante operaciones CRUD usando:

- entidades para representar datos
- DAO para persistencia
- servicio para validaciones
- presentacion para la interaccion con el usuario

La persistencia se realiza en un archivo de texto plano, sin base de datos.

## 2. Tecnologias utilizadas

- Java
- Programacion orientada a objetos
- Arquitectura por capas
- Persistencia en archivo `.txt`
- Git y GitHub

## 3. Estructura general del proyecto

```text
Sistema-Inventario-Basico/
├── datos/
│   └── productos.txt
├── docs/
│   ├── manual_tecnico.md
│   └── manual_usuario.md
├── src/com/inventario/
│   ├── entidades/
│   │   └── Producto.java
│   ├── dao/
│   │   ├── IProductoDAO.java
│   │   └── ProductoDAOArchivo.java
│   ├── servicio/
│   │   ├── IProductoServicio.java
│   │   └── ProductoServicio.java
│   └── presentacion/
│       ├── Main.java
│       └── Menu.java
├── CHANGELOG.md
├── README.md
└── prompts.txt
```

## 4. Descripcion por capas

### 4.1 Capa entidades

Archivo principal:

- `Producto.java`

Responsabilidad:

- Representar un producto del inventario
- Almacenar atributos de negocio basicos

Atributos:

- `id`
- `nombre`
- `cantidad`
- `precio`

Incluye:

- constructor vacio
- constructor completo
- getters y setters
- metodo `toString()`

### 4.2 Capa DAO

Archivos principales:

- `IProductoDAO.java`
- `ProductoDAOArchivo.java`

Responsabilidad:

- Definir y ejecutar operaciones de acceso a datos
- Leer y escribir informacion en `datos/productos.txt`

Metodos definidos en `IProductoDAO`:

- `guardar(Producto producto)`
- `listarTodos()`
- `buscarPorId(int id)`
- `actualizar(Producto producto)`
- `eliminar(int id)`

Implementacion:

`ProductoDAOArchivo` usa clases de `java.nio.file` para manejar el archivo de datos.

Comportamiento:

- `guardar`: agrega una nueva linea al archivo
- `listarTodos`: lee todas las lineas y crea objetos `Producto`
- `buscarPorId`: recorre la lista de productos y devuelve coincidencia exacta
- `actualizar`: reescribe el archivo reemplazando el producto con el mismo ID
- `eliminar`: reescribe el archivo omitiendo el producto eliminado

Manejo de errores:

- Captura `IOException`
- Imprime mensajes de error en consola

### 4.3 Capa servicio

Archivos principales:

- `IProductoServicio.java`
- `ProductoServicio.java`

Responsabilidad:

- Actuar como intermediario entre presentacion y DAO
- Aplicar validaciones antes de guardar informacion

Validaciones actuales en `registrarProducto`:

- nombre no nulo ni vacio
- cantidad no negativa
- precio mayor que cero
- ID no repetido

Si una validacion falla:

- se lanza `IllegalArgumentException`

Los demas metodos delegan directamente al DAO.

### 4.4 Capa presentacion

Archivos principales:

- `Menu.java`
- `Main.java`

Responsabilidad:

- Interactuar con el usuario por consola
- Solicitar datos
- Mostrar resultados y mensajes

`Menu.java` contiene:

- menu principal en bucle
- metodos privados para cada operacion
- lectura de datos con `Scanner`
- manejo de errores de validacion

`Main.java` contiene:

- creacion del DAO
- creacion del servicio
- creacion del menu
- inicio de la aplicacion

## 5. Flujo de funcionamiento

El flujo general del sistema es este:

1. `Main` crea `ProductoDAOArchivo`
2. `Main` crea `ProductoServicio`
3. `Main` crea `Menu`
4. `Menu` solicita datos al usuario
5. `ProductoServicio` valida la informacion
6. `ProductoDAOArchivo` guarda o consulta en `datos/productos.txt`
7. `Menu` muestra el resultado al usuario

## 6. Persistencia de datos

Archivo usado:

- `datos/productos.txt`

Formato por linea:

```text
id|nombre|cantidad|precio
```

Ejemplo:

```text
1|Laptop|5|1200.00
3|Monitor|7|250.00
```

Ventajas de este enfoque:

- simple de entender
- facil de probar
- no requiere servidor ni base de datos

Limitaciones:

- no hay concurrencia
- no hay indices de busqueda
- no es ideal para volumen alto de datos

## 7. Compilacion y ejecucion

### Desde terminal

Compilar:

```bash
javac $(find src -name "*.java")
```

Ejecutar:

```bash
java -cp src com.inventario.presentacion.Main
```

### Desde NetBeans

1. Abrir el proyecto.
2. Confirmar que la clase principal sea `com.inventario.presentacion.Main`.
3. Ejecutar el proyecto.

## 8. Validaciones y manejo de errores

### Validaciones funcionales

Se aplican en `ProductoServicio`:

- nombre obligatorio
- cantidad valida
- precio valido
- ID unico

### Errores de entrada

Se controlan en `Menu`:

- numeros enteros invalidos
- numeros decimales invalidos

### Errores de archivo

Se controlan en `ProductoDAOArchivo`:

- lectura fallida
- escritura fallida
- reescritura fallida

## 9. Posibles mejoras futuras

- agregar interfaz grafica
- agregar pruebas unitarias
- separar utilidades de lectura por consola
- incorporar busqueda por nombre
- agregar reportes o exportacion
- migrar a base de datos si el proyecto crece

## 10. Mantenimiento recomendado

Para mantener el proyecto ordenado:

- conservar la separacion por capas
- evitar colocar validaciones en la capa DAO
- evitar acceder al archivo directamente desde presentacion
- documentar cambios en `CHANGELOG.md`
- registrar prompts y apoyo de IA en `prompts.txt`

## 11. Conclusion

Este proyecto ofrece una base clara, pequena y mantenible para practicar Java, CRUD y arquitectura por capas.

Su diseno facilita futuras ampliaciones sin romper la organizacion principal del sistema.
