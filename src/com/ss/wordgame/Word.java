/*���ӿ� ������ ��� �ܾ ���� y���� ���� ����,
 * �뷮���� ��������� �ϱ� ������
 * �ᱹ ���뼺�� ���� �ڵ������� Ŭ������ ����
 * */

package com.ss.wordgame;

import java.awt.Graphics;

public class Word {
	String name; //�� ��ü�� ��Ե� �ܾ�!!
	int x;
	int y;
	int velX;
	int velY;  //�ܾ ������ �ӵ�	
	//int interval; ���͹��� ������ �ϳ��� ����� �ϳ��� �ִ°��� ����
	//������ ���鶧�� 1. �������� ��ȭ, 2. �ٽñ׸���

	//�� �ܾ �¾ �� ���߾�� �� �ʱ�ȭ�� ��
	public Word(String name, int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	//1.�� ��ü�� �ݿ��� ������ ��ȭ�ڵ�
	public void tick(){
		y+=5;		
	}
	
	//2.�� �ݿ��� �����͸� �̿��Ͽ� ȭ�鿡 �׸���
	public void render(Graphics g){
		g.drawString(name, x, y);
	}
}
