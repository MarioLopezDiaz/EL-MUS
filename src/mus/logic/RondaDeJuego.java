package mus.logic;

import java.util.Arrays;
import java.util.List;

import mus.control.commands.Command;
import mus.control.commands.EnvidarCommand;
import mus.control.commands.OrdagoCommand;
import mus.control.commands.PasarCommand;
import mus.control.commands.SubirCommand;
import mus.control.commands.VerCommand;
import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;
import mus.logic.gameobjects.Mano;
import mus.view.Messages;

public abstract class RondaDeJuego extends Ronda{
	public static final List<Command> commandsEnviteInicial = Arrays.asList(new PasarCommand(), new EnvidarCommand(), new OrdagoCommand());
	public static final List<Command> commandsRespuestaEnvite = Arrays.asList(new PasarCommand(), new VerCommand(), new SubirCommand(), new OrdagoCommand());
	public static final List<Command> commandsRespuestaEnviteOrdago = Arrays.asList(new PasarCommand(), new VerCommand());

	protected Jugador jugadorApuesta;
	protected int apuestaAnterior;
	protected int apuestaActual;
	protected boolean hayEnvite;
	protected boolean robada;
	private boolean hayOrdago;
	
	public RondaDeJuego(GameRondas game, String nombre){
		super(game, nombre);
		jugadorApuesta = null;
		apuestaAnterior = 0;
		apuestaActual = 0;
		hayEnvite = false;
		robada = false;
		hayOrdago = false;
	}
	
	protected void jugarRonda(){
		enviteInicial(getJugadorAt(jug_actual));
	}
	
	public void pasar(Jugador jugador) {
		siguienteJugador();
	}
	
	public void envidar(Jugador jugador, int envite) {
		hayEnvite = true;
		robada = true;
		apuestaAnterior = 1;
		jugadorApuesta = jugador;
		apuestaActual = envite;
		respuestaEnvite();
		
	}
	
	public void subir(Jugador jugador, int subida) {
		robada = true;
		jugadorApuesta = jugador;
		apuestaAnterior = apuestaActual;
		apuestaActual += subida;
		respuestaEnvite();
		
	}
	
	public void ordago(Jugador jugador) {
		hayOrdago = true;
		if(!hayEnvite)	envidar(jugador, 40);
		else			subir(jugador, 40);
	}
	
	public void ver(Jugador jugador){
		robada = false;
		apuestaAnterior = apuestaActual;
		if(!hayOrdago)	jugarSiguienteRonda(getNextRonda());
		else			game.gestionarOrdago(this);
	}
	
	protected void addPuntosJugados(){
		Mano mejor_mano = null;
		Equipo mejor_equipo = null;
		for (int i = 0; i < Game.NUM_JUGADORES; i++) {
			Jugador jugador = getJugadorAt(i);
			if(greaterThan(jugador.getMano(), mejor_mano)) {
				mejor_mano = jugador.getMano();
				mejor_equipo = jugador.getEquipo();
			}
		}
		addPuntosEnvite(mejor_equipo);
		addPuntosEnPaso(mejor_equipo);
	}

	protected void addPuntosRobados() {
		game.addPuntos(jugadorApuesta.getEquipo(), apuestaAnterior);
	}
	
	protected void addPuntosEnvite(Equipo equipo) {
		if(!robada && hayEnvite)	game.addPuntos(equipo, apuestaActual);
	}
	
	protected abstract void addPuntosEnPaso(Equipo equipo);
	
	protected abstract boolean tieneRonda(Jugador jugador);
	
	protected abstract boolean greaterThan(Mano m1, Mano m2);
	
	
	private void enviteInicial(Jugador jugador) {
		if(tieneRonda(jugador))			game.enviteInicial(this, jugador, Messages.ENVITE_INICIAL, RondaDeJuego.commandsEnviteInicial);
		else							siguienteJugador();
	}
	
	private void respuestaEnvite(Jugador jugador) {
		if(tieneRonda(jugador) && !sonPareja(jugador, jugadorApuesta)) {
			if(!hayOrdago)	game.respuestaEnvite(this, jugador, Messages.RESPUESTA_ENVITE, RondaDeJuego.commandsRespuestaEnvite);
			else			game.respuestaEnvite(this, jugador, Messages.RESPUESTA_ENVITE_ORDAGO, RondaDeJuego.commandsRespuestaEnviteOrdago);
		}
		else				siguienteJugador();
	}
	
	private void siguienteJugador() {
		if(!dioVuelta()) {
			if(!hayEnvite)		enviteInicial(getJugadorAt(jug_actual));
			else				respuestaEnvite(getJugadorAt(jug_actual));
		}
		else {
			if(hayEnvite)		addPuntosRobados();
			jugarSiguienteRonda(getNextRonda());
		}
	}
	
	private void respuestaEnvite() {
		resetJugActual();
		respuestaEnvite(getJugadorAt(jug_actual));
	}
}
