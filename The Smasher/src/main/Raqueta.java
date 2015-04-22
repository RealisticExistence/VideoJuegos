package main;

import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Raqueta extends Sprite{

	@Override
	public boolean onClick(float arg0, float arg1) {
		
		return false;
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_LEFT && getPosition().x > 0){
			Point2f pos = super.getPosition();
			pos.add(-10f, 0);
			
			
		}
		else if(keyCode == KeyEvent.VK_RIGHT && getPosition().x < MainWindow.WIDTH - getWidth()){
			Point2f pos = super.getPosition();
			
				pos.add(10f, 0);
			
			
		}
		else if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
			
			
			
		}
		
		
	}

	@Override
	public void act() {
		
		
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
