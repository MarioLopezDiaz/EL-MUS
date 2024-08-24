package mus.test;

import mus.logic.gameobjects.*;
import mus.exceptions.gameObjectsExceptions.AddCartaManoException;
import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.logic.Chica;
import mus.logic.Game;
import mus.logic.Grande;
import mus.logic.Ronda;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrandeTest {

    private Game game;
    private Grande grande;

    @Before
    public void setUp() {
        game = new Game();
        grande = new Grande(game);
    }

    @Test
    public void testConstructor() {
        assertNotNull(grande);
    }

    @Test
    public void greaterThanTest() throws AddCartaManoException, CreacionCartaException {
        Mano manoMayor = new Mano();

        // Asumiendo una mano específica para puntuar
        manoMayor.add(new Carta("OROS", 1));
        manoMayor.add(new Carta("COPAS", 10));
        manoMayor.add(new Carta("ESPADAS", 12));
        manoMayor.add(new Carta("BASTOS", 7));

        Mano manoMenor = new Mano();
        manoMayor.add(new Carta("OROS", 2));
        manoMayor.add(new Carta("COPAS", 2));
        manoMayor.add(new Carta("ESPADAS", 6));
        manoMayor.add(new Carta("BASTOS", 7));

        assertTrue(grande.greaterThan(manoMayor, manoMenor));
    }

    @Test
    public void testGreaterThanNull() throws AddCartaManoException, CreacionCartaException {
        // Verificar que una mano con grande sea considerada "mayor que" una mano nula
    	Mano mano = new Mano();

        // Asumiendo una mano específica para puntuar
        mano.add(new Carta("OROS", 1));
        mano.add(new Carta("COPAS", 10));
        mano.add(new Carta("ESPADAS", 12));
        mano.add(new Carta("BASTOS", 7));
        assertTrue(grande.greaterThan(mano, null));
    }
    
    @Test
    public void testNextRonda() {
        // Verificar que la siguiente ronda después de Grande sea Chica
        Ronda siguienteRonda = grande.getNextRonda();
        assertTrue(siguienteRonda instanceof Chica);
    }
    
}

