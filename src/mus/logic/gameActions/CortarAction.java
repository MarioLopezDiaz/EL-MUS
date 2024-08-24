package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class CortarAction extends RondaMusAction{	
	public CortarAction(Ronda ronda, Jugador jugador) {
		super(ronda, jugador);
	}

	public void execute() {
		ronda.cortar(jugador);
	}
	
	public String getMsg() {
		return "CORTO";
	}
}