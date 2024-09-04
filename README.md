# Computación Concurrente - Introducción a Hilos 

## Equipo de enseñanza
* Ricchy Alaín Pérez Chevanier <alain.chevanier@ciencias.unam.mx>
* Manuel Alcántara Juárez <manuelalcantara52@ciencias.unam.mx>

## Objetivo

Revisar algunos ejemplos para mostrar el uso de hilos en java, así como analizar las 
ventajas y desventajas de utilizar programas multi-hilo con problemas que se pueden
resolver sin utilizar primitivas de sincronización/concurrencia. 
Para medir la mejora obtenida al realizar operaciones concurrentes/paralelas, 
se compara con la mejora obtenida a partir de la **Ley de Amdahl**.

## Indicaciones generales

Los ejercicios describen un problema a resolver mediante un programa que puede 
implementarse de forma secuencial y concurrente sin necesidad de primitivas de 
sincronización.

## Desarrollo
En esta práctica trabajarás con una base de código construida con Java 11+ y Maven Wrapper, 
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

## Entrega

Deja todo el código con tu solución en la rama __main__, pues por omisión es esta
rama la que compara __Github Classroom__ contra la versión inicial del código mediante
el __Pull Request__ llamado __Feedback__, el cual nosotros vamos a revisar
para evaluar tu entrega.

Para verificar que tu código cumple con la especificación, 
en tu __Pull Request__ debes de pasar las dos validaciones que 
hace __Github Actions__ sobre el código, una de ellas verifica 
que pasas las pruebas automatizadas, y la otra que hayas formateado
tu código con el plugin de maven.

Además, no olvides marcar en classroom la tarea como entregada y 
en ella incluir el enlace hacia el __Pull Request__ que contiene tu 
solución. 

La fecha de entrega de tu práctica va a ser el máximo entre la fecha en la que 
abriste el __Pull Request__ y la fecha en la que hiciste el último push al repositorio con tu 
solución.

## Actividades

## Reporte (2 puntos)

En el archivo __REPORTE.md__, para cada problema tendrás que realizar la comparación 
entre los tiempos de ejecución de la forma secuencial (1 hilo) y la forma concurrente 
(2, 4 y 8 hilos). Además, se analizará la aceleración obtenida en la solución 
concurrente, la cual será comparada contra lo que nos dice la __Ley de Amdahl__.

Para hacer las comparaciones, en cada ejercicio realizarás una tabla y una gráfica.

La tabla debe de tener el siguiente formato:

<table>
    <tr>
        <th>Número de hilos</th>
        <th>Aceleración teórica</th>
        <th>Aceleración obtenida</th>
        <th>Porcentaje de código paralelo</th>
    </tr>
    <tr>
        <td>1</td>
        <td>...</td>
        <td>...</td>
        <td>...</td>
    </tr>
</table>

Donde anotarás la aceleración calculada con la **Ley de Amdahl**, la aceleración que
obtuvo tu programa concurrente y el porcentaje de código paralelo de tu programa,
también calculado con la **Ley de Amdahl**.

La gráfica debe de comparar el tiempo de ejecución del algoritmo para cada configuración
de hilos disponibles __[1,2,4,8]__, generando una gráfica para cada tamaño de entrada,
es decir, en el eje `X` vamos a representar el número de hilos disponible y el eje `Y`
el tiempo en segundos obtenido al ejecutar la prueba. La gráfica contendrá 3 funciones,
una para cada tamaño de entrada. Agregar el número de ejecuciones que hicieron para
obtener el promedio de ejecución y el `%` paralelo teórico.

**NOTA**: Si la versión paralela es más lenta, argumenta algunas de las posibles
razones de por qué está sucediendo de esa manera.

## Problema 1. Suma de Matrices (1 puntos)

Es posible realizar la suma de dos matrices usando varios hilos de forma
independiente. Primero recordemos cómo se obtiene la suma de dos matrices:

Sean `A` y `B` matrices de `N  x M`. La matriz suma `C = A + B` es una matriz 
de tamaño `N x M` que está definida por las entradas:

![c_{ij} = a_{ij} + b_{ij}](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20c_%7Bij%7D%20%3D%20a_%7Bij%7D%20&plus;%20b_%7Bij%7D)

Para calcular la suma de forma paralela usando varios hilos de ejecución,
podemos asignar a cada hilo un conjunto renglones de `A` y `B` para que los sume.

