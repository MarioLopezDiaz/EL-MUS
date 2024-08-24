package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class EnvidarAction extends JugarAction {
	public EnvidarAction(Ronda ronda, Jugador jugador, int envite) {
		super(ronda, jugador, envite);
	}
	
	public void execute() {
		ronda.envidar(jugador, piedras);
	}
	
	public String getMsg() {
		return "ENVIDO " + piedras;
	}
}