package mus.logic;

import java.util.ArrayList;
import java.util.List;

import mus.control.ControlerJuego;
import mus.control.commands.Command;
import mus.exceptions.RepartirCartaException;
import mus.exceptions.gameObjectsExceptions.JugadorException;
import mus.logic.gameActions.*;
import mus.logic.gameobjects.*;
import mus.view.Messages;

public class Game implements GameControl, GameRondas, GameUser{
	public static final int NUM_VACAS_VICTORIA = 3;
	public static final int PUNTUACION_VICTORIA = 40;
	public static final int NUM_JUGADORES = 4;
	
	private ControlerJuego controller;
    private Equipo equipo1;
    private Equipo equipo2;
    private Baraja baraja;
    public int pos_mano;
    private ArrayList <Jugador> jugadores = new ArrayList<>();
    private ArrayList<Ronda> rondas = new ArrayList<>();
    private Ronda ronda_actual;
    
    
    //CONSTRUCTORES
    public Game() {
        baraja = new Baraja();
        pos_mano = 3;
        ronda_actual = new RondaMus((GameRondas) this);
    }
    
    public Game(ControlerJuego controller, Equipo e1, Equipo e2, Jugador j11, Jugador j12, Jugador j21, Jugador j22) {
    	this();
    	this.controller = controller;
    	initEquipos(e1, e2);
		initJugadores(j11, j12, j21, j22);
    }
    	
	
    //MÉTODOS DE LA INTERFAZ GameControl (tb son de la interfaz GameBot mus, cortar, darseMus, pasar, envidar, subir, ver, ordago
	public ArrayList<Equipo> getEquipos(){
    	ArrayList<Equipo> equipos = new ArrayList<>();
    	equipos.add(equipo1);
    	equipos.add(equipo2);
    	return equipos;
    }
    
    public ArrayList<Jugador> getJugadores(){
    	return jugadores;
    }
    
    public Ronda getRondaActual() {
		return ronda_actual;
	}
    
    public void jugarPartida() {
		repartir();
		jugarRondaActual();
	}
    
	public void mus(Ronda ronda, Jugador jugador) {
		executeAction(new MusAction(ronda, jugador));
	}
	
	public void cortar(Ronda ronda, Jugador jugador) {
		executeAction(new CortarAction(ronda, jugador));
	}
	
	public void darseMus(Ronda ronda, Jugador jugador, int numCartas, ArrayList<Carta> cartas){
		executeAction(new DarseMusAction(ronda, jugador, numCartas, cartas));
	}
	
	public void pasar(Ronda ronda, Jugador jugador) {
		executeAction(new PasarAction(ronda, jugador));
	}
	
	public void envidar(Ronda ronda, Jugador jugador, int envite) {
		executeAction(new EnvidarAction(ronda, jugador, envite));
	}
	
	public void subir(Ronda ronda, Jugador jugador, int subida) {
		executeAction(new SubirAction(ronda, jugador, subida));
	}
	
	public void ver(Ronda ronda, Jugador jugador) {
		executeAction(new VerAction(ronda, jugador));
	}
	
	public void ordago(Ronda ronda, Jugador jugador){
		executeAction(new OrdagoAction(ronda, jugador));
	}
	
	public void jugarPunto(RondaCondicionada ronda) {
		ronda.jugarPunto();
	}
	
	public void jugarSiguienteRonda(Ronda ronda) {
		ronda.jugarSiguienteRonda(ronda.getNextRonda());
	}
	
	
    // 	MÉTODOS DE LA INTERFAZ GameRondas	   
    public int getMano() {
    	return pos_mano;
    }
    
    public Jugador getJugadorAt(int pos){
    	return jugadores.get((pos + pos_mano) % NUM_JUGADORES);
    }
    
    public boolean sonPareja(Jugador j1, Jugador j2) {
		return j1.esParejaDe(j2);
	}
    
    public int getNumCartas(Jugador jugador) {
    	return jugador.getNumCartas();
    }
    
    public boolean tienePares(Jugador jugador) {
		return jugador.tienePares();
	}
	
	public boolean tieneJuego(Jugador jugador) {
		return jugador.tieneJuego();
	}
	
	public void mostrarCondicionada() {
		controller.mostrarCondicionada();
	}
	
	public void borrarCondicionada() {
		controller.borrarCondicionada();
	}
	
	public void addPuntos(Equipo equipo, int puntos) {
		equipo.addPuntos(puntos);
	}
	
	public void quiereMus(RondaMus ronda, Jugador jugador, String msg, List<Command> comandosPosibles){
		jugador.quiereMus(ronda, msg, comandosPosibles);
	}
	
	public void tirarCartas(RondaMus ronda, Jugador jugador, String msg, List<Command> comandosPosibles){
		jugador.tirarCartas(ronda, msg, comandosPosibles);
	}
	
	public void enviteInicial(RondaDeJuego ronda, Jugador jugador, String msg, List<Command> comandosPosibles) {
		jugador.enviteInicial(ronda, msg, comandosPosibles);
	}
	
	public void respuestaEnvite(RondaDeJuego ronda, Jugador jugador, String msg, List<Command> comandosPosibles){
		jugador.respuestaEnvite(ronda, msg, comandosPosibles);
	}
	
