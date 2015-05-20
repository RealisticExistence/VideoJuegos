package main;

import es.techtalents.ttgdl.geom.Point2f;

public abstract class Armas {
	private long tiempoanterior;
	private float tiempoderecarga;
	public abstract void disparar(Point2f pos);
	
	public boolean recargado(){
		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;
		
		if(tiempoTranscurrido > tiempoderecarga){
			tiempoanterior = tiempoactual;
		}
		return tiempoTranscurrido > tiempoderecarga;
	}
	
	public float getTiempoderecarga() {
		return tiempoderecarga;
	}
	
	public void setTiempoderecarga(float tiempoderecarga) {
		this.tiempoderecarga = tiempoderecarga;
	}



}
