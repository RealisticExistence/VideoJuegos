package main;

import java.awt.Image;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Enemigo extends Sprite{
	Armas arma;
	private Nivel nvl;
	private List<Enemigo> enemigos;
	private boolean b;
	private Nave n;
	public Enemigo(Point2f pos, Nivel nvl, List<Enemigo> enemigos, boolean tieneArma, Nave n){
		this.n = n;
		this.b = tieneArma;
		this.enemigos = enemigos;
		this.nvl = nvl;
		Image img = ImageLoader.loadImage("Images/NaveLvl3.png").getScaledInstance(Game.WIDTH/10,Game.HEIGHT/10, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		setPosition(pos);
		if(b){
			arma = new ArmaLaser(nvl,enemigos,false,n);
			arma.setTiempoderecarga(1000);
		}
		
		
	}
	int numaleatorioy = (int) Math.round(Math.random()*(-5-5)+5);
	int num = (int) Math.round(Math.random()*(0-5)+5);
	int num1 = (int) Math.round(Math.random()*(-5-0)+0);
	int numx = (int) Math.round(Math.random()*(2-5)+5);
	Vector2f speed = new Vector2f(-numx, numaleatorioy);
	@Override
	public void act() {
		disparar();
		if(getPosition().y < 0){
			speed.y = num;
		}
		if(getPosition().y > Game.HEIGHT-getHeight()){
			speed.y = num1;
		}
		getPosition().add(speed);

		
	}
	private void disparar() {
		if(b){

			if(arma.recargado()){
				arma.disparar(getPosition(), -1500);
			
		}
		}
		
		
	}
	@Override
	public void onColision(Sprite s) {
		if(s instanceof Laser){
			Laser l = (Laser) s;
			if(l.b == true){
				setVisible(false);
				nvl.removeSpriteArray(this);
			}
			
		}
		super.onColision(s);
	}

}
