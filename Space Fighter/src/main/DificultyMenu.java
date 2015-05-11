package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class DificultyMenu extends Window{
	private Game game;
	public DificultyMenu(Game game){
		this.game = game;
		Image fondo = ImageLoader.loadImage("Images/FondoDificultad.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		crearBotones();
	}
	private void crearBotones() {
		Image Easy = ImageLoader.loadImage("Botones/Facil.png");
		Image EasyPressed = ImageLoader.loadImage("Botones/FacilPressed.png");
		
		Image Medium = ImageLoader.loadImage("Botones/Medio.png");
		Image MediumPressed = ImageLoader.loadImage("Botones/MedioPressed.png");
		
		Image Hard = ImageLoader.loadImage("Botones/Dificil.png");
		Image HardPressed = ImageLoader.loadImage("Botones/DificilPressed.png");
		
		Boton easy = new Boton(EasyPressed,Easy){

			@Override
			public void clicked() {
				game.showLevel(1);
				
			}
			
		};
		
		Boton medio = new Boton(MediumPressed,Medium){

			@Override
			public void clicked() {
				game.showLevel(2);
				
			}
			
		};
		
		
		Boton dificil = new Boton(HardPressed,Hard){

			@Override
			public void clicked() {
				game.showLevel(3);
				
				
				
			}
			
		};
		
		dificil.setVisible(true);
		dificil.setEnabled(true);
		
		easy.setVisible(true);
		easy.setEnabled(true);
		
		medio.setVisible(true);
		medio.setEnabled(true);
		medio.setPosition(Game.WIDTH/2-medio.getWidth()/2, Game.HEIGHT/2-50);
		dificil.setPosition(Game.WIDTH/2-dificil.getWidth()/2, Game.HEIGHT/2+100);
		easy.setPosition(Game.WIDTH/2-easy.getWidth()/2, Game.HEIGHT/2-200);
		
		addSprite(dificil);
		addSprite(easy);
		addSprite(medio);
	}

	
	
}
