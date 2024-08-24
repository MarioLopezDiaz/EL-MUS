package mus.logic.gameobjects;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import mus.control.commands.Command;
import javafx.scene.image.Image;
import mus.logic.RondaDeJuego;
import mus.logic.RondaMus;

public class Bot extends Jugador {
	private double exigencia_cortar;
	private double exigencia_envidar;
	private double farolero;
	private double negrero;
	private double pGrande;
	private double pChica;
	private double pPares;
	private double pJuego;
	private double pPunto;
	private PuntuadorMano pm;
	
	public Bot(Equipo equipo, String nombre, int num_jugador, Image image,
			double exigencia_cortar, double exigencia_envidar, double farolero, double negrero,
			double pGrande, double pChica, double pPares, double pJuego, double pPunto) {
		super(equipo, nombre, num_jugador, image);
		this.exigencia_cortar = exigencia_cortar;
		this.exigencia_envidar = exigencia_envidar;
		this.farolero = farolero;
		this.negrero = negrero;
		this.pGrande = pGrande;
		this.pChica = pChica;
		this.pPares = pPares;
		this.pJuego = pJuego;
		this.pPunto = pPunto;
	}
	
	@Override
	public void quiereMus(RondaMus ronda, String msg, List<Command> comandosPosibles){
		pm = new PuntuadorMano(mano);
		double puntuacion = calcularPuntuacionMano();
		
		if ( (manoParaCortar(puntuacion) || voyDeFarol()) && (!meDoyMusNegro()))
			game.cortar(ronda, this);
		else
			game.mus(ronda, this);
	}
	
	@Override
	public void tirarCartas(RondaMus ronda, String msg, List<Command> comandosPosibles){
		ArrayList<Carta> cartas = new ArrayList<>();
		int contadorCartas = 0;
		if(pm.cercaDeUna()) {
			if(pm.getTipoPares() == 1) {
				if(pm.getSuma() == 28 ) {
					cartas.add(mano.getCarta(2));
					cartas.add(mano.getCarta(3));
					contadorCartas = 2;
				}
				
				else if(pm.getSuma() == 25 || pm.getSuma() == 26 || pm.getSuma() == 27 || pm.getSuma() == 29) {
					cartas.add(mano.getCarta(2));
					contadorCartas = 1;
				}
				
				else if(pm.getSuma() == 30) {
					if(mano.getCarta(2).getValor() == 5) {
						cartas.add(mano.getCarta(2));
						cartas.add(mano.getCarta(3));
						contadorCartas = 2;
					}
					else {
						cartas.add(mano.getCarta(2));
						contadorCartas = 1;
					}
				}
			}
		}
		else if(pm.cercaDeDuplex()) {
			if(pm.getTipoPares() == 2) {
				for (Carta c : mano.getCartas()) {
					if (c.getEscalaValor() != pm.getNumPares()[0]) {
						cartas.add(c);
						contadorCartas++;
					}
				}
			}
			else {
				if(pm.getNumPares()[0] >= 6) {
					for (Carta c : mano.getCartas()) {
						if (c.getValor() < 10) {
							cartas.add(c);
							contadorCartas++;
						}
					}
					if(contadorCartas == 0) {
						cartas.add(mano.getCarta(3));
						contadorCartas++;
					}
				}
				else {
					for (Carta c : mano.getCartas()) {
						if (c.getEscalaValor() != pm.getNumPares()[0]) {
							cartas.add(c);
							contadorCartas++;
						}
					}
					if(contadorCartas == 0) {
						cartas.add(mano.getCarta(0));
						contadorCartas++;
					}
				}
			}
		}
		else {
			for (Carta c : mano.getCartas()) {
				if (c.getEscalaValor() != 8) {
					cartas.add(c);
					contadorCartas++;
				}
			}
		}
		game.darseMus(ronda, this, contadorCartas, cartas);
	}
	
	
	@Override
	public void enviteInicial(RondaDeJuego ronda, String msg, List<Command> comandosPosibles){
		pm = new PuntuadorMano(mano);
		if (ronda.getNombre().equals("GRANDE"))
			if(puedoEnvidar(puntosGrande()) || voyDeFarol())	game.envidar(ronda, this, 2);
			else												game.pasar(ronda, this);
		
		else if (ronda.getNombre().equals("CHICA"))
			if(puedoEnvidar(puntosChica()) || voyDeFarol())		game.envidar(ronda, this, 2);
			else												game.pasar(ronda, this);
		
		else if (ronda.getNombre().equals("PARES"))
			if(puedoEnvidar(puntosPares()) || voyDeFarol())		game.envidar(ronda, this, 2);
			else												game.pasar(ronda, this);
		
		else if (ronda.getNombre().equals("JUEGO"))
			if(puedoEnvidar(puntosJuego()) || voyDeFarol())		game.envidar(ronda, this, 2);
			else												game.pasar(ronda, this);
		
		
		else if (ronda.getNombre().equals("PUNTO"))
			if(puedoEnvidar(puntosPunto()) || voyDeFarol())		game.envidar(ronda, this, 2);
			else												game.pasar(ronda, this);
		
		
	}
	
