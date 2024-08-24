package mus.logic.gameActions;

import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class OrdagoAction extends RondaDeJuegoAction {
	public OrdagoAction(Ronda ronda, Jugador jugador) {
		super(ronda, jugador);
	}
	
	public void execute() {
		ronda.ordago(jugador);
	}
	
	public String getMsg() {
		return "ORDAGO";
	}
}