/*��Ŭ������ sun���� ��ü ������ ui������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����.
 * ���� jpanel�� �׷������� jpanel�� Graphics�� ���۷����� �� ��ü�� �����ؾ� �Ѵ�.
 * */
package com.ss.gameframework2;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	int x;
	int y;
	int width;
	int height;
	int velX; //0���� �ʱ�ȭ�ȴ�.
	int velY;
	//float g;

	public Player(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}
	
	//�Ѿ� �߻� ������ �����Ѵ�.
	public void fire(){
		Bullet bullet = new Bullet(x, y, 10, 10);
		//Bullet�� tick�� render�� �ؾ��ϴµ� �ϱ� ��ƴ�.

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
