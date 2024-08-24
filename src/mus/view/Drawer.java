package mus.view;

import java.util.List;
import mus.control.ControllerInterfaz;
import mus.control.commands.Command;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.RondaCondicionada;
import mus.logic.gameActions.GameAction;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;
import javafx.stage.Stage;

public class Drawer {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private ControllerInterfaz controller;
	
	public Drawer() {}
	
	public Drawer(ControllerInterfaz controller, Stage stage) {
		this.controller = controller;
		this.stage = stage;
		root = new AnchorPane();
		scene = new Scene(root);
		this.stage.setScene(scene);
		this.stage.setTitle("Mus-ElArmaSecreta");
		this.stage.setWidth(510);
		this.stage.setHeight(536);
		this.stage.setResizable(true);		
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/mus/gui/resources/icon.png")));
		this.stage.show();
	}
	
	public void updateScene(Parent root) {
		this.root = root;
		scene.setRoot(root);
	}
	
	public void updateNombres() {
		updateNombresEquipos();
		updateNombresJugadores();
	}
	
	public void updateCartas() {
		for (Jugador j : controller.getJugadores())
			updateCartasJugador(j);
	}
	
	public void updateRonda() {
		Text label = (Text) getPaneMarcador().lookup("#ronda");
		String new_text = controller.getRondaActual().getNombre().toUpperCase();
		updateLabelText(label, new_text);
	}
	
	public void cambiarMano(int pos_mano) {
		for(Jugador j : controller.getJugadores())
			getManoJugador(j).setVisible(false);
		getManoJugador(controller.getJugadores().get(pos_mano)).setVisible(true);
	}
	
	public void updateMarcador() {
		for (Equipo e : controller.getEquipos()){
			for(int valPiedras = 1; valPiedras <= 5; valPiedras += 4) {
				int lim_piedras = valPiedras == 1 ? 5 : 8;
				for(int puntos = 1; puntos <= lim_piedras; puntos++)
					getCirclePiedraDeNPuntos(e, valPiedras, valPiedras*puntos).setFill(Color.TRANSPARENT);
			}
			int piedrasDe5 = e.getPuntuacion() > 40 ? 8 : e.getPuntuacion() / 5;
			int piedrasDe1 = e.getPuntuacion() % 5;
			for(int puntos = 1; puntos <= piedrasDe5; puntos++)
				getCirclePiedraDeNPuntos(e, 5, 5*puntos).setFill(Color.web("#ff722a"));
			
			for(int puntos = 1; puntos <= piedrasDe1; puntos++)
				getCirclePiedraDeNPuntos(e, 1, puntos).setFill(Color.web("#ff722a"));
			
			for(int i = 1; i <= 4; i++)
				((AnchorPane) getPaneVacaI(e, i)).setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-border-width: 1px;");
			int vacas = e.getVacas();
			if(vacas != 0)					((AnchorPane) getPaneVacaI(e, vacas)).setStyle("-fx-background-color: #ff722a; -fx-border-color: white; -fx-border-width: 1px;");
		}
	}
	
	public void borrarCondicionada() {
		for(Jugador j : controller.getJugadores())
			getPaneCondicionada(j).setVisible(false);
	}
	
	public void mostrarCondicionada() {
		for(Jugador j : controller.getJugadores()) {
			Text condicionada = getTextCondicionada(j);
			boolean tieneRonda = controller.getRondaActual().getNombre() == "PARES" ? j.tienePares() : j.tieneJuego();
			String new_text = String.format("%s tiene %s", tieneRonda ? "SI" : "NO", controller.getRondaActual().getNombre());
			updateLabelText(condicionada, new_text);
			getPaneCondicionada(j).setVisible(true);
		}
	}
	
	public void pedirComando(GameControl game, Ronda ronda, Jugador jugador, String msg, List<Command> availableCommands) {
		((AnchorPane) getCommandSpace()).setVisible(true);
		updateLabelText(getTextCommandMsg(), String.format(msg, jugador.getNombre()));
		VBox vbox = (VBox) getCommandSpaceBox();
	    for (Command c : availableCommands)
	        vbox.getChildren().add(c.parse(c, game, ronda, jugador));
	    vbox.setAlignment(Pos.CENTER);
	}
	
