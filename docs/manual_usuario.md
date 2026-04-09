# Manual de Usuario

## 1. Introduccion

Este sistema permite administrar un inventario basico de productos desde una interfaz por consola.

Con el programa se pueden realizar estas acciones:

- Registrar productos
- Listar productos
- Buscar productos por ID
- Actualizar productos
- Eliminar productos

La informacion se guarda en el archivo `datos/productos.txt`, por lo que los datos permanecen guardados aunque el programa se cierre.

## 2. Requisitos para usar el sistema

Antes de ejecutar el proyecto, se recomienda tener:

- Java instalado
- NetBeans o una terminal con `javac` y `java`

## 3. Como abrir el proyecto

### Desde NetBeans

1. Abrir NetBeans.
2. Seleccionar `Open Project`.
3. Buscar la carpeta `Sistema-Inventario-Basico`.
4. Abrir el proyecto.
5. Ejecutar la clase principal `com.inventario.presentacion.Main`.

### Desde terminal

Compilar:

```bash
javac $(find src -name "*.java")
```

Ejecutar:

```bash
java -cp src com.inventario.presentacion.Main
```

## 4. Menu principal

Al iniciar, el sistema muestra este menu:

```text
1. Registrar producto
2. Listar productos
3. Buscar producto por ID
4. Actualizar producto
5. Eliminar producto
0. Salir
```

El usuario debe escribir el numero de la opcion deseada y presionar `Enter`.

## 5. Uso de cada opcion

### 5.1 Registrar producto

Esta opcion permite agregar un nuevo producto al inventario.

El sistema solicita:

- ID
- Nombre
- Cantidad
- Precio

Despues de ingresar los datos, el producto se guarda en el archivo `datos/productos.txt`.

### 5.2 Listar productos

Muestra en pantalla todos los productos registrados en el sistema.

Si no hay productos guardados, se muestra el mensaje:

```text
No hay productos registrados.
```

### 5.3 Buscar producto por ID

Solicita un ID y busca un producto exacto con ese valor.

Si el producto existe, se muestran sus datos.  
Si no existe, el sistema muestra:

```text
No encontrado
```

### 5.4 Actualizar producto

Permite modificar un producto existente.

Pasos:

1. Ingresar el ID del producto que se desea actualizar.
2. Si el producto existe, ingresar el nuevo nombre.
3. Ingresar la nueva cantidad.
4. Ingresar el nuevo precio.

Al final, el sistema reemplaza los datos anteriores por los nuevos.

Si el producto no existe, se muestra:

```text
No encontrado
```

### 5.5 Eliminar producto

Permite eliminar un producto por su ID.

Pasos:

1. Ingresar el ID del producto.
2. Confirmar la accion escribiendo `s` cuando el sistema pregunte `¿Esta seguro? (s/n)`.

Si no se confirma, la operacion se cancela.

### 5.6 Salir

Finaliza la ejecucion del programa.

## 6. Validaciones del sistema

Al registrar un producto, el sistema valida lo siguiente:

- El nombre no puede estar vacio
- La cantidad no puede ser negativa
- El precio debe ser mayor que cero
- El ID no puede repetirse

Si ocurre un error, el sistema muestra un mensaje en consola indicando el problema.

## 7. Formato de almacenamiento

Cada producto se guarda en una linea del archivo `datos/productos.txt` con este formato:

```text
id|nombre|cantidad|precio
```

Ejemplo:

```text
1|Laptop|5|1200.00
2|Teclado|10|35.50
```

## 8. Recomendaciones de uso

- No editar manualmente `datos/productos.txt` mientras el programa este en ejecucion
- Usar IDs unicos para evitar conflictos
- Verificar bien cantidad y precio antes de registrar o actualizar
- Mantener una copia del archivo de datos si el inventario es importante

## 9. Problemas comunes

### El programa no compila

Verificar que Java este instalado correctamente.

### Aparece un mensaje de numero invalido

Significa que se ingreso texto donde el sistema esperaba un numero entero o decimal.

### No se ven productos listados

Puede significar que todavia no se han registrado productos o que el archivo `datos/productos.txt` esta vacio.

## 10. Resumen

El sistema fue diseñado para ser simple, practico y facil de entender.  
Es adecuado para ejercicios academicos, practica de CRUD y aprendizaje de arquitectura por capas en Java.
