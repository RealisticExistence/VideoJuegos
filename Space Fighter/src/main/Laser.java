package main;

import java.awt.Image;
import java.util.List;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;
import es.techtalents.ttgdl.sprite.Sprite;

public class Laser extends Sprite{
	private Window window;
	private float speed = 1500;
	private long tiempoanterior;
	Sound s = new Sound("Musica/DisparoLaser.wav",1);
	private List<Enemigo> e;
	public Laser(Window w, List<Enemigo> e2){
		this.e = e2;
		this.window = w;
		Image img = ImageLoader.loadImage("Botones/bala_aliada2.png").getScaledInstance(Game.WIDTH/50, Game.HEIGHT/50, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		w.addSprite(this);

	}
	@Override
	public void act() {
		for(Enemigo e : this.e){
			if(e.checkCollision(this)){
				e.onColision(this);
				this.onColision(e);
			}
		}
		
	
		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;
		

		if(tiempoanterior == 0){
			tiempoanterior = tiempoactual;
			return;
		}
		tiempoanterior = tiempoactual;
		float tiempo = tiempoTranscurrido/1000f;		
		getPosition().x += speed*tiempo;
		
		s.start();


		if(getPosition().x < 0){
			setVisible(false);
			window.removeSprite(this);
		}
		if(getPosition().y < 0){
			setVisible(false);
			window.removeSprite(this);

		}
		if(getPosition().x > Game.WIDTH){
			setVisible(false);
			window.removeSprite(this);

		}
		if(getPosition().y > Game.HEIGHT){
			setVisible(false);
			window.removeSprite(this);

		}



	}
	@Override
	public void onColision(Sprite s) {
		if(s instanceof Enemigo){
			setVisible(false);
		}
		super.onColision(s);
	}
}
