module mus_elarmasecreta{
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires junit;
	
	opens mus.gui to javafx.graphics, javafx.fxml;
	opens mus.gui.controllers to javafx.fxml;
	
	exports mus.gui.controllers;
}
