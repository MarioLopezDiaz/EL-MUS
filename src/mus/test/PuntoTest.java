package mus.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import mus.logic.Game;
import mus.logic.Punto;
import mus.logic.Ronda;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;
import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.exceptions.gameObjectsExceptions.RecibirCartaException;

public class PuntoTest {

    private Punto punto;
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
        punto = new Punto(game);
    }

    @Test
    public void testGreaterThan() throws RecibirCartaException, CreacionCartaException {
        // Verificar que una mano con puntos mayor es considerada "mayor que" una mano con puntos menor
        Jugador jugador1 = new Jugador(null, null, 0, null);
        Jugador jugador2 = new Jugador(null, null, 0, null);
        jugador1.recibirCarta(new Carta("OROS", 1));
        jugador1.recibirCarta(new Carta("COPAS", 1));
        jugador2.recibirCarta(new Carta("ESPADAS", 1));
        jugador2.recibirCarta(new Carta("BASTOS", 1));
        assertTrue(punto.greaterThan(jugador1.getMano(), jugador2.getMano()));
    }


    @Test
    public void testGetNextRonda() {
        // Verificar que la siguiente ronda después de Punto es null
        Ronda siguienteRonda = punto.getNextRonda();
        assertNull(siguienteRonda);
    }

}
