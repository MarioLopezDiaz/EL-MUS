package mus.gui.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import mus.control.Controller;
import mus.gui.Gui;

public class ControladorReglas {
	@FXML
	private Button btnAtras;
	
	private Controller controller = Gui.controller;
	
	
	
    @FXML
    private void atrasButtonClicked()throws IOException {
    	controller.updateScene((new FXMLLoader(getClass().getResource("/mus/gui/escenas/menu.fxml"))).load());
    }
}