package main;

import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public class ArmaLaser extends Armas{

	private Window w;
	private List<Enemigo> e;
	public ArmaLaser(Window w, List<Enemigo> enemigos){
		this.w = w;
		this.e = enemigos;
	}
	

	@Override
	public void disparar(Point2f pos) {
		Laser l = new Laser(w,e);
		l.setPosition(pos.x, pos.y);
	}

}
