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

abstract public class GameObject {
	ObjectManager objectManager; //�θ� ������ �ڽĵ鵵 ��� ������ �ȴ�. �ڽĵ��� ���ξȰ����� �͵� �ȴ�.
	int x;
	int y;
	int width;
	int height;
	int velX; //0���� �ʱ�ȭ�ȴ�.
	int velY;
	//float g;
	
	public GameObject(ObjectManager objectManager, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	//�߻�޼ҵ�� ���� ����
	abstract public void tick();
	abstract public void render(Graphics g);
}
