Preguntas - nivel 3

1. ¿Cuántas sesiones se necesitan? 
R//= Se necesitan 20 seciones para completar el entrenamiento.
2. ¿Qué pasa si borras la línea experiencia += 5;? 
R//= Se crea un ciclo infinito.
3. Reescríbelo usando for. ¿Cuál de las dos versiones te parece más clara y por qué? 
R//= El ciclo While, ya que el ejercicio da las herramientras exactas para llevarlo a cabo.

=============================================================================

Caza de Bugs # 3 

1. ¿Cuál de las 3 partes del ciclo falta? 
R/= Falta el incremento en i, haciendo que se quede atascado en un ciclo infinito.
2. Escribe la línea que falta y dónde exactamente va: _______
R= i++ o (i =+ 1)
3. Reto extra: si alguien "arregla" el programa poniendo i++ antes de suma += i, ¿cuánto daría la suma? Haz la
   prueba de escritorio y compárala con el resultado correcto (55). _______ 
R/= La suma da 65 mientras que correctamente 55
4. Reto extra 2: reescríbelo con for en tres líneas. Explica por qué con for este bug era imposible. _______
R/= Es imposible, ya que la estructura del for no lo permite.

============================================================================

1. Pídele: "Escribe un programa Java con un ciclo while que tenga un bug de ciclo infinito, pero NO me digas dónde
   está."
2. Encuéntralo tú con prueba de escritorio (con simular 4 vueltas basta para detectarlo).
3. Ahora al revés: pídele que resuelva la Misión 3.1 y audita:

   ☐ ¿Puso las inicializaciones antes del do o las metió adentro? - Si

   ☐ ¿La condición de salida contempla las dos causas (salir y morir)? - Si

   ☐ ¿El tope de vida en 100 está bien aplicado? - Si

   ☐ ¿Usó algo prohibido (métodos, constructores)? Si, uso el case

4. Pregunta final: "¿Cuándo NO se puede convertir un while en un for?" Contrástalo con la tabla de este nivel.

===============================================

NIVEL 4 - EL INVENTARIO

Preguntas:
1. ¿Por qué se imprime (i + 1) y no i en el mensaje "Golpe N"? _______
R/= Por que los arreglos van de 0 a 5, y para el usuario seria confuso.
2. ¿Qué pasaría con i <= danios.length? _______
R/= Intetaria acceder a un indice que no existe saldria: ArrayIndexOutOfBoundsException
3. ¿Cuál es el índice del último elemento? _______
R/= 5 o (danios.length - 1)

===============================================

Caza de Bugs #4 

1. Bug 1: ejecuta el programa. ¿Cuántas líneas alcanza a imprimir antes de caerse? ¿Cuál es el mensaje de error
   exacto? _______
R/= 4 lineas y el mensaje es: java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
2. ¿Por qué i <= vidas.length es incorrecto? Escribe el índice máximo válido: _______
R/= Porque los arreglos inician desde 0, la posicion 4 no existiria, solo [0,1,2,3]
3. Bug 2: ¿por qué vidas.length() no compila? ¿Cuál es la diferencia con String? _______
R/= Porque no es una funcion, es un atributo y va sin parentesis.
4. Corrige ambos y verifica.
R/= Se corrigió la condición del ciclo a i < vidas.length y se quitó los paréntesis a vidas.length.

===============================================

NIVEL 5 - EL SALÓN DE LA FAMA

Preguntas (El daño máximo):
1. Hay dos golpes de 45 (índices 1 y 3). ¿Cuál de los dos reporta el programa y por qué?
R/= Reporta el primero (índice 1, turno 2), porque la condición (golpes[i] > maximo) es una comparación estricta (>) y el segundo 45 no es estrictamente mayor que el primero.

2. ¿Qué habría que cambiar para que reportara el último en vez del primero?
R/= Cambiar el operador de comparación estricta (>) por mayor o igual (>=).

3. ¿Por qué el ciclo empieza en i = 1 y no en i = 0?
R/= Porque la posición 0 ya se asignó como valor inicial del máximo (maximo = golpes[0]); comparar el elemento 0 consigo mismo es innecesario.

===============================================

Caza de Bugs #5

1. Bug 1: el máximo imprime 0, pero 0 no está en el array. ¿Por qué?
R/= Porque int maximo se inicializó en 0. Al ser todas las temperaturas negativas (-5, -12, -3, -7), ninguna supera el 0 y el máximo queda en 0.
Corrígelo: Inicializar con el primer elemento int maximo = temperaturas[0]; y comenzar el ciclo en i = 1.

2. Bug 2: la suma es -27 y hay 4 elementos, así que el promedio debería ser -6.75. ¿Qué imprime realmente y por qué?
R/= Imprime -6.0 porque suma / temperaturas.length es una división entre dos números enteros (int), descartando la parte decimal.
Corrígelo: Hacer el casting explícito a double: double promedio = (double) suma / temperaturas.length;

3. Reto extra: ¿por qué el bug 2 no se notaría si los valores fueran -4, -8, -12, -8?
R/= Porque la suma da -32 y al dividir entre 4 da exactamente -8. Da el resultado correcto por pura casualidad, lo que hace al bug muy peligroso ya que puede pasar las pruebas iniciales y fallar silenciosamente en producción.

===============================================

NIVEL 7 - EL EJÉRCITO (Arrays de objetos)

Preguntas (La patrulla):
1. ¿Cuántas veces aparece la palabra new en un programa correcto con 4 guardias?
R/= 5 veces (1 para crear el array y 4 para instanciar cada uno de los 4 héroes dentro del ciclo).

2. ¿Qué error exacto ocurre si borras la línea patrulla[i] = new Heroe();?
R/= java.lang.NullPointerException, porque crear el array solo reserva casillas vacías (null); intentar acceder a un atributo de null provoca esa excepción.

3. ¿Qué vida tiene patrulla[3]?
R/= 80, calculado mediante la fórmula 50 + (3 * 10) = 80.

===============================================

Caza de Bugs #7

1. Bug 1: el programa se cae en la primera vuelta del primer ciclo. ¿Cuál es la excepción exacta y por qué ocurre? ¿Qué línea falta y dónde va?
R/= Excepción: java.lang.NullPointerException. Ocurre porque new Heroe[3] solo crea un array con 3 casillas vacías (null). Falta la línea equipo[i] = new Heroe(); como primera instrucción dentro del primer ciclo for.

2. Bug 2: arregla el bug 1 y vuelve a ejecutar. Ahora se cae al final. ¿Qué excepción es y por qué?
R/= Excepción: java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3. Ocurre porque el segundo ciclo usa i <= equipo.length, intentando acceder a la casilla 3 que no existe.

3. ¿Cuál es el índice máximo válido de este array?
R/= 2 (equipo.length - 1).

4. Corrige ambos y verifica que imprima los tres héroes.
R/= Se corrigió agregando equipo[i] = new Personaje(); dentro del primer for y cambiando la condición del segundo for a i < equipo.length.