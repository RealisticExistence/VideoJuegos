package main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;

public class Nivel extends Window{
	private int dificulty;
	private Game game;
	private boolean b;
	private Nave n;
	private int numEneigos = 1;
	public static boolean musicaActive = true;
	static List<Enemigo> enemigos = new ArrayList<Enemigo>();
	Point2f pos = new Point2f(Game.WIDTH,(float) (Math.random()*Game.HEIGHT));
	private Window w;

	public Nivel(Game game, int i) {
		this.w = this;
		this.game = game;
		Image fondo = ImageLoader.loadImage("Images/fondoLevel.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		dificulty = i;
		siguienteRonda(pos, 6);


		Nave n = new Nave(1, 0, 0, this,enemigos,game);
		addSprite(n);
		this.n = n;


	}
	public void setDificulty(int i) {
		dificulty = i;

	}
	
	public void siguienteRonda(Point2f point2f, int profundidad) {

			b = true;

			Enemigo e = new Enemigo(point2f, this,enemigos, b, n);
			e.profundidad = profundidad;
			enemigos.add(e);
			addSprite(e);
			
		
		
		

	}
	private void rotarPantalla() {
		//TODO rotate screen
		Thread t = new Thread(new Runnable() {
			double angulo = 1;
			int cuenta = 0;
			@Override
			public void run() {
				w.getTransform().translate(MainWindow.WIDTH/2, MainWindow.HEIGHT/2);
				while(cuenta < 180){
					w.getTransform().rotate(Math.toRadians(angulo));
					cuenta++;
					//w.getTransform().translate(MainWindow.WIDTH/2, MainWindow.HEIGHT/2);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				w.getTransform().translate(-MainWindow.WIDTH/2, -MainWindow.HEIGHT/2);
			}
		});
		t.start();

	}
}
