package mus.logic;

import java.util.List;

import mus.control.commands.Command;
import mus.exceptions.RepartirCartaException;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public interface GameRondas {
	public int getMano();
	public Jugador getJugadorAt(int pos);
	public boolean sonPareja(Jugador j1, Jugador j2);

	public int getNumCartas(Jugador jugador);
	public boolean tienePares(Jugador jugador);
	public boolean tieneJuego(Jugador jugador);
	public void mostrarCondicionada();
	public void borrarCondicionada();
	
	public void addPuntos(Equipo equipo, int puntos);
	
	public void quiereMus(RondaMus ronda, Jugador jugador, String msg, List<Command> comandosPosibles);
	public void tirarCartas(RondaMus ronda, Jugador jugador, String msg, List<Command> comandosPosibles);
	public void enviteInicial(RondaDeJuego ronda, Jugador jugador, String msg, List<Command> comandosPosibles);
	public void respuestaEnvite(RondaDeJuego  ronda, Jugador jugador, String msg, List<Command> comandosPosibles);
	
	public void repartirCarta(Jugador jugador) throws RepartirCartaException;
	public void updateCartas();
	public void pasarARonda(Ronda ronda);
	public void gestionarOrdago(RondaDeJuego ronda);
	
	public void jugarPunto(Punto punto);
	public void seJuegaPunto(RondaCondicionada ronda);
	public void noSeJuegaCondicionada(RondaCondicionada ronda);
}