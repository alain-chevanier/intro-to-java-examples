# Introduccion a las Ciencias de la Computacion

## Equipo de enseñanza
* Ricchy Alaín Pérez Chevanier <alain.chevanier@ciencias.unam.mx>
* Manuel Alcántara Juárez <manuelalcantara52@ciencias.unam.mx>

## Objetivo

Aprender el lenguaje de programacion Java a traves de ejemplos del mismo.

## Desarrollo
En este proyecto trabajarás con una base de código construida con Java 17 (LTS) y Maven Wrapper, 
también proveemos pruebas unitarias escritas con la biblioteca **Junit 5.7.2** que te 
darán retrospectiva inmediatamente sobre el funcionamiento de tu implementación.

Para ejecutar las pruebas necesitas ejecutar el siguiente comando:

```
$ env ENV=github ./mvnw test
```

Para ejecutar las pruebas contenidas en una única clase de pruebas, utiliza 
un comando como el siguiente:

```
$ ./mvnw -Dtest=MyClassTest test
```

En el código que recibirás la clase **App** tiene un método __main__ que puedes ejecutar 
como cualquier programa escrito en __Java__. Para eso primero tienes que empaquetar 
la aplicación y finalmente ejecutar el jar generado. Utiliza un comando como el que 
sigue:

```
$ ./mvnw package
... o saltando las pruebas unitarias
$ ./mvnw package -DskipTests
...
...
$ ./mvnw exec:java 
```

## Configuración de los git hooks para formatear el código

Antes de empezar a realizar commits que contenga tu solución
tienes que configurar un módulo de git que te ayudará a 
formatear tu código.

```
./mvnw git-code-format:install-hooks
```

## Forma de trabajo

Recomendamos ampliamente utilizar el editor [IntelliJ](https://www.jetbrains.com/help/idea/installation-guide.html)
para realizar el desarrollo de la práctica.
También agrega el plugin de IntelliJ [SonarLint](https://www.sonarsource.com/products/sonarlint/features/jetbrains/).

## Ejemplos

Cada ejemplo tiene su propio metodo main para poder ejecutar los ejemplos alli presentes.

* Programa para cambiar de base N (2-16) a base 10 y vice versa.
  [codigo aqui](./src/main/java/unam/ciencias/icc/BaseConversionUtils.java)
* Caracteres y complemento a 1 y a 2.
  [codigo aqui](./src/main/java/unam/ciencias/icc/ExampleCharsAndBitOperations.java)
