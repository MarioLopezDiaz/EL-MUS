package mus.control.commands;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Jugador;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public abstract class ParamsCommand extends Command{
	protected int por_defecto;
	protected TextField envite;
	
	public ParamsCommand(int por_defecto) {
		this.por_defecto = por_defecto;
	}

	@Override
	public Node parse(Command c, GameControl game, Ronda ronda, Jugador jugador) {
		HBox envidarCommand = new HBox();
		envidarCommand.setAlignment(Pos.CENTER);
		envidarCommand.setSpacing(10);
		Button button = new Button(c.getName());
		button.setPrefWidth(30);
		button.setPrefHeight(15);
		button.setStyle("-fx-font-size: 5px;");
		envidarCommand.getChildren().add(button);
        button.setOnAction(event -> {
            c.execute(game, ronda, jugador);
        });
        envite = new TextField();
        envite.setPrefWidth(15);
        envite.setPrefHeight(15);
        envite.setStyle("-fx-font-size: 5px;");
        envite.setPromptText(String.valueOf(por_defecto));
        envite.setPrefWidth(30);
        envidarCommand.getChildren().add(envite );
        envite .setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        }));
        return envidarCommand;
	}
}
