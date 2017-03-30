/*��Ŭ������ sun���� ��ü ������ ui������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����.
 * ���� jpanel�� �׷������� jpanel�� Graphics�� ���۷����� �� ��ü�� �����ؾ� �Ѵ�.
 * */
package com.ss.gameframework;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	
	public Player(ObjectManager objectManager, int x, int y, int width, int height) {
		super(objectManager, x, y, width, height);
		/*this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;*/		
	}
	
	//�Ѿ� �߻� ������ �����Ѵ�.
	public void fire(){
		//Bullet bullet = new Bullet(x, y, 10, 10);
		//Bullet�� tick�� render�� �ؾ��ϴµ� �ϱ� ��ƴ�.
		
		Bullet bullet = new Bullet(objectManager, x, y, 10, 10);
		objectManager.addObject(bullet);
		
	}
	
	
	/*x, y, width, height���� ������ ���� ��ȭ��
	 * �����ϱ� ���� �޼ҵ�(��� ����:��� ��ȭ)*/
	public void tick(){
		//System.out.println("tick");
		x+=velX;
		y+=velY;
	
	}
	
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼ҵ�
	public void render(Graphics g){
		g.setColor(Color.WHITE);//������ �ٸ��� ����Ʈ �� �ٲٱ�
		g.drawRect(x, y, width, height);
		//System.out.println("render");
	
	}
	
}
