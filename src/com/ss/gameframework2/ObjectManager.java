/*
 * 우리가 제작중인 게임은 게임루프가 오직 1개만 존재하기 때문에,
 * while내에서 게임에 등장할 모든 오브젝트의 tick, render를 호출해야 할
 * 모든 오브젝트의 tick, render호출해야할 의무가 있다.
 * 하지만, 게임에 등장할 객체들이 너무나 여러 클래스에 걸쳐서 복잡하게 등장하기 때문에
 * 게임루프인 while문 내에서 모든 객체들의 레퍼런스를 접근하기란 쉽지 않다.
 * 
 * 해결책?
 * 게임에 등장할 모든 객체들을 관리해주는 존재가 필요하다. 영화감독
 * */

package com.ss.gameframework2;

import java.util.ArrayList;

public class ObjectManager {
	//데이터 베이스 역할을 할 존재..
	ArrayList<Object> list = new ArrayList<Object>();
	
	//객체 등록
	//모든 게임에 등잘할 객체는 생성될 때 아래의 메소드를 통해 데이터베이스에 등록된다.
	
	public void addObject(Object obj){
		list.add(obj); //뭘추가?		
	}
	
}
