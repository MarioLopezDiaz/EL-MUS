package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public abstract class JugarAction extends RondaDeJuegoAction{
	protected int piedras;
	
	public JugarAction(Ronda ronda, Jugador jugador, int piedras) {
		super(ronda, jugador);
		this.piedras = piedras;
	}
}