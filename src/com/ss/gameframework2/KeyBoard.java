/*플레이어의 움직임을 제어하자!!*/

package com.ss.gameframework2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	Player player;
	
	public KeyBoard(Player player) {
		this.player=player;
	}
		
	//키보드 누르면 이동
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		switch (key) {//소괄호 안의 값에 대해 조건을 따져보겠다
			case KeyEvent.VK_LEFT: 
				player.velX=-3;	break;
			case KeyEvent.VK_RIGHT: 
				player.velX=3;	break;
			case KeyEvent.VK_UP: 
				player.velY=-3;	break;
			case KeyEvent.VK_DOWN: 
				player.velY=3;	break;			
			case KeyEvent.VK_SPACE: 
				//총알생성 플레이어로부터
				//new Bullet(player.x, player.y, width, height);
				player.fire();
				
				break;			
	
			//default:
				//break;
		}
	}
	
	//키보드 떼면 정지
	public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();		
		switch (key) {//소괄호 안의 값에 대해 조건을 따져보겠다
			case KeyEvent.VK_LEFT: 
				player.velX=0;	break;
			case KeyEvent.VK_RIGHT: 
				player.velX=0;	break;
			case KeyEvent.VK_UP: 
				player.velY=0;	break;
			case KeyEvent.VK_DOWN: 
				player.velY=0;	break;
		}
		
	}
	
}