	public void repartirCarta(Jugador jugador) throws RepartirCartaException {
    	try{
    		jugador.recibirCarta(baraja.repartirCarta());
    	}catch(JugadorException je) {
    		throw new RepartirCartaException(String.format(Messages.ERROR_REPARTIR_CARTA, jugador), je);
    	}
    }
	
	public void updateCartas() {
    	controller.updateCartas();
    }
	
	public void pasarARonda(Ronda ronda) {
		if (ronda != null) {
			updateMarcador();
			if(hayGanador())
				gestionarGanadorVaca();
			else {
				rondas.add(ronda);
				ronda_actual = ronda;
				jugarRondaActual();
			}
		}
		else {
			boolean hayGanador = sumarPuntos();
			updateMarcador();
			if(hayGanador)			gestionarGanadorVaca();
			else					nuevaMano();
		}
	}
	
	public void gestionarOrdago(RondaDeJuego ronda) {
		ronda.sumarPuntos();
		gestionarGanadorVaca();
	}
	
	public void jugarPunto(Punto punto) {
		ronda_actual = punto;
		controller.updateRonda();
		ronda_actual.jugar();
	}
	
	public void seJuegaPunto(RondaCondicionada ronda) {
		controller.seJuegaPunto(ronda);
	}
	
	public void noSeJuegaCondicionada(RondaCondicionada ronda) {
		controller.noSeJuegaCondicionada(ronda);
	}
        
    
	//  MÉTODOS DE LA INTERFAZ GameUser   	
    public void anyadirMonton(Carta carta) {
    	baraja.anyadirMonton(carta);
    }
    
    public void pedirComando(Ronda ronda, Jugador jugador, String msg, List<Command> comandosPosibles){
    	controller.pedirComando(ronda, jugador, msg, comandosPosibles);
    }
    
    
    //	OTROS MÉTODOS PÚBLICOS
    public String toString() {
		StringBuilder game = new StringBuilder();
		game.append(equipo1).append("\n");
		game.append(equipo2).append("\n");
		game.append("                  ºº").append(getJugadorAt(0));
		game.append("                  \n\n\n").append(getJugadorAt(1));
		game.append("                  ").append(getJugadorAt(3)).append("\n\n\n");
		game.append("                  ").append(getJugadorAt(2)).append("\n\n\n");
				
		return game.toString();
	}
	
	
    //  MÉTODOS INICIALIZADORES AUXILIARES
    private void initBaraja() {
    	baraja = new Baraja();
    }
    
    private void initJugadores(Jugador j11, Jugador j12, Jugador j21, Jugador j22){
    	jugadores.add(j11);
        jugadores.add(j21);
        jugadores.add(j12);
        jugadores.add(j22);
        for (Jugador j : jugadores)
        	j.setGame((GameUser)this);
    }
    
    private void initEquipos(Equipo e1, Equipo e2) {
		this.equipo1 = e1;
		this.equipo2 = e2;
    }
    
    
	//  MÉTODOS AUXILIARES PRIVADOS
	private boolean hayGanador(){
        return equipo1.getPuntuacion() > PUNTUACION_VICTORIA || equipo2.getPuntuacion() > PUNTUACION_VICTORIA;
    }
	
	private void jugarRondaActual() {
		controller.updateRonda();
		ronda_actual.jugar();
	}
	
	private void repartir(){
    	tirarseCartas();
    	cambiarMano();
    	initBaraja();
    	baraja.barajar();
    	try {
    		for (int i = 0; i < Mano.MAX_CARTAS_MANO; i++) {
        		for (int j = 0; j < Game.NUM_JUGADORES; j++)
        			repartirCarta(getJugadorAt(j));
        	}
    		updateCartas();
    	}catch(RepartirCartaException rce) {System.out.println(rce);}	//Esto no debería pasar nunca
    }
		
	private void cambiarMano() {
		pos_mano = (pos_mano + 1) % NUM_JUGADORES;
		controller.cambiarMano(pos_mano);
	}
    
    private void tirarseCartas(){
		for (int j = 0; j < Game.NUM_JUGADORES; j++)
			tirarseTodas(getJugadorAt(j));
    }
    
    private void tirarseTodas(Jugador jugador) {
    	jugador.tirarseTodas();
    }
    
    private  boolean sumarPuntos() {
		for (Ronda ronda : rondas) {
        	ronda.sumarPuntos();
        	if (hayGanador())		return true;
		}
		return false;
	}

	private void updateMarcador() {
		controller.updateMarcador();
	}
	
	private void gestionarGanadorVaca() {
		Equipo ganador = null;
		for (Equipo e : getEquipos()) {
			if (e.getPuntuacion() >= PUNTUACION_VICTORIA) {
				ganador = e;
				break;
			}
		}
		updateMarcador();
		ganador.addVaca();
		if (ganador.getVacas() == NUM_VACAS_VICTORIA)
			controller.showGanador(ganador);
		else {
			for (Equipo e : getEquipos())
				e.resetPuntos();
			nuevaMano();
		}
	}
	
	private void nuevaMano() {
		rondas = new ArrayList<>();
		ronda_actual = new RondaMus((GameRondas)this);
		controller.nuevaMano();
	}
	
	private void executeAction(GameAction action) {
		controller.executeAction(action);
	}
}