package mus.control;

import java.util.ArrayList;

import mus.logic.Ronda;
import mus.logic.RondaCondicionada;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public interface ControllerInterfaz {
	public ArrayList<Jugador> getJugadores();
	public ArrayList<Equipo> getEquipos();
	public Ronda getRondaActual();
	public void nuevaPartida();
	public void jugarPartida();
	public void jugarPunto(RondaCondicionada ronda);
	public void jugarSiguienteRonda(Ronda ronda);
}
