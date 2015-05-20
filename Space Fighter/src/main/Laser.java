package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;
import es.techtalents.ttgdl.sprite.Sprite;

public class Laser extends Sprite{
	private Window window;
	private float speed = 1500;
	private long tiempoanterior;
	public Laser(Window w){
		this.window = w;
		Image img = ImageLoader.loadImage("Botones/bala_aliada2.png").getScaledInstance(Game.WIDTH/50, Game.HEIGHT/50, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		w.addSprite(this);

	}
	@Override
	public void act() {
		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;
		tiempoanterior = tiempoactual;

		if(tiempoanterior == 0){
			tiempoanterior = tiempoactual;
			return;
		}
		tiempoanterior = tiempoactual;
		float tiempo = tiempoTranscurrido/1000f;		
		getPosition().x += speed*tiempo;
		Sound s = new Sound("Musica/DisparoLaser.wav",1);
		s.start();


		if(getPosition().x < 0){
			setVisible(false);

		}
		if(getPosition().y > Game.HEIGHT-getHeight()){
			setVisible(false);

		}
		if(getPosition().x > Game.WIDTH-getWidth()){
			setVisible(false);

		}
		if(getPosition().y > Game.HEIGHT-getHeight()){
			setVisible(false);

		}



	}
}
