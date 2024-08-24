package mus.logic.gameobjects;

import java.util.ArrayList;

public class PuntuadorMano {
	public static final int MAX_CARTA = 9;
	ArrayList<Carta> cartas;
	private int suma;
	private int tipoPares;
	private int[] numPares;
	
	
	//CONSTRUCTOR
	public PuntuadorMano(Mano mano){
		cartas = mano.getCartas();
		suma = mano.getSuma();
		tipoPares = mano.getTipoPares();
		numPares = mano.getNumPares();
	}
	
	public int getSuma() {
		return suma;
	}
	
	public int getTipoPares() {
		return tipoPares;
	}
	
	public int[] getNumPares() {
		return numPares;
	}
	
	//MÉTODOS PÚBLICOS
	public int puntuarGrande() {
		int p1 = puntuarPrimerDigito(cartas.get(0).getEscalaValor());
		int p2 = puntuarSegundoDigito(cartas.get(1).getEscalaValor());
		int p3 = puntuarTercerDigito(cartas.get(2).getEscalaValor());
		int p4 = cartas.get(3).getEscalaValor() - 1;
		return p1 + p2 + p3 + p4;
	}
	
	public int puntuarChica() {		
		int p1 = puntuarPrimerDigito(MAX_CARTA - cartas.get(3).getEscalaValor());
		int p2 = puntuarSegundoDigito(MAX_CARTA - cartas.get(2).getEscalaValor());
		int p3 = puntuarTercerDigito(MAX_CARTA - cartas.get(1).getEscalaValor());
		int p4 = MAX_CARTA - cartas.get(0).getEscalaValor() - 1;
		return p1 + p2 + p3 + p4;
	}
	
	public int puntuarPares(){
		if(tipoPares == 1)		return numPares[0];
		if(tipoPares == 2)		return 8 + numPares[0];
		if(tipoPares == 3)		return 16 + puntuarTercerDigito(numPares[0]-1) + numPares[1];
		return 0;
	}
	
	public int puntuarJuego(){
		if (esLaReal()) return 11;
		else if(suma == 31)return 10;
		else if(suma == 32)return 9;
		else if(!tieneJuego()) return 0;
		return suma - 32;
	}
	
	public int puntuarPunto(){
		return suma <= 30 ? suma : 0;
	}
	
	public int puntosJuego() {
		if(suma == 31)							return 3;
		else if (suma >= 32 && suma <= 40)		return 2;
		else									return 0;
	}
	
	public int puntosPares() {
		return tipoPares;
	}
	
	public boolean tieneLaUna() {
		return suma == 31;
	}
	
	public boolean tieneBuenosPares() {
		return puntuarPares() >= 12; 
	}
	
	public boolean cercaDeUna() {
		return (suma >= 25 && cartas.get(0).getValor() == 10 && cartas.get(1).getValor() == 10);
	}
	
	public boolean cercaDeDuplex() {
		return (tipoPares == 2) || (tipoPares == 1 && (numPares[0] == 1 || numPares[0] == 8));
	}
	
	
	//MÉTODOS AUXILIARES PRIVADOS
	private boolean tieneJuego() {
		return suma >= 31;
	}
	
	private boolean esLaReal() {
		int sietes = 0;
		int sotas = 0;
		for (Carta c : cartas) {
			int num = c.getNumero();
			if(num == 7) sietes++;
			else if(num == 10) sotas++;
			else return false;
		}
		return sietes == 3 && sotas == 1;
	}
	
	private int puntuarPrimerDigito(int d) {
		int c1 = 1;
		int c2 = 0;
		int suma = 1;
		int x;
		for (int i = 2; i <= d; i++) {
			x = c1 + (c1 - c2) + i;
			suma += x;
			c2 = c1;
			c1 = x;
		}
		return suma;
	}
	
	private int puntuarSegundoDigito(int d) {
		int c1 = 1;
		int suma = 1;
		int x;
		for (int i = 2; i <= d; i++) {
			x = c1 + i;
			suma += x;
			c1 = x;
		}
		return suma;
	}
	
	private int puntuarTercerDigito(int d) {
		int suma = 0;
		for (int i = 0; i <= d; i++)
			suma += i;
		return suma;
	}
}