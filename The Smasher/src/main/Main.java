package main;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Main {
	public static void main(String[] args){
		MainWindow mw = new MainWindow();
		Window w = new Window();
		Image pelota = ImageLoader.loadImage("Images/Pelota.png");
		Image img = ImageLoader.loadImage("Images/TheSmasherBackground.png").getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		Image ladrillo = ImageLoader.loadImage("Images/Ladrillo.png");
		ladrillo = ImageLoader.loadImage("Images/Ladrillo.png").getScaledInstance(ladrillo.getWidth(null) - 10, ladrillo.getHeight(null), Image.SCALE_SMOOTH);


		w.setBackgroundImage(img);
		w.setWidth(MainWindow.WIDTH);
		w.setHeight(MainWindow.HEIGHT);
		w.setVisible(true); //164 , 71
		w.setBgColor(Color.BLACK);
		mw.addWindow(w);


		Raqueta r = new Raqueta();
		r.setVisible(true);


		Pelota p = new Pelota(r);
		p.setVisible(true);
		p.setImage(pelota);
		p.setPosition(MainWindow.WIDTH/2, MainWindow.HEIGHT/2);

		int ancho = 0;
		
		int altura = 0;
		
		ancho = 0;
		ArrayList<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
		
		for(int i = 0; i < 18; i++){
			Ladrillo l = new Ladrillo(p);
			l.setVisible(true);
			
			ladrillos.add(l);
			l.setImage(ladrillo);
			w.addSprite(l);
			
			if(ladrillos.size() == 7){
				altura = (int) l.getHeight();
				ancho = 0;
			}
			if(ladrillos.size() == 13){
				altura=(int) l.getHeight()*2;
				ancho = 0;
			if(ladrillos.size() == 19){
				altura*=(int) l.getHeight()*3;
				ancho = 0;
				}
			}
			l.setPosition(i*l.getWidth(), altura);
		}
		
		w.addSprite(p);
		w.addSprite(r);
	}

	

}



