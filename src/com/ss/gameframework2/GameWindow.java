package com.ss.gameframework2;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	
	public GameWindow() {
		//setLayout(new FlowLayout());
		//setBackground(Color.BLACK);
		
		gamePanel=new GamePanel();
		
		
		add(gamePanel);
		//패널에 프로그래밍적으로 포커스 올리기 gamePanel의 listener를 위해서!
		gamePanel.setFocusable(true);
		
		
		pack();
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
