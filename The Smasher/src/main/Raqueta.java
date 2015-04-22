package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Raqueta extends Sprite{
	boolean derecha = false;
	boolean izquierda = false;
	
	public Raqueta(){
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
			pos.add(2, 0);
		}
		if (izquierda &&  getPosition().x > 0) {
			Point2f pos = getPosition();
			pos.add(-2, 0);

		}

	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

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
