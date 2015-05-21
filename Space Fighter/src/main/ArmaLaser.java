package main;

import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public class ArmaLaser extends Armas{

	private Window w;
	private List<Enemigo> e;
	private boolean b;
	private Nave nave;
	public ArmaLaser(Window w, List<Enemigo> enemigos, boolean b, Nave nave){
		this.w = w;
		this.e = enemigos;
		this.b = b;
		this.nave = nave;
	}
	

	@Override
	public void disparar(Point2f pos, float speed) {
		Laser l = new Laser(w,e,speed,b,nave);
		
		l.setPosition(pos.x, pos.y);
	}

}
