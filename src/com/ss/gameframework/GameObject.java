/*
 * ���ӿ� ������ ��� ��ü�� �ֻ��� ũ������ �����Ѵ�.
 * 
 * ��? ����� �̿��ϸ� �ڵ� �ߺ��� ������ �� �ְ�, 
 * �ֻ��� Ŭ���� �ڷ������� �ڽĵ��� ����ų���� �ְ�, 
 * �ڵ尡 ����������.
 * 
 * */

package com.ss.gameframework;

import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class GameObject {
	ObjectManager objectManager; //�θ� ������ �ڽĵ鵵 ��� ������ �ȴ�. �ڽĵ��� ���ξȰ����� �͵� �ȴ�.
	ObjectId id; //��� ���Ӱ�ü�� �Ҵ�� ���̴�.
	int x;
	int y;
	int width;
	int height;
	int velX; //0���� �ʱ�ȭ�ȴ�.
	int velY;
	//float g;
	Rectangle rect; //���� �׽�Ʈ�� ����� �簢�� ��ü
	
	public GameObject(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.id=id; //� �������� �����ϱ� ����
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		rect=new Rectangle(x, y, width, height);
	}
	
	//�߻�޼ҵ�� ���� ����
	abstract public void tick();
	abstract public void render(Graphics g);
}
