/*이클래스는 sun에서 자체 제작한 ui컴포넌트가 아니기 때문에 화면에 그려질 수 없다.
 * 따라서 jpanel에 그려지려면 jpanel의 Graphics의 레퍼런스를 이 객체가 보유해야 한다.
 * */
package com.ss.gameframework2;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	int x;
	int y;
	int width;
	int height;
	int velX; //0으로 초기화된다.
	int velY;
	//float g;

	public Player(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}
	
	//총알 발사 행위를 정의한다.
	public void fire(){
		Bullet bullet = new Bullet(x, y, 10, 10);
		//Bullet의 tick과 render를 해야하는데 하기 어렵다.

	}
	
	
	/*x, y, width, height등의 물리량 등의 변화를
	 * 제어하기 위한 메소드(사람 비유:운동량 변화)*/
	public void tick(){
		//System.out.println("tick");
		x+=velX;
		y+=velY;
	
	}
	
	//변화된 값을 화면에 그려지게 할 메소드
	public void render(Graphics g){
		g.setColor(Color.WHITE);//배경색과 다르게 페인트 색 바꾸기
		g.drawRect(x, y, width, height);
		//System.out.println("render");
	
	}
	
}
