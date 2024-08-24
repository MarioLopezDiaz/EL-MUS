package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class MusAction extends RondaMusAction{	
	public MusAction (Ronda ronda, Jugador jugador) {
		super(ronda, jugador);
	}

	public void execute() {
		ronda.mus(jugador);
	}
	
	public String getMsg() {
		return "SOY MUS";
	}
}