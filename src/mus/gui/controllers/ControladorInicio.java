package mus.gui.controllers;

import java.io.IOException;

import mus.control.Controller;
import mus.gui.Gui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class ControladorInicio {
	@FXML
	private Button btnJugar;
	@FXML
	private Button btnCrearOnLineMatch;
	@FXML
	private Button btnReglas;
	
	private Controller controller = Gui.controller;
	
    @FXML
    private void jugarButtonClicked() throws IOException {
    	controller.updateScene((new FXMLLoader(getClass().getResource("/mus/gui/escenas/equipos.fxml"))).load());
    }
    
    @FXML
    private void reglasButtonClicked() throws IOException{
    	controller.updateScene((new FXMLLoader(getClass().getResource("/mus/gui/escenas/creditos.fxml"))).load());
    }
}
