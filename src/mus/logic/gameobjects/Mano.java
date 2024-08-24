package mus.logic.gameobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import mus.exceptions.gameObjectsExceptions.AddCartaManoException;
import mus.exceptions.gameObjectsExceptions.ManoException;
import mus.exceptions.gameObjectsExceptions.ManoVaciaException;
import mus.exceptions.gameObjectsExceptions.NoTienesCartaException;
import mus.exceptions.gameObjectsExceptions.RemoveCartaManoException;
import mus.view.Messages;

public class Mano {
	public static final int MAX_CARTAS_MANO = 4;
	private ArrayList<Carta> mano;
	private int suma;
	private int tipoPares;	//0 (todo son cartas distintas) - 1 (pareja) - 2 (medias) - 3 (duplex)
	private int[] numPares; //el numero de la pareja, medias o duplex.
	
	
	//  CONSTRUCTORES
	public Mano() {
		mano = new ArrayList<Carta>(4);
		suma = 0;
		tipoPares = 0;
		numPares = new int[2];
		Arrays.fill(numPares, 0);
	}
	
	public Mano(Mano mano){
		this();
		try {
			for(Carta c : mano.mano)
				this.add(c);
		}catch(ManoException acme) {System.out.println("Error en el contructor de copia de Mano al copiar." + acme);} //Esto no debería suceder nunca
	}
	
	
	//MÉTODOS PÚBLICOS
		//OBSERVADORES
	public ArrayList<Carta> getCartas(){
		return mano;
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
	
	public int getNumCartas() {
		return mano.size();
	}
	
	public Carta getCarta(int pos){
		return mano.get(pos);
	}
	
	public boolean tienePares() {
		return tipoPares > 0;
	}
	
	public boolean tieneJuego() {
		return suma >= 31;
	}
	
	
		//MUTADORES
	public void add(Carta carta) throws AddCartaManoException {
		if(!manoLlena()) {
			actualizarSuma(carta);
			actualizarPares(carta);
			mano.add(carta);
			if(mano.size() == MAX_CARTAS_MANO)
				ordenarMano();
		}
		else throw new AddCartaManoException(String.format(Messages.MANO_LLENA, this));
	}
	
	public void remove(Carta carta) throws RemoveCartaManoException{
		if(tieneCartas()) {
			for (Carta c : mano) {
				if(c.equals(carta)) {
					mano.remove(c);
					restarSuma(carta);
					actualizarParesTirarCarta(carta);
					return;
				}
			}
			throw new NoTienesCartaException(String.format(Messages.NO_TIENES_CARTA, this, carta));
		}
		else throw new ManoVaciaException(Messages.MANO_VACIA);
	}
	
		//MOSTRAR POR PANTALLA
	public String toString() {
		StringBuilder m = new StringBuilder();
		for (Carta c : mano)
			m.append(c).append("-");
		if (m.length() > 0)
			m.deleteCharAt(m.length() - 1);
		return m.toString();
	}

	
	//MÉTODOS AUXILIARES PRIVADOS
	private void actualizarParesTirarCarta(Carta carta) {
		for(int val : numPares) {
			if(carta.getEscalaValor() == val) {
				tipoPares--;
				if(tipoPares == 0)		val = 0;
				break;
			}
		}
	}
	
	private void actualizarPares(Carta carta) {
		for(Carta c : mano) {
		    if (carta.equalsEscalaValor(c)) {
		    	if(tipoPares == 0) {
					tipoPares = 1;
					numPares[0] = carta.getEscalaValor();
				}
				else if(tipoPares == 1) {
					if(numPares[0] == carta.getEscalaValor())
						tipoPares = 2;
					else {
						tipoPares = 3;
						numPares[1] = carta.getEscalaValor();
						if(numPares[1] > numPares[0]) {
							int aux = numPares[0];
							numPares[0] = numPares[1];
							numPares[1] = aux;
						}
					}
				}
				else if(tipoPares == 2) {
					tipoPares = 3;
					numPares[1] = numPares[0];
				}
		        break;
		    }
		}
	}

	private void ordenarMano(){
        	Collections.sort(this.mano, new Comparator<Carta>() {
            		@Override
            		public int compare(Carta p1, Carta p2) {
                		return Integer.valueOf(p2.getEscalaValor()).compareTo(Integer.valueOf(p1.getEscalaValor()));
            		}
        	});
   	}
	
	private boolean tieneCartas() {
		return mano.size() > 0;
	}
	
	private boolean manoLlena() {
		return mano.size() == Mano.MAX_CARTAS_MANO;
	}

	private void actualizarSuma(Carta carta) {
		suma += carta.getValor();
	}
	
	private void restarSuma(Carta carta) {
		suma -= carta.getValor();
	}
}