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
	private Game game;
	private boolean b;
	private Nave n;
	public static boolean musicaActive = true;
	static List<Enemigo> enemigos = new ArrayList<Enemigo>();

	public Nivel(Game game, int i) {
		this.game = game;
		Image fondo = ImageLoader.loadImage("Images/fondoLevel.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		dificulty = i;
		siguienteRonda();
		
		
		Nave n = new Nave(1, 0, 0, this,enemigos,game);
		addSprite(n);
		this.n = n;
		
		
	}
	public void setDificulty(int i) {
		dificulty = i;
		
	}
	public  void removeSpriteArray(Enemigo enemigo) {
		enemigos.remove(enemigo);
		if(enemigos.size() == 0){
			this.siguienteRonda();
		}
		
	}
	private  void siguienteRonda() {
		int numX = 10;
		int numY = 10;

		for(int x = 0; x < numX; x++){
			for(int y = 0; y < numY; y++){
				if(y %2 == Math.round(Math.random())){
					Point2f pos = new Point2f(x, y);
					double rand = Math.random();
					if(rand <= 0.1){
						b = true;
					}else{
						b = false;
					}
					Enemigo e = new Enemigo(pos, this,enemigos, b, n);
					enemigos.add(e);
					addSprite(e);
					e.setPosition(Game.WIDTH,y*e.getHeight());
				}
				
			}
			
		}
		
	}

}
