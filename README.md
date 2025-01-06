# Proyecto: Serializador JSON con Anotaciones en Java

## Descripción
Este proyecto demuestra cómo utilizar **anotaciones personalizadas** en Java para serializar objetos a formato JSON. Combina conceptos clave como:

- Uso de **Reflection**.
- Creación y procesamiento de **anotaciones personalizadas**.
- Ejecución de métodos inicializadores mediante anotaciones.

El objetivo es transformar clases Java en objetos JSON utilizando metadatos definidos a través de anotaciones como `@JsonAtributo` y `@Init`.

---

## Características

1. **@JsonAtributo**:
   - Permite configurar los atributos que se incluirán en el JSON.
   - Permite renombrar atributos y capitalizar cadenas de texto.

2. **@Init**:
   - Marca métodos que deben ejecutarse para inicializar objetos antes de serializarlos.

3. **Procesamiento dinámico**:
   - Usa Reflection para procesar anotaciones en tiempo de ejecución y construir dinámicamente el JSON.

---

## Estructura del Proyecto

```
📁 anotaciones
├── 📁 src
│   └── 📁 co.jmurillo.anotacines.ejemplo
│       ├── 📁 models
│       │   └── Producto.java
│       ├── 📁 procesador
│       │   ├── JsonSerializador.java
│       │   └── exception
│       │       └── JsonSereliazadorException.java
│       ├── EjemploAnotacion.java
│       ├── Init.java
│       └── JsonAtributo.java
├── .gitignore
├── anotaciones.iml
└── README.md
```

### Archivos principales:

1. **`Producto.java`**
   - Clase que representa un producto con atributos `nombre`, `precio` y `fecha`.
   - Usa las anotaciones `@JsonAtributo` y `@Init` para personalizar su serialización.

2. **`JsonAtributo.java`**
   - Define la anotación `@JsonAtributo` para marcar los atributos que deben ser serializados.
   - Permite renombrar atributos y opcionalmente capitalizar cadenas de texto.

3. **`Init.java`**
   - Define la anotación `@Init` para marcar métodos de inicialización en las clases.

4. **`JsonSerializador.java`**
   - Procesa las anotaciones de una clase para serializarla en formato JSON.
   - Ejecuta métodos anotados con `@Init` antes de la serialización.

5. **`EjemploAnotacion.java`**
   - Clase principal que ejecuta el ejemplo práctico del proyecto.

---

## Instalación y Uso

### Requisitos previos
- **Java**: JDK 8 o superior.
- **IDE**: IntelliJ IDEA, Eclipse o cualquier IDE de tu preferencia.

### Pasos para ejecutar el proyecto
1. Clona el repositorio en tu máquina local:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Importa el proyecto en tu IDE.

3. Ejecuta la clase `EjemploAnotacion` para observar el siguiente resultado:

```json
{
  "nombre": "Mesa Centro Roble",
  "precio": "1000"
}
```

---

## Explicación Técnica

### **Anotación @JsonAtributo**
```java
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAtributo {
    String nombre() default "";
    boolean capitalizar() default false;
}
```
- **`nombre`**: Permite definir un nombre personalizado para el atributo en el JSON.
- **`capitalizar`**: Si se establece en `true`, transforma el texto para que cada palabra comience con mayúscula.

### **Anotación @Init**
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {}
```
- Marca un método para inicializar el objeto antes de la serialización.

### **Clase JsonSerializador**
- **`convertirJson`**: Convierte un objeto en formato JSON procesando las anotaciones `@JsonAtributo` y ejecutando métodos marcados con `@Init`.
- **`inicializarObjeto`**: Ejecuta los métodos marcados con `@Init` para preparar el objeto antes de la serialización.

Ejemplo:
```java
Producto p = new Producto();
p.setNombre("mesa centro ROBLE");
p.setPrecio(1000L);
System.out.println(JsonSerializador.convertirJson(p));
```

---

## Ejemplo de Salida

```json
{
  "nombre": "Mesa Centro Roble",
  "precio": "1000"
}
```

---

## Posibles Mejoras

1. **Soporte para más tipos de datos**:
   - Ampliar la funcionalidad para manejar listas, fechas en diferentes formatos, etc.

2. **Validaciones adicionales**:
   - Agregar validaciones para atributos nulos o inválidos.

3. **Configuración avanzada**:
   - Permitir más opciones en la anotación `@JsonAtributo`, como formato de fecha o precisión para valores numéricos.

---

## Contribuciones
Si deseas contribuir a este proyecto, envía un pull request con tus cambios o sugerencias.

---

## Autor
- **Jefferson Murillo**

---

## Licencia
Este proyecto se distribuye bajo la Licencia MIT.
