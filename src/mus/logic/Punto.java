package mus.logic;

import mus.logic.gameobjects.Equipo;
import mus.logic.gameobjects.Mano;
import mus.logic.gameobjects.PuntuadorMano;

public class Punto extends RondaNoCondicionada{
	public static final int MIEDO = 1;
	public Punto(GameRondas game){
		super(game, "PUNTO");
	}
	
	public boolean greaterThan(Mano m1, Mano m2) {
		if(m2 == null)
			return true;
		return new PuntuadorMano(m1).puntuarPunto() > new PuntuadorMano(m2).puntuarPunto();
	}
	
	@Override
	protected void addPuntosRobados() {
		game.addPuntos(jugadorApuesta.getEquipo(), apuestaAnterior + Punto.MIEDO);
	}
	
	@Override
	protected void addPuntosEnvite(Equipo equipo) {
		if(!robada && hayEnvite)	game.addPuntos(equipo, apuestaActual + Punto.MIEDO);
	}
	
	public Ronda getNextRonda() {
		return null;
	}
}
