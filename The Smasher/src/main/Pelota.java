package main;

import java.awt.Image;
import java.util.ArrayList;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite{
	Vector2f speed = new Vector2f(2,-2);
	private Raqueta r;  
	Image ladrilloNv1 = ImageLoader.loadImage("Ladrillos/RaquetaNv1.png");
	Image ladrilloNv2 = ImageLoader.loadImage("Ladrillos/RaquetaNv2.png");
	Image ladrilloNv3 = ImageLoader.loadImage("Ladrillos/RaquetaNv3.png");
	private ArrayList<Ladrillo> array;
	private Window w;
	private MainWindow mw;
	public Pelota(Raqueta r, ArrayList<Ladrillo> array, Window w, MainWindow mw){
		this.r = r;
		this.w = w;
		this.mw = mw;
		this.array = array;
		ladrilloNv1 = ImageLoader.loadImage("Ladrillos/RaquetaNv1.png").getScaledInstance(ladrilloNv1.getWidth(null) - 10, ladrilloNv1.getHeight(null), Image.SCALE_SMOOTH);
		ladrilloNv2 = ImageLoader.loadImage("Ladrillos/RaquetaNv2.png").getScaledInstance(ladrilloNv2.getWidth(null) - 10, ladrilloNv2.getHeight(null), Image.SCALE_SMOOTH);
		ladrilloNv3 = ImageLoader.loadImage("Ladrillos/RaquetaNv3.png").getScaledInstance(ladrilloNv3.getWidth(null) - 10, ladrilloNv3.getHeight(null), Image.SCALE_SMOOTH);

	}

	@Override
	public void act() {
		for(int i = 0; i < array.size(); i++){
			Ladrillo l = array.get(i);
			if(l.checkCollision(this) && !(l.isDead())){
				this.onColision(l);
				//break;
			}
		}
		if(r.checkCollision(this)){
			speed.y *= -1;
		}
		if(getPosition().x > MainWindow.WIDTH-getWidth()){
			speed.x *= -1;
		}
		if(getPosition().x < 0){
			speed.x *= -1;
		}
		if(getPosition().y > MainWindow.HEIGHT){
			speed.y *= -1;

			//mw.removeWindow(w);
			//mw.addWindow(new GameOverScreen());
		}
		if(getPosition().y < 0){
			speed.y *= -1;
		}
		getPosition().add(speed.add(0.0001f, 0.0001f));
	}
	
	@Override
	public void onColision(Sprite sprite) {
		speed.y *= -1.01;
		speed.rotate(Math.random()*10-5);
		if(sprite instanceof Ladrillo){
			sprite.onColision(this);
		}

	}






}
