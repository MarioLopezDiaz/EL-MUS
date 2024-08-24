package mus.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import mus.exceptions.gameObjectsExceptions.AddCartaManoException;
import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.exceptions.gameObjectsExceptions.RecibirCartaException;
import mus.logic.Game;
import mus.logic.Juego;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;
import mus.logic.gameobjects.Mano;

public class JuegoTest {

    private Juego juego;
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
        juego = new Juego(game);
    }

    @Test
    public void testTieneRonda() {
        // Verificar que el juego tiene una ronda para un jugador con juego
        Jugador jugador = new Jugador(null, null, 0, null);
        assertTrue(juego.tieneRonda(jugador));
    }

    @Test
    public void testGreaterThan() throws AddCartaManoException, CreacionCartaException {
        // Verificar que una mano con juego mayor sea considerada "mayor que" otra mano con juego menor
    	Mano manoMayor = new Mano();

        // Asumiendo una mano específica para puntuar
        manoMayor.add(new Carta("OROS", 1));
        manoMayor.add(new Carta("COPAS", 10));
        manoMayor.add(new Carta("ESPADAS", 12));
        manoMayor.add(new Carta("BASTOS", 11));

        Mano manoMenor = new Mano();
        manoMayor.add(new Carta("OROS", 12));
        manoMayor.add(new Carta("COPAS", 12));
        manoMayor.add(new Carta("ESPADAS", 6));
        manoMayor.add(new Carta("BASTOS", 7));
        assertTrue(juego.greaterThan(manoMayor, manoMenor));
    }


    @Test
    public void testPuntosMano() throws RecibirCartaException, CreacionCartaException {
        // Verificar que se calculan correctamente los puntos de juego de una mano
        Jugador jugador = new Jugador(null, null,0, null);
        jugador.recibirCarta(new Carta("OROS", 1));
        jugador.recibirCarta(new Carta("COPAS", 10));
        assertEquals(30, juego.puntosMano(jugador));
    }


    @Test
    public void testGetNextRonda() {
        // Verificar que la siguiente ronda después de un juego es null
        assertNull(juego.getNextRonda());
    }

}
