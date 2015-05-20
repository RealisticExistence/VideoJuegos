package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Controles extends Window{
	public static boolean musicaActive;
	private Game game;
	private boolean MusicaActive;
	private Controles c = this;
	public Controles(Game game){
		this.game = game;
		Image fondo = ImageLoader.loadImage("Images/FondoDificultad.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		crearBotones();

	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.removeWindows(this);
			game.mostrarMenu(MusicaActive);

		}
		super.onKeyPress(keyCode);
	}

	private void crearBotones() {
		final Image ActivarMusica = ImageLoader.loadImage("Botones/ActivarMusica.png");
		final Image ActivarMusicaPressed = ImageLoader.loadImage("Botones/ActivarMusicaPressed.png");

		final Image DesactivarMusica = ImageLoader.loadImage("Botones/DesactivarMusica.png");
		final Image DesactivarMusicaPressed = ImageLoader.loadImage("Botones/DesactivarMusicaPressed.png");



		Boton medio = new Boton(ActivarMusicaPressed,ActivarMusica){


			@Override
			public void clicked() {
				MainMenu.musicaActive = !MainMenu.musicaActive;
				crearBotones();
				setVisible(false);
				if(musicaActive){
					setImage(DesactivarMusica);
					setPressedImage(DesactivarMusicaPressed);
				}
				else{
					setImage(ActivarMusica);
					setPressedImage(ActivarMusicaPressed);
				}




			}


		};








		medio.setVisible(true);
		medio.setEnabled(true);
		medio.setPosition(Game.WIDTH/2-medio.getWidth()/2, Game.HEIGHT/2-50);

		addSprite(medio);
	}



}
