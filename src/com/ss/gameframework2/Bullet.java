package com.ss.gameframework2;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	public Bullet(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
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
