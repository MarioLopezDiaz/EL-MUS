package mus.gui;

import mus.control.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import mus.view.Drawer;

public class Gui extends Application {
	public static Drawer drawer;
	public static Controller controller;
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	controller = new Controller();
    	drawer = new Drawer(controller, primaryStage);
    	controller.setDrawer(drawer);
    	controller.run();
    }

    public static void main(String[] args) {
        launch(args);
    }
}