/*��Ŭ������ sun���� ��ü ������ ui������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����.
 * ���� jpanel�� �׷������� jpanel�� Graphics�� ���۷����� �� ��ü�� �����ؾ� �Ѵ�.
 * */
package com.ss.gameframework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{
	
	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
		/*this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;*/		

	}
	
	//�Ѿ� �߻� ������ �����Ѵ�.
	public void fire(){
		//Bullet bullet = new Bullet(x, y, 10, 10);
		//Bullet�� tick�� render�� �ؾ��ϴµ� �ϱ� ��ƴ�.
		
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);
		objectManager.addObject(bullet);
		
	}
	
	
	/*x, y, width, height���� ������ ���� ��ȭ��
	 * �����ϱ� ���� �޼ҵ�(��� ����:��� ��ȭ)*/
	public void tick(){
		//System.out.println("tick");
		x+=velX;
		y+=velY;
	
		//�浹�׽�Ʈ�� �簢���� ���� ����ٴϰ� ���� ����ȭ
		rect.setBounds(x, y, width, height);
		
		//���� �÷��̾ �浹�ϸ� �װ� ������
		for (int i = 0; i < objectManager.list.size(); i++) {
			GameObject obj=objectManager.list.get(i);
			if (obj.id==ObjectId.Enemy) { //Enemy���
				if (obj.rect.intersects(rect)) {//�� �簢���� ���簢���� �浹�Ѵٸ�	
					System.out.println("objectManager�� size="+objectManager.list.size());
					
					objectManager.list.remove(obj);//���װ�					
					objectManager.list.remove(this);//������	
					//�׾ �Ѿ˻��� ����?
					
					System.out.println("objectManager�� size="+objectManager.list.size());
				}
			}
		}
	
	}
	
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼ҵ�
	public void render(Graphics g){
		g.setColor(Color.WHITE);//������ �ٸ��� ����Ʈ �� �ٲٱ�
		//g.drawRect(x, y, width, height);
		
		//rect�� �ð�ȭ���Ѻ���
		Graphics2D g2 = (Graphics2D) g; //���׷��̵�Ȱ�
		g2.draw(rect);
		
		
		//System.out.println("render");	
	}
	
}
