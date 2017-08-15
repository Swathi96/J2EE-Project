package com.src.service;

public class FactoryClass {
	private FactoryClass(){}
	static DbIntr di;
	public static DbIntr getInstance(){
		di=new Dbimpl();
		return di;
		
		
	}
	

}
