package mus.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.ArrayList;
import mus.avatares.Avatar;
import mus.avatares.AvatarBot;
import mus.control.Controller;
import mus.gui.Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import mus.logic.gameobjects.Bot;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public class ControladorEquipos implements Initializable {
	@FXML
	private Button btnAtras;
	@FXML
	private Button btnListoEquipos;
	@FXML
	private ComboBox<Avatar> cb_eq1_j1;
	@FXML
	private ComboBox<Avatar> cb_eq1_j2;
	@FXML
	private ComboBox<Avatar> cb_eq2_j1;
	@FXML
	private ComboBox<Avatar> cb_eq2_j2;
	
	private Controller controller = Gui.controller;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeComboBox(cb_eq1_j1);
		initializeComboBox(cb_eq1_j2);
		initializeComboBox(cb_eq2_j1);
		initializeComboBox(cb_eq2_j2);
    }
	
    @FXML
    private void atrasButtonClicked()throws IOException {
    	controller.updateScene((new FXMLLoader(getClass().getResource("/mus/gui/escenas/menu.fxml"))).load());
    }
    
    @FXML
    private void listoButtonClicked(ActionEvent event) throws IOException {
    	Equipo equipo1 = new Equipo("equipo 1", 1);
		Equipo equipo2 = new Equipo("equipo 2", 2);
		
		Jugador j11 = initJugador(equipo1, cb_eq1_j1, 0);
		Jugador j12 = initJugador(equipo1, cb_eq1_j2, 2);
		Jugador j21 = initJugador(equipo2, cb_eq2_j1, 1);
		Jugador j22 = initJugador(equipo2, cb_eq2_j2, 3);
		
		controller.initGame(equipo1, equipo2, j11, j12, j21, j22);
		controller.jugarPartida();
    }
    
    private Jugador initJugador(Equipo equipo, ComboBox<Avatar> comboBox, int num_jugador) {
    	Avatar avatar = comboBox.getSelectionModel().getSelectedItem();
    	if(avatar.esBot()) {
    		AvatarBot a = (AvatarBot) avatar;
    		return new Bot(equipo, a.getNombre(), num_jugador, a.getImage(),
    				a.getExigenciaCorte(), a.getExigenciaEnvidar(), a.getFarolero(), a.getNegrero(),
    				a.getPGrande(), a.getPChica(), a.getPPares(), a.getPJuego(), a.getPPunto());
    	}
    	else
    		return new Jugador(equipo, (avatar.getNombre() + " " + num_jugador), num_jugador, avatar.getImage());
    }
    
    
	private double getRandom() {
		return new Random(System.currentTimeMillis()).nextDouble();
	}
	
	private void initializeComboBox(ComboBox<Avatar> cb) {
		ArrayList<Avatar> opciones = new ArrayList<>();
		opciones.add(new Avatar("Jugador"));
		opciones.add(new AvatarBot("Juguetito",	0.8, 0.8, 0.5, 0.9, 0.1, 0,   0.45, 0.45, 0));
		opciones.add(new AvatarBot("Notaloca",	0.2, 0.5, 0.7, 0.7, 0.2, 0.2, 0.3,  0.3,  0));
		opciones.add(new AvatarBot("Serebro",	0.5, 0.5, 0.5, 0.5, 0.2, 0.2, 0.2,  0.2,  0));
		opciones.add(new AvatarBot("Lindo", 	0.3, 0.7, 0.3, 0.7, 0.2, 0,   0.4,  0.4,  0));
		opciones.add(new AvatarBot("Father", 	0.5, 0.4, 0.9, 0.2, 0.3, 0.1, 0.3,  0.3,  0));
		opciones.add(new AvatarBot("Hueso", 	0.4, 0.4, 0.4, 0.6, 0.2, 0,   0.4,  0.4,  0));
		opciones.add(new AvatarBot("Jorge", 	0.7, 0.7, 0.7, 0.1, 0.1, 0.4, 0.4,  0.1,  0));
		opciones.add(new AvatarBot("Enano", 	getRandom(), getRandom(), getRandom(), getRandom(), 0.2, 0.2, 0.2, 0.2, 0.2));
        cb.getItems().addAll(opciones);
        
        cb.setCellFactory(comboBox -> new ListCell<Avatar>() {
            private final ImageView imageView = new ImageView();
            private final Label label = new Label();

            @Override
            protected void updateItem(Avatar item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                	AnchorPane hbox = new AnchorPane();
                	imageView.setImage(item.getImage());
                    imageView.setFitWidth(20);
                    imageView.setFitHeight(20);
                    AnchorPane.setLeftAnchor(imageView, 0.0);
                    
                    label.setText(item.getNombre());
                    label.setFont(Font.font("Aero", 8));
                    AnchorPane.setLeftAnchor(label, 40.0);
                    AnchorPane.setTopAnchor(label, 5.0);
                    hbox.getChildren().add(imageView);
                    hbox.getChildren().add(label);
                    hbox.setPrefWidth(75);
                    setGraphic(hbox);
                }
            }
        });
        cb.setButtonCell(new ListCell<Avatar>() {
            private final ImageView imageView = new ImageView();
            private final Label label = new Label();

            @Override
            protected void updateItem(Avatar item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                	AnchorPane hbox = new AnchorPane();
                	imageView.setImage(item.getImage());
                    imageView.setFitWidth(20);
                    imageView.setFitHeight(20);
                    AnchorPane.setLeftAnchor(imageView, 0.0);
                    label.setText(item.getNombre());
                    label.setFont(Font.font("Aero", 8));
                    label.setTextFill(Color.BLACK);
                    AnchorPane.setLeftAnchor(label, 40.0);
                    AnchorPane.setTopAnchor(label, 10.0);
                    hbox.getChildren().add(imageView);
                    hbox.getChildren().add(label);
                    hbox.setPrefWidth(75);
                    setGraphic(hbox);
                }
            }
        });
	}
}