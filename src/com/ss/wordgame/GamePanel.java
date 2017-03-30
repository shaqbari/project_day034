package com.ss.wordgame;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements ItemListener, Runnable, ActionListener{
	GameWindow gameWindow;
	
	JPanel p_west; //������ ��Ʈ�� ����
	JPanel p_center; //�ܾ� �׷��� ó�� ����
	JLabel la_user; //���� �α��� ������
	JLabel la_score; //��������
	Choice choice; //�ܾ�õ���ڽ�
	JTextField t_input; //�����Է�â
	JButton bt_start; //���� ���۹�ư
	JButton bt_pause; //���� �����ư
	JButton bt_stop; //���� �����ư
	
	String res="E:/git/java_workspace/project_day033/src/com/ss/res/"; //������ ���
	FileInputStream fis;
	InputStreamReader reader;
	//FileReader reader; //������ ������� �� ���ڱ�� �Է½�Ʈ�� (fis���� ���׷��̵�� �����γ�)
	//utf-8ó�� ���ϴ� ó������ ���׷��̵� ����
	BufferedReader buffer; //���ڱ�ݹ��� ��Ʈ��
	ArrayList<String> wordList=new ArrayList<String>();//�����Ѵܾ ��Ƴ���! ���ӿ� ��Ա� ����
	
	Thread thread;//�ܾ������ ������ ������
	boolean flag=true; //�����带 Ű�� �� flag
	boolean isDown=true; //������ų�� �̿��� flag
	//int y=50; //�ܾ��� y�ప ��üȭ��Ų Word�� ����
	ArrayList<Word> words=new ArrayList<Word>(); //������ Word��ü�� ���� �÷���
	
	
	public GamePanel(GameWindow gameWindow) {
		this.gameWindow=gameWindow;		
		
		setLayout(new BorderLayout());
		
		p_west=new JPanel();
		p_center=new JPanel(){
			//�̿����� ���ݺ��� �׸��� �׸� ����!
			public void paintComponent(Graphics g) { //paint��ſ� �̰� ����.
				//���� �׸� �����
				g.setColor(Color.PINK);
				g.fillRect(0, 0, 750, 700);
				
				//�ٽ� �׸���
				g.setColor(Color.BLACK);				
				//��� ����鿡 ���� render()ȣ��
				for (int i = 0; i < words.size() ; i++) {
					words.get(i).render(g);
				}
				
				//g.drawString("����", 200, y);				
				//����� �ٽñ׷��� ����� �׷�����.
				//�ܾ �������� Ŭ����ȭ ���Ѿ� �Ѵ�.
			}
		};	
		
		la_user=new JLabel("~��");
		la_score=new JLabel("~��");
		choice=new Choice();
		t_input=new JTextField(10);
		bt_start=new JButton("Start");		
		bt_pause=new JButton("Pause");
		bt_stop=new JButton("Stop");
		
		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.YELLOW);
		
		choice.setPreferredSize(new Dimension(130, 40));
		choice.add("�� �ܾ��� ����");
		choice.addItemListener(this);
		
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		bt_stop.addActionListener(this);
		
		//�ؽ�Ʈ �ʵ�� ������ ����
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					//System.out.println("������?");
					
					//ȭ�鿡 �����ϴ� words�� �Է°� ���Ͽ� ������, words���� ��ü ����
					String value=t_input.getText();
					for (int i = 0; i < words.size(); i++) {
						if (words.get(i).name.equals(value)) {
							words.remove(i);
						}
					}
				}
			}
		});
		
		p_west.add(la_user);
		p_west.add(choice);
		p_west.add(t_input);
		p_west.add(bt_start);
		p_west.add(bt_pause);
		p_west.add(bt_stop);
		p_west.add(la_score);
		
		add(p_west, BorderLayout.WEST);	
		add(p_center);		
		
		setBackground(Color.PINK);
		setVisible(false);//���ʿ� �������
		setPreferredSize(new Dimension(900, 700));
		
		getCategory();
	}
	
	//���̽� ������Ʈ�� ä���� ���ϸ� �����ϱ�
	public void getCategory(){
		File file=new File(res); //url�� �ȵȴ�. uri�� �Ǵµ� ���߿�
		File[] files=file.listFiles(); //���ϰ� ���丮�� �����ִ� �迭��ȯ.
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String name=files[i].getName();
				String[] arr=name.split("\\.");//�������ø� �ι���� Ư��������.�̾ƴ� ����.���� �ν��Ѵ�.
				if (arr[1].equals("txt")) {//�޸����̶��
					choice.add(name); //arr[0]���� ������ Ȯ���ڻ� name�� ����.
				}				
			}
		}
	}
	
	//�ܾ� �о��!!
	public void getWord(){
		int index=choice.getSelectedIndex();
		if(index!=0){//ù��° ��Ұ� �ƴҶ�
			String name=choice.getSelectedItem();
			//System.out.println(res+name);
			
			try {
				fis=new FileInputStream(res+name);
				reader = new InputStreamReader(fis, "utf-8");
				buffer=new BufferedReader(reader); //��Ʈ���� ����ó�� ���ر��� �ø�
				
				//������ wordList�� �����.
				wordList.removeAll(wordList);
				//xml�ؽ�Ʈ����� �����ͺ��̽�? ��� json�� ���� ����.
				while(true){
					String data=buffer.readLine();
					if(data==null) break;
					System.out.println(data);
					wordList.add(data); //�̷��Ը� ���� �ٲܶ����� �߰��Ǿ������.
				}
				//System.out.println("������� wordList="+wordList.size());
				
				//editplus���� utf-8�� �ٽ� �����ؾ� ?���ȳ��´�.
				
				//�غ�� �ܾ ȭ�鿡 �����ֱ�
				createWord();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (buffer!=null) {
					try {
						buffer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (reader!=null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void createWord(){
		for (int i = 0; i < wordList.size(); i++) {
			String name=wordList.get(i);
			Word word = new Word(name, 10+50*i, 50);
			words.add(word); //���� ��ü��� �����
		}
		
	}
	
	//���ӽ���
	public void startGame() {
		if (thread==null) {//null ���¿��� ó�� �ѹ��� ����ȴ�.
			flag=true; //while�� �ٽ� �۵��ϵ���
			thread = new Thread(this);
			thread.start();
		}
	}
	
	//���� ����
	public void pauseGame(){
		isDown=!isDown;
	}
	
	//���� ����--�ᱹ ó������ ���ư���
	/*1. wordList(�ܾ���� ����ִ�)����
	 *2. words(Word�ν��Ͻ��� ����ִ� )����
	 *3. choice �ʱ�ȭ(index=0)
	 *4. flag=false
	 *5. thread�� null�� �ٽ� �ʱ�ȭ
	 * */
	public void stopGame(){
		wordList.removeAll(wordList);
		words.removeAll(words);
		choice.select(0);//ù��° ��� ���� ����
		flag=false; //while�� ���� ����
		thread=null;		
	}
	
	//�ܾ� �������� ȿ��!
	/*public void down(){
		//y�� ������Ű��
		//p_center �гη� �Ͽ��� �ٽ� �׸���
		//y+=20;
		//p_center.repaint(); //�г��� repaint�ϸ� �̻��ϰ� ���´�. paint��� paintComponent�� ����
		//�ϳ������� �̷������� ���������� �������� �����̷��� �����.
		
		
		//System.out.println("down()");
	}*/
	
	
	public void itemStateChanged(ItemEvent e) {
		//System.out.println("�ٲ��?"); //���ϰ��ִ��� Ȯ��
		getWord();
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if (obj==bt_start) {
			startGame();
		}else if(obj==bt_pause){
			pauseGame();
		}else if(obj==bt_stop){
			stopGame();
		}
	}
	
	public void run() {		
		try {
			while(flag){ //���ξ������ ���� ���� �ȵȴ�. �̰������ؾ���
				thread.sleep(500);
				//down();
				
				if(isDown){ //�̺κ��� �����ؾ� ��� ������ų �� �ִ�.
					//��� �ܾ�鿡���ؼ� tick()
					//��� �ܾ�鿡 ���� reapint()
					for(int i=0; i<words.size(); i++){
						words.get(i).tick();
						//words.get(i).render(g); //g������ ���⼭ ȣ�� �Ұ��� paint���� ȣ������
					}					
				}
				//��� �ܾ�鿡 ���ؼ� repaint()					
				p_center.repaint();					
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
