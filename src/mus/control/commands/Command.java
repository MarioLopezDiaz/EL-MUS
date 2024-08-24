package mus.control.commands;

import mus.control.Controller;
import mus.gui.Gui;
import javafx.scene.Node;
import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public abstract class Command {
	protected static Controller controller = Gui.controller;
	
	public abstract String getName();
	public abstract String getShortcut();

	public abstract Node parse(Command c, GameControl game, Ronda ronda, Jugador jugador);
	public abstract void execute(GameControl game, Ronda ronda, Jugador jugador);
	  
	protected boolean matchCommandName(String name){
		return getShortcut().equalsIgnoreCase(name) || getName().equalsIgnoreCase(name);
	  }
}