package main;

import es.techtalents.ttgdl.gui.MainWindow;

public class Main {
	public static void main(String[] args){
		MainWindow mw = new MainWindow();
		Level w = new Level(mw);
		mw.addWindow(w);
	}

	

}



