package mus.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mus.control.commands.Command;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import mus.logic.Game;
import mus.logic.GameControl;
import mus.logic.Ronda;
import mus.logic.RondaCondicionada;
import mus.logic.gameActions.GameAction;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;
import mus.view.Drawer;

public class Controller implements ControlerJuego, ControllerInterfaz{
	private GameControl game;
	private Drawer drawer;

	public Controller() {}
	
	//Métodos de la interfaz ControllerGame
	public void nuevaMano() {
		drawer.nuevaMano();
	}
	
	public void pedirComando(Ronda ronda, Jugador jugador, String msg, List<Command> availableCommands) {
		drawer.pedirComando(game, ronda, jugador, msg, availableCommands);
	}
	
	public void updateCartas() {
		drawer.updateCartas();
	}
	
	public void updateMarcador() {
		drawer.updateMarcador();
	}
	
	public void mostrarCondicionada() {
		drawer.mostrarCondicionada();
	}
	
	public void borrarCondicionada() {
		drawer.borrarCondicionada();
	}
	
	public void showGanador(Equipo ganador) {
		drawer.showGanador(ganador);
	}
	
	public void updateRonda() {
		drawer.updateRonda();
	}
	
	public void executeAction(GameAction action) {
		drawer.executeAction(action);
	}
	
	public void seJuegaPunto(RondaCondicionada ronda) {
		drawer.seJuegaPunto(ronda);
	}
	public void noSeJuegaCondicionada(RondaCondicionada ronda) {
		drawer.noSeJuegaCondicionada(ronda);
	}
	
	public void cambiarMano(int pos_mano) {
		drawer.cambiarMano(pos_mano);
	}
	
	
	//Métodos de la interfaz ControllerInterfaz
	public ArrayList<Jugador> getJugadores() {
		return game.getJugadores();
	}
	
	public ArrayList<Equipo> getEquipos() {
		return game.getEquipos();
	}
	
	public Ronda getRondaActual() {
		return game.getRondaActual();
	}
	
	@FXML
	public void nuevaPartida(){
		try{
			updateScene((new FXMLLoader(getClass().getResource("/mus/gui/escenas/menu.fxml"))).load());
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void jugarPartida() {
		game.jugarPartida();
	}
	
	public void jugarPunto(RondaCondicionada ronda) {
		game.jugarPunto(ronda);
	}
	
	public void jugarSiguienteRonda(Ronda ronda) {
		game.jugarSiguienteRonda(ronda);
	}

	
	//Métodos para GUI
	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}
	
	public void run()  throws IOException {
		showMenu();
	}
	
	//Métodos para los controladores del menu
	public void updateScene(Parent root) {
		drawer.updateScene(root);
	}
	
	public void initGame(Equipo e1, Equipo e2, Jugador j11, Jugador j12, Jugador j21, Jugador j22) throws IOException{
		game = new Game(this, e1, e2, j11, j12, j21, j22);
		updateScene((new FXMLLoader(getClass().getResource("/mus/gui/escenas/mesa.fxml"))).load());
		updateNombres();
	}
	
	public void add(HBox hboxCheckBoxes) {
		drawer.add(hboxCheckBoxes);
	}
	
	//Métodos auxiliares privados
	private void showMenu() throws IOException  {
		updateScene(new FXMLLoader(getClass().getResource("/mus/gui/escenas/menu.fxml")).load());
	}

	private void updateNombres() {
		drawer.updateNombres();
	}
}