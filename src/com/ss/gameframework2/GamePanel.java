/*모든 게임은 이 패널 안에서 그려질 예정이다.
 * 아무리 게임의 장면이 다양하더라도, 패널은 오직 1개만 사용된다.
	
	모든 오브젝트는 결국 이 패널에 그려져야 하므로,
	이 패널ㅇ의 paint메소드의 인수로 전달되는 graphics객체를 게임에 등장할
	모든 오브젝트가 전달받아야 한다.

	그래픽스 객체는 하나를 모든 객체가 공유해야 한다.
 * 인스턴스마다 쓰레드를 가지면 서로 타이밍이 어긋나 화면이 깜빡거린다.
 * */

package com.ss.gameframework2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	public static final int WIDTH =400;
	public static final int HEIGHT =300;
	public static final int SCALE =2; //유저가변하게 하려면 변수로 해도 된다.
	boolean flag=true; //게임가동 여부를 결정하는 변수
	Thread thread; //게임 운영 쓰레드

	ObjectManager objectManager; //객체명단 관리자
	Player player;
	
	public GamePanel() {
		thread=new Thread(this);
		thread.start();
		
		init();
		
		//크기지정
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}

	public void init(){
		//명단 관리자 생성
		objectManager=new ObjectManager();
		
		//주인공 등장 시키기
		player=new Player(100, 100, 50, 50);
		objectManager.addObject(player); //1명 추가
		
		//패널과 키보드 리스너 연결
		this.addKeyListener(new KeyBoard(player));
		//포커스가 처음시작할때 윈도우에 있기 때문에 패널로 옮겨야 작동한다.
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		player.render(g);
	}
	
	public void run() {
		while (flag) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("저 살아있어요");
			//player.tick();
			//player.render(g);//는 불가능 g가 없기 때문에
			
			//총알의 tick, render
			//적군의 tick, render
			//아이템의 tick, render
			
			//오브젝트 매니저에 등록된 모든 객체를 대상으로 tick() 호출해보자
			for (int i = 0; i < objectManager.list.size(); i++) {
				//Object obj=objectManager.list.get(i); 오브젝트 클래스에는 tick()이 없다
				//Player player=(player) obj; //총알등 다른 클래스면 형변환오류
			}
			
			repaint(); //paintComponent를 간접 호출
		}
	}
	
}
