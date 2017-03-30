/*이클래스는 sun에서 자체 제작한 ui컴포넌트가 아니기 때문에 화면에 그려질 수 없다.
 * 따라서 jpanel에 그려지려면 jpanel의 Graphics의 레퍼런스를 이 객체가 보유해야 한다.
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
	
	//총알 발사 행위를 정의한다.
	public void fire(){
		//Bullet bullet = new Bullet(x, y, 10, 10);
		//Bullet의 tick과 render를 해야하는데 하기 어렵다.
		
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);
		objectManager.addObject(bullet);
		
	}
	
	
	/*x, y, width, height등의 물리량 등의 변화를
	 * 제어하기 위한 메소드(사람 비유:운동량 변화)*/
	public void tick(){
		//System.out.println("tick");
		x+=velX;
		y+=velY;
	
		//충돌테스트할 사각형이 나를 따라다니게 값의 동기화
		rect.setBounds(x, y, width, height);
		
		//적과 플레이어가 충돌하면 죽게 만들어보자
		for (int i = 0; i < objectManager.list.size(); i++) {
			GameObject obj=objectManager.list.get(i);
			if (obj.id==ObjectId.Enemy) { //Enemy라면
				if (obj.rect.intersects(rect)) {//적 사각형과 내사각형이 충돌한다면	
					System.out.println("objectManager의 size="+objectManager.list.size());
					
					objectManager.list.remove(obj);//너죽고					
					objectManager.list.remove(this);//나죽자	
					//죽어도 총알생성 가능?
					
					System.out.println("objectManager의 size="+objectManager.list.size());
				}
			}
		}
	
	}
	
	//변화된 값을 화면에 그려지게 할 메소드
	public void render(Graphics g){
		g.setColor(Color.WHITE);//배경색과 다르게 페인트 색 바꾸기
		//g.drawRect(x, y, width, height);
		
		//rect를 시각화시켜보자
		Graphics2D g2 = (Graphics2D) g; //업그레이드된것
		g2.draw(rect);
		
		
		//System.out.println("render");	
	}
	
}
