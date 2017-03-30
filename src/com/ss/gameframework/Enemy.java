package com.ss.gameframework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends GameObject{	
	Random r=new Random();
	int max; //r의 최대값
	int min;	//r의 최소값
	
	public Enemy(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
		
		velX=-4; //다가오게함
		max=GamePanel.HEIGHT*GamePanel.SCALE-50;
		min=50;
	}

	public void tick() {
		x+=velX;		
		
		//화면 좌측 끝에 도착하면 다시 우측부터 시작하게
		if (x<=0) {
			x=GamePanel.WIDTH*GamePanel.SCALE;
			y=r.nextInt(max-min+1)+min;//r.nextInt(max - min + 1)+min;			
		}
		
		rect.setBounds(x, y, width, height);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		//g.fillRect(x, y, width, height);
		
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect);
	}

	
}
