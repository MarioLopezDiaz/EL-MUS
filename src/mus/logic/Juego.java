package mus.logic;

import mus.logic.gameobjects.Jugador;
import mus.logic.gameobjects.Mano;
import mus.logic.gameobjects.PuntuadorMano;

public class Juego extends RondaCondicionada {
	private Punto punto;
	
	public Juego(GameRondas game){
		super(game, "JUEGO");
		punto = new Punto(game);
	}
	
	public boolean tieneRonda(Jugador jugador) {
		return game.tieneJuego(jugador);
	}
	
	public boolean greaterThan(Mano m1, Mano m2) {
		if(m2 == null)
			return true;
		return (new PuntuadorMano(m1)).puntuarJuego() > (new PuntuadorMano(m2)).puntuarJuego();
	}
	
	protected void sumarPunto() {
		punto.sumarPuntos();
	}
	
	protected void jugarPunto(){
		game.jugarPunto(punto);
	}
	
	public  int puntosMano(Jugador jugador) {
		return (new PuntuadorMano(jugador.getMano())).puntosJuego();
	}
	
	public Ronda getNextRonda() {
		return null;
	}
}
