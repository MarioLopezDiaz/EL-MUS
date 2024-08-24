package mus.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mus.control.commands.Command;
import mus.control.commands.CortarCommand;
import mus.control.commands.MusCommand;
import mus.control.commands.TirarCartasCommand;
import mus.exceptions.RepartirCartaException;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;
import mus.logic.gameobjects.Mano;
import mus.view.Messages;

public class RondaMus extends Ronda {
	public static final List<Command> quiereMus = Arrays.asList(new MusCommand(), new CortarCommand());
	public static final List<Command> tirarCartas = Arrays.asList(new TirarCartasCommand());
	
	public RondaMus(GameRondas game){
		super(game, "MUS");
	}
	
	//Métodos públicos
	public void jugar() {
		jug_actual = 0;
		quiereMus(getJugadorAt(jug_actual));
	}
	
	public void sumarPuntos() {}
	
	public Ronda getNextRonda() {
		return new Grande(game);
	}
	
	//Métodos que controlan los botones de los comandos
	public void mus(Jugador jugador) {
		if (!dioVuelta())	quiereMus(getJugadorAt(jug_actual));
		else {
			resetJugActual();
			darseMus(getJugadorAt(jug_actual));
		}
	}
	
	public void cortar(Jugador jugador) {
		jugarSiguienteRonda(getNextRonda());
	}
	
	public void darseMus(Jugador jugador, int numCartas, ArrayList<Carta> cartas) {
		jugador.darseMus(numCartas, cartas);
		if (!dioVuelta())
			darseMus(getJugadorAt(jug_actual));
		else {
			repartirTrasMus();
			jugarSiguienteRonda(new RondaMus(game));
		}
	}
	
	//Métodos auxiliares de los comandos
	private void quiereMus(Jugador jugador){
		game.quiereMus(this, jugador, Messages.MUS, RondaMus.quiereMus);
	}
	
	private void darseMus(Jugador jugador){
		game.tirarCartas(this, jugador, Messages.TIRAR_CARTAS, RondaMus.tirarCartas);
	}
	
	//	
	private void repartirTrasMus(){
		try {
			for(int i = 0; i < Game.NUM_JUGADORES; i++) {
				Jugador jug = getJugadorAt(i);
				int cartas_a_repartir = Mano.MAX_CARTAS_MANO - getNumCartas(jug);
	    		for (int j = 0; j < cartas_a_repartir; j++)
	    			repartirCarta(jug);
			}
			game.updateCartas();
		}catch(RepartirCartaException rce) {System.out.println(rce);}		//Esto no debería pasar nunca
	}
	
	private void repartirCarta(Jugador jugador) throws RepartirCartaException {
		game.repartirCarta(jugador);
	}
	
	private int getNumCartas(Jugador jugador) {
		return game.getNumCartas(jugador);
	}
}