package com.ss.gameframework;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject{
	
	public Bullet(ObjectManager objectManager, int x, int y, int width, int height) {
		super(objectManager, x, y, width, height);
		/*this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;*/
		velX=6;
		
	}
	
	
	public void tick(){
		x+=velX;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
				
	}
}
