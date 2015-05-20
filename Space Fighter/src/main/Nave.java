package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Nave extends Sprite{

	private Nivel nvl;
	private boolean arriba = false;
	private boolean abajo = false;
	private boolean derecha = false;
	private boolean izquierda = false;
	private boolean disparar = false;
	private long tiempoanterior;
	private int nvlnave;
	private int ctrlMode;
	public static int modoGiro;

	public Nave(int wasdOflechas,int modoGiro,int nivelnave, Nivel nvl) {
		this.nvl = nvl;
		this.nvlnave = nivelnave;
		this.ctrlMode = wasdOflechas;
		this.modoGiro = modoGiro;
		Image img = ImageLoader.loadImage("Images/NaveLvl1.png");
		img = img.getScaledInstance((MainWindow.WIDTH/10), (MainWindow.HEIGHT/10), Image.SCALE_SMOOTH);
		setPosition(0, MainWindow.HEIGHT/2-getHeight()/2);
		setImage(img);
		setVisible(true);

	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_UP){
			arriba = true;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			abajo = true;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			derecha = true;
		}
		if(keyCode == KeyEvent.VK_LEFT){
			izquierda = true;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			disparar();
		}
		super.onKeyPress(keyCode);
	}


	@Override
	public void onKeyReleased(int keyCode) {

		if(keyCode == KeyEvent.VK_UP){
			arriba = false;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			abajo = false;
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			derecha = false;
		}
		if(keyCode == KeyEvent.VK_LEFT){
			izquierda = false;
		}

		super.onKeyReleased(keyCode);
	}

	@Override
	public void act() {
		long tiempoactual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoactual - tiempoanterior;
		tiempoanterior = tiempoactual;

		float tiempo = tiempoTranscurrido/1000f;
		Vector2f speed = new Vector2f(0, 0);
		if(modoGiro == 0){
			if(arriba){
				speed.y = -750;
			}
			if(abajo){
				speed.y = 750;
			}
			if(izquierda){
				speed.x = -750;
			}
			if(derecha){
				speed.x = 750;


			}
		}else if(modoGiro == 1){

			if(arriba){
				speed.y = -750;
			}
			if(abajo){
				speed.y = 750;
			}
			if(izquierda){
				//TODO cambiar giro
			}
			if(derecha){
				//TODO cambiar giro
			}
			
		}






		if(getPosition().y < 0){
			getPosition().y = 0;
		}
		if(getPosition().y > Game.HEIGHT-getHeight()){
			getPosition().y = Game.HEIGHT-getHeight();
		}
		if(getPosition().x < 0){
			getPosition().x = 0;
		}
		if(getPosition().x > Game.WIDTH-getWidth()){
			getPosition().x = Game.WIDTH-getWidth();
		}
		getPosition().add(speed.mul(tiempo));


	}
	private void disparar() {
	}


}
