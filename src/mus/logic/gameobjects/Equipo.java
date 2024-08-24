package mus.logic.gameobjects;

public class Equipo {
	private int vacas;
	private int puntuacion;
	private String nombre;
	private int num_equipo;
	
	
	//  CONSTRUCTOR
	public Equipo(String nombre, int num_equipo) {
		this.vacas = 0;
		this.puntuacion = 0;
		this.nombre = nombre;
		this.num_equipo = num_equipo;
	}
	
	
	//  MÉTODOS PÚBLICOS
	public String getNombre() {
        return nombre;
    }
	
	public int getVacas() {
		return vacas;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public int getNumEquipo() {
		return num_equipo;
	}
    
	public void addVaca() {
		vacas += 1;
	}
	
	public void addPuntos(int puntos){
        puntuacion += puntos;
	}
	
	public void resetPuntos() {
		puntuacion = 0;
	}
    
	public String toString() {
		StringBuilder e = new StringBuilder();
		e.append(nombre).append(": " + puntuacion);
		return e.toString();
	}
}