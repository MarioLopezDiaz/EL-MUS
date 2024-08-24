package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class PasarCommand extends NoParamsCommand{		
	@Override
	public String getName() {
		return "Pasar";
	}
	
	@Override
	public String getShortcut() {		
		return "P";
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.pasar(ronda, jugador);
	}
}
