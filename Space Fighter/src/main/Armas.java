package main;

public abstract class Armas {
	private long tiempoanterior;
	private float tiempoderecarga;
	public abstract void disparar();
	public boolean recargado(){
		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;
		tiempoanterior = tiempoactual;
		
		float tiempo = tiempoTranscurrido/1000f;
		return tiempo > tiempoderecarga;
	}
	public float getTiempoderecarga() {
		return tiempoderecarga;
	}
	public void setTiempoderecarga(float tiempoderecarga) {
		this.tiempoderecarga = tiempoderecarga;
	}
	
	
	
}
