package mus.control.commands;

import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public class EnvidarCommand extends ParamsCommand{
	private static final int POR_DEFECTO = 2;
	
	public EnvidarCommand() {
		super(POR_DEFECTO);
	}
	
	@Override
	public String getName() {
		return "Envidar";
	}

	@Override
	public String getShortcut() {		
		return "E";
	}
	
	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		game.envidar(ronda, jugador, envite.getText().isEmpty() ? POR_DEFECTO : Integer.parseInt(envite.getText()));	
	}
}
