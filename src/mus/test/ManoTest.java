package mus.test;

import mus.exceptions.gameObjectsExceptions.AddCartaManoException;
import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.exceptions.gameObjectsExceptions.RemoveCartaManoException;
import mus.logic.gameobjects.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ManoTest {

    private Mano mano;

    @Before
    public void setUp() {
        mano = new Mano();
    }

    @Test
    public void testGetNumCartas() {
        assertEquals(0, mano.getNumCartas());
    }

    @Test
    public void testAdd() throws CreacionCartaException, AddCartaManoException {
        Carta carta = new Carta("OROS", 7);
        mano.add(carta);
        assertEquals(1, mano.getNumCartas());
    }

    @Test
    public void testRemove() throws CreacionCartaException, AddCartaManoException, RemoveCartaManoException {
        Carta carta = new Carta("COPAS", 10);
        mano.add(carta);
        mano.remove(carta);
        assertEquals(0, mano.getNumCartas());
    }

    @Test
    public void testTienePares() throws CreacionCartaException, AddCartaManoException {
        Carta carta1 = new Carta("OROS", 7);
        Carta carta2 = new Carta("ESPADAS", 7);
        mano.add(carta1);
        mano.add(carta2);
        assertTrue(mano.tienePares());
    }


    @Test
    public void testToString() throws CreacionCartaException, AddCartaManoException {
        Carta carta1 = new Carta("BASTOS", 5);
        Carta carta2 = new Carta("COPAS", 8);
        mano.add(carta1);
        mano.add(carta2);
        assertEquals("[5,BASTOS] - [8,COPAS] -", mano.toString());
    }
}

