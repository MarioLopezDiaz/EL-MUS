package mus.avatares;

import javafx.scene.image.Image;

public class Avatar {
    private String nombre;
    private Image image;
    
    public Avatar(String nombre) {
        this.nombre = nombre;
        this.image = new Image(getClass().getResourceAsStream(String.format("/mus/gui/resources/%s.jpg", nombre.toLowerCase())));
    }

    public String getNombre() {
        return nombre;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public boolean esBot() {
    	return false;
    }
}
