package com.ss.gameframework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
	//rectangle���⼭�� ����� ������ gameobject�� ����°��� �ٸ� Ŭ������ ������ �־ ����.
	
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
		
		//������ ���� �����ϸ�, �Ѵ� �ױ�!!
		for(int i=0; i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id==ObjectId.Enemy){
				if(obj.rect.intersects(rect)){//�浹�ϸ�
				//rect.intersection(r);//������ �簢���� �浹, ������ object���� �ν��Ϸ��� id�� �ʿ��ϴ�.
			
				//���װ� ������
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
		g2.fillOval(x, y, width, height); //tick���� setBounds�� ���� �簢���ȿ� �������.
		
	}
}
