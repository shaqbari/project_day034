package com.ss.gameframework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
	//rectangle여기서도 만들수 있지만 gameobject에 만드는것이 다른 클래스도 가질수 있어서 좋다.
	
	public Bullet(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
		/*this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;*/
		velX=6;
		
	}
	
	
	public void tick(){
		x+=velX;
		rect.setBounds(x, y, width, height);
		
		//적군과 내가 교차하면, 둘다 죽기!!
		for(int i=0; i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id==ObjectId.Enemy){
				if(obj.rect.intersects(rect)){//충돌하면
				//rect.intersection(r);//적군의 사각형과 충돌, 적군을 object에서 인식하려면 id가 필요하다.
			
				//너죽고 나죽자
				objectManager.list.remove(obj);
				objectManager.list.remove(this);
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		//g.fillOval(x, y, width, height);
			
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height); //tick에서 setBounds로 인해 사각형안에 들어있음.
		
	}
}
