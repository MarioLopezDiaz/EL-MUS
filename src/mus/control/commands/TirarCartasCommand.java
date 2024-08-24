package mus.control.commands;

import java.util.ArrayList;

import mus.control.Controller;
import mus.gui.Gui;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;
import mus.logic.gameobjects.Mano;

public class TirarCartasCommand extends Command{
	private Controller controller = Gui.controller;
	private int numCartas;
	private ArrayList<CheckBox> checkboxes;
	
	@Override
	public String getName() {
		return "Tirar Cartas";
	}

	@Override
	public String getShortcut() {		
		return "T";
	}

	@Override
	public Node parse(Command c, GameControl game, Ronda ronda, Jugador jugador) {
		Button button = new Button(c.getName());
        button.setOnAction(event -> {
            c.execute(game, ronda, jugador);
        });
        HBox hboxCheckBoxes = new HBox();
        hboxCheckBoxes.setSpacing(30);
        checkboxes = new ArrayList<>();
		for(int i = 0; i < Mano.MAX_CARTAS_MANO; i++) {
			CheckBox cb = new CheckBox();
			hboxCheckBoxes.getChildren().add(cb);
			checkboxes.add(cb);
		}
		hboxCheckBoxes.setRotate(-90 * (jugador.getNumJugador() % 2 == 0 ? 0 : jugador.getNumJugador()));
		hboxCheckBoxes.setLayoutX((jugador.getNumJugador() % 2 == 0) 
				? ((jugador.getNumJugador() == 0) 
						? 195
						: 140)
				: (jugador.getNumJugador() == 1) 
					? 330 
					: 10);
		hboxCheckBoxes.setLayoutY((jugador.getNumJugador() % 2 == 1) 
				? ((jugador.getNumJugador() == 1) 
						? 210 
						: 285)
				: ((jugador.getNumJugador() == 0) 
						? 400 
						: 80));
		controller.add(hboxCheckBoxes);
        return button;
	}

	@Override
	public void execute(GameControl game, Ronda ronda, Jugador jugador){
		ArrayList<Carta> cartas = new ArrayList<>();
		for (int i = 0; i < Mano.MAX_CARTAS_MANO; i++) {
			CheckBox cb = checkboxes.get(i);
			if(cb.isSelected())
				cartas.add(jugador.getCarta(i));
			((HBox) cb.getParent()).getChildren().remove(cb);
		}
		numCartas = cartas.size();
		game.darseMus(ronda, jugador, numCartas, cartas);	
	}
}