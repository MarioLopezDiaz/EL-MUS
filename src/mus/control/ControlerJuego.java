package mus.control;

import java.util.List;

import mus.control.commands.Command;
import mus.logic.Ronda;
import mus.logic.RondaCondicionada;
import mus.logic.gameActions.GameAction;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public interface ControlerJuego {	
	public void nuevaMano();
	
	public void pedirComando(Ronda ronda, Jugador jugador, String msg, List<Command> availableCommands);
	
	public void updateCartas();
	public void updateMarcador();
	public void mostrarCondicionada();
	public void borrarCondicionada();
	public void showGanador(Equipo ganador);
	public void updateRonda();
	public void executeAction(GameAction action);
	
	public void seJuegaPunto(RondaCondicionada ronda);
	public void noSeJuegaCondicionada(RondaCondicionada ronda);
	
	public void cambiarMano(int pos_mano);
}