/*
 * 게임에 등잘할 모든 객체의 최상위 크랠스를 정의한다.
 * 
 * 왜? 상속을 이용하면 코드 중복을 방지할 수 있고, 
 * 최상위 클래스 자료형으로 자식들을 가리킬수도 있고, 
 * 코드가 유연해진다.
 * 
 * */

package com.ss.gameframework;

import java.awt.Graphics;

abstract public class GameObject {
	ObjectManager objectManager; //부모가 가지면 자식들도 모두 가지게 된다. 자식들이 따로안가지고 와도 된다.
	int x;
	int y;
	int width;
	int height;
	int velX; //0으로 초기화된다.
	int velY;
	//float g;
	
	public GameObject(ObjectManager objectManager, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	//추상메소드로 구현 강제
	abstract public void tick();
	abstract public void render(Graphics g);
}
