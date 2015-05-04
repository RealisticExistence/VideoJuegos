package main;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Level extends Window{

	ArrayList<Ladrillo> array = new ArrayList<Ladrillo>();
	
	public Level(MainWindow mw){
		Image pelota = ImageLoader.loadImage("Images/Pelota.png");
		Image img = ImageLoader.loadImage("Images/TheSmasherBackground.png").getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(img);
		setWidth(MainWindow.WIDTH);
		setHeight(MainWindow.HEIGHT);
		setVisible(true); //164 , 71
		setBgColor(Color.BLACK);
		


		
		
		int numX = 10;
		int numY = 4;
		
		
		
		for(int x = 0; x < numX; x++){
			for(int y = 0; y < numY; y++){
				Ladrillo l = new Ladrillo(this);
				array.add(l);
				l.setVisible(true);
				addSprite(l);
				l.setPosition(x*l.getWidth(), y*l.getHeight());
			}
		}
		Raqueta r = new Raqueta(array,this,mw);
		r.setVisible(true);
		Pelota p = new Pelota(r,array,this,mw);
		p.setVisible(true);
		p.setImage(pelota);
		p.setPosition(MainWindow.WIDTH/2, MainWindow.HEIGHT/2);
		r.p = p;
		addSprite(p);
		addSprite(r);
		
	}
	
	@Override
	public void removeSprite(Sprite s) {
		super.removeSprite(s);
		array.remove(s);
		if(array.size() == 0){
			System.exit(0);
		}
	}
	
	
	
	
}
