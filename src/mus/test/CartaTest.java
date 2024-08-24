package mus.test;
import static org.junit.Assert.*;
import org.junit.Test;
import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.logic.gameobjects.Carta;

public class CartaTest {

    @Test
    public void testConstructor() throws CreacionCartaException {
        // Comprobamos que se pueda crear una carta correctamente
        Carta carta = new Carta("OROS", 1);
        assertNotNull(carta);
    }

    @Test(expected = CreacionCartaException.class)
    public void testConstructorInvalido() throws CreacionCartaException {
        // Comprobamos que se lance una excepción al crear una carta con un palo inválido
        new Carta("PALO_INVALIDO", 1);
    }

    @Test
    public void testGetNumero() throws CreacionCartaException {
        // Comprobamos que se pueda obtener el número de la carta correctamente
        Carta carta = new Carta("OROS", 1);
        assertEquals(1, carta.getNumero());
    }

    @Test
    public void testGetValor() throws CreacionCartaException {
        // Comprobamos que se pueda obtener el valor de la carta correctamente
        Carta carta = new Carta("OROS", 1);
        assertEquals(1, carta.getValor());
    }

    @Test
    public void testGetEscalaValor() throws CreacionCartaException {
        // Comprobamos que se pueda obtener la escala de valor de la carta correctamente
        Carta carta = new Carta("OROS", 1);
        assertEquals(1, carta.getEscalaValor());
    }

    @Test
    public void testToString() throws CreacionCartaException {
        // Comprobamos que la representación como cadena de la carta sea correcta
        Carta carta = new Carta("OROS", 1);
        assertEquals("1O", carta.toString());
    }

    @Test
    public void testEquals() throws CreacionCartaException {
        // Comprobamos que la comparación de cartas funcione correctamente
        Carta carta1 = new Carta("OROS", 1);
        Carta carta2 = new Carta("OROS", 1);
        assertTrue(carta1.equals(carta2));
    }

    @Test
    public void testEqualsEscalaValor() throws CreacionCartaException {
        // Comprobamos que la comparación de escalas de valor funcione correctamente
        Carta carta1 = new Carta("OROS", 1);
        Carta carta2 = new Carta("COPAS", 1);
        assertTrue(carta1.equalsEscalaValor(carta2));
    }
}
