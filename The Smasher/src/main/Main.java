package main;

import java.awt.Color;

import es.techtalents.techlib.gui.MainWindow;
import es.techtalents.techlib.gui.window.Window;
import es.techtalents.techlib.image.ImageLoader;

public class Main {
	public static void main(String[] args){
		MainWindow mw = new MainWindow();
		Window w = new Window();
		w.setWidth(MainWindow.WIDTH);
		w.setHeight(MainWindow.HEIGHT);
		w.setVisible(true);
		w.setBgColor(Color.BLACK);
		mw.addWindow(w);
		Raqueta r = new Raqueta();
		r.setVisible(true);
		r.setPosition(100f, 100f);
		r.setImage(ImageLoader.loadImage("Images/RaquetaRoja.png"));
		r.setPosition(MainWindow.WIDTH/2-r.getImage().getWidth(null)/2, MainWindow.HEIGHT-100);
		w.addSprite(r);
		
	}
	
	
}