### Especificación del programa

Implementa la interfaz `MatrixAddition` por medio de la clase 
`MultiThreadedMatrixAddition`, la peculiaridad de esta implementación
es que recibe como argumento el operador de suma, el cual es una
instancia de la interfaz `IntBinaryOperator`. La intención de
pasar este operador es que podamos ajustar como combinamos dos 
matrices, esto puede ayudar para que implementes algunos algoritmos
de procesamiento de imágenes.
Para verificar que tu implementación funciona debes de pasar las
pruebas unitarias de la clase `MatrixAdditionTest`.

## Problema 2. Multiplicación de matrices (2 puntos)

Es posible realizar el producto de dos matrices usando varios hilos de forma 
independiente. Primero recordemos cómo se obtiene el producto de dos matrices:

Sean `A` y `B` matrices de `N  x R` y `R x M` respectivamente. La matriz producto 
`C = A x B` es una matriz de tamaño `N x M` que está definida por las entradas:

![c_{ij} = \sum_{k=0}^{r-1} a_{ik} \cdot b_{kj}](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20c_%7Bij%7D%20%3D%20%5Csum_%7Bk%3D0%7D%5E%7Br-1%7D%20a_%7Bik%7D%20%5Ccdot%20b_%7Bkj%7D)

Es decir, el elemento <code>c<sub>ij</sub></code> es igual al producto punto entre la `i`-ésima 
fila de `A` y la `j`-ésima columna de `B`.

Directamente de esta definición obtenemos un algoritmo secuencial para calcular `A x B`, 
donde el cálculo principal es el producto punto, que se vería similar al siguiente 
código:

```java
for(k = 0; k < R; k++) {
    C[i][j] += A[i][k] * B[k][j];
}
```

Para calcular el producto de forma concurrente usando varios hilos de ejecución, 
podemos asignar a cada hilo un conjunto renglones de `A` y multiplicarlos por `B`;
el resultado de estas operaciones se escribe en la matriz `C`.

### Especificación del programa

Crea un programa que calcule la multiplicación de dos matrices de 
tamaño compatibles. Con tal fin tienes que implementar la interfaz
`MatrixMultiplication` por medio de la clase 
`MultiThreadedMatrixMultiplication`.

Para verificar que tu implementación funciona es necesario que pases
las pruebas unitarias contenidas en la clase `MatrixMultiplicationTest`.


## Problema 3. Blur (5 puntos)

Tu tarea en este ejercicio es implementar un algoritmo paralelo de procesamiento 
digital de imágenes, en particular un `Blur`. 

En esencia este algoritmo de lo que se trata es de calcular la convolución 
de una imagen contra una matriz núcleo (`kernal`). 
El efecto que tiene esta operación es que a cada pixel le estamos asignando
como color el promedio de los colores de los pixeles vecinos cercanos.

Este algoritmo se puede descomponer en los siguientes pasos:

1. Implementar la operación de convolución de una matriz por un núcleo.
2. Implementar un generador de matrices nucleo.
3. Implementar un algoritmo de integración de los puntos anteriores
   que generen la imagen resultante de aplicar este filtro.

A continuación describiremos a detalle cómo se implementa cada uno de los 
componentes del algoritmo.

### 1 Algoritmo de convolución de una imagen por un núcleo

La convolución es el proceso de agregar cada elemento de una imagen (pixel) a 
sus vecinos cercanos por medio de una matriz de convolución, a la cual vamos 
a referirnos como núcleo. Es operación no es una multiplicación de matrices 
aunque la operación se representa con el operador `*`.

Sea `I` una imagen representada por medio de una matriz de números
enteros, donde cada entrada representa un color hexadecimal con el 
formato `0xRRGGBB` donde `RR`, `GG` y `BB` son números hexadecimales
de dos dígitos que van desde `0` hasta `FF`(255) y que representan
las bandas de color rojo, verde y azul respectivamente.

Sea `K` una matriz de números de punto flotante y que tiene un número
impar de renglones y columnas, ademas la suma de las entradas de la matriz
es `1`. Por ejemplo si `K` fuera de `3x3` se
vería de esta manera:

