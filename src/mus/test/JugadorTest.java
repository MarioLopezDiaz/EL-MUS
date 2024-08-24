package mus.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javafx.scene.image.Image;

import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.exceptions.gameObjectsExceptions.RecibirCartaException;
import mus.exceptions.gameObjectsExceptions.TirarCartaException;
import mus.logic.gameobjects.Equipo;
import mus.logic.Game;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;
import java.util.ArrayList;
import java.util.Arrays;

public class JugadorTest {

    private Jugador jugador;
    private Game game;
    private Equipo equipo;
    private Image image;

    @Before
    public void setUp() {
        game = new Game();
        equipo = new Equipo("Equipo 1", 2);
        jugador = new Jugador(game, equipo, "Jugador 1", 4, image);
    }

    @Test
    public void testRecibirCarta() throws RecibirCartaException, CreacionCartaException {
        // Verificar que el jugador recibe una carta correctamente
        Carta carta = new Carta("OROS", 1);
        jugador.recibirCarta(carta);
        assertEquals(1, jugador.getNumCartas());
    }

    @Test(expected = RecibirCartaException.class)
    public void testRecibirCartaError() throws RecibirCartaException, CreacionCartaException {
        // Verificar que se lanza una excepción al intentar recibir una carta en una mano llena
        for (int i = 1; i <= 8; i++) {
            Carta carta = new Carta("OROS", i);
            jugador.recibirCarta(carta);
        }
        Carta cartaExtra = new Carta("OROS", 9);
        jugador.recibirCarta(cartaExtra);
    }

    @Test
    public void testTirarCarta() throws TirarCartaException, RecibirCartaException, CreacionCartaException {
        // Verificar que el jugador puede tirar una carta correctamente
        Carta carta = new Carta("OROS", 1);
        jugador.recibirCarta(carta);
        jugador.tirarCarta(carta);
        assertEquals(0, jugador.getNumCartas());
    }

    @Test(expected = TirarCartaException.class)
    public void testTirarCartaError() throws TirarCartaException, CreacionCartaException {
        // Verificar que se lanza una excepción al intentar tirar una carta que el jugador no tiene en su mano
        Carta carta = new Carta("OROS", 1);
        jugador.tirarCarta(carta);
    }

    @Test
    public void testDarseMus() throws RecibirCartaException, TirarCartaException, CreacionCartaException {
        // Verificar que el jugador puede darse mus correctamente
        Carta carta1 = new Carta("OROS", 1);
        Carta carta2 = new Carta("COPAS", 2);
        Carta carta3 = new Carta("ESPADAS", 3);
        Carta carta4 = new Carta("BASTOS", 4);
        jugador.recibirCarta(carta1);
        jugador.recibirCarta(carta2);
        jugador.recibirCarta(carta3);
        jugador.recibirCarta(carta4);
        jugador.darseMus(4, new ArrayList<>(Arrays.asList(carta1, carta2, carta3, carta4)));
        assertEquals(0, jugador.getNumCartas());
    }

    @Test
    public void testTirarseTodas() throws RecibirCartaException, CreacionCartaException {
        // Verificar que el jugador puede tirarse todas las cartas correctamente
        Carta carta1 = new Carta("OROS", 1);
        Carta carta2 = new Carta("COPAS", 2);
        jugador.recibirCarta(carta1);
        jugador.recibirCarta(carta2);
        jugador.tirarseTodas();
        assertEquals(0, jugador.getNumCartas());
    }

}
