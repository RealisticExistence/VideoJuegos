package main;

import java.awt.Image;
import java.util.List;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;
import es.techtalents.ttgdl.sprite.Sprite;

public class Laser extends Sprite{
	private Window window;
	static Image img = ImageLoader.loadImage("Botones/bala_aliada2.png").getScaledInstance(Game.WIDTH/50, Game.HEIGHT/50, Image.SCALE_SMOOTH);
	private float speed;
	private long tiempoanterior;
	Sound s = new Sound("Musica/DisparoLaser.wav",1);
	private List<Enemigo> e;
	public boolean b;
	private Nave n;
	public Laser(Window w, List<Enemigo> e2, float speed, boolean b, Nave nave){
		this.speed = speed;
		this.n = nave;
		this.e = e2;
		this.b = b;
		this.window = w;
		
		setImage(img);
		setVisible(true);
		w.addSprite(this);

	}
	@Override
	public void act() {
		checkColisions();



		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;


		if(tiempoanterior == 0){
			tiempoanterior = tiempoactual;
			return;
		}
		tiempoanterior = tiempoactual;
		float tiempo = tiempoTranscurrido/1000f;		
		getPosition().x += speed*tiempo;
		if(b == true){
			s.start();

		}


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
	private void checkColisions() {
		if(n != null){
			if(checkCollision(n)){
				n.onColision(this);
			}
		}
		if(e.size() > 0){
			for(int i = 0; i < e.size(); i++){
				Enemigo e = this.e.get(i);
				if(e.checkCollision(this)){
					e.onColision(this);
					this.onColision(e);
					return;
				}
			}
		}
		
	}
	@Override
	public void onColision(Sprite s) {
		if(s instanceof Enemigo){
			if(b == true){
				setVisible(false);

			}
		}
		super.onColision(s);
	}
}
