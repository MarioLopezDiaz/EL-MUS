package mus.logic;

import mus.logic.gameobjects.Jugador;
import mus.logic.gameobjects.Mano;
import mus.logic.gameobjects.PuntuadorMano;

public class Pares extends RondaCondicionada {
	public Pares(GameRondas game){
		super(game, "PARES");
	}

	public boolean tieneRonda(Jugador jugador) {
		return game.tienePares(jugador);
	}
	
	public boolean greaterThan(Mano m1, Mano m2) {
		if(m2 == null)
			return true;
		return (new PuntuadorMano(m1)).puntuarPares() > (new PuntuadorMano(m2)).puntuarPares(); 
	}
	
	protected void sumarPunto() {}
	
	protected void jugarPunto() {
		jugarSiguienteRonda(getNextRonda());
	}
	
	public  int puntosMano(Jugador jugador) {
		return (new PuntuadorMano(jugador.getMano())).puntosPares();
	}
	
	public Ronda getNextRonda() {
		return new Juego(game);
	}
}
