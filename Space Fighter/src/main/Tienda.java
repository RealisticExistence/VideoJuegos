package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Tienda extends Window{
	private Game game;
	public static boolean musicActive;
	public Tienda(Game game){
		this.game = game;
		setBackgroundImage(ImageLoader.loadImage("Images/FondoTienda.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH));
		setVisible(true);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.removeWindows(this);
			game.mostrarMenu(musicActive);
		}
		super.onKeyPress(keyCode);
	}
	
}