	@Override
	public void respuestaEnvite(RondaDeJuego ronda, String msg, List<Command> comandosPosibles){
		pm = new PuntuadorMano(mano);
		if (ronda.getNombre().equals("GRANDE"))
			if(puedoEnvidar(puntosGrande()) || voyDeFarol()) {
				game.ver(ronda, this);
			}
			else
				game.pasar(ronda, this);
		
		else if (ronda.getNombre().equals("CHICA"))
			if(puedoEnvidar(puntosChica()) || voyDeFarol()) {
				game.ver(ronda, this);
			}
			else
				game.pasar(ronda, this);
		
		else if (ronda.getNombre().equals("PARES"))
			if(puedoEnvidar(puntosPares()) || voyDeFarol()) {
				game.ver(ronda, this);
			}
			else
				game.pasar(ronda, this);
		
		else if (ronda.getNombre().equals("JUEGO"))
			if(puedoEnvidar(puntosJuego()) || voyDeFarol()) {
				game.ver(ronda, this);
			}
			else
				game.pasar(ronda, this);
		
		
		else if (ronda.getNombre().equals("PUNTO"))
			if(puedoEnvidar(puntosPunto()) || voyDeFarol()) {
				game.ver(ronda, this);
			}
			else
				game.pasar(ronda, this);
	}
	
	private double calcularPuntuacionMano() {
		if (tieneJuego())			return pGrande * puntosGrande() + pChica * puntosChica() + pPares * puntosPares() + (pJuego + pPunto) * puntosJuego();
		else						return pGrande * puntosGrande() + pChica * puntosChica() + pPares * puntosPares() + pJuego * puntosJuego() + pPunto * puntosPunto();
	}
	
	private boolean voyDeFarol() {
		return getRandom() < farolero;
	}
	
	private boolean meDoyMusNegro() {
		return getRandom() < negrero;
	}
	
	private boolean puedoEnvidar(int puntos) {
		return puntos > exigencia_envidar;
	}
	
	private int puntosGrande() {
		return pm.puntuarGrande()/493;
	}
	
	private int puntosChica() {
		return pm.puntuarChica()/493;
	}
	
	private int puntosPares() {
		return pm.puntuarPares()/52;
	}
	
	private int puntosJuego() {
		return pm.puntuarJuego()/11;
	}
	
	private int puntosPunto() {
		return pm.puntuarPunto()/30;
	}
	
	private boolean manoParaCortar(double puntuacionMano) {
		return (puntuacionMano > exigencia_cortar) || pm.tieneLaUna() || pm.tieneBuenosPares();
	}
	
	private double getRandom() {
		return new Random(System.currentTimeMillis()).nextDouble();
	}
}
