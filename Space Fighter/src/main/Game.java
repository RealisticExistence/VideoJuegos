package main;

import java.awt.Menu;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.sound.Sound;

public class Game extends MainWindow{

	private Window menu = new MainMenu(this);
	private Tienda tienda = new Tienda(this);
	private Nivel level = new Nivel(this,1);
	private Controles control = new Controles(this);

	private DificultyMenu menuD = new DificultyMenu(this);


	public Game(){ 
		mostrarMenu(true);
		//showLevel(1);
	}

	public void removeWindows(Window w){
		removeWindow(tienda);
		removeWindow(menu);
		removeWindow(menuD);
		removeWindow(level);
		addWindow(w);

	}
	
	public void mostrarMenu(boolean musicaActive){
		addWindow(menu);
		menu.setVisible(true);
		MainMenu.musicaActive = musicaActive;
	}

	public void showShop() {
		addWindow(tienda);
		tienda.setVisible(true);
		Tienda.musicActive = MainMenu.musicaActive;
	}

	public void showDificultyMenu(boolean musicaActive) {
		addWindow(menuD);
		menuD.setVisible(true);
		menuD.musicaActive = musicaActive;

	}

	public void showLevel(int i, boolean musicaActive) {
		addWindow(level);
		level.setVisible(true);	
		level.setDificulty(i);
		if(musicaActive){
			Sound s = new Sound("Musica/bangarang.wav", 1);
			s.start();
		}

	}

	public void showcontrols(boolean musicaActive) {
	addWindow(control);
	control.setVisible(true);
	Controles.musicaActive = musicaActive;
	
	}

	
}
