package mus.test;


import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class EscenaCortarTest {

    @FXML
    private Button btnAtras;

    @FXML
    private ImageView eq1_jug1_carta1, eq1_jug1_carta2, eq1_jug1_carta3, eq1_jug1_carta4,
            eq1_jug2_carta1, eq1_jug2_carta2, eq1_jug2_carta3, eq1_jug2_carta4,
            eq2_jug1_carta1, eq2_jug1_carta2, eq2_jug1_carta3, eq2_jug1_carta4,
            eq2_jug2_carta1, eq2_jug2_carta2, eq2_jug2_carta3, eq2_jug2_carta4;

    @FXML
    private Label label_eq1_jug1, label_eq1_jug2, label_eq2_jug1, label_eq2_jug2,
            puntuacion_eq1, puntuacion_eq2, label_mus;

    @FXML
    private Button btn_empezar, bt_mus, btn_cortar;

    @FXML
    private void initialize() {
    	
        // Inicializar la interfaz de usuario, si es necesario
    	
        label_eq1_jug1.setText("Jugador 1 Equipo 1");
        
        label_eq1_jug2.setText("Jugador 2 Equipo 1");
        
        label_eq2_jug1.setText("Jugador 1 Equipo 2");
        
        label_eq2_jug2.setText("Jugador 2 Equipo 2");
        
        puntuacion_eq1.setText("0");
        
        puntuacion_eq2.setText("0");
        
        label_mus.setText("");
    }
    
    public void actualizarCartas(Image carta1, Image carta2, Image carta3, Image carta4) {
    	
    	initialize();
    	
        eq1_jug1_carta1.setImage(carta1);
        
        eq1_jug1_carta2.setImage(carta2);
        
        eq1_jug1_carta3.setImage(carta3);
        
        eq1_jug1_carta4.setImage(carta4);
        
        // Actualizar otras cartas según sea necesario
        
    }

    public void actualizarPuntuacion(int puntuacionEquipo1, int puntuacionEquipo2) {
    	
    	initialize();
    	
        puntuacion_eq1.setText(String.valueOf(puntuacionEquipo1));
        
        puntuacion_eq2.setText(String.valueOf(puntuacionEquipo2));
        
    }

}
