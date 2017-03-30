package com.ss.gameframework2;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	
	public GameWindow() {
		//setLayout(new FlowLayout());
		//setBackground(Color.BLACK);
		
		gamePanel=new GamePanel();
		
		
		add(gamePanel);
		//�гο� ���α׷��������� ��Ŀ�� �ø��� gamePanel�� listener�� ���ؼ�!
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
