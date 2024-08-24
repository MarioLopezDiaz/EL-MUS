package mus.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import mus.logic.Game;
import mus.logic.Grande;
import mus.logic.RondaMus;
import mus.logic.Ronda;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;
import mus.exceptions.gameObjectsExceptions.TirarCartaException;

public class MusTest {

    private RondaMus rondaMus;
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
        rondaMus = new RondaMus(game);
    }


    @Test
    public void testGetNextRonda() {
        // Verificar que la siguiente ronda después de Mus es Grande
        Ronda siguienteRonda = rondaMus.getNextRonda();
        assertTrue(siguienteRonda instanceof Grande);
    }

    @Test
    public void testMus() {
        // Verificar que se juega correctamente la acción de Mus
        Jugador jugador = new Jugador(null, null,0, null);
        rondaMus.mus(jugador);
        assertTrue(rondaMus.dioVuelta());
    }

    @Test
    public void testCortar() {
        // Verificar que se juega correctamente la acción de Cortar
        rondaMus.cortar(null); // No hay necesidad de un jugador para esta acción en el test
        assertFalse(rondaMus.dioVuelta());
    }

    @Test
    public void testDarseMus() throws TirarCartaException {
        // Verificar que se juega correctamente la acción de Darse Mus
        Jugador jugador = new Jugador(null, null, 0,null);
        rondaMus.darseMus(jugador, 4, new ArrayList<Carta>());
        assertFalse(rondaMus.dioVuelta());
    }

}

