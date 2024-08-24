package mus.avatares;

public class AvatarBot extends Avatar{
	private double exigencia_cortar;
	private double exigencia_envidar;
	private double farolero;
	private double negrero;
	private double pGrande;
	private double pChica;
	private double pPares;
	private double pJuego;
	private double pPunto;
	
	public AvatarBot(String nombre, double exigencia_cortar, double exigencia_envidar,
			double farolero, double negrero, double pGrande, double pChica, double pPares,
			double pJuego, double pPunto) {
		super(nombre);
		this.exigencia_cortar = exigencia_cortar;
		this.exigencia_envidar = exigencia_envidar;
		this.farolero = farolero;
		this.negrero = negrero;
		this.pGrande = pGrande;
		this.pChica = pChica;
		this.pPares = pPares;
		this.pJuego = pJuego;
		this.pPunto = pPunto;
	}
	
	@Override
	public boolean esBot() {
    	return true;
    }
	
	public double getExigenciaCorte() {
		return exigencia_cortar;
	}
	
	public double getExigenciaEnvidar() {
		return exigencia_envidar;
	}
	
	public double getFarolero() {
		return farolero;
	}
	
	public double getNegrero() {
		return negrero;
	}
	
	public double getPGrande() {
		return pGrande;
	}
	
	public double getPChica() {
		return pChica;
	}
	
	public double getPPares() {
		return pPares;
	}
	
	public double getPJuego() {
		return pJuego;
	}
	
	public double getPPunto() {
		return pPunto;
	}
}
