package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public abstract class GameAction {
	protected Ronda ronda;
	protected Jugador jugador;
	
	public GameAction(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public GameAction(Ronda ronda, Jugador jugador) {
		this.ronda = ronda;
		this.jugador = jugador;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public abstract void execute();
	
	public abstract String getMsg();
}