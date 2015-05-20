package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Enemigo extends Sprite{
	public Enemigo(Point2f pos){
		Image img = ImageLoader.loadImage("Images/NaveLvl3.png").getScaledInstance(Game.WIDTH/10,Game.HEIGHT/10, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		setPosition(pos);
		
	}

	@Override
	public void act() {
		
	
		
	}
	@Override
	public void onColision(Sprite s) {
		if(s instanceof Laser){
			setVisible(false);
			
		}
		super.onColision(s);
	}

}
