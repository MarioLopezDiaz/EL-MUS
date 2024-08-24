# EL MUS

## DESCRIPCIÓN DEL PROYECTO
  
  El proyecto consistirá en el conocido y reputado juego de cartas español conocido como "El Mus", el cual se juega con 4 cartas por persona y en el que se enfrentan dos parejas con el objetivo de alcanzar la cifra de 40 puntos o "amarracos".
  
  La partida se divide en rondas indefinidas hasta que una de las parejas logre la puntuación previamente mencionada. Cada ronda se estructura a su vez en 4 tipos diferentes de juego, las cuales no comenzarán hasta que una pareja decida cortar "mus", es decir, dejar de descartarse cartas y cambiarlas por otras del mazo. 
  
  En primer lugar, se jugará "Grande", en el que se premiará a quien tenga las cartas más altas siendo el rey y el 3 las más grandes. 
  
  Posteriormente, se disputará "Chica", siendo esto lo opuesto a lo jugado anteriormente, es decir, se premiará a quien tenga las cartas más bajas siendo el as y el 2 las más pequeñas. 
  
  Tras esto se jugará "Pares". En esta parte de la ronda es importante aclarar que para poder jugar esta parte, en primer lugar, habrá que decir si se tiene algún tipo de pareja, trío o "medias", doble pareja o "duples", siendo esta última jugada la más poderosa en esta parte, aunque también influirá las cartas que formen la pareja, siendo los reyes y los 3 los mejores. 
  
  Por último, se jugará "Juego". Al igual que en "Pares", habrá que decir si se tiene un mínimo de 31 puntos con la suma de las 4 cartas. Cada figura y el 3 contarán 10 puntos, el resto su propio número, y el 2 contará 1 punto al ser igual que un as. Si ocurriese que nadie alcanzase esa puntuación se disputaría "Punto" siendo 30 puntos la mejor puntuación. 
  
  Para finalizar, en cada lance de la ronda se realizarán apuestas o "envites" los cuales se repartirán al final de cada ronda cuando los jugadores descubran sus cartas. Asimismo, hay que aclarar que en caso de empate, ganará la persona más próxima a la mano, la cual se irá desplazando a la derecha al final de cada ronda.

## INTRUCCIONES DE TRABAJO

  El lenguaje de programación en el que se elaborará el proyecto será Java, por lo que para poder ejecutarlo y modificarlo se recomienda utilizar la aplicación de Eclipse (Java). Asimismo, para la implementación de la parte gráfica del proyecto, será necesario el uso del paquete de JavaFX.

  Una vez asegurado que, tanto la última versión de Eclipse como el paquete de JavaFX estén instalados, se procederá a la configuración del proyecto. Para ello, se descargará la carpeta src de este repositorio, la cual contiene todo el código necesario para ejecutar el juego del Mus.
  
  Tras esto, únicamente habrá que configurar como main de nuestro código el que está relacionado con la interfaz gráfica, ya que existe otro main el cual abarca el juego en la consola. Ya escogido el main apropiado en el apartado de run configurations, sólo habrá que ejecutar el código con el comando de run y se imprimirá por pantalla el menú principal del juego. A partir de aquí, te tocará envidar y puede que mucho...


## ESTRUCTURA DEL PROYECTO

- **`Prueba_interfaz`**: Contiene el código fuente de prueba para elaborar la parte gráfica del proyecto.
  
