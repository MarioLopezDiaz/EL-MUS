package mus.view;

import mus.logic.gameobjects.Mano;
import mus.view.Messages;

public class Messages {
	//GUI
	public static final String GUI_MUS = "%s quieres darte mus?";
	//  PROMPTS	
	public static final String MUS = "%s quieres darte mus?";
	
	public static final String TIRAR_CARTAS = "%s, ¿que cartas quieres tirar?";
	
	public static final String ENVITE_INICIAL = "%s que quieres hacer?";
	
	public static final String RESPUESTA_ENVITE = "%s que quieres hacer?";
	
	public static final String RESPUESTA_ENVITE_ORDAGO = "%s que quieres hacer?(";
	
	// INFO PARTIDA
	public static final String EMPIEZA_RONDA = "\n###############    COMIENZA LA RONDA DE %s    ###############";
	
	public static final String HAY_MUS = "######   HAY MUS   ######";
	
	public static final String TIRA_ORDAGO = "%s se tira ordago en %s";
	
	public static final String TIENE_RONDA = "%s %s tiene %s";
	
	// EXCEPCIONES PARSEO COMANDOS
	public static final String COMANDO_DESCONOCIDO = "Comando desconocido. Introduce un comando válido";
	
	public static final String NO_PARAMS = "El comando %s no espera ningún parametro. ERROR: %s";
	
	public static final String MISSING_PARAM = "Se espera un parámetro.";
	
	public static final String JUST_ONE_PARAM = "El comando %s espera un solo parametro. ERROR: %s";
	
	public static final String EXPECTING_NUMBER = "El comando %s espera un valor numérico como parámetro. ERROR: %s";
	
	public static final String MAX_4_CARTAS = "Como máximo se pueden tirar 4 cartas. ERROR: %s";
	
	public static final String NEG_NUM_CARTAS = "No puedes tirar un numero de cartas negativo. ERROR: %s";
	
	public static final String NUMERO_CARTAS_INCORRECTO = "No has introducido el número de cartas que has dicho que querías tirar. Introduce %s cartas";
	
	public static final String WRONG_CARD = "Se ha introducido una carta equivocada.";
	
	
	//EXCEPCIONES
		//CARTA
	public static final String CARTA_INEXISTENTE = "No existe la carta %s de %s";
	
	public static final String PALO_INEXISTENTE = "No existe el palo %s";
	
	public static final String NUMERO_INEXISTENTE = "No existe una carta con el número %s";
	
		//MANO
	public static final String MANO_LLENA = "No se puede añadir una carta porque la mano (%s) ya tiene" + Mano.MAX_CARTAS_MANO + "cartas";
	
	public static final String MANO_VACIA = "No se puede eliminar la carta porque la mano está vacía";
	
	public static final String NO_TIENES_CARTA = "La mano %s no tienes la carta %s";
	
		//JUGADOR
	public static final String ERROR_RECIBIR_CARTA = "El jugador %s no puede recibir la carta %s";
	
	public static final String ERROR_TIRAR_CARTA = "El jugador %s no puede tirar la carta %s";
	
		//GAME
	public static final String ERROR_REPARTIR_CARTA = "Error repartiendo carta al jugador %s";
	
	public static final String ERROR_DARSE_MUS = "El jugador %s no ha podido darse Mus";
}
