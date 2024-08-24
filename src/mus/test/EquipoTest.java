package mus.test;

import mus.logic.gameobjects.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EquipoTest {

    private Equipo equipo;

    @Before
    public void setUp() {
        equipo = new Equipo("Las Nalgas de Sofia Vergara", 2);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Las Nalgas de Sofia Vergara", equipo.getNombre());
    }

    @Test
    public void testGetPuntuacion() {
        assertEquals(0, equipo.getPuntuacion());
    }

    @Test
    public void testAddPuntos() {
        equipo.addPuntos(50);
        assertEquals(50, equipo.getPuntuacion());
    }

    @Test
    public void testToString() {
        assertEquals("Las Nalgas de Sofia Vergara0", equipo.toString());
    }
}

