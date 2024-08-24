package mus.logic;

import mus.logic.gameobjects.Jugador;

public abstract class Ronda {
	protected GameRondas game;
	protected String nombre;
	protected int jug_actual;
	
	public Ronda(GameRondas game, String nombre){
		this.game = game;
		this.nombre = nombre;
		this.jug_actual = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	protected int getMano() {
		return game.getMano();
	}
	
	protected Jugador getJugadorAt(int pos) {
		return game.getJugadorAt(pos);
	}
	
	protected boolean sonPareja(Jugador j1, Jugador j2) {
		return game.sonPareja(j1, j2);
	}
	
	public void jugarSiguienteRonda(Ronda ronda) {
		game.borrarCondicionada();
		game.pasarARonda(ronda);
	}
	
	public boolean dioVuelta() {
		int jug_anterior = jug_actual;
		cambiarJugador();
		return (jug_actual == 0) && (jug_anterior == 3);
	}
	
	protected void cambiarJugador() {
		jug_actual = (jug_actual + 1) % Game.NUM_JUGADORES;
	}
	
	protected void resetJugActual() {
		jug_actual = 0;
	}
	
	public abstract void jugar();
	
	public abstract void sumarPuntos();
	
	protected abstract Ronda getNextRonda();
}