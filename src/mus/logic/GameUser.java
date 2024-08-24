package mus.logic;

import java.util.ArrayList;
import java.util.List;

import mus.control.commands.Command;
import mus.logic.gameobjects.Carta;
import mus.logic.gameobjects.Jugador;

public interface GameUser {
    public void anyadirMonton(Carta carta);
    public void pedirComando(Ronda ronda, Jugador jugador, String msg, List<Command> comandosPosibles);
    

    public void cortar(Ronda ronda, Jugador jugador);
    public void mus(Ronda ronda, Jugador jugador);
    public void darseMus(Ronda ronda, Jugador jugador, int numCartas, ArrayList<Carta> cartas);
    public void pasar(Ronda ronda, Jugador jugador);
	public void envidar(Ronda ronda, Jugador jugador, int envite);
	public void subir(Ronda ronda, Jugador jugador, int subida);
	public void ver(Ronda ronda, Jugador jugador);
	public void ordago(Ronda ronda, Jugador jugador);
}