![\begin{bmatrix}
k_{0,0} & k_{0,1} & k_{0,2} \\
k_{1,0} & k_{1,1} & k_{1,2} \\
k_{2,0} & k_{2,1} & k_{2,2}
\end{bmatrix}](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20%5Cbegin%7Bbmatrix%7D%20k_%7B0%2C0%7D%20%26%20k_%7B0%2C1%7D%20%26%20k_%7B0%2C2%7D%20%5C%5C%20k_%7B1%2C0%7D%20%26%20k_%7B1%2C1%7D%20%26%20k_%7B1%2C2%7D%20%5C%5C%20k_%7B2%2C0%7D%20%26%20k_%7B2%2C1%7D%20%26%20k_%7B2%2C2%7D%20%5Cend%7Bbmatrix%7D)

La convolución de `I` con `K` denotada por `C = I * K` es una nueva imagen en
donde el color de cada pixel <code>c<sub>i,j</sub></code> se calcula de la 
siguiente manera:

![nc_{i,j} =
\begin{bmatrix}
c_{i-1,j-1} & c_{i-1,j} & c_{i-1,j+1} \\
c_{i,j-1} & c_{i,j} & c_{i,j+1} \\
c_{i+1,j-1} & c_{i+1,j} & c_{i+1,j+1}
\end{bmatrix}
\begin{bmatrix}
k_{0,0} & k_{0,1} & k_{0,2} \\
k_{1,0} & k_{1,1} & k_{1,2} \\
k_{2,0} & k_{2,1} & k_{2,2}
\end{bmatrix}](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20nc_%7Bi%2Cj%7D%20%3D%20%5Cbegin%7Bbmatrix%7D%20c_%7Bi-1%2Cj-1%7D%20%26%20c_%7Bi-1%2Cj%7D%20%26%20c_%7Bi-1%2Cj&plus;1%7D%20%5C%5C%20c_%7Bi%2Cj-1%7D%20%26%20c_%7Bi%2Cj%7D%20%26%20c_%7Bi%2Cj&plus;1%7D%20%5C%5C%20c_%7Bi&plus;1%2Cj-1%7D%20%26%20c_%7Bi&plus;1%2Cj%7D%20%26%20c_%7Bi&plus;1%2Cj&plus;1%7D%20%5Cend%7Bbmatrix%7D%20*%20%5Cbegin%7Bbmatrix%7D%20k_%7B0%2C0%7D%20%26%20k_%7B0%2C1%7D%20%26%20k_%7B0%2C2%7D%20%5C%5C%20k_%7B1%2C0%7D%20%26%20k_%7B1%2C1%7D%20%26%20k_%7B1%2C2%7D%20%5C%5C%20k_%7B2%2C0%7D%20%26%20k_%7B2%2C1%7D%20%26%20k_%7B2%2C2%7D%20%5Cend%7Bbmatrix%7D)

