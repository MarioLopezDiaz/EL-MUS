package mus.logic;

import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public abstract class RondaCondicionada extends RondaDeJuego {
	private boolean seJuega;
	private boolean seJuegaPunto;
	private boolean seSuman;
	private boolean equipo1;
	private boolean equipo2;
	
	public RondaCondicionada(GameRondas game, String nombre){
		super(game, nombre);
		seJuega = false;
		seSuman = false;
		seJuegaPunto = false;
		equipo1 = false;
		equipo2 = false;
	}
	
	public void jugar(){
		seJuega();
		if(seJuega) 				jugarRonda();
		else if(seJuegaPunto)		seJuegaPunto();
		else						noSeJuegaCondicionada();
	}
	
	public void sumarPuntos() {
		if(seJuega)				addPuntosJugados();		//Se suman los puntos cuando ambas parjeas podían jugar la ronda(envites y puntos de la ronda)
		else if (seSuman)		addPuntosNoJugados();	//Se suman los puntos cuando solo una pareja podía jugar la ronda(puntos en la mano en esa ronda)
		else if(seJuegaPunto)	sumarPunto();			//Se suman los puntos cuando ninguna pareja podía jugar la ronda(en pares nada y en juego se suma el punto)
	}
	
	public void seJuega(){
		for (int i = 0; i < Game.NUM_JUGADORES; i++) {
			Jugador jugador = getJugadorAt(i);
			boolean tieneRonda = tieneRonda(jugador);
			mostrarCondicionada();
			if(i % 2 == 0) equipo1 = tieneRonda | equipo1;
			else equipo2 = tieneRonda | equipo2;
		}
		seJuega = equipo1 && equipo2;
		seSuman = !seJuega && (equipo1 || equipo2);
		seJuegaPunto = !equipo1 && !equipo2;
	}
	
	private void addPuntosNoJugados() {
		Equipo mejor_equipo = null;
		for(int i = 0; i < Game.NUM_JUGADORES; i++) {
			Jugador jugador = getJugadorAt(i);
			if(tieneRonda(jugador)) {
				mejor_equipo = jugador.getEquipo();
				break;
			}
		}
		addPuntosEnPaso(mejor_equipo);
	}
	
	protected void addPuntosEnPaso(Equipo equipo) {
		int puntos = 0;
		for(int i = 0; i < Game.NUM_JUGADORES; i++) {
			Jugador jugador = getJugadorAt(i);
			if(jugador.esDe(equipo))
				puntos += puntosMano(jugador);
		}
		game.addPuntos(equipo, puntos);
	}
	
	private void mostrarCondicionada() {
		game.mostrarCondicionada();
	}
	
	private void seJuegaPunto() {
		game.seJuegaPunto(this);
	}
	
	private void noSeJuegaCondicionada() {
		game.noSeJuegaCondicionada(this);
	}
	
	protected abstract int puntosMano(Jugador jugador);
	
	protected abstract void jugarPunto();
	
	protected abstract void sumarPunto();
}