# AppStore

#### Bienvenido a las Elecciones.
Se desea crear una aplicación que permita manejar información y estadísticas sobre unas 
elecciones. Esta permite manejar la información de 3 candidatos.

De cada candidato se conoce:

- El nombre completo.
- La edad.
- El partido político.
- El costo de la campaña.
- La cantidad de votos obtenidos.
- El porcentaje de votos que tiene el candidato (con respecto al total de votos).

Para calcular el costo de la campaña, se tiene en cuenta el medio de comunicación 
(Televisión, radio o Internet) que influenció a cada votante. De esta manera, para retornar
el retorno de la inversión realizada en publicidad, se incrementa el costo de la campaña
usando los siguientes valores:

1. Voto influenciado por publicidad en Televisión: $1.000
2. Voto influenciado por publicidad en Radio: $500
3. Voto influenciado por publicidad en Internet: $100

Lo anterior quiere decir que, por cada voto que reciba un candidato influenciado por
publicidad en televisión, su costo de campaña se incrementara en $1.000, del mismo modo
por cada voto influenciado por publicidad en radio, su costo de campaña se incrementara
en $500, y finalmente, por cada voto influenciado por publicidad en Internet, su costo de
campaña se incrementará en $100.

Se desea que la aplicación permita:

1. Visualizar la información de un candidato.
2. Votar por un candidato.
3. Calcular el número total de votos.
4. Calcular el costo promedio por campaña.
5. Visualizar estadísticas por rango de edad y género.
6. Vaciar la urna.


#### Requerimientos Funcionales
------------------------------------------------------------------------------------------------------
**Nombre** 
R1 –  Visualizar la información de un candidato.

**Resumen**  Permite visualizar la información detallada (Nombre, edad, partido político, costo campaña, 
cantidad de votos y porcentaje de votos) de cada candidato.

**Entrada**  Ninguna

**Resultado**   Se visualiza la información detallada del candidato..

------------------------------------------------------------------------------------------------------
**Nombre**
R2 – Votar por un candidato.

**Resumen**  Permite votar por un candidato.

**Entrada**
El número del candidato (1, 2 o 3).
El medio publicitario que influenció en la votación (Televisión, Radio o Internet).
El rango de edad del votante ( joven, media o mayor)
El género del votante (masculino o femenino).

**Resultado**  
El número total de votos del candidato se incrementó en 1.
El costo de campaña del candidato se incrementó dependiendo del medio publicitario.
Los estadísticos de votos según rango de edad y género se actualizaron.

------------------------------------------------------------------------------------------------------
**Nombre**
R3 – Calcular el número total de votos.

**Resumen** Permite conocer la cantidad total de votos que hay en la urna, es decir la suma de los votos que
hay para cada uno de los tres candidatos.

**Entrada**
Ninguna.

**Resultado** 
Se visualiza el total de votos en la urna.

------------------------------------------------------------------------------------------------------
**Nombre**
R4 – Calcular el costo promedio por campaña.

**Resumen**
Permite conocer el promedio del costo de campaña de los tres candidatos, es decir, la razón de
la sumatoria de los costos de campaña de los tres candidatos y el número total de candidatos.

**Entrada**
Ninguna.

**Resultado** 
Permite visualizar el costo promedio de la campaña.


------------------------------------------------------------------------------------------------------
**Nombre**
R5 – Visualizar estadísticas.

**Resumen**
Permite visualizar estadísticas de votos por género (femenino y masculino) y rango de edad
(joven, media, mayor). 

**Entrada**
Ninguna.

**Resultado** 
Muestra dos diagramas donde se puede visualizar la cantidad de votos por género y por rango de edad.
------------------------------------------------------------------------------------------------------
**Nombre**
R6 – Vaciar la urna.

**Resumen**
Permite reiniciar los votos y los costos de campaña de todos los candidatos, de tal manera estos
queden en cero. 

**Entrada**
Los votos de los candidatos quedan en cero.

**Resultado** 
Los costos de campaña de los candidatos quedan en cero.
------------------------------------------------------------------------------------------------------

#### Directorio
    editor.md/
       	source/
            test/source/
       	data/
        	docs/
            specs/
                 doc/
             Javadoc/
            api/
            Ejecutable/
        ...
  [YouTube](https://www.youtube.com/user/MrDionicios/videos "youtube")    
