package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class VerCommand extends NoParamsCommand{
	@Override
	public String getName() {
		return "Ver";
	}

	@Override
	public String getShortcut() {
		return "V";
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.ver(ronda, jugador);
	}
}