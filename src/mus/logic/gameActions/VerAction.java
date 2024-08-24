package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class VerAction extends RondaDeJuegoAction {
	public VerAction(Ronda ronda, Jugador jugador) {
		super(ronda, jugador);
	}
	
	public void execute() {
		ronda.ver(jugador);
	}
	
	public String getMsg() {
		return "VEO";
	}
}
