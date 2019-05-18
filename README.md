# CartMode
[![Heroku](https://wmpics.pics/di-D9YP.png)](https://arswproyect.herokuapp.com)
[![CircleCI](https://circleci.com/gh/Arsw2019-1/ProyectoARSW20191.svg?style=svg)](https://circleci.com/gh/Arsw2019-1/ProyectoARSW20191)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/badges/shields.svg)](https://github.com/Arsw2019-1/ProyectoARSW20191)
[![MIT license](https://img.shields.io/badge/License-MIT-lightgrey.svg)](https://lbesson.mit-license.org/)

## Arquitecturas de Software (ARSW)<br />
## 2019-1<br/>
## Escuela Colombiana de Ingeniería Julio Garavito - Ingeniería de Sistemas
#### Juego educativo, competitivo y a su vez de entretenimiento tipo seleccion de parejas que pretende poner a prueba las hablidades cognitivas de los usuarios, complementandolo con preguntas sencillas de matematicas..
---
### Integrante
- Cesar E. Lanos Camacho
### Profesor
- David Saavedra
---
### :link: URLs
| Elemento | Link |
|:-------------------------------------:|:----------------------------------------------------------------------------------------------------:|
| Propuesta de proyecto | https://docs.google.com/document/d/1ynF7FltaMq4Is_eI6oozmRWI5bi-lQrzWnHo84oVVRc/edit?usp=sharing  |
| Taiga | https://tree.taiga.io/project/cefarr-cartmode/timeline  |  
| NinjaMock | https://ninjamock.com/s/V5J5CSx  | 
| Javadoc | Generado en la ruta ./target/site/apidocs |
| Documento de Arquitectura del Sistema | https://drive.google.com/file/d/1Q7eTkRk0ZuE1sClnu6SufcEVbkiP3maU/view?usp=sharing | 
| Servidor 1 | http://34.74.211.162:8080/ | 
| Servidor 2 | http://34.73.143.202:8080/ | 
| Balanceador de Carga | http://35.211.240.94:8080/ | 
---
### :book: Instrucciones
Proximamente

---

### :camera: Pantallas de la aplicación-- Pruebas Funcionales.

### :book: Requisitos Funcionales

- El jugador inicia la aplicacion e ingresa a la pagina de bienvenida.

![](img/1.png)

---

- El jugador se conecta y queda registrado en una sala unica.(De ser el primero queda como anfitrion).

![](img/2.png)

---

- Cada jugador puede conocer tanto su anfitrion como los demas participantes de su partida.

![](img/3.png)

---

-Como se observa Cesar ingreso a la sala de juego.
![](img/8.png)

---
- El Anfitrion no puede iniciar la partida ya que no hay suficientes jugadores conectados.
![](img/82.png)

---

- Ingreso Leonado pero el jugador Anfitrion es el unico que puede iniciar la partida (Cesar).

![](img/4.png)

---
-Como se observa Leonardo y Pepita han ingresado a la sala de juego.
![](img/81.png)

---

-Ya se completaron los jugadores minimos, y el Anfitrion inicia la partida.
![](img/51.png)

---

-Los jugadores comienzan a jugar y se evidencia el Stomp funcionando. Ademas se 
puede apreciar que cada jugador tiene su propio color caracteristico.

![](img/92.png)
![](img/91.png)

---

-Otro usuario se conecta pero ya no hace parte de la sala anteriormente creada, 
    es agregado a una nueva sala.

![](img/61.png)

---

- Despues los jugadores pueden ver sus resultador de manera ordenada.

![](img/7.png)

---

- Los jugadores o cualquier usuario podra consultar el historial de los mejores
  puntajes en cartMode de manera ordenada.

![](img/99.png)

---

## Pruebas con Postman

---

## CartModeCOntroller

- Obtener todos los nombres de los jugadores de la aplicacion.

![](img/p1.png)

---

- Obtener todos los nombres de los jugadores de una sala.

![](img/p2.png)


---

- Cantidad de Jugadores en una sala especifica.

![](img/p3.png)

---

- Añadiendo un nuevo jugador al juego.

![](img/p4.png)

---
- Datos completos sobre todos los jugadores de la aplicacion.

![](img/p5.png)

---
- Datos completos sobre todos los jugadores de una sala especifica de 
la aplicacion.

![](img/p6.png)

---
- Toda la informacion sobre todas las salas que esten creadas en la aplicacion.
![](img/p7.png)

---
- Informacion sobre sala a la cual pertenece un jugador especifico.
![](img/p8.png)

---
- Nos retorna un valor booleano y saber si la sala ya inicio o todavia esta 
en espera.
![](img/p9.png)

---
- Retorna todos los nombres de los jugadores de una sala especifica.
![](img/p10.png)

---
- Nos regresa el jugador anfitrion de la sala especificada.
![](img/p11.png)

---
- Nos regresa un valor booleano informando si el jugador pasado como 
parametro es o no Anfitrion en su sala.
![](img/p12.png)

---
- Nos regresa el nivel de la sala especificada.
![](img/p13.png)

---
- Adiciona un puntaje cuando el jugador responde correctamente una pregunta.
![](img/p14.png)

---

## CartMode ControllerPersistence

---
- Adicionar nuevos jugadores a la base de datos.
![](img/p15.png)

---
- Muestra a todos los jugadores almacenados en la base de datos.
![](img/p16.png)
---

## CartMode Controller Preguntas

---
- Nos muestra todas las preguntas del sistema.
![](img/p17.png)

---
- Nos regresa una pregunta aleatoriamente de todas las preguntas del sistema.
![](img/p18.png)

---
- Nos regresa una baraja de cartas con una configuracion deacuerdo al nivel 
que se le pase como parametro.

- Nivel 1

![](img/p19.png)

- Nivel 2
![](img/p20.png)

- NIvel 3
![](img/p21.png)

---

### :triangular_ruler: Diseño de arquitectura 
#### - Paquetes
![](img/DiagramaFullClases.png)
#### - Clases
![](img/DiagramaClases1.png)
#### - Paquete Detalle 1
![](img/DiagramasF1.png)
#### - Paquete Detalle 2
![](img/DiagramaF2.png)
#### - Paquete Detalle 3
![](img/DiagramaF3.png)
#### - Interaccion Stomp
![](img/InteraccionStomp.png)
#### - Diagrama de Despliege
![](img/DiagramaDespliege.png)

---
### :wrench: Tecnologías utilizadas
[![](img/Java-Logo.png)](https://www.java.com/)
[![](img/html_css_js.png)](https://blog.hubspot.com/marketing/web-design-html-css-javascript)
[![](img/mavenLogo.jpg)](https://maven.apache.org/)
[![](img/axios.png)](https://github.com/axios/axios)
[![](img/Spring-Logo.png)](https://spring.io/)
[![](img/astahLogo.png)](http://astah.net/)
[![](img/cover-heroku.png)](https://www.heroku.com/)
[![](img/circleciLogo.png)](https://circleci.com/)
[![]()]()
[![](img/git-githubLogo.jpg)](https://github.com/)

---
### Licencia
[MIT]()
