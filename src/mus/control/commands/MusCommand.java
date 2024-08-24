package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class MusCommand extends NoParamsCommand{
	@Override
	public String getName() {
		return "Mus";
	}

	@Override
	public String getShortcut() {
		return "M";
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.mus(ronda, jugador);
	}
}
