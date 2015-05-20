package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class MainMenu extends Window{

	private Game game;
	public static boolean musicaActive;
	public MainMenu(Game game) {
		this.game = game;
		Image fondo = ImageLoader.loadImage("Images/fondo.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		setBackgroundImage(fondo);
		crearBotones();


	}

	private void crearBotones() {
		Image ExitButton = ImageLoader.loadImage("Botones/ExitButton.png");
		Image ExitButtonPressed = ImageLoader.loadImage("Botones/ExitPressed.png");

		Image PlayButton = ImageLoader.loadImage("Botones/Play.png");
		Image PlayButtonPressed = ImageLoader.loadImage("Botones/PlayPressed.png");

		Image Tienda = ImageLoader.loadImage("Botones/Tienda.png");
		Image TiendaPressed = ImageLoader.loadImage("Botones/TiendaPressed.png");

		Image options = ImageLoader.loadImage("Botones/Options.png");
		Image optionsPressed = ImageLoader.loadImage("Botones/OptionsPressed.png");

		Boton exit = new Boton(ExitButtonPressed,ExitButton){

			@Override
			public void clicked() {
				System.exit(0);

			}

		};

		Boton tienda = new Boton(TiendaPressed,Tienda){

			@Override
			public void clicked() {
				game.showShop();


			}

		};


		Boton play = new Boton(PlayButton,PlayButtonPressed){

			@Override
			public void clicked() {
				game.addWindow(new DificultyMenu(game));
				game.showDificultyMenu(musicaActive);
			}

		};
		Boton controls = new Boton(options,optionsPressed){

			@Override
			public void clicked() {
				game.addWindow(new Controles(game));
				game.showcontrols(musicaActive);
			}

		};

		play.setVisible(true);
		play.setEnabled(true);

		controls.setVisible(true);
		controls.setEnabled(true);

		exit.setVisible(true);
		exit.setEnabled(true);

		tienda.setVisible(true);
		tienda.setEnabled(true);

		exit.setPosition(Game.WIDTH/2-exit.getWidth()/2, Game.HEIGHT/2+100);
		play.setPosition(Game.WIDTH/2-play.getWidth()/2, Game.HEIGHT/2-200);
		tienda.setPosition(Game.WIDTH/2-tienda.getWidth()/2, Game.HEIGHT/2+250);
		controls.setPosition(Game.WIDTH/2-controls.getWidth()/2, Game.HEIGHT/2-50);
		
		addSprite(play);
		addSprite(exit);
		addSprite(tienda);
		addSprite(controls);
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		super.onKeyPress(keyCode);
	}


}
