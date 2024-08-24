package mus.logic;

import mus.logic.gameobjects.Mano;
import mus.logic.gameobjects.PuntuadorMano;

public class Chica extends RondaNoCondicionada{
	public Chica(GameRondas game){
		super(game, "CHICA");
	}
	
	public boolean greaterThan(Mano m1, Mano m2) {
		if(m2 == null)
			return true;
		return (new PuntuadorMano(m1)).puntuarChica() > (new PuntuadorMano(m2)).puntuarChica(); 
	}
	
	public Ronda getNextRonda() {
		return new Pares(game);
	}
}
