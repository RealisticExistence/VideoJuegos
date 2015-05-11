package main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.InputEvent;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class YouWinScreen extends Window {
	public YouWinScreen(){
		setWidth(MainWindow.WIDTH);
		setHeight(MainWindow.HEIGHT);
		setVisible(true);
		Thread r = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Image img = ImageLoader.loadImage("Images/YouWin.png").getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
				setBackgroundImage(img);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		r.start();
		
	}
	
	
	
	
	
	
	
}
