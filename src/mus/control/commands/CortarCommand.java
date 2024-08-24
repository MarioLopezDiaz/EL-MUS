package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class CortarCommand extends NoParamsCommand{
	@Override
	public String getName() {
		return "Cortar";
	}

	@Override
	public String getShortcut() {
		return "C";
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.cortar(ronda, jugador);
	}
}
