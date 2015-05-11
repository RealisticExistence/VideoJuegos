package main;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;

public class Game extends MainWindow{

		private Window menu = new MainMenu(this);
		private Tienda tienda = new Tienda(this);

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
}
