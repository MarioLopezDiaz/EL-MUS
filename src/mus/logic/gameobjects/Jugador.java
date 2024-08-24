package mus.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import mus.control.commands.Command;
import mus.exceptions.gameObjectsExceptions.ManoException;
import mus.exceptions.gameObjectsExceptions.RecibirCartaException;
import mus.exceptions.gameObjectsExceptions.TirarCartaException;
import javafx.scene.image.Image;
import mus.logic.GameUser;
import mus.logic.RondaDeJuego;
import mus.logic.RondaMus;
import mus.view.Messages;

public class Jugador {
	protected GameUser game;
	protected Mano mano;
	private Equipo equipo;
	private String nombre;
	private int num_jugador;
	private Image image;
	
	//  CONSTRUCTOR
	public Jugador(Equipo equipo, String nombre, int num_jugador, Image image) {
		this.equipo = equipo;
		this.mano = new Mano();
		this.nombre = nombre;
		this.num_jugador = num_jugador;
		this.image = image;
	}
	
	public Jugador(GameUser game, Equipo equipo, String nombre, int num_jugador, Image image) {
		try {
			this.game = game;
			this.mano = new Mano();
			this.equipo = equipo;
			this.nombre = nombre;
			this.image = image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setGame(GameUser game) {
		this.game = game;
	}
		
	//MÉTODOS PÚBLICOS
	public Image getImage() {
		return image;
	}
	
	public int getNumJugador() {
		return num_jugador;
	}
	public String getNombre() {
		return nombre;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}
	
	public boolean esDe(Equipo equipo) {
		return this.equipo.equals(equipo);
	}
	
	public boolean esParejaDe(Jugador jugador) {
		return equipo.getNombre() == jugador.getEquipo().getNombre();
	}
	
	public Mano getMano() {
		return mano;
	}
	
	public Carta getCarta(int i) {
		return mano.getCarta(i);
	}
	
	public int getNumCartas() {
		return mano.getNumCartas();
	}
	
	public boolean darseMus(int numCartas, ArrayList<Carta> cartas){
		if(numCartas == 4)		tirarseTodas();
		else {
			Mano aux = new Mano(mano);
			try {
				for (Carta c : cartas)
					tirarCarta(c);
			} catch(TirarCartaException tce) {
				mano = aux;
			}
		}
		return true;
	}
	
	public void recibirCarta(Carta carta) throws RecibirCartaException {
		try{
			mano.add(carta);
		}catch(ManoException acme) {
			throw new RecibirCartaException(String.format(Messages.ERROR_RECIBIR_CARTA, nombre, carta), acme);
		}
	}
	
	public void tirarCarta(Carta carta) throws TirarCartaException{
		try{
			mano.remove(carta);
		}catch(ManoException e) {
			throw new TirarCartaException(String.format(Messages.ERROR_TIRAR_CARTA, nombre, carta), e);
		}
	}
	
	public void tirarseTodas() {
		for(int i = 0; i < mano.getNumCartas(); i++)
			game.anyadirMonton(mano.getCarta(i));
		mano = new Mano();
	}

	public boolean tienePares(){
		return mano.tienePares();
   	}
	
	public boolean tieneJuego(){
   		return mano.tieneJuego();
   	}
	
	public void quiereMus(RondaMus ronda, String msg, List<Command> comandosPosibles){
		game.pedirComando(ronda, this, msg, comandosPosibles);
	}
	
	public void tirarCartas(RondaMus ronda, String msg, List<Command> comandosPosibles){
		game.pedirComando(ronda, this, msg, comandosPosibles);
	}
	
	public void enviteInicial(RondaDeJuego ronda, String msg, List<Command> comandosPosibles) {
		game.pedirComando(ronda, this, msg, comandosPosibles);
	}
	
	public void respuestaEnvite(RondaDeJuego ronda, String msg, List<Command> comandosPosibles) {
		game.pedirComando(ronda, this, msg, comandosPosibles);
	}
	
	public String toString() {
		StringBuilder j = new StringBuilder();
		j.append(nombre).append("->").append(mano);
		return j.toString();
	}
}
