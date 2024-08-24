package mus.logic.gameobjects;

import java.util.List;

import mus.exceptions.gameObjectsExceptions.CreacionCartaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Baraja {
	private List<Carta> baraja;
	private List<Carta> monton;
	
	public Baraja() {
		try {
			baraja = new ArrayList<>();
			monton = new ArrayList<>();
			List<String> palos = Arrays.asList("OROS", "COPAS", "ESPADAS", "BASTOS");
			for (String palo : palos) {
				for(int j = 1; j <= 12; j++) {
					if(j != 8 && j != 9) {
						Carta carta = new Carta(palo, j);
						baraja.add(carta);
					}
				}
			}
		}catch(CreacionCartaException cce) {System.out.println("Error iniciando la baraja" + cce);}	//Esto no debería suceder nunca
	}
    
	
	// METODOS PÚBLICOS
	public void barajar() {
		Collections.shuffle(baraja);
	}
	
	public void anyadirMonton(Carta carta) {
		monton.add(carta);
	}

	public Carta repartirCarta() {
		if (hayCartas()) {
		    Carta carta = primeraCarta();
		    eliminarCarta();
		    return carta;
		}
		else {
			baraja = monton;
			monton = new ArrayList<Carta>();
			barajar();
			return repartirCarta();
		}
	}
	
	public String toString() {
		StringBuilder bar = new StringBuilder();
		bar.append("MONTON: ");
		for(Carta c : monton)
			bar.append(c).append("-");
		
		bar.append("\nBARAJA: ");
		for(Carta c : baraja)
			bar.append(c).append("-");
		
		return bar.toString() + "\n";
	}
	
	
	// METODOS AUXILIARES PRIVADOS
	public boolean hayCartas() {
		return baraja.size() > 0;
	}
	
    public Carta primeraCarta() {
	    return baraja.get(0);
	}
	
	private void eliminarCarta() {
	    baraja.remove(0);
	}
}