package mus.logic.gameActions;

import java.util.ArrayList;

import mus.logic.Ronda;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;

public class DarseMusAction extends RondaMusAction{
	private int numCartas;
	private ArrayList<Carta> cartas;
	public DarseMusAction(Ronda ronda, Jugador jugador, int numCartas, ArrayList<Carta> cartas) {
		super(ronda, jugador);
		this.numCartas = numCartas;
		this.cartas = cartas;
	}
	
	public void execute() {
		ronda.darseMus(jugador, numCartas, cartas);
	}
	
	public String getMsg() {
		return "TIRO " + numCartas;
	}
}
