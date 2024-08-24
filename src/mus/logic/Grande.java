package mus.logic;

import mus.logic.gameobjects.Mano;
import mus.logic.gameobjects.PuntuadorMano;

public class Grande extends RondaNoCondicionada {
	public Grande(GameRondas game){
		super(game, "GRANDE");
	}
	
	public boolean greaterThan(Mano m1, Mano m2) {
		if(m2 == null)
			return true;
		return (new PuntuadorMano(m1)).puntuarGrande() > (new PuntuadorMano(m2)).puntuarGrande(); 
	}
	
	public Ronda getNextRonda() {
		return new Chica(game);
	}
}
