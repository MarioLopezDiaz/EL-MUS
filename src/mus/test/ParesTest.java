package mus.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.exceptions.gameObjectsExceptions.RecibirCartaException;
import mus.logic.Game;
import mus.logic.Juego;
import mus.logic.Pares;
import mus.logic.Ronda;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;

public class ParesTest {

    private Pares pares;
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
        pares = new Pares(game);
    }

    @Test
    public void testTieneRonda() {
        // Verificar que la ronda de Pares se activa para un jugador con pares
        Jugador jugador = new Jugador(null, null, 0, null);
        assertTrue(pares.tieneRonda(jugador));
    }

    @Test
    public void testGreaterThan() throws RecibirCartaException, CreacionCartaException {
        // Verificar que una mano con pares mayor es considerada "mayor que" una mano con pares menor
        Jugador jugador1 = new Jugador(null, null, 0, null);
        Jugador jugador2 = new Jugador(null, null, 0, null);
        jugador1.recibirCarta(new Carta("OROS", 1));
        jugador1.recibirCarta(new Carta("COPAS", 1));
        jugador2.recibirCarta(new Carta("ESPADAS", 1));
        jugador2.recibirCarta(new Carta("BASTOS", 1));
        assertTrue(pares.greaterThan(jugador1.getMano(), jugador2.getMano()));
    }

    @Test
    public void testPuntosMano() throws RecibirCartaException, CreacionCartaException {
        // Verificar que se calculan correctamente los puntos de pares de una mano
        Jugador jugador = new Jugador(null, null, 0, null);
        jugador.recibirCarta(new Carta("OROS", 1));
        jugador.recibirCarta(new Carta("COPAS", 1));
        assertEquals(40, pares.puntosMano(jugador));
    }


    @Test
    public void testGetNextRonda() {
        // Verificar que la siguiente ronda después de Pares es Juego
        Ronda siguienteRonda = pares.getNextRonda();
        assertTrue(siguienteRonda instanceof Juego);
    }

}
