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
	public Pelota p;
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
	int derecha1 = 5;
	int izquierda1 = -5;
	Point2f pos = getPosition();

	@Override
	public void act() {
		if(derecha && getPosition().x < MainWindow.WIDTH - getWidth()) {
			pos.add(derecha1, 0);
		}
		if (izquierda &&  getPosition().x > 0) {
			pos.add(izquierda1, 0);

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

					double chooser2 = Math.random();
					if(chooser2 > 0.0 && chooser2 < 0.2){
						ladrillosUnaVida();
					}
					else if(chooser2 > 0.2 && chooser2 < 0.4){
						hacerGrande();
					}
					else if(chooser2 > 0.4 && chooser2 < 0.6){
						hacerPelotaLenta();
					}	
					else if(chooser2 > 0.8 && chooser2 < 1){
						hacerRapido();
					}
				}
				if(malo){
					double chooser = Math.random();
					if(chooser > 0.0 && chooser < 0.2){
						hacerPelotaRapida();
					}
					else if(chooser > 0.2 && chooser < 0.4){
						hacerPequeña();
					}
					 if(chooser > 0.4 && chooser < 0.6){
						rotarPantalla();
					}
					else if(chooser > 0.6 && chooser < 0.8){
						hacerLenta();
					}
					else if(chooser > 0.8 && chooser < 1){
						hacerLenta();
					}


				}
				l.setVisible(false);
				w.removeSprite(l);
			}


		}
	}




	private void hacerGrande() {
		Image imggood = getImage().getScaledInstance(getImage().getWidth(null) + 100, getImage().getHeight(null), Image.SCALE_SMOOTH);
		setImage(imggood);
		bueno = false;
	}

	private void hacerPelotaRapida() {
		p.speed.x *= 1.5;
		p.speed.y *= 1.5;
		
	}
	private void hacerLenta() {
		izquierda1 = -3;
		derecha1 = 3;

	}
	private void hacerRapido() {
		izquierda1 = -7;
		derecha1 = 7;

		
	}

	
	
	
	
	
	

	private void ladrillosUnaVida() {
		for(int i = 0; i < array.size(); i++){
			Ladrillo l = array.get(i);
			if(l.vida > 0){
				l.vida = 1;

			}
		}
	}

	private void hacerPelotaLenta() {
		p.speed.x *= 0.5;
		p.speed.y *= 0.5;
		
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