![nc_{i,j} = \sum_{a=0}^{2} \sum_{b=0}^{2}  c_{i-a-1,j-b-1} * k_{a,b}](https://latex.codecogs.com/png.latex?\bg_white&space;\LARGE&space;nc_{i,j}&space;=&space;\sum_{a=0}^{2}&space;\sum_{b=0}^{2}&space;c_{i-a-1,j-b-1}&space;*&space;k_{a,b})

Al calcular esta operación es necesario que tengas en cuentas las siguientes
consideraciones:

* En los bordes de la imagen, la convolución intenta utilizar valores fuera 
  de la imagen, es ese caso siempre hay que utilizar el pixel de más cercano 
  válido dentro de la imagen. Por ejemplo si nuestra imagen tiene 20 renglones 
  y 30 columnas, si intentamos leer el valor de la entrada (renglón=-1, column=-3)
  en realidad debemos de usar el valor de la entrada (0, 0), si intentamos
  leer de (28, 35) en realidad utilizamos (19, 29).
* Se está haciendo la multiplicación de un número por un color.
* Hay que hacer dicha multiplicación por cada banda de color, es decir, el valor 
  del kernel se multiplica por el valor de cada banda de color.
* Los valores intermedios de la suma son números de punto flotante.
* El valor final de la suma se tiene que redondear y ajustar para que quede
  en el rango `0` a `255`.
* Se tiene que formar el color resultante de la convolución a partir de los 
  valores obtenidos en cada banda de color.

En el código lo que tienes que hacer es implementar el método `convolve` de la clase 
`MultiThreadedMatrixConvolution` que implementa la interfaz `MatrixConvolution`.
Al crear una instancia de esta clase es necesario proveer cuantos hilos auxiliares vamos a 
utilizar para realizar la ejecución de `convolve`.
Para verificar que tu implementación es correcta tienes que pasar las pruebas
unitarias que se encuentran en `MatrixConvolutionTest`.


### 2 Generación de la Matriz Nucleo

Un núcleo de convolución es una matriz con un número impar de renglones y
columnas, en el caso de un núcleo para calcular un promedio, 
es una matriz cuadrada en donde la suma de todas las entradas es `1` y 
todas las entradas tienen el mismo valor.

Por ejemplo el siguiente es un nucleo de `3 x 3`.

![K_1 = \begin{bmatrix}
1/9 & 1/9 & 1/9 \\
1/9 & 1/9 & 1/9 \\
1/9 & 1/9 & 1/9
\end{bmatrix}](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20K_1%20%3D%20%5Cbegin%7Bbmatrix%7D%0A1%2F9%20%26%201%2F9%20%26%201%2F9%20%5C%5C%0A1%2F9%20%26%201%2F9%20%26%201%2F9%20%5C%5C%0A1%2F9%20%26%201%2F9%20%26%201%2F9%0A%5Cend%7Bbmatrix%7D)

Para implementar esta parte del algoritmo tienes que implementar el método `build`
de la clase `AvgKernelGenerator` la cual al momento de ser instanciada es 
necesario proveer un radio, si el radio es `R` entonces
el núcleo que hay que generar va a tener `2 * R + 1` renglones y columnas, 
ademas cada entrada de la matriz tendra el valor `1 / (2 * R + 1)^2`.
Para verificar que tu implementación funciona es necesario que pases las pruebas 
unitarias de la clase `AvgKernelGeneratorTest`.


### 3 Implementación del `Blur`

Finalmente, hay que integrar los dos pasos anteriores para poder implementar
el filtro de `Blur` es necesario hacer la convolución de la imagen
contra un núcleo generado en el punto 2.

Para terminar este filtro es necesario implementar el método `process` de 
la clase `MultiThreadedBlur` que implementa la interfaz 
`ImageProcessingAlgorithm`, para crear una instancia de esta clase es necesario
proporcionar el número de hilos a utilizar para ejecutar el algoritmo y el
kernel que utilizaremos para realizar la convolucion. 
Para verificar que todas las partes funcionan es necesario que pases las pruebas 
unitarias de la clase `AvgBlurTest`. 

Para evaluar que tu algoritmo funciona las pruebas unitarias no generan
la imagen final en el sistema de archivos, para que sí las genere y veas
los resultados es necesario que pongas como `true` la variable estática
`WRITE_RESULTS` de la clase `ImageProcessingTestCaseExecutor`. 
Dichas imágenes de resultado serán creadas en el directorio 
`src/test/resources/output_image_processing`.

Los inputs y outputs esperados de este algoritmo se encuentran en el directorio
`src/test/resources/image_processing`.

### Ejemplos

Entrada:

![input](src/test/resources/image_processing/image1.png)

Salida esperada utilizando un kernel de radio 5:

![expected](src/test/resources/image_processing/image1-avg-blur.png)


## [EXTRA] Detección de bordes con operador de Sobel (1 punto)

Este algoritmo se trata de hacer la convolución de una imagen contra dos
núcleos. Dada una imagen `I` definimos las siguientes dos convoluciones como:

![G_x = \begin{bmatrix}
+1 & 0 & -1 \\
+2 & 0 & -2\\
+1 & 0 & -1
\end{bmatrix} * I](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20G_x%20%3D%20%5Cbegin%7Bbmatrix%7D%20&plus;1%20%26%200%20%26%20-1%20%5C%5C%20&plus;2%20%26%200%20%26%20-2%5C%5C%20&plus;1%20%26%200%20%26%20-1%20%5Cend%7Bbmatrix%7D%20*%20I)

y

![G_y = \begin{bmatrix}
+1 & 2 & +1 \\
0 & 0 & 0\\
-1 & -2 & -1
\end{bmatrix} * I](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20G_y%20%3D%20%5Cbegin%7Bbmatrix%7D%20&plus;1%20%26%202%20%26%20&plus;1%20%5C%5C%200%20%26%200%20%26%200%5C%5C%20-1%20%26%20-2%20%26%20-1%20%5Cend%7Bbmatrix%7D%20*%20I)

La imagen resultante `G` se puede obtener de hacer una combinación de las dos 
imágenes anteriores, de la siguiente forma, la entrada `(i, j)`
queda dada por 

![G_{(i,j)} = \sqrt{ (G_y_{(i,j)} )^2 + (G_x_{(i,j)} )^2}](https://latex.codecogs.com/png.latex?%5Cbg_white%20%5CLARGE%20G_%7B%28i%2Cj%29%7D%20%3D%20%5Csqrt%7B%20%28G_y_%7B%28i%2Cj%29%7D%20%29%5E2%20&plus;%20%28G_x_%7B%28i%2Cj%29%7D%20%29%5E2%7D)

Recuerda que esta operación la tienes que hacer por cada banda de color,
y debes de tener cuidado de que los resultados finales tengan valores válidos
para cada banda de color, es decir, valores entre `0` y `255`.

Para la implementación de este ejercicio es necesario que implementes el método
`process` de la clase `MultiThreadSobelOperator`. 
Y para verificar que la implementación funciona es necesario que pases las pruebas
unitarias de la clase `SobelOperatorTest`. Para activar la ejecución de las pruebas 
de este ejercicio tienes que cambiar el valor de `sobel-operator.enabled` a
`true` en el archivo ` src/test/resources/application.properties`.

Para este ejercicio aplican las mismas consideraciones que para el ejercicio
del `Blur`.

### Ejemplo

Entrada:

![input](src/test/resources/image_processing/image1.png)

Salida esperada:

![output](src/test/resources/image_processing/image1-sobel-operator.png)


## [EXTRA] Blur Gaussiano (1 punto)
 
Una forma de mejorar la implementacion del blur es utilizar un nucleo
de convolucion mas conveniente, donde cambiamos en promedio regular por
un promedio ponderado, donde a las posiciones mas cercanas al pixel se
les da un peso mas alto.

Para este ejercicio hay que implementar un generador de nucleos Gaussianos.

El valor de la entrada `(i, j)` de la matriz se obtienen por medio de la 
siguiente fórmula:

![G(x,y) = \frac{1}{2\pi\sigma^2}  e^{-\frac{x^2 + y^2}{2\sigma^2}}](https://latex.codecogs.com/png.latex?\dpi{150}&space;\bg_white&space;\LARGE&space;G(x,y)&space;=&space;\frac{1}{2\pi\sigma^2}&space;e^{-\frac{x^2&space;&plus;&space;y^2}{2\sigma^2}})

Donde `sigma` es la desviación estándar, pero es un valor fijo que será dado
al momento de realizar el cálculo, `x` es la distancia horizontal con respecto
al centro de la matriz y `y` es la distancia vertical.

En general si es núcleo es de dimensión `(2n + 1) x (2n + 1)` el centro se 
encuentra en la entrada `(n, n)` y para una entrada arbitraria `(i, j)` 
calculamos `x = |i-n|` y `y = |j -n|`.

Por ejemplo, en un núcleo de tamaño `5 x 5` el centro se encuentra en la 
entrada `(2,2)`, y para la entrada `(0,0)` el valor de `x = |0-2| = 2` y 
`y = |0-2| = 2`.

Dado que deseamos utilizar esta matriz para obtener un promedio, tenemos que 
normalizarla, es decir, en una pasada calculamos el peso total de toda la matriz
sumando los valores de todas sus entradas, para finalmente con ese valor 
dividir cada entrada del núcleo.

### Especificacion

Para implementar esta parte del algoritmo tiene que implementar el método `build`
de la clase `GaussianKernelGenerator` la cual al momento de ser instanciada es 
necesario proveer un radio y un valor de `varianza`, si el radio es `r` entonces
el núcleo que hay que generar va a tener `2r + 1` renglones y columnas.
Para verificar que tu implementación funciona es necesario que pases las pruebas 
unitarias de la clase `GaussianKernelGeneratorTest`.

Para verificar que el algoritmo completo funciona debes de pasar las pruebas
`GaussianBlurTest`. 
Para activar la ejecución de las pruebas de este ejercicio tienes que cambiar 
el valor de `gaussian-blur.enabled` a `true` en el archivo 
`src/test/resources/application.properties`.

Para este ejercicio aplican las mismas consideraciones que para el ejercicio
del `Blur`.

### Ejemplos

Entrada:

![input](src/test/resources/image_processing/image1.png)

Salida esperada utilizando un kernel de radio 5:

![expected](src/test/resources/image_processing/image1-gaussian-blur.png)