	public void executeAction(GameAction action) {
		Node viñeta = getPaneActionJugador(action.getJugador());
		Text action_txt = getActionJugador(action.getJugador());
		updateLabelText(action_txt, action.getMsg());
		viñeta.setVisible(true);
		((AnchorPane) getCommandSpace()).setVisible(false);
		Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			if (root.lookup("#cartas_mus") != null) {
				HBox cartas_mus = (HBox) root.lookup("#cartas_mus");
				((AnchorPane) root).getChildren().remove(cartas_mus);
			}
			((VBox) getCommandSpaceBox()).getChildren().clear();
			action.execute();
        }));
		timeline1.play();
		
		Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
        	viñeta.setVisible(false);
        }));
        timeline2.play();
	}
	
	public void showGanador(Equipo ganador) {
		Node panel_ganador = getPaneGanador();
		panel_ganador.setVisible(true);
		getTextGanador().setText(String.format("HA GANADO EL EQUIPO %s", ganador.getNombre()));
		Button button = new Button("NUEVA PARTIDA");
		button.setFont(new Font(8));
		button.setLayoutX(35);
		button.setLayoutY(113);
		button.setPrefHeight(10);
		button.setPrefHeight(20);
		button.setOnAction(event -> {
			controller.nuevaPartida();
		});
		((Pane) panel_ganador).getChildren().add(button); 
	}
	
	public void nuevaMano() {
		Button button = new Button("NUEVA MANO");
		((AnchorPane) root).getChildren().add(button);
		AnchorPane.setRightAnchor(button, 14.0);
		AnchorPane.setTopAnchor(button, 14.0);
		button.setOnAction(event -> {
			((AnchorPane) root).getChildren().remove(button);
			updateMarcador();
		    controller.jugarPartida();
		});
	}
	
	public void seJuegaPunto(RondaCondicionada ronda) {
		PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event -> {
    		borrarCondicionada();
    		controller.jugarPunto(ronda);
        });
        pause.play();
	}
	
	public void noSeJuegaCondicionada(RondaCondicionada ronda) {
		PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event -> {
    		borrarCondicionada();
    		controller.jugarSiguienteRonda(ronda);
        });
        pause.play();
	}
	
	public void add(HBox hboxCheckBoxes) {
		hboxCheckBoxes.setId("cartas_mus");
		((AnchorPane) root).getChildren().add(hboxCheckBoxes);
	}
	
	private void updateNombresEquipos() {
		for (Equipo e : controller.getEquipos()){
			Text nombre_equipo = getTextNombreEquipo(e);
			String new_text = e.getNombre();
			updateLabelText(nombre_equipo, new_text);
		}
	}
	
	private void updateNombresJugadores() {
		for (Jugador j : controller.getJugadores()){
			ImageView img_jug = getImageJugador(j);
			img_jug.setImage(j.getImage());
			Text nombre_jugador = getTextNombreJugador(j);
			String new_text = j.getNombre();
			updateLabelText(nombre_jugador, new_text);
		}
	}
	
	private void updateLabelText(Text text, String new_text) {
		text.setText(new_text);
	}
	
	private void updateCartasJugador(Jugador jugador) {
		Node pane_cartas = getPaneCartasJugador(jugador);
		for (int i = 0; i < jugador.getNumCartas(); i++) {
			Carta carta = jugador.getMano().getCarta(i);
			String numero = String.valueOf(carta.getNumero());
			String palo = String.valueOf(String.valueOf(carta.getPalo()).charAt(0));
			ImageView carta_img = (ImageView) pane_cartas.lookup(String.format("#carta_%s%s", jugador.getNumJugador(), String.valueOf(i)));
			carta_img.setImage(new Image(getClass().getResourceAsStream(String.format("/mus/gui/resources/cartas/%s%s.jpg", numero, palo))));
		}
	}
	
	private Node getPaneMarcador() {
		return (Node) root.lookup("#marcador");
	}
	
	private Node getPaneVacasEquipo(Equipo equipo) {
		return (Node) getPaneMarcador().lookup(String.format("#vacas_eq%s", equipo.getNumEquipo()));
	}
	
	private Text getTextNombreEquipo(Equipo equipo) {
		return (Text) getPaneVacasEquipo(equipo).lookup(String.format("#eq%s_nombre", equipo.getNumEquipo()));
	}
	
	private Text getTextNombreJugador(Jugador jugador){
		return (Text) getPaneJugador(jugador).lookup(String.format("#name_j%s", jugador.getNumJugador()));
	}
	
	private ImageView getImageJugador(Jugador jugador) {
		return (ImageView) getPaneJugador(jugador).lookup(String.format("#img_j%s", jugador.getNumJugador()));
	}
	
	private Node getPaneVacaI(Equipo equipo, int numVaca) {
		return (Node) getPaneVacasEquipo(equipo).lookup(String.format("#eq%s_vaca%s", equipo.getNumEquipo(), numVaca));
	}
	
	private Node getPaneJugadores() {
		return (Node) root.lookup("#pane_jugadores");
	}
	
	private Node getPaneJugador(Jugador jugador) {		
		return (Node) getPaneJugadores().lookup(String.format("#pane_jugador%s", String.valueOf(jugador.getNumJugador())));
	}
	
	private Node getPaneCartasJugador(Jugador jugador) {
		return (Node) getPaneJugador(jugador).lookup(String.format("#pane_cartas%s", jugador.getNumJugador()));
	}
	
	private Node getPaneActionJugador(Jugador jugador) {
		return getPaneJugador(jugador).lookup(String.format("#pane_j%s_action", jugador.getNumJugador()));
	}
	
	private Text getActionJugador(Jugador jugador) {
		return (Text) getPaneActionJugador(jugador).lookup(String.format("#action_j%s", jugador.getNumJugador()));
	}
	
	private Node getPiedrasDe(Equipo equipo, int valorPiedra) {
		return (Node) getPaneMarcador().lookup(String.format("#eq%s_piedrasDe%s", equipo.getNumEquipo(), valorPiedra));
	}
	
	private Node getPiedrasDeNPuntos(Equipo equipo, int valorPiedra, int puntos) {
		String id = ((valorPiedra == 1) && (puntos==5))
				? String.format("#eq%s_puntosDe%s_%s", equipo.getNumEquipo(), valorPiedra, puntos)
				: String.format("#eq%s_puntos%s", equipo.getNumEquipo(), puntos);
		return (Node) getPiedrasDe(equipo, valorPiedra).lookup(id);
	}
	
	private Circle getCirclePiedraDeNPuntos(Equipo equipo, int valorPiedra, int puntos) {
		String id = ((valorPiedra == 1) && (puntos==5))
				? String.format("#eq%s_puntosDe%s_%s_circle", equipo.getNumEquipo(), valorPiedra, puntos)
				: String.format("#eq%s_puntos%s_circle", equipo.getNumEquipo(), puntos);
		return (Circle) getPiedrasDeNPuntos(equipo, valorPiedra, puntos).lookup(id);
	}
	
	private Node getPaneCondicionada(Jugador jugador) {
		return (Node) getPaneJugador(jugador).lookup(String.format("#pane_j%s_condicional", jugador.getNumJugador()));
	}
	
	private Text getTextCondicionada(Jugador jugador) {
		return (Text) getPaneCondicionada(jugador).lookup(String.format("#info_j%s_condicional", jugador.getNumJugador()));
	}
	
	private Node getCommandSpace() {
		return (Node) root.lookup("#pane_comandos");
	}
	
	private Node getCommandSpaceBox() {
		return (Node) getCommandSpace().lookup("#vbox_comandos");
	}
	
	private Text getTextCommandMsg() {
		return (Text) getCommandSpace().lookup("#msg_comando");
	}
	
	private Node getManoJugador(Jugador jugador) {
		return (Node) getPaneJugador(jugador).lookup(String.format("#mano_j%s", jugador.getNumJugador()));
	}
	
	private Node getPaneGanador() {
		return (Node) root.lookup("#panel_ganador");
	}
	
	private Label getTextGanador() {
		return (Label) getPaneGanador().lookup("#ganador_text");
	}
}
