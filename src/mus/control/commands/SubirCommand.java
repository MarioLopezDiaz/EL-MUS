package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class SubirCommand extends ParamsCommand{
	private static final int POR_DEFECTO = 1;
	
	public SubirCommand() {
		super(POR_DEFECTO);
	}
	
	@Override
	public String getName() {
		return "Subir";
	}

	@Override
	public String getShortcut() {
		return "S";
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.subir(ronda, jugador, envite.getText().isEmpty() ? POR_DEFECTO : Integer.parseInt(envite.getText()));	
	}
}