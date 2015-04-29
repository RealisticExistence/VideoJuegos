package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Raqueta extends Sprite{
	boolean derecha = false;
	boolean izquierda = false;
	boolean bueno = false;
	boolean malo = false;
	private Window w;
	private MainWindow mw;
	private ArrayList<Ladrillo> array;
	public Raqueta(ArrayList<Ladrillo> array, Window w, MainWindow mw){
		this.array = array;
		this.w = w;
		this.mw = mw;
		Image img = ImageLoader.loadImage("Images/RaquetaRoja.png").getScaledInstance(MainWindow.WIDTH/7, MainWindow.HEIGHT/28, Image.SCALE_SMOOTH);
		setImage(img );
		setPosition(MainWindow.WIDTH/2-getImage().getWidth(null)/2, MainWindow.HEIGHT-getHeight()/3);
	}

	@Override
	public boolean onClick(float arg0, float arg1) {

		return false;
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_LEFT && getPosition().x > 0){
			izquierda = true;

		}
		else if(keyCode == KeyEvent.VK_RIGHT && getPosition().x < MainWindow.WIDTH - getWidth()){
			derecha = true;
		}
		else if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);



		}


	}

	@Override
	public void act() {
		if(derecha && getPosition().x < MainWindow.WIDTH - getWidth()) {
			Point2f pos = getPosition();
			pos.add(5, 0);
		}
		if (izquierda &&  getPosition().x > 0) {
			Point2f pos = getPosition();
			pos.add(-5, 0);

		}
		for(int i = 0; i < array.size(); i++){
			Ladrillo l = array.get(i);
			if(this.checkCollision(l)){
				double GoodOrBad = Math.random();
				if(GoodOrBad >= 0.5){
					bueno = true;
					malo = false;
				}
				else if(GoodOrBad < 0.5){
					malo = true;
					bueno = false;
				}
				if(bueno){
					Image imggood = getImage().getScaledInstance(getImage().getWidth(null) + 100, getImage().getHeight(null), Image.SCALE_SMOOTH);
					setImage(imggood);
					bueno = false;
					
				}
				if(malo){
					int eleccion = (int) Math.floor(Math.random()*3);
					switch(eleccion){
					case 1:
						hacerPequeña();
						break;
					case 2:
						rotarPantalla();
						break;
					case 3:
						morir();
						break;
					}
					
				}
				l.setVisible(false);
				w.removeSprite(l);
				
		}

		}
		

	}

	private void morir() {
		mw.removeWindow(w);
		mw.addWindow(new GameOverScreen());
		
	}

	private void rotarPantalla() {
			//TODO rotate screen
			 
		
	}

	private void hacerPequeña() {
		Image imgbad = getImage().getScaledInstance(getImage().getWidth(null) - 100, getImage().getHeight(null), Image.SCALE_SMOOTH);
		setImage(imgbad);
		malo = false;
	}

	@Override
	public void onColision(Sprite arg0) {
		
	}

	@Override
	public void onKeyReleased(int keyCode) {
		if(keyCode == KeyEvent.VK_RIGHT){
			derecha = false;

		}
		if(keyCode == KeyEvent.VK_LEFT){
			izquierda = false;

		}

	}

}
