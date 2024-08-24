package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.RondaMus;
import mus.logic.gameobjects.Jugador;

public abstract class RondaMusAction extends GameAction {
	protected RondaMus ronda;
	
	public RondaMusAction (Ronda ronda, Jugador jugador) {
		super(jugador);
		this.ronda = (RondaMus) ronda;
	}
}
