package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.RondaDeJuego;
import mus.logic.gameobjects.Jugador;

public abstract class RondaDeJuegoAction extends GameAction{
	protected RondaDeJuego ronda;
	
	public RondaDeJuegoAction(Ronda ronda, Jugador jugador) {
		super(jugador);
		this.ronda= (RondaDeJuego) ronda; 
	}
}