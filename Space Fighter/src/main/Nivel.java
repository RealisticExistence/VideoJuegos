package main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;

public class Nivel extends Window{
	private int dificulty;
	public static boolean musicaActive = true;
	public Nivel(Game game, int i) {
		Image fondo = ImageLoader.loadImage("Images/fondoLevel.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		dificulty = i;
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		int numX = 6;
		int numY = 10;

		for(int x = 0; x < numX; x++){
			for(int y = 0; y < numY; y++){
				Point2f pos = new Point2f(x, y);
				Enemigo e = new Enemigo(pos);
				enemigos.add(e);
				addSprite(e);
				e.setPosition(x*e.getWidth(),y*e.getHeight());
			}
			
		}
		
		
		Nave n = new Nave(1, 0, 0, this,enemigos);
		addSprite(n);
		
		
	}
	public void setDificulty(int i) {
		dificulty = i;
	}

}
