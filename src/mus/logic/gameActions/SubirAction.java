package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class SubirAction extends JugarAction {
	public SubirAction(Ronda ronda, Jugador jugador, int subida) {
		super(ronda, jugador, subida);
	}
	
	public void execute() {
		ronda.subir(jugador, piedras);
	}
	
	public String getMsg() {
		return "SUBO " + piedras;
	}
}