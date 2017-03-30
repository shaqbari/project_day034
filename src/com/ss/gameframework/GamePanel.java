/*��� ������ �� �г� �ȿ��� �׷��� �����̴�.
 * �ƹ��� ������ ����� �پ��ϴ���, �г��� ���� 1���� ���ȴ�.
	
	��� ������Ʈ�� �ᱹ �� �гο� �׷����� �ϹǷ�,
	�� �гΤ��� paint�޼ҵ��� �μ��� ���޵Ǵ� graphics��ü�� ���ӿ� ������
	��� ������Ʈ�� ���޹޾ƾ� �Ѵ�.

	�׷��Ƚ� ��ü�� �ϳ��� ��� ��ü�� �����ؾ� �Ѵ�.
 * �ν��Ͻ����� �����带 ������ ���� Ÿ�̹��� ��߳� ȭ���� �����Ÿ���.
 * */

package com.ss.gameframework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{	
	public static final int WIDTH =400;
	public static final int HEIGHT =300;
	public static final int SCALE =2; //���������ϰ� �Ϸ��� ������ �ص� �ȴ�.
	boolean flag=true; //���Ӱ��� ���θ� �����ϴ� ����
	Thread thread; //���� � ������

	ObjectManager objectManager; //��ü��� ������
	Player player;
	
	public GamePanel() {
		thread=new Thread(this);
		thread.start();
		
		init();
		
		//ũ������
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}

	public void init(){
		//��� ������ ����
		objectManager=new ObjectManager();
		
		//���ΰ� ���� ��Ű��
		player=new Player(objectManager, ObjectId.Player, 100, 100, 50, 50);
		objectManager.addObject(player); //1�� �߰�
		
		//���� ����
		Random r=new Random();
		for(int i=0; i<10; i++){
			int x=r.nextInt(WIDTH*SCALE-50+1)+50;
			int y=r.nextInt(HEIGHT*SCALE-50+1)+50;
			Enemy enemy=new Enemy(objectManager, ObjectId.Enemy, x, y, 30, 30);
			objectManager.addObject(enemy);
		}
		
		//�гΰ� Ű���� ������ ����
		this.addKeyListener(new KeyBoard(player));
		//��Ŀ���� ó�������Ҷ� �����쿡 �ֱ� ������ �����쿡�� �гη� �Űܾ� �۵��Ѵ�.
		
		
	}	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//player.render(g);
		for (int i = 0; i < objectManager.list.size(); i++) {
			//Object obj=objectManager.list.get(i); ������Ʈ Ŭ�������� tick()�� ����
			//Player player=(player) obj; //�Ѿ˵� �ٸ� Ŭ������ ����ȯ����
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
			
		}
	}
	
	public void run() {
		while (flag) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("�� ����־��");
			//player.tick();
			//player.render(g);//�� �Ұ��� g�� ���� ������
			
			//�Ѿ��� tick, render
			//������ tick, render
			//�������� tick, render
			
			//������Ʈ �Ŵ����� ��ϵ� ��� ��ü�� ������� tick() ȣ���غ���
			for (int i = 0; i < objectManager.list.size(); i++) {
				//Object obj=objectManager.list.get(i); ������Ʈ Ŭ�������� tick()�� ����
				//Player player=(player) obj; //�Ѿ˵� �ٸ� Ŭ������ ����ȯ����
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			
			repaint(); //paintComponent�� ���� ȣ��
		}
	}
	
}
