package com.ss.wordgame;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//�� ������� ũ�Ⱑ �����Ǿ� ���� �ʾƾ� �Ѵ�.
//��? ������ �ȿ� ������ �� �г��� �� ũ�⸦ �����ϰ� �ǹǷ�..
//�α��� ����϶� �۰�, ���� �� ȭ�鿡���� ũ��
public class GameWindow extends JFrame{
	/*LoginForm loginForm;
	GamePanel gamePanel;*/
	
	JPanel[] page=new JPanel[2];
	
	public GameWindow() {
		setLayout(new FlowLayout());
		
		/*loginForm=new LoginForm();
		gamePanel=new GamePanel();*/
		
		page[0]=new LoginForm(this);
		page[1]=new GamePanel(this);
		
		add(page[0]);
		add(page[1]);
		
		setPage(0);

		setVisible(true);
		setLocationRelativeTo(null);//ȭ���߾ӿ� ��ġ
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	//������ �ȿ� � �г��� ������ �������ִ� �޼ҵ� ����
	public void setPage(int index){
		
		for(int i=0; i<page.length; i++){
			if(i==index){
				page[i].setVisible(true);				
			}else{
				page[i].setVisible(false);				
			}			
		}
		//������ �������ϸ� �����ɱ׶��Ƿ� pack�� �̿��Ѵ�.
		pack();//���빰�� ũ�⸸ŭ ������ ũ�⸦ ����, �ϳ��� �����찡 �������� ����� ���ϼ� �ִ�.
		setLocationRelativeTo(null);//ȭ���߾ӿ� ��ġ, ���⼭ �� ���ϸ� �����ִ����� ũ�� �ٲ��.
		//������Ʈ Ŭ�������� ũ�������Ѵ�.
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
