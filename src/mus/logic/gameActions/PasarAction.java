package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class PasarAction extends RondaDeJuegoAction {
	public PasarAction(Ronda ronda, Jugador jugador) {
		super(ronda, jugador);
	}
	
	public void execute() {
		ronda.pasar(jugador);
	}
	
	public String getMsg() {
		return "PASAR";
	}
}