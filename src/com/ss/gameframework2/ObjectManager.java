/*
 * �츮�� �������� ������ ���ӷ����� ���� 1���� �����ϱ� ������,
 * while������ ���ӿ� ������ ��� ������Ʈ�� tick, render�� ȣ���ؾ� ��
 * ��� ������Ʈ�� tick, renderȣ���ؾ��� �ǹ��� �ִ�.
 * ������, ���ӿ� ������ ��ü���� �ʹ��� ���� Ŭ������ ���ļ� �����ϰ� �����ϱ� ������
 * ���ӷ����� while�� ������ ��� ��ü���� ���۷����� �����ϱ�� ���� �ʴ�.
 * 
 * �ذ�å?
 * ���ӿ� ������ ��� ��ü���� �������ִ� ���簡 �ʿ��ϴ�. ��ȭ����
 * */

package com.ss.gameframework2;

import java.util.ArrayList;

public class ObjectManager {
	//������ ���̽� ������ �� ����..
	ArrayList<Object> list = new ArrayList<Object>();
	
	//��ü ���
	//��� ���ӿ� ������ ��ü�� ������ �� �Ʒ��� �޼ҵ带 ���� �����ͺ��̽��� ��ϵȴ�.
	
	public void addObject(Object obj){
		list.add(obj); //���߰�?		
	}
	
}