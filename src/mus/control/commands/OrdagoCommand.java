package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class OrdagoCommand extends NoParamsCommand{
	@Override
	public String getName() {
		return "Ordago";
	}

	@Override
	public String getShortcut() {
		return "O";
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.ordago(ronda, jugador);
	}
}