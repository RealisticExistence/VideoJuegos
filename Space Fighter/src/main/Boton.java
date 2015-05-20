package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.sprite.Sprite;

public abstract class Boton extends Sprite{
	private Image pressed;
	private Image notPressed;
	public Boton(Image pressed, Image notPressed){
		this.pressed = pressed;
		this.notPressed = notPressed;
		setImage(notPressed);
	}
	
	@Override
	public void act() {
		
	}
	
	@Override
	public boolean onClick(float x, float y) {
		clicked();
		return super.onClick(x, y);
	}

	public abstract void clicked(); 
	
	public void setPressedImage(Image img){
		pressed = img;
	}
	@Override
	public void onMouseEntered() {
		setImage(pressed);		
		super.onMouseEntered();
	}

	@Override
	public void onMouseExited() {
		setImage(notPressed);
		super.onMouseExited();
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
		}
		super.onKeyPress(keyCode);
	}

}
