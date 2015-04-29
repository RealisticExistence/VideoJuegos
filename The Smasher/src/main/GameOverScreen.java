package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class GameOverScreen extends Window{
	public GameOverScreen(){
		setBackgroundImage(ImageLoader.loadImage("Images/background.png").getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH));
		setVisible(true);
		setHeight(MainWindow.HEIGHT);
		setWidth(MainWindow.WIDTH);
	}

	@Override
	public void onKeyPress(int keyCode) {
		super.onKeyPress(keyCode);
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
}
