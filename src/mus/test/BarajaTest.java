package mus.test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;

import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.logic.gameobjects.Baraja;
import mus.logic.gameobjects.Carta;
import java.util.ArrayList;

public class BarajaTest {

    private Baraja baraja;

    @Before
    public void setUp() {
        baraja = new Baraja();
    }

    @Test
    public void testBarajar() {
        // Comprobamos que la baraja se baraje correctamente
        baraja.barajar();
        try {
            Field barajaField = Baraja.class.getDeclaredField("baraja");
            barajaField.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Carta> barajaList = (ArrayList<Carta>) barajaField.get(baraja);
            assertEquals(40, barajaList.size());
        } catch (Exception e) {
            fail("Excepción al acceder a la baraja: " + e.getMessage());
        }
    }

    @Test
    public void testRepartirCarta() {
        // Comprobamos que se pueda repartir una carta de la baraja
        assertNotNull(baraja.repartirCarta());
        try {
            Field barajaField = Baraja.class.getDeclaredField("baraja");
            barajaField.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Carta> barajaList = (ArrayList<Carta>) barajaField.get(baraja);
            assertEquals(39, barajaList.size());
        } catch (Exception e) {
            fail("Excepción al acceder a la baraja: " + e.getMessage());
        }
    }

    @Test
    public void testAnyadirMonton() throws CreacionCartaException {
        // Comprobamos que se pueda añadir una carta al montón
        Carta carta = new Carta("OROS", 1); // Creamos una carta para añadir al montón
        baraja.anyadirMonton(carta);
        try {
            Field montonField = Baraja.class.getDeclaredField("monton");
            montonField.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Carta> montonList = (ArrayList<Carta>) montonField.get(baraja);
            assertTrue(montonList.contains(carta));
        } catch (Exception e) {
            fail("Excepción al acceder al montón: " + e.getMessage());
        }
    }
}
