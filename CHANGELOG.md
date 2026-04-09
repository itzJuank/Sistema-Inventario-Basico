v1.0 - Estructura inicial
- Creacion de la estructura por capas en `src/com/inventario/entidades`, `src/com/inventario/dao`, `src/com/inventario/servicio` y `src/com/inventario/presentacion`.
- Creacion de carpetas de apoyo `datos` y `docs`.
- Configuracion del archivo `datos/productos.txt` para persistencia en texto plano.
- Creacion de la entidad `Producto` con atributos, constructores, getters, setters y metodo `toString()`.

v1.1 - CRUD funcional
- Creacion de la interfaz `IProductoDAO` con operaciones `guardar`, `listarTodos`, `buscarPorId`, `actualizar` y `eliminar`.
- Implementacion de `ProductoDAOArchivo` para leer y escribir productos en `datos/productos.txt` con formato `id|nombre|cantidad|precio`.
- Implementacion de reescritura completa del archivo para actualizar y eliminar productos.
- Creacion de la interfaz `IProductoServicio` y de la clase `ProductoServicio` para delegar operaciones entre presentacion y dao.
- Creacion del menu de consola con opciones para registrar, listar, buscar, actualizar y eliminar productos.
- Creacion de `Main` para iniciar la aplicacion conectando dao, servicio y presentacion.

v1.2 - Validaciones y mejoras
- Validacion en `registrarProducto` para evitar nombres nulos o vacios.
- Validacion en `registrarProducto` para impedir cantidades negativas.
- Validacion en `registrarProducto` para exigir precios mayores a cero.
- Validacion en `registrarProducto` para evitar IDs duplicados con el mensaje `ID ya existe`.
- Manejo de `IllegalArgumentException` en el menu para mostrar mensajes claros al usuario.
- Manejo de `IOException` en el dao con mensajes de error en consola.
- Mejora del menu para confirmar eliminaciones con `¿Esta seguro? (s/n)` y mostrar mensajes sencillos de estado.
