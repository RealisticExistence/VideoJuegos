package main;

import java.awt.Image;
import java.util.ArrayList;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Explosion extends Sprite{
	private Window window;
	private static ArrayList<Image> images = loadImages();
	private long tiempoanterior;
	private float duracion = 1f;
	public Explosion(Point2f pos, Window w){
		this.window = w;
		pos.add(-images.get(15).getWidth(null), -images.get(15).getHeight(null));
		setPosition(pos.add(50, 70));
		setImage(images.get(0));
		setVisible(true);
	}
	private static ArrayList<Image> loadImages() {
		ArrayList<Image> images = new ArrayList<>();
		for(int i = 0; i < 25; i++){
			Image img = ImageLoader.loadImage("explosiones/explosion"+i+".png").getScaledInstance(Game.WIDTH/10, Game.HEIGHT/10, Image.SCALE_SMOOTH);
			images.add(img);
			
		}
		return images;
	}
	@Override
	public void act() {
		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;
		if(tiempoanterior == 0){
			tiempoanterior = tiempoactual;
			return;
		}
		float secs = tiempoTranscurrido/1000f;
		int numframes = images.size();
		int frameActual = (int) ((secs/duracion)*numframes);
		if(frameActual >= numframes){
			window.removeSprite(this);
			return;
		}
		setImage(images.get(frameActual));
	}

}
