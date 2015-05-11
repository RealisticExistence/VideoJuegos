package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Nivel extends Window{
	public int dificulty; 
	public Nivel(Game game) {
		Image fondo = ImageLoader.loadImage("Images/fondoLevel.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		// TODO Auto-generated constructor stub
	}

}
