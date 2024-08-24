package mus.logic;

import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Jugador;

public abstract class RondaNoCondicionada extends RondaDeJuego{	
	public RondaNoCondicionada(GameRondas game, String nombre){
		super(game, nombre);
	}
	
	public void jugar(){
		jugarRonda();
	}
	
	public void sumarPuntos() {
		addPuntosJugados();
	}
	
	protected void addPuntosEnPaso(Equipo equipo) {
		if(!hayEnvite)
			game.addPuntos(equipo, 1);
	}
	
	protected boolean tieneRonda(Jugador jugador) {
		return true;
	}
}