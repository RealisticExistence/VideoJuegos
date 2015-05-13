package main;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;

public class Game extends MainWindow{

	private Window menu = new MainMenu(this);
	private Tienda tienda = new Tienda(this);
	private Nivel level = new Nivel(this,1);

	private DificultyMenu menuD = new DificultyMenu(this);


	public Game(){ 
		//mostrarMenu();
		showLevel(1);
	}

	public void removeWindows(Window w){
		removeWindow(tienda);
		removeWindow(menu);
		removeWindow(menuD);
		removeWindow(level);
		addWindow(w);

	}
	
	public void mostrarMenu(){
		addWindow(menu);
		menu.setVisible(true);
	}

	public void showShop() {
		addWindow(tienda);
		tienda.setVisible(true);		
	}

	public void showDificultyMenu() {
		addWindow(menuD);
		menuD.setVisible(true);

	}

	public void showLevel(int i) {
		addWindow(level);
		level.setVisible(true);	
		level.setDificulty(i);

	}
}
