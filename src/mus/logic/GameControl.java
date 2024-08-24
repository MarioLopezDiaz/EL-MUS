package mus.logic;

import java.util.ArrayList;

import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public interface GameControl {
	public ArrayList<Equipo> getEquipos();
	public ArrayList<Jugador> getJugadores();
	public Ronda getRondaActual();
	
	public void jugarPartida();
	
	public void mus(Ronda ronda, Jugador jugador);
	public void cortar(Ronda ronda, Jugador jugador);
	
	public void darseMus(Ronda ronda, Jugador jugador, int numCartas, ArrayList<Carta> cartas);
	
	public void pasar(Ronda ronda, Jugador jugador);
	public void envidar(Ronda ronda, Jugador jugador, int envite);
	public void subir(Ronda ronda, Jugador jugador, int subida);
	public void ver(Ronda ronda, Jugador jugador);
	public void ordago(Ronda ronda, Jugador jugador);
	
	public void jugarPunto(RondaCondicionada ronda);
	public void jugarSiguienteRonda(Ronda ronda);
}