- **`src/mus`**: Contiene el código fuente del proyecto.

  - **`avatares/`**: Este módulo contiene los avatares de la parte gráfica.
     - **`Avatar.java`**: Avatar de los jugadores.
     - **`AvatarBot.java`**: Avatar de los bots.

  - **`control/`**: Este módulo controla la implementación de la partida.
     - **`commands/`**: Este módulo contiene los diferentes comandos que representan las diferentes acciones que puede realizar un jugador durante la partida.
        - **`Command.java`**: Clase abstracta para la creación de cada comando.
        - **`CortarCommand.java`**: Código que implementa la funcionalidad de cortar el mus para comenzar la partida.
        - **`EnvidarCommand.java`**: Código que implementa la funcionalidad de hacer una apuesta.
        - **`MusCommand.java`**: Código que implementa la funcionalidad de darse mus en la partida.
        - **`NoParamsCommand.java`**: Código para comando de extensión de un término.
        - **`OrdagoCommand.java`**: Código que implementa la funcionalidad de tirar un All-In.
        - **`ParamsCommand.java`**: Código para comando de extensión de más de un término.
        - **`PasarCommand.java`**: Código que implementa la funcionalidad de pasar el turno.
        - **`SubirCommand.java`**: Código que implementa la funcionalidad de subir la apuesta.
        - **`TirarCartasCommand.java`**: Código que implementa la funcionalidad de tirar las cartas tras darse mus.
        - **`VerCommand.java`**: Código que implementa la funcionalidad de ver la apuesta.
     - **`Controller.java`**: Contiene el código que controla los comandos.
     - **`ControllerJuego.java`**: Contiene el código que controla la parte del juego.
     - **`ControllerInterfaz.java`**: Contiene el código que controla la parte de la interfaz.
       
  - **`exceptions/`**: Este módulo contiene las diferentes excepciones que pueden saltar durante la ejecución del juego.
     - **`gameObjectsExceptions/`**: Este módulo contiene las diferentes excepciones que pueden saltar durante la ejecución del juego relacionadas con los gameObjects de la parte lógica.
        - **`AddCartaManoException.java`**: Contiene el código de las excepciones al añadir nuevas cartas a la mano.
        - **`CreacionCartaException.java`**: Contiene el código de las excepciones al crear una cartas.
        - **`GameObjectException.java`**: Contiene el código de las excepciones relacionados con los gameObjects.
        - **`JugadorException.java`**: Contiene el código de las excepciones relacionadas con el jugador.
        - **`ManoException.java`**: Contiene el código de las excepciones relacionadas con la mano.
        - **`ManoVaciaException.java`**: Contiene el código de las excepciones al tener una mano sin cartas.
        - **`NoExisteNumeroException.java`**: Contiene el código de las excepciones al no existir ese número.
        - **`NoExistePaloException.java`**: Contiene el código de las excepciones al no existir ese palo.
        - **`NoTienesCartaException.java`**: Contiene el código de las excepciones al no tener esa carta.
        - **`RecibirCartaException.java`**: Contiene el código de las excepciones al recibir cartas.
        - **`RemoveCartaManoException.java`**: Contiene el código de las excepciones al eliminar las cartas de la mano.
        - **`TirarCartaException.java`**: Contiene el código de las excepciones al tirar cartas.
     - **`CommandExecuteException.java`**: Contiene el código de las excepciones al ejecutar comandos.
     - **`CommandParseException.java`**: Contiene el código de las excepciones al hacer el parse de los comandos.
     - **`DarseMusException.java`**: Contiene el código de las excepciones al darse mus.
     - **`MusGameException.java`**: Contiene el código de las excepciones relacionadas con la partida.
     - **`RepartirCartasException.java`**: Contiene el código de las excepciones al repartir las cartas.

  - **`gui/`**: Este módulo contiene la parte gráfica del proyecto.
     - **`controllers/`**: Contiene los distintos controladores de las escenas.
     - **`escenas/`**: Contiene las diferentes escenas que compones la parte gráfica del juego.
     - **`resources/`**: Contiene los archivos .jpg como las cartas o el fondo de las escenas.
     - **`Gui.java`**: Contiene el código de la interfaz gráfica del juego.
       
  - **`logic/`**: Este módulo contiene tanto las minirondas en las que se divide cada ronda, como la ronda en sí.
     - **`gameactions/`**: Este módulo contiene los acciones imprescindibles para jugar al mus relacionados con la interfaz.
        - **`CortarAction.java`**: Código que implementa la funcionalidad de cortar el mus para comenzar la partida.
        - **`DarseMusAction.java`**: Código que implementa la funcionalidad de darse mus en la partida.
        - **`EnvidarAction.java`**: Código que implementa la funcionalidad de hacer una apuesta.
        - **`GameAction.java`**: Código que implementa la funcionalidad del game.
        - **`JugarAction.java`**: Código que implementa la funcionalidad de jugar.
        - **`MusAction.java`**: Código que implementa la funcionalidad del mus.
        - **`OrdagoAction.java`**:Código que implementa la funcionalidad de hacer un órdago.
        - **`PasarAction.java`**: Código que implementa la funcionalidad de pasar el turno.
        - **`RondaDeJuegoAction.java`**: Código que implementa la funcionalidad de ronda de juego.
        - **`RondaMusAction.java`**: Código que implementa la funcionalidad de la fase de mus.
        - **`SubirAction.java`**: Código que implementa la funcionalidad de subir la apuesta.
        - **`VerAction.java`**: Código que implementa la funcionalidad de ver la apuesta.
     - **`gameobjects/`**: Este módulo contiene los objetos imprescindibles para jugar al mus.
        - **`Baraja.java`**: Contiene el código de la clase Baraja.
        - **`Bot.java`**: Contiene el código de la clase Bot.
        - **`Carta.java`**: Contiene el código de la clase Carta.
        - **`Equipo.java`**: Contiene el código de la clase Equipo.
        - **`Jugador.java`**: Contiene el código de la clase Jugador.
        - **`Mano.java`**: Contiene el código de la clase Mano.
        - **`PuntuadorMano.java`**: Contiene el código de la clase PuntuadorMano.
     - **`Chica.java`**: Contiene el código de la fase de Chica de la partida.
     - **`Game.java`**: Contiene el código de la lógica de la partida.
     - **`GameControl.java`**: Interfaz para el control del juego.
     - **`GameRondas.java`**: Interfaz para la lógica de las rondas.
     - **`GameUser.java`**: Interfaz para las acciones del jugador.
     - **`Grande.java`**: Contiene el código de la fase de Grande de la partida.
     - **`Juego.java`**: Contiene el código de la fase de Juego de la partida.
     - **`Pares.java`**: Contiene el código de la fase de Pares de la partida.
     - **`Punto.java`**: Contiene el código de la fase de Punto de la partida.
     - **`Ronda.java`**: Contiene el código básico de la ronda.
     - **`RondaCondicionada.java`**: Contiene el código a cerca de una ronda condicionada.
     - **`RondaDeJuego.java`**: Contiene el código para disputar la ronda.
     - **`RondaMus.java`**: Contiene el código para la fase de mus.
     - **`RondaNoCondicionada.java`**: Contiene el código a cerca de una ronda no condicionada.
       
  - **`test/`**: Este módulo contiene tests de la mayoria de funciones publicas del juego.
     - **`BarajaTest.java`**: Contiene el código de los test de la clase Baraja.
     - **`CartaTest.java`**: Contiene el código de los test de la clase Carta.
     - **`ChicaTest.java`**: Contiene el código de los test de la fase de Chica de la partida.
     - **`EquipoTest.java`**: Contiene el código de los test de la clase Equipo.
     - **`EscenaCortarTest.java`**: Contiene el código de los test de la escena de cortar en la mesa.
     - **`GrandeTest.java`**: Contiene el código de los test de la fase de Grande de la partida.
     - **`JuegoTest.java`**: Contiene el código de los test de la fase de Juego de la partida.
     - **`JugadorTest.java`**: Contiene el código de los test de la clase Jugador.
     - **`ManoTest.java`**: Contiene el código de los test de la clase Mano.
     - **`MusTest.java`**: Contiene el código de los test de la fase de Mus de la partida.
     - **`ParesTest.java`**: Contiene el código de los test de la fase de Pares de la partida.
     - **`PuntoTest.java`**: Contiene el código de los test de la fase de Punto de la partida.
    
  - **`view/`**: Este módulo contiene la vista.
     - **`Drawer.java`**: Contiene la parte gráfica de la interfaz.
     - **`Messages.java`**: Contiene los mensajes que se verán por pantalla.
    
- **`.gitignore`**: Especifica los archivos y directorios que Git debe ignorar.

- **`module-info.java`**: Contiene los requisitos que ha de tener el proyecto para funcionar.
  
- **`README.md`**: Este archivo que proporciona una visión general del proyecto, su propósito y la estructura del repositorio.
