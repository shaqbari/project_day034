/*�α��� ȭ���� ����� Ŭ���� ����*/

package com.ss.wordgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JPanel implements ActionListener{
	GameWindow gameWindow;
	
	JPanel container; //borderlayout ����
	JPanel p_center;	//gridlayout����
	JPanel p_south;	//���ʿ� ��ư�� �� ����
	JLabel la_id, la_pw;
	JTextField t_id;
	JPasswordField t_pw;
	JButton bt;
	
	public LoginForm(GameWindow gameWindow) {
		this.gameWindow=gameWindow;
		
		container=new JPanel();
		p_center=new JPanel();
		p_south=new JPanel();
		la_id=new JLabel("id");
		la_pw=new JLabel("Password");
		t_id=new JTextField("batman", 15);
		t_pw=new JPasswordField("1234", 15);
		bt=new JButton("�α���");
		
		container.setLayout(new BorderLayout());
		p_center.setLayout(new GridLayout(2, 2));
		
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pw);
		p_center.add(t_pw);
		p_south.add(bt);
		container.add(p_center);
		container.add(p_south, BorderLayout.SOUTH);
		
		add(container);
		
		bt.addActionListener(this);
		
		setPreferredSize(new Dimension(400, 100));//�����ؾ� ���ϴ� ũ�� ��´�.
		setBackground(Color.YELLOW);		
	}
	
	public void loginCheck(){
		String id=t_id.getText();
		String pw=new String(t_pw.getPassword()); //getPassword()�� char[]�迭 ��ȯ String�������� �̹迭�� �޴°��� �ִ�.
		if(id.equals("batman")&&pw.equals("1234")){
			JOptionPane.showMessageDialog(this, "�α��� �Ϸ�");
			gameWindow.setPage(1);	
			//gameWindow.page[1].getCategory();
		}else{
			JOptionPane.showMessageDialog(this, "�α��� ������ �ùٸ��� �ʽ��ϴ�.");
			//id�� pw�� ���� Ʋ�ȴ��� �˷��ָ� �ȵǰ� ��������� �Ѵ�.		
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		loginCheck();
	}
}
