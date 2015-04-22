package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite{
	Vector2f speed = new Vector2f(1,-1);
	private Raqueta r;  
	public Pelota(Raqueta r){
		this.r = r;
	}

	@Override
	public void act() {
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
			System.exit(0);
		}
		if(getPosition().y < 0){
			speed.y *= -1;
		}
		getPosition().add(speed);
		
	}

	@Override
	public void onColision(Sprite sprite) {
		
		
		
		
		
	}
	
	
	
	
	
	
}
