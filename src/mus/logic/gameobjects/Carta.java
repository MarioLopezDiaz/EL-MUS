package mus.logic.gameobjects;

import mus.exceptions.gameObjectsExceptions.CreacionCartaException;
import mus.exceptions.gameObjectsExceptions.NoExisteNumeroException;
import mus.exceptions.gameObjectsExceptions.NoExistePaloException;
import mus.view.Messages;

public class Carta {
	private enum Palo {OROS, COPAS, ESPADAS, BASTOS};
	
	private Palo palo;			//Palo de la carta
	private int numero;			//Número de la carta
	private int valor;			//Valor de la carta. Es igual al número menos en los siguientes casos: (num 2 = 3);(num 3 = 10);(figuras=10)
	private int escalaValor;	//(1 y 2 -> 1); (4 -> 2); (5 -> 3); (6 -> 4); (7 -> 5); (10 -> 6); (11 -> 7); (12 y 3 -> 8) 
	
	
	//	CONSTRUCTORES
	public Carta(Palo palo, int numero) throws CreacionCartaException {
		inicializarCarta(palo, numero);
	}
	
	public Carta(String palo, int numero) throws CreacionCartaException{
		try {
			inicializarCarta(Carta.toPalo(palo), numero);
		}catch(NoExistePaloException nepe) {
			throw new CreacionCartaException(String.format(Messages.CARTA_INEXISTENTE, numero, palo), nepe);
		}
	}
	
	public Carta(String palo, String numero) throws CreacionCartaException{
		try{
			inicializarCarta(Carta.toPalo(palo), Integer.parseInt(numero));
		}catch(NoExistePaloException nepe) {
			throw new CreacionCartaException(String.format(Messages.CARTA_INEXISTENTE, numero, palo), nepe);
		}catch(NumberFormatException nfe) {
			throw new CreacionCartaException(String.format(Messages.CARTA_INEXISTENTE, numero, palo), nfe);
		}
	}
	
		//MÉTODO AUXILIAR PARA CONSTRUCTORES
	private void inicializarCarta(Palo palo, int numero)  throws CreacionCartaException {
		try {
			this.palo = palo;
			this.numero = numero;
			valor = valorDe(numero);
			escalaValor = escalaValorDe(numero);
		}catch(NoExisteNumeroException nene) {
			throw new CreacionCartaException(String.format(Messages.CARTA_INEXISTENTE, numero, palo.name()), nene);
		}
	}
	
	
	//	MÉTODOS PÚBLICOS
	public int getNumero() {
		return numero;
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getEscalaValor() {
		return escalaValor;
	}
	
	public String toString() {
		return Integer.toString(numero) + String.valueOf(palo.name().charAt(0));
	}
	
	public boolean equals(Carta c) {
		return numero == c.numero && palo.equals(c.palo);
	}
	
	public boolean equalsEscalaValor(Carta c) {
		return escalaValor == c.escalaValor;
	}

	
	
	//  MÉTODOS AUXILIARES PRIVADOS Y ESTÁTICOS
	private static Palo toPalo(String palo) throws NoExistePaloException{
		if(palo.toUpperCase().equals("O") || palo.toUpperCase().equals("OROS"))		return Palo.OROS;
		if(palo.toUpperCase().equals("C") || palo.toUpperCase().equals("COPAS"))		return Palo.COPAS;
		if(palo.toUpperCase().equals("E") || palo.toUpperCase().equals("ESPADAS"))	return Palo.ESPADAS;
		if(palo.toUpperCase().equals("B") || palo.toUpperCase().equals("BASTOS"))		return Palo.BASTOS;
		
		throw new NoExistePaloException(String.format(Messages.PALO_INEXISTENTE, palo));
	}
	
	private static int valorDe(int numero) throws NoExisteNumeroException {
		if(numero == 2)	return 1;
		else if(numero == 11 || numero == 12 || numero == 3)	return 10;
		else if(numero == 8 || numero == 9 || numero < 1 || numero > 12) throw new NoExisteNumeroException(String.format(Messages.NUMERO_INEXISTENTE, numero));
		return numero;
	}
	
	private static int escalaValorDe(int numero) {
		if (numero == 1 || numero == 2)	return 1;
		else if(numero == 3) return 8;
		else if(numero >= 4 && numero <= 7) return numero - 2;
		return numero - 4;
	}
}