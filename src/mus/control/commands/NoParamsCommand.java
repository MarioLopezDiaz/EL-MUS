package mus.control.commands;

import javafx.scene.control.Button;
import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;

public abstract class NoParamsCommand extends Command {
	@Override
	public Button parse(Command c, GameControl game, Ronda ronda, Jugador jugador) {
		Button button = new Button(c.getName());
		button.setPrefWidth(30);
		button.setPrefHeight(15);
		button.setStyle("-fx-font-size: 5px;");
        button.setOnAction(event -> {
        	c.execute(game, ronda, jugador);
        });
        return button;
	}
}