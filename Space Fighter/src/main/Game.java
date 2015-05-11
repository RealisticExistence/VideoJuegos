package main;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;

public class Game extends MainWindow{

		private Window menu = new MainMenu(this);
		private Tienda tienda = new Tienda(this);
		private Nivel level = new Nivel(this);

		private DificultyMenu menuD = new DificultyMenu(this);


		public Game(){ 
			mostrarMenu();
			
		}
	public void mostrarMenu(){
		removeWindow(tienda);
		addWindow(menu);
		menu.setEnabled(true);
		menu.setVisible(true);
	}
	public void showShop() {
		menu.setVisible(false);
		removeWindow(menu);
		addWindow(tienda);
		tienda.setVisible(true);		
	}
	public void showDificultyMenu() {
		menu.setVisible(false);
		removeWindow(menu);
		addWindow(menuD);
		menuD.setVisible(true);	
		
	}
	public void showLevel(int i) {
		menuD.setVisible(false);
		removeWindow(menuD);
		addWindow(level);
		level.setVisible(true);	
		level.dificulty = i;
		
	}
}
